package br.com.fiap.banco.model;


public class Seguro  {
	private String dataContratacao;
	private String codigoSeguro;
	private String pagamento;
	private int valorSeguro;
	private String clausulas;
	private String numSerie;
	
	public Seguro () {
		
	}
	
	
	public Seguro(String recebeDataContratacao,String recebeCodigoSeguro,String recebePagamento, 
			int recebeValorSeguro, String recebeClausulas, String recebeNumSerie) {
		setDataContratacao(recebeDataContratacao);
		setCodigoSeguro(recebeCodigoSeguro);
		setPagamento(recebePagamento);
		setValorSeguro(recebeValorSeguro);
		setClausulas(recebeClausulas);
		setNumSerie(recebeNumSerie);
	}
	
	public String getClausulas() {
		return clausulas;
	}


	public void setClausulas(String clausulas) {
		this.clausulas = clausulas;
	}


	public String getNumSerie() {
		return numSerie;
	}


	public void setNumSerie(String numSerie) {
		this.numSerie = numSerie;
	}


	public String getDataContratacao() {
		return dataContratacao;
	}
	public void setDataContratacao(String dataContratacao) {
		this.dataContratacao = dataContratacao;
	}
	public String getCodigoSeguro() {
		return codigoSeguro;
	}
	public void setCodigoSeguro(String codigoSeguro) {
		this.codigoSeguro = codigoSeguro;
	}
	public String getPagamento() {
		return pagamento;
	}
	public void setPagamento(String pagamento) {
		this.pagamento = pagamento;
	}
	public int getValorSeguro() {
		return valorSeguro;
	}
	public void setValorSeguro(int valorSeguro) {
		this.valorSeguro = valorSeguro;
	}
	
}
