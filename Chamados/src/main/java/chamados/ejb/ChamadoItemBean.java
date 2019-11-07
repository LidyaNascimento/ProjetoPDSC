package chamados.ejb;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.persistence.*;

import chamados.entidades.ChamadoItem;


@Stateless
public class ChamadoItemBean {
	
	@PersistenceContext(unitName = "pu")
	private EntityManager entityManager;
	
	@PostConstruct
    private void initializeBean(){
		
    } 
	
	public List<ChamadoItem> getAllCargos() {
		String jpql = ("select i from ChamadoItem i");
        Query query = entityManager.createQuery(jpql, ChamadoItem.class);
        List<ChamadoItem> chamadoItens = query.getResultList();
        if (chamadoItens!=null) {
        	return chamadoItens;
        }
		return null;
	}

}
