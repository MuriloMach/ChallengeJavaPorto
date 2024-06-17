package br.com.fiap.banco.model;

public class Veiculo {
	private String cor;
	private String modelo;
	
	public Veiculo() {	
	}
	
	public Veiculo(String recebeCor, String recebeModelo) {
		setCor(recebeCor);
		setModelo(recebeModelo);
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
}
