
public class Produto {
	
	private Integer identificador;
	private String nome;
	private String descricao;
	
	public Produto(Integer id, String name, String desc) {
		identificador = id;
		nome = name;
		descricao = desc;
	}
	
	public Integer getId() {
		return identificador;
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setNome(String name) {
		nome = name;
	}
	
	public void setDescricao(String desc) {
		descricao = desc;
	}
}
