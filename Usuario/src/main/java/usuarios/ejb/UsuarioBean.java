package usuarios.ejb;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import usuarios.Usuario.PasswordUtils;
import usuarios.entidades.Cliente;
import usuarios.entidades.Login;
import usuarios.entidades.Usuario;

@Stateless
public class UsuarioBean {

	@PersistenceContext(unitName = "pu")
	private EntityManager entityManager;
	
	@PostConstruct
    private void initializeBean(){
    } 
 
	public Usuario cadastrarUsuario(String nome, String login, String senha, String cpf, String email) {
		Usuario usuario = new Cliente();
		usuario.setNome(nome);
		usuario.setLogin(login);
		usuario.setSenha(PasswordUtils.digestPassword(senha));
		usuario.setCPF(cpf);
		usuario.setEmail(email);
		entityManager.persist(usuario);
		return usuario;
	}




	public Usuario getUsuario(Long id) {
		Usuario usuario = entityManager.find(Usuario.class, id);
		if (usuario != null)
            return usuario;
		return null;
	} 


	public List<Usuario> getAllUsuarios() {
		String jpql = ("select u from Usuario u");
        Query query = entityManager.createQuery(jpql, Usuario.class);
        List<Usuario> usuarios = query.getResultList();
        if (usuarios!=null) {
        	return usuarios;
        }
		return null;
	}


	public Usuario getUserByToken(String token) {
		String jpql = ("select u from Usuario u where u.token= :pToken");
        Query query = entityManager.createQuery(jpql);
        query.setParameter("pToken", token);
        Usuario usuario = (Usuario)query.getSingleResult();
		return usuario;
	}
	
	public Login login(Login login) {
		List<Usuario> usuarios = loginCliente(login);
		
		if(!usuarios.isEmpty()) {
			login.setDiscriminator("C");  
			login.setId(usuarios.get(0).getId());
			return login;
		}
		 
		usuarios = loginFuncionario(login);
		
		if(!usuarios.isEmpty()) {
			login.setDiscriminator("F");  
			login.setId(usuarios.get(0).getId());
			return login;
		}
        
		
		return null;
	}


	public void updateUser(Usuario usuario) {	
		entityManager.merge(usuario);
	}
	
	public List<Usuario> loginCliente(Login login) {
		String jpql_cliente = ("SELECT u from Usuario u"
						+ " WHERE u.login= :pNome"
						+ " AND u.senha= :pSenha");
        
		Query query_cliente = entityManager.createQuery(jpql_cliente);
		query_cliente.setParameter("pNome", login.getLogin());
		query_cliente.setParameter("pSenha", login.getSenha());
        
        List<Usuario> usuarios = query_cliente.getResultList();
             
        return usuarios;
		
	}
	
	public List<Usuario> loginFuncionario(Login login) {
		String jpql_func = ("SELECT u from Usuario u"
				+ " WHERE u.login= :pNome"
				+ " AND u.senha= :pSenha");
    	
		Query query_func = entityManager.createQuery(jpql_func);
		query_func.setParameter("pNome", login.getLogin());
		query_func.setParameter("pSenha", login.getSenha());
        
        List<Usuario> usuarios = query_func.getResultList();
        	
        return usuarios;
		
	}


	
}
