public class Produto {
  private Integer codigo;
  private String nome;
  private Integer qtdDisponivelEstoque;
  private Double precoVenda;
  private String descricao;

  // construtor padrao
  public Produto() {

  }

  public Produto(Integer id, String name, Integer qtd,
            Double preco, String description) {
    codigo = id;
    nome = name;
    qtdDisponivelEstoque = qtd;
    precoVenda = preco;
    descricao = description;
  }

  public Integer getCodigo() {
    return codigo;
  }

  public void setCodigo(Integer id) {
     codigo = id;
  }

  public String getNome() {
    return nome;
  } 

  public void setNome(String name) {
    nome = name;
  }

  public Integer getQtdDisponivelEstoque() {
    return qtdDisponivelEstoque;
  }

  public void setQtdDisponivelEstoque(Integer qtd) {
    qtdDisponivelEstoque = qtd;
  } 

  public Double getPrecoVenda() {
    return precoVenda;
  }

  public void setPrecoVenda(Double preco) {
    precoVenda = preco;
  }

  public String getDescricao() {
    return descricao;
  }

  public void setDescricao(String desc) {
    descricao = desc;
  }

}