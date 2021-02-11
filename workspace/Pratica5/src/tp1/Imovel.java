package tp1;

public class Imovel {
	private int codigo;
	private String endereco;
	private String descricao;
	private int nQuartos;
	private int metrosQuadrados;
	private int vagasGaragem;
	private float valor;
	
	/**
	 * @param codigo C�digo do do im�vel
	 * @param endereco Endere�o do im�vel
	 * @param descricao Descri��o do im�vel
	 * @param nQuartos N�mero de quartos do im�vel
	 * @param metrosQuadrados N�mero de metros quadrados do im�vel (m^2)
	 * @param vagasGaragem N�mero de vagas de garagem do im�vel
	 * @param valor Valor do im�vel (R$)
	 */
	public Imovel(int codigo, String endereco, String descricao, int nQuartos, int metrosQuadrados, int vagasGaragem,
			float valor) {
		super();
		this.codigo = codigo;
		this.endereco = endereco;
		this.descricao = descricao;
		this.nQuartos = nQuartos;
		this.metrosQuadrados = metrosQuadrados;
		this.vagasGaragem = vagasGaragem;
		this.valor = valor;
	}
	
	
	/**
	 * @return o codigo
	 */
	public int getCodigo() {
		return codigo;
	}
	/**
	 * @param codigo o codigo a ser assinalado
	 */
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	/**
	 * @return o endereco
	 */
	public String getEndereco() {
		return endereco;
	}
	/**
	 * @param endereco o endereco a ser assinalado
	 */
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	/**
	 * @return o descricao
	 */
	public String getDescricao() {
		return descricao;
	}
	/**
	 * @param descricao o descricao a ser assinalado
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	/**
	 * @return o nQuartos
	 */
	public int getnQuartos() {
		return nQuartos;
	}
	/**
	 * @param nQuartos o nQuartos a ser assinalado
	 */
	public void setnQuartos(int nQuartos) {
		this.nQuartos = nQuartos;
	}
	/**
	 * @return o metrosQuadrados
	 */
	public int getMetrosQuadrados() {
		return metrosQuadrados;
	}
	/**
	 * @param metrosQuadrados o metrosQuadrados a ser assinalado
	 */
	public void setMetrosQuadrados(int metrosQuadrados) {
		this.metrosQuadrados = metrosQuadrados;
	}
	/**
	 * @return o vagasGaragem
	 */
	public int getVagasGaragem() {
		return vagasGaragem;
	}
	/**
	 * @param vagasGaragem o vagasGaragem a ser assinalado
	 */
	public void setVagasGaragem(int vagasGaragem) {
		this.vagasGaragem = vagasGaragem;
	}
	/**
	 * @return o valor
	 */
	public float getValor() {
		return valor;
	}
	/**
	 * @param valor o valor a ser assinalado
	 */
	public void setValor(float valor) {
		this.valor = valor;
	}
	
	
	/**
	 * @return Descri��o do im�vel (em m�ltiplas linhas)
	 */
	public String descrever() {
		return "C�digo:\t\t\t" + codigo + "\nEndere�o:\t\t" + endereco + "\nDescri��o\t\t" + descricao + "\nN�mero de quartos: \t"
				+ nQuartos + "\nTamanho (m^2): \t\t" + metrosQuadrados + "\nVagas na garagem: \t" + vagasGaragem + "\nValor (R$):\t\tq"
				+ valor;
	}
	
}
