
public class Convenio {

	private Integer codigo; 
	private String descricao;
	
	public Convenio() {
		
	}
	
	public Convenio(Integer codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public String toString() {
		return "Convenio [codigo=" + codigo + ", descricao=" + descricao + "]";
	}

	
}
