package br.com.fiap.banco.model;

public class Avaria extends Sinistro {
	private String tipoAvaria;
	private String localAvaria;
	private String gravidadeAvaria;
	
	//Construtor Vazio
		public Avaria() {
	    }
	
	//Construtor Cheio
	public Avaria (String recebeRoubo, String recebeQuebra, String recebeTipoAvaria, String recebeLocalAvaria, String recebeGravidadeAvaria,String recebeIdSinistro, String recebeGravidade, int recebeValorManutencao){
		super (recebeRoubo, recebeQuebra,recebeIdSinistro,recebeGravidade,recebeValorManutencao);
		setTipoAvaria(recebeTipoAvaria);
		setLocalAvaria(recebeTipoAvaria);
		setGravidadeAvaria(recebeGravidadeAvaria);
		}
	
	public String getTipoAvaria() {
		return tipoAvaria;
	}
	public void setTipoAvaria(String tipoAvaria) {
		this.tipoAvaria = tipoAvaria;
	}
	public String getLocalAvaria() {
		return localAvaria;
	}
	public void setLocalAvaria(String localAvaria) {
		this.localAvaria = localAvaria;
	}
	public String getGravidadeAvaria() {
		return gravidadeAvaria;
	}
	public void setGravidadeAvaria(String gravidadeAvaria) {
		this.gravidadeAvaria = gravidadeAvaria;
	}
	public void mostrarAtributo() {
		System.out.println("\nMotivo de quebra: " + getQuebra() + 
				"\nHouve roubo: " + getRoubo() +
				"\nId do sinistro:" + getIdSinistro() + 
				"\nValor da manutenção:" + getValorManutencao() +
				"\nGravidade da avaria: " + getGravidadeAvaria() +
				"\nLocal da avaria: " + getLocalAvaria() + 
				"\nTipo de avaria: " + getTipoAvaria());
				
	}
	
	
}