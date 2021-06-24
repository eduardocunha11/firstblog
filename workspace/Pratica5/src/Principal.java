import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {
	

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		Scanner scan2 = new Scanner(System.in);
		
		List<Imoveis> listaImovel = new ArrayList<Imoveis>();
		
		Imoveis[] imoveisVet = new Imoveis[50];
		
		
		
		int count = 0;
		
		Integer opcao, escolha, numQuartos, numGaragem, tamanho, i;
		int posicao;
		Double preco;
		String codigo, endereco, descricao, editar, excluir;
		Boolean achou;
		
		do {
			achou = false;
			System.out.println("---------- Menu ----------");
			System.out.println("");
			System.out.println("");
			System.out.println("1. Cadastrar;");
			System.out.println("2. Editar;");
			System.out.println("3. Excluir;");
			System.out.println("4. Listar;");
			System.out.println("");
			System.out.println("0. Sair");
			
			System.out.println("");
			System.out.print("Op��o: ");
			
			opcao = scan.nextInt();
			
			switch (opcao) {
			case 1:
				
				System.out.println("---------- Cadastrar Im�vel ----------");
				System.out.println("");
				
				System.out.print("Digite o C�DIGO do im�vel ");
				codigo = scan2.next();
				
				System.out.print("Digite o ENDERE�O do im�vel: ");
				endereco = scan2.nextLine();	

				System.out.print("Digite a DESCRI��O do im�vel: ");
				descricao = scan2.nextLine();
				
				System.out.print("Digite o N�MERO DE QUARTOS do im�vel: ");
				numQuartos = scan.nextInt();	
				
				System.out.print("Digite o TAMANHO do im�vel: ");
				tamanho = scan.nextInt();	
				
				System.out.print("Digite o N�MERO DE VAGAS DE GARAGEM do im�vel: ");
				numGaragem = scan.nextInt();
				
				System.out.print("Digite o PRE�O do im�vel: ");
				preco = scan.nextDouble();
				

				

				Imoveis imovel = new Imoveis(codigo, endereco, descricao, numQuartos, tamanho, numGaragem, preco);
				listaImovel.add(imovel);
				
				imoveisVet[count] = imovel;
				count++;
				
				System.out.println("");
				System.out.println("Im�vel cadastrado!");	
				System.out.println("");
				
				break;
				
			case 2: 	
				System.out.println("---------- Editar Im�vel ----------");
				System.out.println("");
				
				System.out.print("Digite o C�DIGO do im�vel que deseja alterar: ");
				editar = scan2.next();
				
				/*Iterator<Imoveis> imoveisIterator = listaImovel.iterator();
				Imoveis imovel = null;
				while (imoveisIterator.hasNext()) {
					imovel = imoveisIterator.next();
					
				}*/
				
				for(i=0;i<listaImovel.size();i++) {
					if(editar.equals(listaImovel.get(i).getCodigo())) {
						System.out.println("");
						achou = true;
						System.out.println("Im�vel encontrado!");
						System.out.println("Qual dado voc� deseja alterar? ");
						System.out.println("");
						System.out.println("1. Endere�o;");
						System.out.println("2. Descri��o;");
						System.out.println("3. N�mero de Quartos;");
						System.out.println("4. Tamanho;");
						System.out.println("5. N�mero de Vagas de Garagem;");
						System.out.println("6. Pre�o;");
						System.out.println("");
						System.out.println("0. Sair.");
						System.out.println("");
						System.out.print("Op��o: ");
						escolha = scan.nextInt();

						switch(escolha){
						case 1: 
							System.out.println("");
							System.out.print("Deseja alterar para qual ENDERE�O? ");
							String pularEspacoVazio = scan2.nextLine();
							String newAdress = scan2.nextLine();
							
							listaImovel.get(i).setEndereco(newAdress);
							
							System.out.println("");
							System.out.println("Endere�o alterado com sucesso!");
							System.out.println("");
														
							break;
							
						case 2: 	
							System.out.println("");
							System.out.print("Deseja alterar para qual DESCRI��O? ");
							String pularEspacoVazio2 = scan2.nextLine();
							String newDescription = scan2.nextLine();
							
							listaImovel.get(i).setDescricao(newDescription);
							
							System.out.println("");
							System.out.println("Descri��o alterada com sucesso!");
							System.out.println("");
																
							break;
							
						case 3:	
							System.out.println("");
							System.out.println("Deseja alterar para qual N�MERO DE QUARTOS? ");
							Integer newQuartos = scan.nextInt();
							
							listaImovel.get(i).setQuartos(newQuartos);
							
							System.out.println("");
							System.out.println("N�mero de Quartos alterado com sucesso!");
							System.out.println("");
							
							break;
							
						case 4:	
							System.out.println("");
							System.out.println("Deseja alterar para qual TAMANHO? ");
							Integer newTamanho = scan.nextInt();
							
							listaImovel.get(i).setMetros(newTamanho);
							
							System.out.println("");
							System.out.println("Tamanho alterado com sucesso!");
							System.out.println("");
							
							break;
							
						case 5:	
							System.out.println("");
							System.out.println("Deseja alterar para qual N�MERO DE VAGAS DE GARAGEM? ");
							Integer newVagas = scan.nextInt();
							
							listaImovel.get(i).setGaragem(newVagas);
							
							System.out.println("");
							System.out.println("N�mero de Vagas alterado com sucesso!");
							System.out.println("");
							
							break;
							
						case 6:	
							System.out.println("");
							System.out.println("Deseja alterar para qual VALOR? ");
							Double newValor= scan.nextDouble();
							
							listaImovel.get(i).setPreco(newValor);
							
							System.out.println("");
							System.out.println("Valor alterado com sucesso!");
							System.out.println("");
							
							break;
							
						case 0:
							
							break;
							
						default: 
							System.err.println("Op��o inv�lida!");
						}
					}
				}
				
				if(achou == false) {
					System.out.println("");	
					System.err.println("C�digo n�o encontrado!");				
					System.out.println("");	
				}
				
				break;
				
			case 3:
				System.out.println("---------- Excluir Im�vel ----------");
				System.out.println("");
				
				System.out.print("Digite o C�DIGO do im�vel que deseja excluir: ");
				excluir = scan2.next();
				
				for(i=0;i<listaImovel.size();i++) {
					if(excluir.equals(listaImovel.get(i).getCodigo())) {
						achou = true;
						posicao = i;
						break;
					}
				}
				
				if (achou) {
					listaImovel.remove(posicao);
					System.out.println("");
					System.out.println("Im�vel exclu�do com sucesso!");
					System.out.println("");	
				} else {
					System.out.println("");	
					System.err.println("C�digo n�o encontrado!");				
					System.out.println("");
				}
				break;
				
			case 4:
				System.out.println("--------- Im�veis Cadastrados ----------");
				System.out.println("");
				for(i=0;i<listaImovel.size();i++) {
					System.out.println("--- Im�vel " + (i+1) + " ---");
					System.out.println("C�digo: " + listaImovel.get(i).getCodigo());
					System.out.println("Endere�o: " + listaImovel.get(i).getEndereco());
					System.out.println("Descri��o: " + listaImovel.get(i).getDescricao());
					System.out.println("N�mero de Quartos: " + listaImovel.get(i).getQuartos());
					System.out.println("Tamanho: " + listaImovel.get(i).getMetros() + "m�.");
					System.out.println("N�mero de Vagas de Garagem: " + listaImovel.get(i).getGaragem());
					System.out.println("Pre�o: R$" + listaImovel.get(i).getPreco());
					System.out.println("");
					}
				
				
				break;
				
			case 0:
				
				
				break;
				
			default:
				System.out.println("");	
				System.err.println("Op��o inv�lida!");				
				System.out.println("");	
				
				break;
			}
						
		}while(opcao!=0);
		
	}

}
