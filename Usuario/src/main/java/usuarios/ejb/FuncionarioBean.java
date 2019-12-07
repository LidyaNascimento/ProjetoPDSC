package usuarios.ejb;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import usuarios.entidades.Funcionario;
import usuarios.entidades.Login;
import usuarios.entidades.Usuario;
import usuarios.mapeamento.FuncionarioMapeamento;

@Stateless
public class FuncionarioBean {

	@PersistenceContext(unitName = "pu")
	private EntityManager entityManager;
	
	@PostConstruct
    private void initializeBean(){
    } 
 
	public Funcionario cadastrarFuncionario(FuncionarioMapeamento func) {
		Funcionario user = new Funcionario();
				
		user.setNome(func.getNome());
		user.setLogin(func.getLogin());
		user.setSenha(func.getSenha());
		user.setEmail(func.getEmail());
		user.setCPF(func.getCPF());
		user.setRG(func.getRG());
		user.setData_nascimento(func.getData_nascimento());
		user.setCriado_em(func.getCriado_em());
		user.setAtualizado_em(func.getAtualizado_em());
		entityManager.persist(user);
		return user;
	}

	public Login login(Login login) {
		String jpql_cliente = ("SELECT u from Usuario u"
						+ " WHERE u.login= :pNome "
						+ "AND u.senha= :pSenha"
						+ "AND u.discriminator = 'C'");
        
		Query query_cliente = entityManager.createQuery(jpql_cliente);
		query_cliente.setParameter("pNome", login.getLogin());
		query_cliente.setParameter("pSenha", login.getSenha());
        
        List<Usuario> usuarios = query_cliente.getResultList();
        
        if(usuarios.isEmpty()) {
        	String jpql_func = ("SELECT u from Usuario u"
					+ " WHERE u.login= :pNome "
					+ "AND u.senha= :pSenha"
					+ "AND u.discriminator = 'F'");
        	
    		Query query_func = entityManager.createQuery(jpql_func);
    		query_func.setParameter("pNome", login.getLogin());
    		query_func.setParameter("pSenha", login.getSenha());
    		
    		usuarios = query_cliente.getResultList();
    		
    		if(usuarios.isEmpty()) {
            	
            	return null;
    		}
    		
    		login.setDiscriminator("F");

        } else {
        	login.setDiscriminator("C");
        }
        
        Usuario usuario = (Usuario) usuarios.get(0);
        
        return login;
		
	}

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
