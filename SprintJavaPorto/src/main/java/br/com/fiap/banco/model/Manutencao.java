package br.com.fiap.banco.model;

public class Manutencao extends Sinistro {
	private String localManutencao;
	
	
	//Construtor Vazio
	public Manutencao() {
		    }
		
	//Construtor Cheio
	public Manutencao (String recebeRoubo, String recebeQuebra, String recebeLocalManutencao,String recebeIdSinistro, String recebeGravidade, int recebeValorManutencao){
			super (recebeRoubo, recebeQuebra,recebeIdSinistro,recebeGravidade,recebeValorManutencao);
			setLocalManutencao(recebeLocalManutencao);
			
			}
	
	public String getLocalManutencao() {
		return localManutencao;
	}
	public void setLocalManutencao(String localManutencao) {
		this.localManutencao = localManutencao;
	}
	
	public void mostrarAtributo() {
		System.out.println( "\nMotivo de quebra: " + getQuebra() +
				"\nHouve roubo: " + getRoubo()+
				"\nLocal da manutenção: " + getLocalManutencao() + 
				"\nValor: " + getValorManutencao() +
				"\nId do sinistro: " + getIdSinistro() +
				"\nGravidade: " + getGravidade() + 
				"\n ");
		
	}
		
}
