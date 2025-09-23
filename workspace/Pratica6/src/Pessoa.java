
public class Pessoa {
	
	private String nome;
	private Endereco endereco;
	private String email; 
	
	public Pessoa() {
		
	}
	
	public Pessoa(String name, Endereco address) {
		nome = name;
		endereco = address;
	}
	
	public Pessoa(String name, Endereco address, String mail) {
		nome = name;
		endereco = address;
		email = mail;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}	
}
