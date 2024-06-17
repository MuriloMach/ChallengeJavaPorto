package br.com.fiap.banco.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.banco.exception.IdNotFoundException;
import br.com.fiap.banco.model.Sinistro;

public class SinistroDAO {

	private Connection conn;

	public SinistroDAO(Connection conn) {
		this.conn = conn;
	}

	public void cadastrar(Sinistro sinistro) throws ClassNotFoundException, SQLException {

		// Criar o objeto com o comando SQL configuravel
		PreparedStatement stm = conn
				.prepareStatement("INSERT INTO sinistro_java (id_sinistro,roubo, quebra, gravidade, valor_manu)"
						+ " values (?, ?,?,?,?)");

		// Setar os valores no comando SQL
		stm.setString(1, sinistro.getIdSinistro());
		stm.setString(2, sinistro.getRoubo());
		stm.setString(3, sinistro.getQuebra());
		stm.setString(4, sinistro.getGravidade());
		stm.setInt(5, sinistro.getValorManutencao());

		// Executar o comando SQL
		stm.executeUpdate();
	}

	public List<Sinistro> listar() throws ClassNotFoundException, SQLException {

		PreparedStatement stm = conn.prepareStatement("select * from sinistro_java");

		ResultSet result = stm.executeQuery();
		List<Sinistro> lista = new ArrayList<Sinistro>();

		while (result.next()) {
			Sinistro sinistro = parse(result);
			lista.add(sinistro);
		}

		return lista;
	}

	private Sinistro parse(ResultSet result) throws SQLException {

		String idSinistro = result.getString("id_sinistro");
		String roubo = result.getString("roubo");
		String quebra = result.getString("quebra");
		String gravidade = result.getString("gravidade");
		int valorManutencao = result.getInt("valor_manu");

		Sinistro sinistro = new Sinistro(roubo, quebra, idSinistro, gravidade, valorManutencao);

		return sinistro;
	}

	public void remover(String id_sinistro) throws ClassNotFoundException, SQLException, IdNotFoundException {

		// PreparedStatement
		PreparedStatement stm = conn.prepareStatement("delete from sinistro_java where id_sinistro = ?");
		// Setar os parametros na Query
		stm.setString(1, id_sinistro);
		// Executar a Query
		int linha = stm.executeUpdate();
		if (linha == 0)
			throw new IdNotFoundException("Id do sinistro nao encontrado para remocao");
	}

	public void atualizar(Sinistro sinistro) throws ClassNotFoundException, SQLException, IdNotFoundException {

		// PreparedStatement
		PreparedStatement stm = conn.prepareStatement("update sinistro_java set roubo = ? where id_sinistro = ?");
		// Setar os parametros na Query
		stm.setString(1, sinistro.getRoubo());
		// stm.setDouble(1, 700);
		stm.setString(2, sinistro.getIdSinistro());
		// Executar a Query
		int linha = stm.executeUpdate();
		if (linha == 0)
			throw new IdNotFoundException("Id do sinistro nao encontrado para atualizar");
	}

}