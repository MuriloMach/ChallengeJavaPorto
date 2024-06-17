package br.com.fiap.banco.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.banco.exception.IdNotFoundException;
import br.com.fiap.banco.model.Inspecao;

public class InspecaoDAO {

	private Connection conn;

	public InspecaoDAO(Connection conn) {
		this.conn = conn;
	}

	public void cadastrar(Inspecao inspecao) throws ClassNotFoundException, SQLException {

		// Criar o objeto com o comando SQL configuravel
		PreparedStatement stm = conn.prepareStatement(
				"INSERT INTO inspecao_java (cod_serie, analise, custo, dt_inspecao, qtd_inspecao, fiscalizacao)"
						+ " values(?,?,?,?,?,?)");

		// Setar os valores no comando SQL
		stm.setString(1, inspecao.getCodigoSerie());
		stm.setString(2, inspecao.getAnalise());
		stm.setInt(3, inspecao.getCusto());
		stm.setString(4, inspecao.getDataInspecao());
		stm.setInt(5, inspecao.getQtdInspecao());
		stm.setString(6, inspecao.getFiscalizacao());

		// Executar o comando SQL
		stm.executeUpdate();
	}

	public List<Inspecao> listar() throws ClassNotFoundException, SQLException {

		PreparedStatement stm = conn.prepareStatement("select * from inspecao_java");

		ResultSet result = stm.executeQuery();
		List<Inspecao> lista = new ArrayList<Inspecao>();

		while (result.next()) {
			Inspecao inspecao = parse(result);
			lista.add(inspecao);
		}

		return lista;
	}

	private Inspecao parse(ResultSet result) throws SQLException {

		String CodigoSerie = result.getString("cod_serie");
		String Analise = result.getString("analise");
		int Custo = result.getInt("custo");
		String DataInspecao = result.getString("dt_inspecao");
		int QtdInspecao = result.getInt("qtd_inspecao");
		String Fiscalizacao = result.getString("fiscalizacao");

		Inspecao inspecao = new Inspecao(CodigoSerie, Custo, DataInspecao, Fiscalizacao, QtdInspecao, Analise);

		return inspecao;
	}

	public void remover(String cod_serie) throws ClassNotFoundException, SQLException, IdNotFoundException {

		// PreparedStatement
		PreparedStatement stm = conn.prepareStatement("delete from inspecao_java where cod_serie = ?");
		// Setar os parametros na Query
		stm.setString(1, cod_serie);
		// Executar a Query
		int linha = stm.executeUpdate();
		if (linha == 0)
			throw new IdNotFoundException("Codigo de serie nao encontrado para remocao");
	}

	public void atualizar(Inspecao inspecao) throws ClassNotFoundException, SQLException, IdNotFoundException {

		// PreparedStatement
		PreparedStatement stm = conn.prepareStatement("update inspecao_java set custo = ? where cod_serie = ?");
		// Setar os parametros na Query
		stm.setInt(1, inspecao.getCusto());
		// stm.setDouble(1, 700);
		stm.setString(2, inspecao.getCodigoSerie());
		// Executar a Query
		int linha = stm.executeUpdate();
		if (linha == 0)
			throw new IdNotFoundException("Codigo de serie nao encontrado para atualizar");
	}

}