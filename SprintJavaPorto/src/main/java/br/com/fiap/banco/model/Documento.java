package br.com.fiap.banco.model;

public class Documento extends Diagnostico{
	private int codigoDocumento;
	private String dataEmissao;
	
	public Documento() {
		
	}
	
	public Documento (String recebeDanos,String recebeEstadoGeral,String recebeidSinistro,String recebeRegistroAvaria, int recebeCodigoDocumento, String recebeDataEmissao) {
		super(recebeDanos, recebeEstadoGeral, recebeidSinistro,recebeRegistroAvaria);
		setCodigoDocumento(recebeCodigoDocumento);
		setDataEmissao(recebeDataEmissao);
	}
			
	
	public int getCodigoDocumento() {
		return codigoDocumento;
	}
	public void setCodigoDocumento(int codigoDocumento) {
		this.codigoDocumento = codigoDocumento;
	}
	public String getDataEmissao() {
		return dataEmissao;
	}
	public void setDataEmissao(String dataEmissao) {
		this.dataEmissao = dataEmissao;
	}

	public void mostrarAtributo() {
		System.out.println( "Codigo do documento: " + getCodigoDocumento() +
				"\nData Emissão: " + getDataEmissao() +
				"\nDano: " + getDanos() + 
				"\nEstado geral: " + getEstadoGeral() + 
				"\nRegistro da avaria: " + getRegistroAvaria() + 
				"\nId do sinistro:" + getidSinistro() + "\n");
	}
	
	
}
