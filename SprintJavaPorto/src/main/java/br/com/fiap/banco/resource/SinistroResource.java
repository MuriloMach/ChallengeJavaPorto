package br.com.fiap.banco.resource;

import java.sql.SQLException;
import java.util.List;

import br.com.fiap.banco.exception.BadInfoException;
import br.com.fiap.banco.exception.IdNotFoundException;
import br.com.fiap.banco.model.Sinistro;
import br.com.fiap.banco.service.SinistroService;
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

@Path("/sinistro")// http://localhost:8080/SprintJavaPorto/api/sinistro
public class SinistroResource {

	private SinistroService service;

	public SinistroResource() throws ClassNotFoundException, SQLException {
		service = new SinistroService();
	}

	//POST http://localhost:8080/SprintJavaPorto/api/sinistro
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cadastrar(Sinistro sinistro, @Context UriInfo uri) throws ClassNotFoundException, SQLException {
		try {
			service.cadastrar(sinistro);
			UriBuilder uriBuilder = uri.getAbsolutePathBuilder();
			uriBuilder.path((sinistro.getIdSinistro()));
			return Response.created(uriBuilder.build()).build();
		} catch (BadInfoException e) {
			e.printStackTrace();
			return Response.status(Status.BAD_REQUEST).entity(e.getMessage()).build();
		}
	}

	//GET http://localhost:8080/SprintJavaPorto/api/sinistro
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Sinistro> lista() throws ClassNotFoundException, SQLException {
		return service.listar();
	}

	//DELETE http://localhost:8080/SprintJavaPorto/api/sinistro/ULI900
	@DELETE
	@Path("/{IdSinistro}")
	public Response remover(@PathParam("IdSinistro") String IdSinistro) throws ClassNotFoundException, SQLException {
		try {
			service.remover(IdSinistro);
			return Response.noContent().build();
		} catch (IdNotFoundException e) {
			return Response.status(Status.NOT_FOUND).build();
		}
	}

	// PUT http://localhost:8080/SprintJavaPorto/api/sinistro/RS937
	@PUT
	@Path("/{IdSinistro}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response atualizar(Sinistro sinistro, @PathParam("IdSinistro") String IdSinistro)
			throws ClassNotFoundException, SQLException {
		try {
			sinistro.setIdSinistro(IdSinistro);
			service.atualizar(sinistro);
			return Response.ok().build();
		} catch (IdNotFoundException e) {
			return Response.status(Status.NOT_FOUND).build();
		} catch (BadInfoException e) {
			return Response.status(Status.BAD_REQUEST).entity(e.getMessage()).build();
		}
	}

}
