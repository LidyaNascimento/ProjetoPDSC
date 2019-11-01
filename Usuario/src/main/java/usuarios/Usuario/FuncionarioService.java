package usuarios.Usuario;

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
import usuarios.entidades.Funcionario;
import usuarios.ejb.FuncionarioBean;

@Path("/funcionarios")
@Produces(APPLICATION_JSON)
@Consumes(APPLICATION_JSON)
public class FuncionarioService {
	
	@EJB
    private FuncionarioBean funcionarioBean;


	@GET
	@Path("/{id}")
	public Response findById(@PathParam("id") Long id) {
		Funcionario funcionario = funcionarioBean.getFuncionario(id);
		if (funcionario != null)
			return Response.ok(funcionario).build();
		return Response.status(NOT_FOUND).build();
	}

	@GET
	public Response findAllFuncionarios() {
		List<Funcionario> allFuncionarios = funcionarioBean.getAllFuncionarios();
		if (allFuncionarios != null)
			return Response.ok(allFuncionarios).build();
		return Response.status(NOT_FOUND).build();
	}
	
	@POST
	@Path("/adicionarFuncionario")
	@Consumes(APPLICATION_JSON)
	public Response cadastrarFuncionario(Funcionario func) {
		Funcionario user = funcionarioBean.cadastrarFuncionario(func);
		
		if (user!=null) {	
			return Response.ok().build();
			
		}
		
		return Response.status(NOT_FOUND).build(); 

	}
	
}