package br.com.fiap.banco.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.fiap.banco.dao.InspecaoDAO;
import br.com.fiap.banco.exception.BadInfoException;
import br.com.fiap.banco.exception.IdNotFoundException;
import br.com.fiap.banco.factory.ConnectionFactory;
import br.com.fiap.banco.model.Inspecao;

public class InspecaoService {

	private InspecaoDAO inspecaoDao;

	public InspecaoService() throws ClassNotFoundException, SQLException {
		Connection conn = ConnectionFactory.getConnection();
		inspecaoDao = new InspecaoDAO(conn);

	}

	public void cadastrar(Inspecao codSerie) throws ClassNotFoundException, SQLException, BadInfoException {
		inspecaoDao.cadastrar(codSerie);
	}

	public List<Inspecao> listar() throws ClassNotFoundException, SQLException {
		return inspecaoDao.listar();
	}

	public void remover(String codigoSerie) throws ClassNotFoundException, SQLException, IdNotFoundException {
		inspecaoDao.remover(codigoSerie);
	}

	public void atualizar(Inspecao inspecao)
			throws ClassNotFoundException, SQLException, IdNotFoundException, BadInfoException {
		inspecaoDao.atualizar(inspecao);
	}

}
