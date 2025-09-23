package cefet.aulas;

public class Principal {
	
	 public static void main(String[] args){
		 Aluno a, b, c;

		 a = new Aluno("João", "1", 20);
		 a.matricular();
		 a.imprimir();

		 b = new Aluno("Maria", "2", 22);
		 b.imprimir();

		 c = new Aluno ("Carlos", "3", 19);
		 c.matricular();
		 c.imprimir();

		 a = c;
		 a.imprimir();
		 c.imprimir();
		 c.alterarIdade(25);
		 a.imprimir(); // O que ocorre aqui e porque?

		 //O que o programa exibe aqui e porque?
		 
//		 a.alterarIdadeMinima(15);
		 
		 // ATRIBUTOS STATIC: NOME_DA_CLASSE.NOME_DO_ATRIBUTO
		 Aluno.IDADE_MINIMA = 23;
		  
		 System.out.println("Idade Mínima vista por a e: " + Aluno.IDADE_MINIMA);

	 }
}
