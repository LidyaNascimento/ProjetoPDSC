package usuarios.Usuario;

import static javax.ws.rs.core.HttpHeaders.AUTHORIZATION;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static javax.ws.rs.core.Response.Status.NOT_FOUND;

import java.util.List;

import javax.ejb.EJB;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import usuarios.entidades.Cliente;
import usuarios.ejb.ClienteBean;

@Path("/clientes")
@Produces(APPLICATION_JSON)
@Consumes(APPLICATION_JSON)
public class ClienteService {
	
	
	@EJB
    private ClienteBean clienteBean;


	@GET
	@Path("/{id}")
	public Response findById(@PathParam("id") Long id) {
		Cliente cliente = clienteBean.getCliente(id);
		if (cliente != null)
			return Response.ok(cliente).build();
		return Response.status(NOT_FOUND).build();
	}

	@GET
	public Response findAllClientes() {
		List<Cliente> allClientes = clienteBean.getAllClientes();
		if (allClientes != null)
			return Response.ok(allClientes).build();
		return Response.status(NOT_FOUND).build();
	}
	
	@POST
	@Path("/adicionarCliente")
	@Consumes(APPLICATION_JSON)
	public Response cadastrarCliente(Cliente cliente) {
		Cliente user = clienteBean.cadastrarCliente(cliente);
		System.out.println("//////////////");
		System.out.println("user: " + user.getNome());
		
		if (user!=null) {	
			System.out.println("userMetodo: " + user.getNome());
			return Response.ok().build();
			
		}
		
		return Response.status(NOT_FOUND).build(); 

	}
	
}