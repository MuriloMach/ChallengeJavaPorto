package br.com.fiap.banco.resource;

import java.sql.SQLException;
import java.util.List;

import br.com.fiap.banco.exception.BadInfoException;
import br.com.fiap.banco.exception.IdNotFoundException;
import br.com.fiap.banco.model.Inspecao;
import br.com.fiap.banco.service.InspecaoService;
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

@Path("/inspecao")// http://localhost:8080/SprintJavaPorto/api/inspecao
public class InspecaoResource {

	private InspecaoService service;

	public InspecaoResource() throws ClassNotFoundException, SQLException {
		service = new InspecaoService();
	}

	//POST http://localhost:8080/SprintJavaPorto/api/inspecao
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cadastrar(Inspecao inspecao, @Context UriInfo uri) throws ClassNotFoundException, SQLException {
		try {
			service.cadastrar(inspecao);
			UriBuilder uriBuilder = uri.getAbsolutePathBuilder();
			uriBuilder.path((inspecao.getCodigoSerie()));
			return Response.created(uriBuilder.build()).build();
		} catch (BadInfoException e) {
			e.printStackTrace();
			return Response.status(Status.BAD_REQUEST).entity(e.getMessage()).build();
		}
	}

	//GET http://localhost:8080/SprintJavaPorto/api/inspecao
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Inspecao> lista() throws ClassNotFoundException, SQLException {
		return service.listar();
	}

	
	//DELETE http://localhost:8080/SprintJavaPorto/api/inspecao/XCY456
	@DELETE
	@Path("/{codigoSerie}")
	public Response remover(@PathParam("codigoSerie") String codigoSerie) throws ClassNotFoundException, SQLException {
		try {
			service.remover(codigoSerie);
			return Response.noContent().build();
		} catch (IdNotFoundException e) {
			return Response.status(Status.NOT_FOUND).build();
		}
	}

	// PUT http://localhost:8080/SprintJavaPorto/api/inspecao/GHI345
	@PUT
	@Path("/{codigoSerie}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response atualizar(Inspecao inspecao, @PathParam("codigoSerie") String codigoSerie)
			throws ClassNotFoundException, SQLException {
		try {
			inspecao.setCodigoSerie(codigoSerie);
			service.atualizar(inspecao);
			return Response.ok().build();
		} catch (IdNotFoundException e) {
			return Response.status(Status.NOT_FOUND).build();
		} catch (BadInfoException e) {
			return Response.status(Status.BAD_REQUEST).entity(e.getMessage()).build();
		}
	}

}