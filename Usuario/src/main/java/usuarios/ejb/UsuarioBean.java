package usuarios.ejb;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import usuarios.Usuario.PasswordUtils;
import usuarios.entidades.Cliente;
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

	public Usuario login(String nome, String senha) {
		String jpql = ("select u from Usuario u where u.login= :pNome and u.senha= :pSenha");
        Query query = entityManager.createQuery(jpql);
        query.setParameter("pNome", nome);
        query.setParameter("pSenha", senha);
        
        List<Usuario> usuarios = query.getResultList();
        
        if(usuarios.isEmpty()) {
        	return null;
        }
        
        Usuario usuario = (Usuario) usuarios.get(0);
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


	public void updateUser(Usuario usuario) {	
		entityManager.merge(usuario);
	}

	
}
