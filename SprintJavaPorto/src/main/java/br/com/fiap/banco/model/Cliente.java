package br.com.fiap.banco.model;

public class Cliente extends Pessoa{

	private String email;
	private int anoNasc;
	private String senha;
	
	//Construtor Vazio
	public Cliente() {
    }
	
	//Construtor Cheio
	public Cliente(String recebeNome, String recebeCpf, int recebeAnoNsc, String recebeEndereco, String recebeTelefone, String recebeSexo, String recebeEmail, String recebeSenha) {
		super(recebeNome, recebeCpf, recebeEndereco, recebeTelefone, recebeSexo);
		setAnoNasc(recebeAnoNsc);
		setEmail(recebeEmail);
		setSenha(recebeSenha);
		}
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	public int getAnoNasc() {
		return anoNasc;
	}

	public void setAnoNasc(int anoNasc) {
		this.anoNasc = anoNasc;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public void mostrarInformacoes() {
		System.out.println("\nNome: " + getNome() + 
				"\nCpf: " + getCpf() +
				"\nAno de Nascimento: " + getAnoNasc() +
				"\nEndereço: " + getEndereco()+
				"\nTelefone para Contato: " +  getTelefone()+
				"\nSexo:" + getSexo() +
				"\nEmail do cliente: " + getEmail() + 
				"Senha: " + getSenha() + "\n");
				;
	}
	
	public int calculaIdade(int recebeAnoAtual) {
		int resultadoIdade = recebeAnoAtual - getAnoNasc();
		if (resultadoIdade >= 18) {
			System.out.println("A sua idade é " + resultadoIdade + ",voce pode continuar");
			}
			else {
			System.out.println("A sua idade é " + resultadoIdade + ",voce nao pode continuar");
			}
		return resultadoIdade;
		
	}
	
}