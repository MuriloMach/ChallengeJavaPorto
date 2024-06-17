package br.com.fiap.banco.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.banco.exception.IdNotFoundException;
import br.com.fiap.banco.model.Cliente;

public class ClienteDAO {

	private Connection conn;

	public ClienteDAO(Connection conn) {
		this.conn = conn;
	}

	public void cadastrar(Cliente cliente) throws ClassNotFoundException, SQLException {

		// Criar o objeto com o comando SQL configuravel
		PreparedStatement stm = conn.prepareStatement(
				"INSERT INTO cliente_java (cpf, tel_cliente, email, endereco, nome_cliente, sexo_cliente, ano_nasc, senha)"
						+ " values (?,?,?,?,?,?,?,?)");

		// Setar os valores no comando SQL
		stm.setString(1, cliente.getCpf());
		stm.setString(2, cliente.getTelefone());
		stm.setString(3, cliente.getEmail());
		stm.setString(4, cliente.getEndereco());
		stm.setString(5, cliente.getNome());
		stm.setString(6, cliente.getSexo());
		stm.setInt(7, cliente.getAnoNasc());
		stm.setString(8, cliente.getSenha());

		// Executar o comando SQL
		stm.executeUpdate();
	}

	public List<Cliente> listar() throws ClassNotFoundException, SQLException {

		PreparedStatement stm = conn.prepareStatement("select * from cliente_java");

		ResultSet result = stm.executeQuery();
		List<Cliente> lista = new ArrayList<Cliente>();

		while (result.next()) {
			Cliente cliente = parse(result);
			lista.add(cliente);
		}

		return lista;
	}

	private Cliente parse(ResultSet result) throws SQLException {

		String cpf = result.getString("cpf");
		String telefone = result.getString("tel_cliente");
		String email = result.getString("email");
		String endereco = result.getString("endereco");
		String nome = result.getString("nome_cliente");
		String sexo = result.getString("sexo_cliente");
		int anoNasc = result.getInt("ano_nasc");
		String senha = result.getString("senha");

		Cliente cliente = new Cliente(nome, cpf, anoNasc, endereco,telefone, sexo, email, senha);

		return cliente;
	}

	public void remover(String cpf) throws ClassNotFoundException, SQLException, IdNotFoundException {

		// PreparedStatement
		PreparedStatement stm = conn.prepareStatement("delete from cliente_java where cpf = ?");
		// Setar os parametros na Query
		stm.setString(1, cpf);
		// Executar a Query
		int linha = stm.executeUpdate();
		if (linha == 0)
			throw new IdNotFoundException("CPF nao encontrado para remocao");
	}

	public void atualizar(Cliente cliente) throws ClassNotFoundException, SQLException, IdNotFoundException {

		// PreparedStatement
		PreparedStatement stm = conn.prepareStatement("update cliente_java set endereco = ? where cpf = ?");
		// Setar os parametros na Query
		stm.setString(1, cliente.getEndereco());
		// stm.setDouble(1, 700);
		stm.setString(2, cliente.getCpf());
		// Executar a Query
		int linha = stm.executeUpdate();
		if (linha == 0)
			throw new IdNotFoundException("CPF nao encontrado para atualizar");
	}

}
