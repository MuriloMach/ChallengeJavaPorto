package br.com.fiap.banco.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.fiap.banco.dao.BikeDAO;
import br.com.fiap.banco.exception.BadInfoException;
import br.com.fiap.banco.exception.IdNotFoundException;
import br.com.fiap.banco.factory.ConnectionFactory;
import br.com.fiap.banco.model.Bike;

public class BikeService {

	private BikeDAO bikeDao;

	public BikeService() throws ClassNotFoundException, SQLException {
		Connection conn = ConnectionFactory.getConnection();
		bikeDao = new BikeDAO(conn);

	}

	public void cadastrar(Bike bike) throws ClassNotFoundException, SQLException, BadInfoException {
		bikeDao.cadastrar(bike);
	}

	public List<Bike> listar() throws ClassNotFoundException, SQLException {
		return bikeDao.listar();
	}

	public void remover(String numSerie) throws ClassNotFoundException, SQLException, IdNotFoundException {
		bikeDao.remover(numSerie);
	}

	public void atualizar(Bike bike)
			throws ClassNotFoundException, SQLException, IdNotFoundException, BadInfoException {
		bikeDao.atualizar(bike);
	}

}
