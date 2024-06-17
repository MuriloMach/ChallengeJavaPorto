package br.com.fiap.banco.model;

public class Vistoria extends Seguro {
	private String problema;
	private String dataVistoria;
	private String codigoVistoria;

	public Vistoria() {

	}

	public Vistoria(String recebeDataContratacao, String recebeCodigoSeguro, String recebePagamento,
			int recebeValorSeguro, String recebeProblema, String recebeDataVistoria, String recebeCodigoVistoria,
			String recebeClausulas, String recebeNumSerie) {
		super(recebeDataContratacao, recebeCodigoSeguro, recebePagamento, recebeValorSeguro, recebeClausulas,
				recebeNumSerie);
		setProblema(recebeProblema);
		setDataVistoria(recebeDataVistoria);
		setCodigoVistoria(recebeCodigoVistoria);

	}

	public String getProblema() {
		return problema;
	}

	public void setProblema(String problema) {
		this.problema = problema;
	}

	public String getDataVistoria() {
		return dataVistoria;
	}

	public void setDataVistoria(String dataVistoria) {
		this.dataVistoria = dataVistoria;
	}

	public String getCodigoVistoria() {
		return codigoVistoria;
	}

	public void setCodigoVistoria(String codigoVistoria) {
		this.codigoVistoria = codigoVistoria;
	}

	public void mostrarAtributo() {
		System.out.println("\nData de contratação: " + getDataContratacao() + "\nCodigo seguro: " + getCodigoSeguro()
				+ "\nForma de pagamento: " + getPagamento() + "\nValor do seguro: " + getValorSeguro() + "\nProblema: "
				+ getProblema() + "\nData da vistoria: " + getDataVistoria() + "\nCodigo da vistoria: "
				+ getCodigoVistoria() + "\nClausulas: " + getClausulas() + "\nNumero de Serie: " + getNumSerie()
				+ "\n");
	}

	public double calcularValor(double recebeValorFrete) {
		double soma = getValorSeguro() + recebeValorFrete;
		if (getValorSeguro() >= 500) {
			System.out.println("O valor é de: " + getValorSeguro() + ",por isso o frete será gratis");
		} else {
			System.out.println("O valor do frete será de " + recebeValorFrete + ",e o total será de: " + soma);
		}
		return soma;
	}

}
