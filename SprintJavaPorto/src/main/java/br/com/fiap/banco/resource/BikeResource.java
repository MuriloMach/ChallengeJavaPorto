package br.com.fiap.banco.resource;

import java.sql.SQLException;
import java.util.List;
import br.com.fiap.banco.exception.BadInfoException;
import br.com.fiap.banco.exception.IdNotFoundException;
import br.com.fiap.banco.model.Bike;
import br.com.fiap.banco.service.BikeService;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import jakarta.ws.rs.core.UriBuilder;
import jakarta.ws.rs.core.UriInfo;

@Path("/bike")// http://localhost:8080/SprintJavaPorto/api/bike
public class BikeResource {

	private BikeService service;

	public BikeResource() throws ClassNotFoundException, SQLException {
		service = new BikeService();
	}
	
	//POST http://localhost:8080/SprintJavaPorto/api/bike
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cadastrar(Bike bike, @Context UriInfo uri) throws ClassNotFoundException, SQLException {
		try {
			service.cadastrar(bike);
			UriBuilder uriBuilder = uri.getAbsolutePathBuilder();
			uriBuilder.path((bike.getModelo()));
			return Response.created(uriBuilder.build()).build();
		} catch (BadInfoException e) {
			e.printStackTrace();
			return Response.status(Status.BAD_REQUEST).entity(e.getMessage()).build();
		}
	}
	
	//GET http://localhost:8080/SprintJavaPorto/api/bike
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Bike> lista() throws ClassNotFoundException, SQLException {
		return service.listar();
	}

	//DELETE http://localhost:8080/SprintJavaPorto/api/bike/BAC123
	@DELETE
	@Path("/{numSerie}")
	public Response remover(@PathParam("numSerie") String numSerie) throws ClassNotFoundException, SQLException {
		try {
			service.remover(numSerie);
			return Response.noContent().build();
		} catch (IdNotFoundException e) {
			return Response.status(Status.NOT_FOUND).build();
		}
	}

	// PUT http://localhost:8080/SprintJavaPorto/api/bike/ABC123
	@PUT
	@Path("/{numSerie}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response atualizar(Bike bike, @PathParam("numSerie") String numSerie)
			throws ClassNotFoundException, SQLException {
		try {
			bike.setNumSerie(numSerie);
			service.atualizar(bike);
			return Response.ok().build();
		} catch (IdNotFoundException e) {
			return Response.status(Status.NOT_FOUND).build();
		} catch (BadInfoException e) {
			return Response.status(Status.BAD_REQUEST).entity(e.getMessage()).build();
		}
	}

}
