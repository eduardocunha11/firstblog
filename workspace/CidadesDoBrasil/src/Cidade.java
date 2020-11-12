import java.util.List;

public class Cidade {
	
	private String nome;
	private Double IDH;
	private Integer populacao;
	private List<String> bairros;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Double getIDH() {
		return IDH;
	}
	public void setIDH(Double iDH) {
		IDH = iDH;
	}
	public Integer getPopulacao() {
		return populacao;
	}
	public void setPopulacao(Integer populacao) {
		this.populacao = populacao;
	}
	public List<String> getBairros() {
		return bairros;
	}
	public void setBairros(List<String> bairros) {
		this.bairros = bairros;
	}
	
	

}
