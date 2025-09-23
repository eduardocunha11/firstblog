
public class Pessoa {
	
	protected String cpf;
	protected String rg;
	protected String nome;
	protected String endereco;
	protected String telefone;
	protected String estadoCivil;
	protected String naturalidade;
	protected String nacionalidade;
	
	public Pessoa() {
		
	}
	
	public Pessoa(String cpf, String rg, String nome, String endereco, 
	              String telefone, String estadoCivil,
			      String naturalidade, String nacionalidade) {
		super();
		this.cpf = cpf;
		this.rg = rg;
		this.nome = nome;
		this.endereco = endereco;
		this.telefone = telefone;
		this.estadoCivil = estadoCivil;
		this.naturalidade = naturalidade;
		this.nacionalidade = nacionalidade;
	}

	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public String getRg() {
		return rg;
	}
	
	public void setRg(String rg) {
		this.rg = rg;
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
	
	public String getTelefone() {
		return telefone;
	}
	
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public String getEstadoCivil() {
		return estadoCivil;
	}
	
	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}
	
	public String getNaturalidade() {
		return naturalidade;
	}
	
	public void setNaturalidade(String naturalidade) {
		this.naturalidade = naturalidade;
	}
	
	public String getNacionalidade() {
		return nacionalidade;
	}
	
	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}

	@Override
	public String toString() {
		return "Pessoa [cpf=" + cpf + ", rg=" + rg + ", nome=" + nome + ", endereco=" + endereco + ", telefone="
				+ telefone + ", estadoCivil=" + estadoCivil + ", naturalidade=" + naturalidade + ", nacionalidade="
				+ nacionalidade + "]";
	}
	
}
