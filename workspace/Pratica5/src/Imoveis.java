
public class Imoveis {

	private String codigo;
	private String endereco;
	private String descricao;
	private Integer quartos;
	private Integer metros;
	private Integer garagem;
	private Double preco;
	
	public Imoveis() {}
	
	public Imoveis(String codigo, String endereco, String descricao, Integer quartos, Integer metros, Integer garagem, Double preco) {
		this.codigo = codigo;
		this.endereco = endereco;
		this.descricao = descricao;
		this.quartos = quartos;
		this.metros = metros;
		this.garagem = garagem;
		this.preco = preco;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getQuartos() {
		return quartos;
	}

	public void setQuartos(Integer quartos) {
		this.quartos = quartos;
	}

	public Integer getMetros() {
		return metros;
	}

	public void setMetros(Integer metros) {
		this.metros = metros;
	}

	public Integer getGaragem() {
		return garagem;
	}

	public void setGaragem(Integer garagem) {
		this.garagem = garagem;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}
	
	
	
}
