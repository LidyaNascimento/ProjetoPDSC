package usuarios.ejb;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.persistence.*;

import usuarios.entidades.Cargo;


@Stateless
public class CargoBean {
	
	@PersistenceContext(unitName = "pu")
	private EntityManager entityManager;
	
	@PostConstruct
    private void initializeBean(){
		
    } 
	
	public List<Cargo> getAllCargos() {
		String jpql = ("select c from Cargo c");
        Query query = entityManager.createQuery(jpql, Cargo.class);
        List<Cargo> cargos = query.getResultList();
        if (cargos!=null) {
        	return cargos;
        }
		return null;
	}

}
