package br.com.fiap.banco.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.banco.exception.IdNotFoundException;
import br.com.fiap.banco.model.Seguro;

public class SeguroDAO {

	private Connection conn;

	public SeguroDAO(Connection conn) {
		this.conn = conn;
	}

	public void cadastrar(Seguro seguro) throws ClassNotFoundException, SQLException {

		// Criar o objeto com o comando SQL configuravel
		PreparedStatement stm = conn.prepareStatement(
				"INSERT INTO seguro_java (cod_seguro, dt_contratacao, clausulas, pagamento, valor_seguro, num_serie)"
						+ " values (?,?,?,?,?,?)");

		// Setar os valores no comando SQL
		stm.setString(1, seguro.getCodigoSeguro());
		stm.setString(2, seguro.getDataContratacao());
		stm.setString(3, seguro.getClausulas());
		stm.setString(4, seguro.getPagamento());
		stm.setInt(5, seguro.getValorSeguro());
		stm.setString(6, seguro.getNumSerie());

		// Executar o comando SQL
		stm.executeUpdate();
	}

	public List<Seguro> listar() throws ClassNotFoundException, SQLException {

		PreparedStatement stm = conn.prepareStatement("select * from seguro_java");

		ResultSet result = stm.executeQuery();
		List<Seguro> lista = new ArrayList<Seguro>();

		while (result.next()) {
			Seguro seguro = parse(result);
			lista.add(seguro);
		}

		return lista;
	}

	private Seguro parse(ResultSet result) throws SQLException {

		String codSeguro = result.getString("cod_seguro");
		String dataContratacao = result.getString("dt_contratacao");
		String clausulas = result.getString("clausulas");
		String pagamento = result.getString("pagamento");
		int valorSeguro = result.getInt("valor_seguro");
		String numSerie = result.getString("num_serie");

		Seguro seguro = new Seguro(dataContratacao, codSeguro, pagamento, valorSeguro, clausulas, numSerie);

		return seguro;
	}

	public void remover(String numSerie) throws ClassNotFoundException, SQLException, IdNotFoundException {

		// PreparedStatement
		PreparedStatement stm = conn.prepareStatement("delete from seguro_java where num_serie = (?)");
		// Setar os parametros na Query
		stm.setString(1, numSerie);
		// Executar a Query
		int linha = stm.executeUpdate();
		if (linha == 0)
			throw new IdNotFoundException("Numero de serie nao encontrado para remocao");
	}

	public void atualizar(Seguro seguro) throws ClassNotFoundException, SQLException, IdNotFoundException {

		// PreparedStatement
		PreparedStatement stm = conn.prepareStatement("update seguro_java set valor_seguro = ? where num_serie = ?");
		// Setar os parametros na Query
		stm.setInt(1, seguro.getValorSeguro());
		// stm.setDouble(1, 700);
		stm.setString(2, seguro.getNumSerie());
		// Executar a Query
		int linha = stm.executeUpdate();
		if (linha == 0)
			throw new IdNotFoundException("Numero de serie nao encontrado para atualizar");
	}
}