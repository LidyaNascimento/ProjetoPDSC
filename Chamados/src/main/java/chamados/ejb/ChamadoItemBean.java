package chamados.ejb;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.persistence.*;

import chamados.entidades.Chamado;
import chamados.entidades.ChamadoItem;
import chamados.mapeamento.ChamadoItemMapeamento;
import chamados.mapeamento.ChamadoMapeamento;


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
	
	public ChamadoItem cadastrarChamadoItem(ChamadoItemMapeamento chamado_item_mapeamento, Long id) {
		Chamado chamado = entityManager.find(Chamado.class, id);
		
		ChamadoItem chamado_item = new ChamadoItem();

		chamado_item.setTitulo(chamado_item_mapeamento.getTitulo());
		chamado_item.setDescricao(chamado_item_mapeamento.getDescricao());
		chamado_item.setValor(chamado_item_mapeamento.getValor());
		chamado_item.setChamado_id(chamado);
		chamado_item.setFuncionario_id(chamado_item_mapeamento.getFuncionario_id());
		chamado_item.setCriado_em(chamado_item_mapeamento.getCriado_em());
		chamado_item.setAtualizado_em(chamado_item_mapeamento.getAtualizado_em());
		
		entityManager.persist(chamado_item);
		entityManager.flush();
//		chamado_item = entityManager.find(ChamadoItem.class, chamado_item.getId());
		
		
		return chamado_item;
	} 
	
	public ChamadoItem atualizarItemChamado(ChamadoItemMapeamento chamado_item_mapeamento) {
		ChamadoItem chamado_item = new ChamadoItem();
		
		chamado_item.setId(chamado_item_mapeamento.getId());
		chamado_item.setTitulo(chamado_item_mapeamento.getTitulo());
		chamado_item.setDescricao(chamado_item_mapeamento.getDescricao());
		chamado_item.setValor(chamado_item_mapeamento.getValor());
		chamado_item.setChamado_id(chamado_item_mapeamento.getChamado_id());
		chamado_item.setFuncionario_id(chamado_item_mapeamento.getFuncionario_id());
		chamado_item.setCriado_em(chamado_item_mapeamento.getCriado_em());
		chamado_item.setAtualizado_em(chamado_item_mapeamento.getAtualizado_em());
		
		entityManager.clear();
		entityManager.merge(chamado_item);
		chamado_item = entityManager.find(ChamadoItem.class, chamado_item.getId());
		
		return chamado_item;
	}
	
	
}
