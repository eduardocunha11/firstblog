
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		
		int opcao;
		Integer identificador = 0, contador = 0, posicao = 0;
		String nome, descricao;
		
		Scanner scan = new Scanner(System.in);
		Produto[] produtos = new Produto[3];
		
		do {
			System.out.println("====== MENU ======");
			
			System.out.println("1 - Cadastrar Produto");
			System.out.println("2 - Remover Produto");	
			System.out.println("3 - Sair");
			System.out.println("Digite uma opcao: ");
			
			opcao = scan.nextInt();
			
			switch (opcao) {
				case 1: System.out.println("====== Cadastrar Produto ==== ");
					    System.out.println("Digite o nome do produto: ");
					    nome = scan.next();
					    
					    System.out.println("Digite a descricao do produto: ");
					    descricao = scan.next();
					    
					    identificador = identificador + 1;
					    
					    Produto prod = new Produto(identificador, nome, descricao);
					    produtos[contador] = prod;
					    
					    break;
					
				case 2:  System.out.println("====== Remover Produto ==== ");
				 		 System.out.println("Digite o identificador: ");
				 		 identificador = scan.nextInt();
				 		 
				 		 for (Produto p : produtos) {
				 			 if (p.getId() == identificador) {
				 				 // caso em que achou o produto
				 				produtos[posicao] = null; 
				 			 }
				 			 posicao++;
				 		 }
				 						 		 
				 	   break;
					   				
				default: System.out.println("Opcao Invalida!");
				         break;
			
			}
			
		} while (opcao != 3);
	}

}
