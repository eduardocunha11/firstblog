import java.util.Scanner;

public class Principal {
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		String nome;
		String matricula;
		Integer idade;
		
		System.out.println("Digite o nome do aluno: ");
		nome = scan.next();
		
		System.out.println("Digite a matricula do aluno: ");
		matricula = scan.next();
		
		System.out.println("Digite a idade do aluno: ");
		idade = scan.nextInt();
		
		Aluno al = new Aluno(nome, matricula, idade);
		
		System.out.println("A matricula desse aluno eh: " + al.getMatricula() + " nome: " + al.getNome());
		
	}

}