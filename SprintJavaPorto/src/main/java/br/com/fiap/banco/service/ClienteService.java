package br.com.fiap.banco.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.fiap.banco.dao.ClienteDAO;
import br.com.fiap.banco.exception.BadInfoException;
import br.com.fiap.banco.exception.IdNotFoundException;
import br.com.fiap.banco.factory.ConnectionFactory;
import br.com.fiap.banco.model.Cliente;

public class ClienteService {

	private ClienteDAO clienteDao;

	public ClienteService() throws ClassNotFoundException, SQLException {
		Connection conn = ConnectionFactory.getConnection();
		clienteDao = new ClienteDAO(conn);

	}

	public void cadastrar(Cliente cliente) throws ClassNotFoundException, SQLException, BadInfoException {
		clienteDao.cadastrar(cliente);
	}

	public List<Cliente> listar() throws ClassNotFoundException, SQLException {
		return clienteDao.listar();
	}

	public void remover(String cpf) throws ClassNotFoundException, SQLException, IdNotFoundException {
		clienteDao.remover(cpf);
	}

	public void atualizar(Cliente cliente)
			throws ClassNotFoundException, SQLException, IdNotFoundException, BadInfoException {
		clienteDao.atualizar(cliente);
	}

	
}