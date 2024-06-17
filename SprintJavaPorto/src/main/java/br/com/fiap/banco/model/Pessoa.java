package br.com.fiap.banco.model;

public class Pessoa {
	private String nome;
	private String cpf;
	private String endereco;
	private String telefone;
	private String sexo;
	
	//Construtor Vazio
	public Pessoa() {
    }
	
	//Construtor Cheio
	public Pessoa(String recebeNome, String recebeCpf, String recebeEndereco, String recebeTelefone, String recebeSexo) {
		setNome(recebeNome);
		setCpf(recebeCpf);
		setEndereco(recebeEndereco);
		setTelefone(recebeTelefone);
		setSexo(recebeSexo);
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

}