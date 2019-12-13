package tads;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import entidades.Chamado;
import entidades.ChamadoItem;
import tads.jwtConfiguration.JsonTokenNeeded;

@Path("/chamado")
@Produces(APPLICATION_JSON)
@Consumes(APPLICATION_JSON)
public class ChamadoGateway {
	
	@Context
	private HttpServletRequest httpRequest;
	
	@GET
    @Path("/all_chamados")
	@Produces(MediaType.APPLICATION_JSON)
//	@JsonTokenNeeded
    public Response getChamados() {
		Client client = ClientBuilder.newClient();
		
		WebTarget webTarget = client.target("http://localhost:8080/Chamados/api/chamados/all_chamados");
		
		Invocation.Builder invocationBuilder =  webTarget.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.get();
		
		return response;
    }
	
	 @POST
	 @Path("/cadastrarChamado")
	 @Produces(MediaType.APPLICATION_JSON)
	 public Response cadastroChamado(Chamado service) {
	    	
		Client client = ClientBuilder.newClient();
		WebTarget webTarget = client.target("http://localhost:8080/Chamados/api/chamados/adicionarChamado");	
			
		Invocation.Builder invocationBuilder =  webTarget.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.post(Entity.entity(service, MediaType.APPLICATION_JSON));
		
			
		return response;
	 }
	 

	@GET
	@Path("/getChamado/{id}")
	public Response getChamado(@PathParam("id") Long id) {
		Client client = ClientBuilder.newClient();
		WebTarget webTarget = client.target("http://localhost:8080/Chamados/api/chamados/" + id);
			
		Invocation.Builder invocationBuilder =  webTarget.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.get();
			
		return response;
	}
	
	 @POST
	 @Path("/cadastrarChamadoItem/{idChamado}")
	 @Produces(MediaType.APPLICATION_JSON)
	 public Response cadastroChamadoItem(ChamadoItem service, @PathParam("idChamado") Long id) {
	    	
		
		Client client = ClientBuilder.newClient();
		WebTarget webTargetChamado = client.target("http://localhost:8080/Chamados/api/chamado_item/adicionarChamadoItem/" + id);	
			
		Invocation.Builder invocationBuilder =  webTargetChamado.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.post(Entity.entity(service, MediaType.APPLICATION_JSON));
		
			
		return response;
	 }
	 
		@GET
	    @Path("/ChamadosByIdUser/{idUser}")
	    public Response getChamadosByUser(@PathParam("idUser") Long id) {
			Client client = ClientBuilder.newClient();
			
			
			WebTarget webTarget = client.target("http://localhost:8080/Chamados/api/chamados/chamados_by_idUser/" + id);
			
			Invocation.Builder invocationBuilder =  webTarget.request(MediaType.APPLICATION_JSON);
			Response response = invocationBuilder.get();
			
			return response;
	    }
	
	 
	 
}
