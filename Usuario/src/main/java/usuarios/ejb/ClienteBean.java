package usuarios.ejb;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import usuarios.entidades.Funcionario;
import usuarios.entidades.Cliente;

@Stateless
public class ClienteBean {

	@PersistenceContext(unitName = "pu")
	private EntityManager entityManager;
	
	@PostConstruct
    private void initializeBean(){
    } 
 
	public Cliente cadastrarCliente(Cliente cliente) {
		Cliente user = new Cliente();
		user.setNome(cliente.getNome());
		user.setLogin(cliente.getLogin());
		user.setSenha(cliente.getSenha());
		user.setEmail(cliente.getEmail());
		user.setCPF(cliente.getCPF());
		entityManager.persist(user);
		return user;
	}

//	public User login(String nome, String senha) {
//		String jpql = ("select u from User u where u.nome= :pNome and u.senha= :pSenha");
//        Query query = entityManager.createQuery(jpql);
//        query.setParameter("pNome", nome);
//        query.setParameter("pSenha", senha);
//        User usuario = (User)query.getSingleResult();
//		return usuario;
//	}


	public Cliente getCliente(Long id) {
		Cliente cliente = entityManager.find(Cliente.class, id);
		if (cliente != null)
            return cliente;
		return null;
	} 


	public List<Cliente> getAllClientes() {
		String jpql = ("select c from Cliente c");
        Query query = entityManager.createQuery(jpql, Cliente.class);
        List<Cliente> clientes = query.getResultList();
        if (clientes!=null) {
        	return clientes;
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
