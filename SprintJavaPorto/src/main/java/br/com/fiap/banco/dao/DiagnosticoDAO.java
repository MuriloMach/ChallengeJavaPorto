package br.com.fiap.banco.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.banco.exception.IdNotFoundException;
import br.com.fiap.banco.model.Diagnostico;

public class DiagnosticoDAO {

	private Connection conn;

	public DiagnosticoDAO(Connection conn) {
		this.conn = conn;
	}

	public void cadastrar(Diagnostico diagnostico) throws ClassNotFoundException, SQLException {

		// Criar o objeto com o comando SQL configuravel
		PreparedStatement stm = conn
				.prepareStatement("INSERT INTO diagnostico_java (registro_avaria, estado_geral, danos, id_sinistro)" + " values (?,?,?,?)");

		// Setar os valores no comando SQL
		stm.setString(1, diagnostico.getRegistroAvaria());
		stm.setString(2, diagnostico.getEstadoGeral());
		stm.setString(3, diagnostico.getDanos());
		stm.setString(4, diagnostico.getidSinistro());

		// Executar o comando SQL
		stm.executeUpdate();
	}

	public List<Diagnostico> listar() throws ClassNotFoundException, SQLException {

		PreparedStatement stm = conn.prepareStatement("select * from diagnostico_java");

		ResultSet result = stm.executeQuery();
		List<Diagnostico> lista = new ArrayList<Diagnostico>();

		while (result.next()) {
			Diagnostico diagnostico = parse(result);
			lista.add(diagnostico);
		}

		return lista;
	}

	private Diagnostico parse(ResultSet result) throws SQLException {

		String registroAvaria = result.getString("registro_avaria");
		String estadoGeral = result.getString("estado_geral");
		String danos = result.getString("danos");
		String idSinistro = result.getString("id_sinistro");

		Diagnostico diagnostico = new Diagnostico(registroAvaria, estadoGeral, danos, idSinistro);

		return diagnostico;
	}

	public void remover(String idSinistro) throws ClassNotFoundException, SQLException, IdNotFoundException {

		// PreparedStatement
		PreparedStatement stm = conn.prepareStatement("delete from diagnostico_java where id_sinistro = (?)");
		// Setar os parametros na Query
		stm.setString(1, idSinistro);
		// Executar a Query
		int linha = stm.executeUpdate();
		if (linha == 0)
			throw new IdNotFoundException("Id do sinistro nao encontrado para remocao");
	}

	public void atualizar(Diagnostico diagnostico) throws ClassNotFoundException, SQLException, IdNotFoundException {

		// PreparedStatement
		PreparedStatement stm = conn.prepareStatement("update diagnostico_java set danos = ? where id_sinistro = ?");
		// Setar os parametros na Query
		stm.setString(1, diagnostico.getDanos());
		// stm.setDouble(1, 700);
		stm.setString(2, diagnostico.getidSinistro());
		// Executar a Query
		int linha = stm.executeUpdate();
		if (linha == 0)
			throw new IdNotFoundException("Id do sinistro nao encontrado para atualizar");
	}

}