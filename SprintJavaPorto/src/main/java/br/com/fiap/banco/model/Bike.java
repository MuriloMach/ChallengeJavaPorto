package br.com.fiap.banco.model;

public class Bike extends Veiculo {
	private String numSerie;
	private int anoCompra;
	
	public Bike() {
	}
	
	public Bike(String recebeCor, String recebeModelo, String recebeNumSerie,int recebeAnoCompra) {
		super(recebeCor, recebeModelo);
		setNumSerie(recebeNumSerie);
		setAnoCompra(recebeAnoCompra);
	}
	
	public int getAnoCompra() {
		return anoCompra;
	}


	public void setAnoCompra(int anoCompra) {
		this.anoCompra = anoCompra;
	}
	
	public String getNumSerie() {
		return numSerie;
	}

	public void setNumSerie(String numSerie) {
		this.numSerie = numSerie;
	}
	
	public void mostrarAtributo() {
		System.out.println("Cor: " + getCor() + 
				"\nModelo: " + getModelo() + 
				"\nNúmero de Série: " + getNumSerie() + 
				"\nAno da compra:" + getAnoCompra() + "\n"); 
	}
	
	public int calcularAnos(int recebeAnoAtual) {
		int resultado = recebeAnoAtual - getAnoCompra();
		if(resultado >= 10) {
			System.out.println("Voce tem a bike á " + resultado + " anos, ou seja ela é velha");
		}
		else {
			System.out.println("Voce tem a bike á " + resultado + " anos, ou seja ela é nova");
		}
		return resultado;
	}
}