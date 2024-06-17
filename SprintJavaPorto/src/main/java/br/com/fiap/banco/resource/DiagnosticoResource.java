package br.com.fiap.banco.resource;

import java.sql.SQLException;
import java.util.List;

import br.com.fiap.banco.exception.BadInfoException;
import br.com.fiap.banco.exception.IdNotFoundException;
import br.com.fiap.banco.model.Diagnostico;
import br.com.fiap.banco.service.DiagnosticoService;
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

@Path("/diagnostico")// http://localhost:8080/SprintJavaPorto/api/diagnostico
public class DiagnosticoResource {

	private DiagnosticoService service;

	public DiagnosticoResource() throws ClassNotFoundException, SQLException {
		service = new DiagnosticoService();
	}

	@POST //POST http://localhost:8080/SprintJavaPorto/api/diagnostico
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cadastrar(Diagnostico diagnostico, @Context UriInfo uri) throws ClassNotFoundException, SQLException {
		try {
			service.cadastrar(diagnostico);
			UriBuilder uriBuilder = uri.getAbsolutePathBuilder();
			uriBuilder.path((diagnostico.getEstadoGeral()));
			return Response.created(uriBuilder.build()).build();
		} catch (BadInfoException e) {
			e.printStackTrace();
			return Response.status(Status.BAD_REQUEST).entity(e.getMessage()).build();
		}
	}

	@GET //GET http://localhost:8080/SprintJavaPorto/api/diagnostico
	@Produces(MediaType.APPLICATION_JSON)
	public List<Diagnostico> lista() throws ClassNotFoundException, SQLException {
		return service.listar();
	}

	@DELETE //DELETE http://localhost:8080/SprintJavaPorto/api/diagnostico/SEN143
	@Path("/{idSinistro}")
	public Response remover(@PathParam("idSinistro") String idSinistro) throws ClassNotFoundException, SQLException {
		try {
			service.remover(idSinistro);
			return Response.noContent().build();
		} catch (IdNotFoundException e) {
			return Response.status(Status.NOT_FOUND).build();
		}
	}

	// PUT http://localhost:8080/SprintJavaPorto/api/diagnostico/MMP039
	@PUT
	@Path("/{idSinistro}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response atualizar(Diagnostico diagnostico, @PathParam("idSinistro") String idSinistro)
			throws ClassNotFoundException, SQLException {
		try {
			diagnostico.setidSinistro(idSinistro);
			service.atualizar(diagnostico);
			return Response.ok().build();
		} catch (IdNotFoundException e) {
			return Response.status(Status.NOT_FOUND).build();
		} catch (BadInfoException e) {
			return Response.status(Status.BAD_REQUEST).entity(e.getMessage()).build();
		}
	}

}
