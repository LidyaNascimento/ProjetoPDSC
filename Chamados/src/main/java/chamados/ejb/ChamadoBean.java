package chamados.ejb;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.persistence.*;

import chamados.entidades.Chamado;
import chamados.entidades.ChamadoItem;

@Stateless
public class ChamadoBean {
	
	@PersistenceContext(unitName = "pu")
	private EntityManager entityManager;
	
	@PostConstruct
    private void initializeBean(){
		
    } 
	
	public List<Chamado> getAllChamados() {
		String jpql = ("select c from Chamado c");
        Query query = entityManager.createQuery(jpql, Chamado.class);
        List<Chamado> chamados = query.getResultList();
        if (chamados!=null) {
        	return chamados;
        }
		return null;
	}
	
	public Chamado getChamado(Long id) {
		Chamado chamado = entityManager.find(Chamado.class, id);
		if (chamado != null)
            return chamado;
		return null;
	} 
	
	public Chamado cadastrarChamado(Chamado chamado) {
		entityManager.persist(chamado);
		
		return chamado;
	} 
	
	
	
	
	

}
