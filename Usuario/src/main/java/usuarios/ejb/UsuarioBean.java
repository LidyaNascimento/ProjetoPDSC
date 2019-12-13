package usuarios.ejb;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.persistence.CacheRetrieveMode;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import usuarios.Usuario.PasswordUtils;
import usuarios.entidades.Cliente;
import usuarios.entidades.Funcionario;
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
		List<Cliente> clientes = loginCliente(login);
		
		if(!clientes.isEmpty()) {
			login.setDiscriminator("C");  
			login.setId(clientes.get(0).getId());
			return login;
		}
		 
		List<Funcionario> func = loginFuncionario(login);
		
		if(!func.isEmpty()) {
			login.setDiscriminator("F");  
			login.setId(func.get(0).getId());
			return login;
		}
        
		
		return null;
	}


	public void updateUser(Usuario usuario) {	
		entityManager.merge(usuario);
	}
	
	public List<Cliente> loginCliente(Login login) {
		
		Query query;
		query = entityManager.createNativeQuery("SELECT * "
                + "FROM usuarios.cliente c "
                + "INNER JOIN usuarios.usuario u ON u.id = c.usuario_id "
                + "WHERE u.login = '" + login.getLogin()
                + "' AND u.senha = '" + login.getSenha()
                + "' AND u.disc_usuario = 'C'", Cliente.class);
       
        List<Cliente> usuarios = query.getResultList();

        return usuarios;
		
	}
	
	public List<Funcionario> loginFuncionario(Login login) {
		Query query;
		query = entityManager.createNativeQuery("SELECT * "
                + "FROM usuarios.funcionario f "
                + "INNER JOIN usuarios.usuario u ON u.id = f.usuario_id "
                + "WHERE u.login = '" + login.getLogin()
                + "' AND u.senha = '" + login.getSenha()
                + "' AND u.disc_usuario = 'F'", Funcionario.class);
    	
        
        List<Funcionario> usuarios = query.getResultList();
        	
        System.out.println("***: " + usuarios.get(0).getLogin());
        return usuarios;
		
	}


	
}
