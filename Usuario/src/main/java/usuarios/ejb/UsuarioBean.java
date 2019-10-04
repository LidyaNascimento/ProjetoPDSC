package usuarios.ejb;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import usuarios.entidades.Usuario;

@Stateless
public class UsuarioBean {

	@PersistenceContext(unitName = "pu")
	private EntityManager entityManager;
	
	@PostConstruct
    private void initializeBean(){
    } 
 
	public Usuario cadastrarUsuario(String nome, String senha) {
		Usuario usuario = new Usuario();
		usuario.setNome(nome);
		usuario.setSenha(senha);
		entityManager.persist(usuario);
		return usuario;
	}

	public Usuario login(String nome, String senha) {
		String jpql = ("select u from Usuario u where u.login= :pNome and u.senha= :pSenha");
        Query query = entityManager.createQuery(jpql);
        query.setParameter("pNome", nome);
        query.setParameter("pSenha", senha);
        Usuario usuario = (Usuario)query.getSingleResult();
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
