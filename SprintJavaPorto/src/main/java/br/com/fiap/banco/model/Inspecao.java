package br.com.fiap.banco.model;

public class Inspecao extends Seguro {
	private String codigoSerie;
	private int custo;
	private String dataInspecao;
	private String fiscalizacao;
	private int qtdInspecao;
	private String analise;

	
	public Inspecao() {

	}

	public Inspecao(String recebeCodigoSerie, int recebeCusto, String recebeDataInspecao,
			String recebeFiscalizacao, int recebeQtdInspecao, String recebeAnalise) {
		setCodigoSerie(recebeCodigoSerie);
		setCusto(recebeCusto);
		setDataInspecao(recebeDataInspecao);
		setFiscalizacao(recebeFiscalizacao);
		setQtdInspecao(recebeQtdInspecao);
		setAnalise(recebeAnalise);
	}

	public String getAnalise() {
		return analise;
	}

	public void setAnalise(String analise) {
		this.analise = analise;
	}

	public String getCodigoSerie() {
		return codigoSerie;
	}

	public void setCodigoSerie(String codigoSerie) {
		this.codigoSerie = codigoSerie;
	}

	public int getCusto() {
		return custo;
	}

	public void setCusto(int custo) {
		this.custo = custo;
	}

	public String getDataInspecao() {
		return dataInspecao;
	}

	public void setDataInspecao(String dataInspecao) {
		this.dataInspecao = dataInspecao;
	}

	public String getFiscalizacao() {
		return fiscalizacao;
	}

	public void setFiscalizacao(String fiscalizacao) {
		this.fiscalizacao = fiscalizacao;
	}

	public int getQtdInspecao() {
		return qtdInspecao;
	}

	public void setQtdInspecao(int qtdInspecao) {
		this.qtdInspecao = qtdInspecao;
	}

	public void mostrarAtributo() {
		System.out.println("Data de inspeção: " + getDataInspecao()
				+ "\nCodigo de Serie: " + getCodigoSerie() + "\nCusto: " + getCusto() + "\nFiscalização: "
				+ getFiscalizacao() + "\nData de contratação: " + getDataContratacao() + "\nCodigo do seguro: "
				+ getCodigoSeguro() + "\nPagamento: " + getPagamento() + "\nValor do Seguro: " + getValorSeguro()
				+ "\nQuantidade de Inspenções Antigas: " + getQtdInspecao() + "\nClausulas: " + getClausulas()
				+ "\nNumero de Serie: " + getNumSerie() + "\nAnalise:" + getAnalise() + "\n");
	}

	public int calcularHistoricoInspecao(int recebeInspecaoAtual) {
		int resultadoHistorico = getQtdInspecao() + recebeInspecaoAtual;
		if (resultadoHistorico <= 3) {
			double desconto = getCusto() * 0.10;
			double valorFinal = getCusto() - desconto;
			System.out.println(
					"Devido ao seu baixo nivel de inspeções voce ganhou 10% de desconto e o valor final será de: "
							+ valorFinal + "\n");
		}
		return resultadoHistorico;
	}

}