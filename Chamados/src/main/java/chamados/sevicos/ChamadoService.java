package chamados.sevicos;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static javax.ws.rs.core.Response.Status.NOT_FOUND;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import chamados.ejb.ChamadoBean;
import chamados.entidades.Chamado;

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
	public Response findAllChamados() {
		List<Chamado> allChamados = chamadoBean.getAllChamados();
		if (allChamados != null)
			return Response.ok(allChamados).build();
		return Response.status(NOT_FOUND).build();
	}
	
	

}
