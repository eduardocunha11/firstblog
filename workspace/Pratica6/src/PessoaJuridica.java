
public class PessoaJuridica extends Pessoa {
	
	private String CNPJ;
	private String razaoSocial;
	
	public PessoaJuridica() {
		
	}
	
	public PessoaJuridica(String name, Endereco address, String mail, String documento, String nomeFantasia) {
		super(name, address, mail);
		CNPJ = documento;
		razaoSocial = nomeFantasia;
	}

	public String getCNPJ() {
		return CNPJ;
	}

	public void setCNPJ(String cNPJ) {
		CNPJ = cNPJ;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String nomeFantasia) {
		razaoSocial = nomeFantasia;
	}
	
}
