package br.com.fiap.banco.model;

public class Sinistro {
	private String roubo;
	private String quebra;
	private String idSinistro; 
	private String gravidade;
	private int valorManutencao; 
	
	//Construtor Vazio
	public Sinistro() {
    }
	

	//Construtor Cheio
	public Sinistro(String recebeRoubo, String recebeQuebra, String recebeIdSinistro, String recebeGravidade, int recebeValorManutencao) {
	setRoubo(recebeRoubo);
	setQuebra(recebeQuebra);
	setIdSinistro(recebeIdSinistro);
	setGravidade(recebeGravidade);
	setValorManutencao(recebeValorManutencao);}
	
	
	public String getIdSinistro() {
		return idSinistro;
	}

	public void setIdSinistro(String idSinistro) {
		this.idSinistro = idSinistro;
	}

	public String getGravidade() {
		return gravidade;
	}

	public void setGravidade(String gravidade) {
		this.gravidade = gravidade;
	}

	public int getValorManutencao() {
		return valorManutencao;
	}

	public void setValorManutencao(int valorManutencao) {
		this.valorManutencao = valorManutencao;
	}
	
	public String getRoubo() {
		return roubo;
	}
	public void setRoubo(String roubo) {
		this.roubo = roubo;
	}
	public String getQuebra() {
		return quebra;
	}
	public void setQuebra(String quebra) {
		this.quebra = quebra;
	}
	



}