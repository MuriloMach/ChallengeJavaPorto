package br.com.fiap.banco.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.fiap.banco.dao.SinistroDAO;
import br.com.fiap.banco.exception.BadInfoException;
import br.com.fiap.banco.exception.IdNotFoundException;
import br.com.fiap.banco.factory.ConnectionFactory;
import br.com.fiap.banco.model.Sinistro;

public class SinistroService {

	private SinistroDAO sinistroDao;

	public SinistroService() throws ClassNotFoundException, SQLException {
		Connection conn = ConnectionFactory.getConnection();
		sinistroDao = new SinistroDAO(conn);

	}

	public void cadastrar(Sinistro sinistro) throws ClassNotFoundException, SQLException, BadInfoException {
		sinistroDao.cadastrar(sinistro);
	}

	public List<Sinistro> listar() throws ClassNotFoundException, SQLException {
		return sinistroDao.listar();
	}

	public void remover(String idSinistro) throws ClassNotFoundException, SQLException, IdNotFoundException {
		sinistroDao.remover(idSinistro);

	}

	public void atualizar(Sinistro sinistro)
			throws ClassNotFoundException, SQLException, IdNotFoundException, BadInfoException {
		sinistroDao.atualizar(sinistro);
	}

}