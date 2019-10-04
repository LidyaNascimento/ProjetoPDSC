package tads;


import static javax.ws.rs.core.HttpHeaders.AUTHORIZATION;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

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

import tads.jwtConfiguration.JsonTokenNeeded;
import tads.util.JwTokenHelper;


@Path("/")
@Produces(APPLICATION_JSON)
@Consumes(APPLICATION_JSON)
@Transactional
public class Gateway {
	
	@Context
	private HttpServletRequest httpRequest;

    @GET
    @Path("/all_users")
    @JsonTokenNeeded
    public Response getUser() {
    	String authorizationHeader = httpRequest.getHeader(HttpHeaders.AUTHORIZATION);
    	
        
		Client client = ClientBuilder.newClient();
		WebTarget webTarget = client.target("http://localhost:8080/Usuario/api/usuarios");
		
		Invocation.Builder invocationBuilder =  webTarget.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.get();
		
		return response;
    }

    
    
    @GET
    @Path("/getUser/{login}/{senha}")
    @Produces(MediaType.APPLICATION_JSON)
    //@Consumes(APPLICATION_FORM_URLENCODED)
    public Response getUser(@PathParam("login") String login, @PathParam("senha") String senha) {
    
    	String token = JwTokenHelper.getInstance().generateToken(login, senha);

		Client client = ClientBuilder.newClient();
		WebTarget webTarget = client.target("http://localhost:8080/Usuario/api/usuarios/" + login + "/" + senha + "/" + token);
		
		Invocation.Builder invocationBuilder =  webTarget.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.get();
		
		Response.ok().header(AUTHORIZATION, "Bearer " + token).build();
		
		
		return response;
    }
    
    /*@POST
    @Path("/new_user")
    @Produces(MediaType.APPLICATION_JSON)
    public Response addUser(Usuario newUser) {

		Client client = ClientBuilder.newClient();
		WebTarget webTarget = client.target("http://localhost:8080/ms1/api/users"); // alterar
		
		Invocation.Builder invocationBuilder =  webTarget.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.post(Entity.entity(newUser, MediaType.APPLICATION_JSON));
		 
		System.out.println(response.getStatus());
		System.out.println(response.readEntity(String.class));		
    	
		return Response.ok().build();
    }*/
}
