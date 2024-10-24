package cefet.aulas;

public class Aluno {
	
	private String nome;
	private String matricula;
	private String situacao;
	private int idade;
	protected static int IDADE_MINIMA = 18; 
	
	public Aluno (String n, String m, int id) {
		nome = n;
		matricula = m;
		situacao = "Nao matriculado";
		
		if (id >= IDADE_MINIMA)
		 idade = id;
		else
		 idade = 0;
	}

	public void alterarNome(String n){
		 nome = n;
	}

	public String obterNome(){
		 return nome;
	}

	public void matricular(){
		 situacao = "Matriculado";
	}

	public void cancelarMatricula(){
		 situacao = "Nao matriculado";
	}
	
	public String obterMatricula(){
		 return matricula;
	}

	public String obterSituacao(){
		 return situacao;
	}

	public void imprimir(){
		 System.out.println("** Dados do Aluno ***");
		 System.out.println("Nome: " + nome);
		 System.out.println("Matricula: " + matricula);
		 System.out.println("Situa��o: " + situacao);
		 System.out.println("Idade : " + idade);
	}

	public void alterarIdade(int id){
		 if (id >= IDADE_MINIMA) idade = id;
	}

	public int obterIdade(){
		 return idade;
	}
	
	/*public void alterarIdadeMinima(int id){
		 if (id >0) IDADE_MINIMA = id;
	}

	public int obterIdadeMinima(){
		 return IDADE_MINIMA;
	}*/
}
