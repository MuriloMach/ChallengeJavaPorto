package br.com.fiap.banco.model;

public class Diagnostico {

	private String estadoGeral;
	private String danos;
	private String registroAvaria;
	private String idSinistro;
	
	public Diagnostico() {	
	}
	
	public Diagnostico(String recebeDanos,String recebeEstadoGeral,String recebeidSinistro,String recebeRegistroAvaria) {
		setDanos(recebeDanos);
		setEstadoGeral(recebeEstadoGeral);
		setidSinistro(recebeidSinistro);
		setRegistroAvaria(recebeRegistroAvaria);
	}
	
	public String getRegistroAvaria() {
		return registroAvaria;
	}


	public void setRegistroAvaria(String registroAvaria) {
		this.registroAvaria = registroAvaria;
	}

	public String getidSinistro() {
		return idSinistro;
	}


	public void setidSinistro(String idSinistro) {
		this.idSinistro = idSinistro;
	}
	
	public String getEstadoGeral() {
		return estadoGeral;
	}
	public void setEstadoGeral(String estadoGeral) {
		this.estadoGeral = estadoGeral;
	}
	public String getDanos() {
		return danos;
	}
	public void setDanos(String danos) {
		this.danos = danos;
	}
	
	
}
