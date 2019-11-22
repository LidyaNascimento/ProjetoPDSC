package chamados.sevicos;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static javax.ws.rs.core.Response.Status.NOT_FOUND;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import chamados.ejb.ChamadoItemBean;
import chamados.entidades.Chamado;
import chamados.entidades.ChamadoItem;
import chamados.mapeamento.ChamadoItemMapeamento;
import chamados.mapeamento.ChamadoMapeamento;

@Path("/chamado_item")
@Produces(APPLICATION_JSON)
@Consumes(APPLICATION_JSON)
public class ChamadoItemService {

	@EJB
    private ChamadoItemBean chamadoItemBean;

	
	@GET
	@Path("/{id}")
	public Response findById(@PathParam("id") Long id) {
		ChamadoItem chamado_item = chamadoItemBean.getChamadoItem(id);
		
		if (chamado_item != null)
			return Response.ok(chamado_item).build();
		
		return Response.status(NOT_FOUND).build();
	}
	
	
	@GET
	public Response findAllChamados() {
		List<ChamadoItem> allChamadoItens = chamadoItemBean.getAllChamadoItens();
		
		if (allChamadoItens != null)
			return Response.ok(allChamadoItens).build();
		
		return Response.status(NOT_FOUND).build();
	}
	
	@POST
	@Path("/adicionarChamadoItem/{idChamado}")
	@Consumes(APPLICATION_JSON)
	public Response adicionarItemChamado(ChamadoItemMapeamento chamado_item_mapeamento, @PathParam("idChamado") Long id) {
		ChamadoItem chamado_item = chamadoItemBean.cadastrarChamadoItem(chamado_item_mapeamento, id);
		
		if (chamado_item != null) {	 
			return Response.ok().build();
			
		}
		
		return Response.status(NOT_FOUND).build(); 

	}
	
	
}
