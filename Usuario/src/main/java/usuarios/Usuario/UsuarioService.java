package usuarios.Usuario;

import static javax.ws.rs.core.HttpHeaders.AUTHORIZATION;
import static javax.ws.rs.core.MediaType.APPLICATION_FORM_URLENCODED;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static javax.ws.rs.core.Response.Status.NOT_FOUND;

import java.util.List;

import javax.ejb.EJB;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

//import usuarios.jwtConfiguration.JsonTokenNeeded;
import usuarios.entidades.Usuario;
import usuarios.ejb.UsuarioBean;

@Path("/usuarios")
@Produces(APPLICATION_JSON)
@Consumes(APPLICATION_JSON)
@Transactional
public class UsuarioService {
	
	@EJB
    private UsuarioBean usuarioBean;

//	@POST
//	@Consumes(APPLICATION_FORM_URLENCODED)
//	public Response create(@FormParam("login") String login, @FormParam("password") String password) {
//		User user = userBean.cadastrarUsuario(login, PasswordUtils.digestPassword(password));
//		if (user != null)
//			return Response.ok(user).build();
//		return Response.status(NOT_FOUND).build();
//	}
	
	@GET
	@Path("/{login}/{senha}/{token}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response login(@PathParam("login") String login, @PathParam("senha") String senha, @PathParam("token") String token) {
		Usuario user = usuarioBean.login(login, senha);
		
		if (user!=null) {
			return Response.ok().header(AUTHORIZATION, "Bearer " + token).build();
		}
		return Response.status(NOT_FOUND).build(); 
	}

	@GET
	@Path("/{id}")
	public Response findById(@PathParam("id") Long id) {
		Usuario usuario = usuarioBean.getUsuario(id);
		if (usuario != null)
			return Response.ok(usuario).build();
		return Response.status(NOT_FOUND).build();
	}

	@GET
	public Response findAllUsuarios() {
		List<Usuario> allUsuarios = usuarioBean.getAllUsuarios();
		if (allUsuarios != null)
			return Response.ok(allUsuarios).build();
		return Response.status(NOT_FOUND).build();
	}
	
}