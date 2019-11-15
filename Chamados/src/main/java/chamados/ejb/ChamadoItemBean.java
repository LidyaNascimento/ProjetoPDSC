package chamados.ejb;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.persistence.*;

import chamados.entidades.Chamado;
import chamados.entidades.ChamadoItem;


@Stateless
public class ChamadoItemBean {
	
	@PersistenceContext(unitName = "pu")
	private EntityManager entityManager;
	
	@PostConstruct
    private void initializeBean(){
		
    } 
	
	public List<ChamadoItem> getAllChamadoItens() {
		String jpql = ("select i from ChamadoItem i");
        Query query = entityManager.createQuery(jpql, ChamadoItem.class);
        List<ChamadoItem> chamadoItens = query.getResultList();
        if (chamadoItens!=null) {
        	return chamadoItens;
        }
		return null;
	}
	
	public ChamadoItem getChamadoItem(Long id) {
		ChamadoItem chamado_item = entityManager.find(ChamadoItem.class, id);
		if (chamado_item != null)
            return chamado_item;
		
		return null;
	} 
	
	public ChamadoItem cadastrarChamadoItem(ChamadoItem chamado_item) {
		entityManager.persist(chamado_item);
		
		return chamado_item;
	} 
	
}
