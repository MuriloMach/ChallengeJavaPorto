package br.com.fiap.banco.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.fiap.banco.dao.SeguroDAO;
import br.com.fiap.banco.exception.BadInfoException;
import br.com.fiap.banco.exception.IdNotFoundException;
import br.com.fiap.banco.factory.ConnectionFactory;
import br.com.fiap.banco.model.Seguro;

public class SeguroService {

	private SeguroDAO seguroDao;

	public SeguroService() throws ClassNotFoundException, SQLException {
		Connection conn = ConnectionFactory.getConnection();
		seguroDao = new SeguroDAO(conn);

	}

	public void cadastrar(Seguro seguro) throws ClassNotFoundException, SQLException, BadInfoException {
		seguroDao.cadastrar(seguro);
	}

	public List<Seguro> listar() throws ClassNotFoundException, SQLException {
		return seguroDao.listar();
	}

	public void remover(String numSerie) throws ClassNotFoundException, SQLException, IdNotFoundException {
		seguroDao.remover(numSerie);
	}

	public void atualizar(Seguro seguro)
			throws ClassNotFoundException, SQLException, IdNotFoundException, BadInfoException {
		// validar(produto);
		seguroDao.atualizar(seguro);
	}
}
