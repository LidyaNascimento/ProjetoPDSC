package usuarios.Usuario;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static javax.ws.rs.core.Response.Status.NOT_FOUND;

import java.util.List;

import javax.ejb.EJB;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import usuarios.ejb.CargoBean;
import usuarios.entidades.Cargo;

@Path("/cargos")
@Produces(APPLICATION_JSON)
@Consumes(APPLICATION_JSON)
public class CargoService {
	
	
	@EJB
    private CargoBean cargoBean;
	
	@GET
	public Response findAllCargos() {
		List<Cargo> allCargos = cargoBean.getAllCargos();
		if (allCargos != null)
			return Response.ok(allCargos).build();
		return Response.status(NOT_FOUND).build();
	}

}
