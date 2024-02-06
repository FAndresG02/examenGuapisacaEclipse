package ec.edu.ups.ppw.examenGuapisaca.services;

import java.util.List;

import ec.edu.ups.ppw.examenGuapisaca.Operadora;
import ec.edu.ups.ppw.examenGuapisaca.business.GestionOperadoras;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("operadoras")
public class OperadoraServices {
	@Inject
	private GestionOperadoras gOperadoras;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	//@Produces("application/json")
	public Response getOperadoraById(@QueryParam("codigo") int codigo) {
		try{
			System.out.println("codigo " + codigo);
			Operadora cli = gOperadoras.getOperadoraPorId(codigo);
			return Response.ok(cli).build();
		}catch (Exception e) {
			// TODO: handle exception
			ErrorMessage error = new ErrorMessage(4, "Producto no existe");
			return Response.status(Response.Status.NOT_FOUND)
					.entity(error)
					.build();
		}
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("list")
	public Response getProductos(){
		List<Operadora> operadora = gOperadoras.getOperadoras();
		if(operadora.size()>0)
			return Response.ok(operadora).build();
		
		ErrorMessage error = new ErrorMessage(6, "No se registran Operadoras");
		return Response.status(Response.Status.NOT_FOUND)
				.entity(error)
				.build();
		
	}
}
