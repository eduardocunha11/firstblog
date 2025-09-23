
public class PessoaFisica extends Pessoa {
	
	private String CPF;
	
	public PessoaFisica() {
		
	}
	
	public PessoaFisica(String nome, Endereco address, String email, String documento) {
		super(nome, address, email);
		CPF = documento;	
	}

	public String getCPF() {
		return CPF;
	}

	public void setCPF(String documento) {
		CPF = documento;
	}
}
