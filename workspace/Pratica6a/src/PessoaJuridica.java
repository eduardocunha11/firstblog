
public class PessoaJuridica {
	
	private String CNPJ;
	private String nome;
	private String endereco;
	private String email;
	private String inscricaoEstadual;
	private String razaoSocial;
	
	public PessoaJuridica() {
		
	}
	
	public PessoaJuridica(String cNPJ, String nome, String endereco, String email, String inscricaoEstadual,
			String razaoSocial) {
		super();
		CNPJ = cNPJ;
		this.nome = nome;
		this.endereco = endereco;
		this.email = email;
		this.inscricaoEstadual = inscricaoEstadual;
		this.razaoSocial = razaoSocial;
	}
	
	public String getCNPJ() {
		return CNPJ;
	}
	public void setCNPJ(String cNPJ) {
		CNPJ = cNPJ;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getInscricaoEstadual() {
		return inscricaoEstadual;
	}
	public void setInscricaoEstadual(String inscricaoEstadual) {
		this.inscricaoEstadual = inscricaoEstadual;
	}
	public String getRazaoSocial() {
		return razaoSocial;
	}
	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}
	
	

}
