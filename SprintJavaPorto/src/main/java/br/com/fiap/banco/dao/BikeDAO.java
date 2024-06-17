package br.com.fiap.banco.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import br.com.fiap.banco.exception.IdNotFoundException;
import br.com.fiap.banco.model.Bike;

public class BikeDAO {

	private Connection conn;

	public BikeDAO(Connection conn) {
		this.conn = conn;
	}

	public void cadastrar(Bike bike) throws ClassNotFoundException, SQLException {

		// Criar o objeto com o comando SQL configuravel
		PreparedStatement stm = conn
				.prepareStatement("INSERT INTO bike_java (num_serie, ano_compra, cor, modelo)" + " values (?,?,?,?)");

		// Setar os valores no comando SQL
		stm.setString(1, bike.getNumSerie());
		stm.setInt(2, bike.getAnoCompra());
		stm.setString(3, bike.getCor());
		stm.setString(4, bike.getModelo());

		// Executar o comando SQL
		stm.executeUpdate();
	}

	public List<Bike> listar() throws ClassNotFoundException, SQLException {

		PreparedStatement stm = conn.prepareStatement("select * from bike_java");

		ResultSet result = stm.executeQuery();
		List<Bike> lista = new ArrayList<Bike>();

		while (result.next()) {
			Bike bike = parse(result);
			lista.add(bike);
		}

		return lista;
	}

	private Bike parse(ResultSet result) throws SQLException {

		String numSerie = result.getString("num_serie");
		int anoCompra = result.getInt("ano_compra");
		String cor = result.getString("cor");
		String modelo = result.getString("modelo");

		Bike bike = new Bike(cor, modelo, numSerie, anoCompra);

		return bike;
	}

	public void remover(String numSerie) throws ClassNotFoundException, SQLException, IdNotFoundException {

		// PreparedStatement
		PreparedStatement stm = conn.prepareStatement("delete from bike_java where num_serie = ?");
		// Setar os parametros na Query
		stm.setString(1, numSerie);
		// Executar a Query
		int linha = stm.executeUpdate();
		if (linha == 0)
			throw new IdNotFoundException("Número de serie nao encontrado para remocao");
	}

	public void atualizar(Bike bike) throws ClassNotFoundException, SQLException, IdNotFoundException {

		// PreparedStatement
		PreparedStatement stm = conn.prepareStatement("update bike_java set modelo = ? where num_serie = ?");
		// Setar os parametros na Query
		stm.setString(1, bike.getModelo());
		// stm.setDouble(1, 700);
		stm.setString(2, bike.getNumSerie());
		// Executar a Query
		int linha = stm.executeUpdate();
		if (linha == 0)
			throw new IdNotFoundException("Numero de serie nao encontrado para atualizar");
	}

}