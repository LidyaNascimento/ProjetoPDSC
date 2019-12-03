package tads;


import static javax.ws.rs.core.HttpHeaders.AUTHORIZATION;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static javax.ws.rs.core.Response.Status.NOT_FOUND;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import static javax.ws.rs.core.MediaType.APPLICATION_FORM_URLENCODED;

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
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import entidades.Cliente;
import entidades.Funcionario;
import entidades.Login;
import entidades.Usuario;
import tads.jwtConfiguration.JsonTokenNeeded;
import tads.util.JwTokenHelper;


@Path("/")
@Produces(APPLICATION_JSON)
@Consumes(APPLICATION_JSON)
public class Gateway {
	
	@Context
	private HttpServletRequest httpRequest;

    @GET
    @Path("/all_users")
    @JsonTokenNeeded
    public Response getAllUsers() {
		
    	Client client = ClientBuilder.newClient();
		WebTarget webTarget = client.target("http://localhost:8080/Usuario/api/usuarios");
		
		Invocation.Builder invocationBuilder =  webTarget.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.get();
		
		return response;
    }

    
    
    @POST
    @Path("/login")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getUser(Login login) {
    
    	String token = JwTokenHelper.getInstance().generateToken(login.getLogin(), login.getSenha());
    	login.setToken(token);

		Client client = ClientBuilder.newClient();
		WebTarget webTarget = client.target("http://localhost:8080/Usuario/api/usuarios/loginUsuario");
		
		Invocation.Builder invocationBuilder =  webTarget.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.post(Entity.entity(login, MediaType.APPLICATION_JSON));
		
		
		Response.ok().header(AUTHORIZATION, "Bearer " + token).build();
		
		
		return response;
    }
    
    @POST
    @Path("/cadastrarCliente")
    @Produces(MediaType.APPLICATION_JSON)
    public Response cadastroCliente(Cliente cliente) {
    	
    	Client client = ClientBuilder.newClient();
		WebTarget webTarget = client.target("http://localhost:8080/Usuario/api/clientes/adicionarCliente");
		
		
		Invocation.Builder invocationBuilder =  webTarget.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.post(Entity.entity(cliente, MediaType.APPLICATION_JSON));
		
		return response;
    }
    
    @POST
    @Path("/cadastrarFuncionario")
    @Produces(MediaType.APPLICATION_JSON)
    public Response cadastroFuncionario(Funcionario func) {
    	
    	Client client = ClientBuilder.newClient();
		WebTarget webTarget = client.target("http://localhost:8080/Usuario/api/funcionarios/adicionarFuncionario");
		
		
		Invocation.Builder invocationBuilder =  webTarget.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.post(Entity.entity(func, MediaType.APPLICATION_JSON));
		
		return response;
    }
    
    @GET
	@Path("getFuncionario/{id}")
    public Response getFuncionario(@PathParam("id") Long id) {
		Client client = ClientBuilder.newClient();
		WebTarget webTarget = client.target("http://localhost:8080/Usuario/api/funcionarios/" + id );
		
		Invocation.Builder invocationBuilder =  webTarget.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.get();
		
		return response;
    }
	


}
    
