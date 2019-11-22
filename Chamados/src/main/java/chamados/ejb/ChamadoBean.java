package chamados.ejb;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.persistence.*;

import chamados.entidades.Chamado;
import chamados.entidades.ChamadoItem;
import chamados.mapeamento.ChamadoMapeamento;

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
	
	public Chamado cadastrarChamado(ChamadoMapeamento chamado_mapeamento) {
		Chamado chamado = new Chamado();
		
		chamado.setTitulo(chamado_mapeamento.getTitulo());
		chamado.setDescricao(chamado_mapeamento.getDescricao());
		chamado.setUsuario_id(chamado_mapeamento.getUsuario_id());
		chamado.setEndereco_id(chamado_mapeamento.getEndereco_id());
		
		entityManager.persist(chamado);
		
		return chamado;
	} 
	
	
	
	
	

}
