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
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import chamados.ejb.ChamadoBean;
import chamados.mapeamento.ChamadoMapeamento;
import chamados.entidades.Chamado;
import chamados.entidades.ChamadoItem;

@Path("/chamados")
@Produces(APPLICATION_JSON)
@Consumes(APPLICATION_JSON)
public class ChamadoService {
	
	@EJB
    private ChamadoBean chamadoBean;


	@GET
	@Path("/{id}")
	public Response findById(@PathParam("id") Long id) {
		Chamado chamado = chamadoBean.getChamado(id);
		
		if (chamado != null)
			return Response.ok(chamado).build();
		
		return Response.status(NOT_FOUND).build();
	}
	
	
	@GET
	@Path("/all_chamados")
	public Response findAllChamados() {
		List<Chamado> allChamados = chamadoBean.getAllChamados();
		
		if (allChamados != null)
			return Response.ok(allChamados).build();
		
		return Response.status(NOT_FOUND).build();
	}
	
	@POST
	@Path("/adicionarChamado")
	@Consumes(APPLICATION_JSON)
	public Response adicionarChamado(ChamadoMapeamento chamado_mapeamento) {
		Chamado service = chamadoBean.cadastrarChamado(chamado_mapeamento);
		
		
		if (service != null) {	
			return Response.ok().build();
			
		}
		
		return Response.status(NOT_FOUND).build(); 

	}
	
	@GET
	@Path("/chamados_by_idUser/{idUsuario}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response findChamadosByIdUser(@PathParam("idUsuario") Long id) {
		List<Chamado> allChamados = chamadoBean.getChamadoByUser(id);
		
		if (!allChamados.isEmpty())
			return Response.ok(allChamados).build();
		
		return Response.status(NOT_FOUND).build();
	}
	
	
	
	

}
