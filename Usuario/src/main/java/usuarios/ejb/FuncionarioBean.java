package usuarios.ejb;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import usuarios.entidades.Funcionario;

@Stateless
public class FuncionarioBean {

	@PersistenceContext(unitName = "pu")
	private EntityManager entityManager;
	
	@PostConstruct
    private void initializeBean(){
    } 
 
//	public User cadastrarUsuario(String nome, String senha) {
//		User user = new User();
//		user.setNome(nome);
//		user.setSenha(senha);
//		entityManager.persist(user);
//		return user;
//	}
//
//	public User login(String nome, String senha) {
//		String jpql = ("select u from User u where u.nome= :pNome and u.senha= :pSenha");
//        Query query = entityManager.createQuery(jpql);
//        query.setParameter("pNome", nome);
//        query.setParameter("pSenha", senha);
//        User usuario = (User)query.getSingleResult();
//		return usuario;
//	}


	public Funcionario getFuncionario(Long id) {
		Funcionario funcionario = entityManager.find(Funcionario.class, id);
		if (funcionario != null)
            return funcionario;
		return null;
	} 


	public List<Funcionario> getAllFuncionarios() {
		String jpql = ("select f from Funcionario f");
        Query query = entityManager.createQuery(jpql, Funcionario.class);
        List<Funcionario> funcionarios = query.getResultList();
        if (funcionarios!=null) {
        	return funcionarios;
        }
		return null;
	}


//	public User getUserByToken(String token) {
//		String jpql = ("select u from User u where u.token= :pToken");
//        Query query = entityManager.createQuery(jpql);
//        query.setParameter("pToken", token);
//        User usuario = (User)query.getSingleResult();
//		return usuario;
//	}
//
//
//	public void updateUser(User user) {	
//		entityManager.merge(user);
//	}
	
}
