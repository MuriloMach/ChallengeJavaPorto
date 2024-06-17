package br.com.fiap.banco.resource;

import java.sql.SQLException;
import java.util.List;

import br.com.fiap.banco.exception.BadInfoException;
import br.com.fiap.banco.exception.IdNotFoundException;
import br.com.fiap.banco.model.Seguro;
import br.com.fiap.banco.service.SeguroService;
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

@Path("/seguro")// http://localhost:8080/SprintJavaPorto/api/seguro
public class SeguroResource {

	private SeguroService service;

	public SeguroResource() throws ClassNotFoundException, SQLException {
		service = new SeguroService();
	}

	//POST http://localhost:8080/SprintJavaPorto/api/seguro
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cadastrar(Seguro seguro, @Context UriInfo uri) throws ClassNotFoundException, SQLException {
		try {
			service.cadastrar(seguro);
			UriBuilder uriBuilder = uri.getAbsolutePathBuilder();
			uriBuilder.path((seguro.getCodigoSeguro()));
			return Response.created(uriBuilder.build()).build();
		} catch (BadInfoException e) {
			e.printStackTrace();
			return Response.status(Status.BAD_REQUEST).entity(e.getMessage()).build();
		}
	}


	//GET http://localhost:8080/SprintJavaPorto/api/seguro
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Seguro> lista() throws ClassNotFoundException, SQLException {
		return service.listar();
	}

	//DELETE http://localhost:8080/SprintJavaPorto/api/seguro/FR55H8
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

	// PUT http://localhost:8080/SprintJavaPorto/api/seguro/B6NM90
	@PUT
	@Path("/{numSerie}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response atualizar(Seguro seguro, @PathParam("numSerie") String numSerie)
			throws ClassNotFoundException, SQLException {
		try {
			seguro.setNumSerie(numSerie);
			service.atualizar(seguro);
			return Response.ok().build();
		} catch (IdNotFoundException e) {
			return Response.status(Status.NOT_FOUND).build();
		} catch (BadInfoException e) {
			return Response.status(Status.BAD_REQUEST).entity(e.getMessage()).build();
		}
	}

}