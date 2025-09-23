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
			System.out.print("Opção: ");
			
			opcao = scan.nextInt();
			
			switch (opcao) {
			case 1:
				
				System.out.println("---------- Cadastrar Imóvel ----------");
				System.out.println("");
				
				System.out.print("Digite o CÓDIGO do imóvel ");
				codigo = scan2.next();
				
				System.out.print("Digite o ENDEREÇO do imóvel: ");
				endereco = scan2.nextLine();	

				System.out.print("Digite a DESCRIÇÃO do imóvel: ");
				descricao = scan2.nextLine();
				
				System.out.print("Digite o NÚMERO DE QUARTOS do imóvel: ");
				numQuartos = scan.nextInt();	
				
				System.out.print("Digite o TAMANHO do imóvel: ");
				tamanho = scan.nextInt();	
				
				System.out.print("Digite o NÚMERO DE VAGAS DE GARAGEM do imóvel: ");
				numGaragem = scan.nextInt();
				
				System.out.print("Digite o PREÇO do imóvel: ");
				preco = scan.nextDouble();
				

				

				Imoveis imovel = new Imoveis(codigo, endereco, descricao, numQuartos, tamanho, numGaragem, preco);
				listaImovel.add(imovel);
				
				imoveisVet[count] = imovel;
				count++;
				
				System.out.println("");
				System.out.println("Imóvel cadastrado!");	
				System.out.println("");
				
				break;
				
			case 2: 	
				System.out.println("---------- Editar Imóvel ----------");
				System.out.println("");
				
				System.out.print("Digite o CÓDIGO do imóvel que deseja alterar: ");
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
						System.out.println("Imóvel encontrado!");
						System.out.println("Qual dado você deseja alterar? ");
						System.out.println("");
						System.out.println("1. Endereço;");
						System.out.println("2. Descrição;");
						System.out.println("3. Número de Quartos;");
						System.out.println("4. Tamanho;");
						System.out.println("5. Número de Vagas de Garagem;");
						System.out.println("6. Preço;");
						System.out.println("");
						System.out.println("0. Sair.");
						System.out.println("");
						System.out.print("Opção: ");
						escolha = scan.nextInt();

						switch(escolha){
						case 1: 
							System.out.println("");
							System.out.print("Deseja alterar para qual ENDEREÇO? ");
							String pularEspacoVazio = scan2.nextLine();
							String newAdress = scan2.nextLine();
							
							listaImovel.get(i).setEndereco(newAdress);
							
							System.out.println("");
							System.out.println("Endereço alterado com sucesso!");
							System.out.println("");
														
							break;
							
						case 2: 	
							System.out.println("");
							System.out.print("Deseja alterar para qual DESCRIÇÃO? ");
							String pularEspacoVazio2 = scan2.nextLine();
							String newDescription = scan2.nextLine();
							
							listaImovel.get(i).setDescricao(newDescription);
							
							System.out.println("");
							System.out.println("Descrição alterada com sucesso!");
							System.out.println("");
																
							break;
							
						case 3:	
							System.out.println("");
							System.out.println("Deseja alterar para qual NÚMERO DE QUARTOS? ");
							Integer newQuartos = scan.nextInt();
							
							listaImovel.get(i).setQuartos(newQuartos);
							
							System.out.println("");
							System.out.println("Número de Quartos alterado com sucesso!");
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
							System.out.println("Deseja alterar para qual NÚMERO DE VAGAS DE GARAGEM? ");
							Integer newVagas = scan.nextInt();
							
							listaImovel.get(i).setGaragem(newVagas);
							
							System.out.println("");
							System.out.println("Número de Vagas alterado com sucesso!");
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
							System.err.println("Opção inválida!");
						}
					}
				}
				
				if(achou == false) {
					System.out.println("");	
					System.err.println("Código não encontrado!");				
					System.out.println("");	
				}
				
				break;
				
			case 3:
				System.out.println("---------- Excluir Imóvel ----------");
				System.out.println("");
				
				System.out.print("Digite o CÓDIGO do imóvel que deseja excluir: ");
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
					System.out.println("Imóvel excluído com sucesso!");
					System.out.println("");	
				} else {
					System.out.println("");	
					System.err.println("Código não encontrado!");				
					System.out.println("");
				}
				break;
				
			case 4:
				System.out.println("--------- Imóveis Cadastrados ----------");
				System.out.println("");
				for(i=0;i<listaImovel.size();i++) {
					System.out.println("--- Imóvel " + (i+1) + " ---");
					System.out.println("Código: " + listaImovel.get(i).getCodigo());
					System.out.println("Endereço: " + listaImovel.get(i).getEndereco());
					System.out.println("Descrição: " + listaImovel.get(i).getDescricao());
					System.out.println("Número de Quartos: " + listaImovel.get(i).getQuartos());
					System.out.println("Tamanho: " + listaImovel.get(i).getMetros() + "m².");
					System.out.println("Número de Vagas de Garagem: " + listaImovel.get(i).getGaragem());
					System.out.println("Preço: R$" + listaImovel.get(i).getPreco());
					System.out.println("");
					}
				
				
				break;
				
			case 0:
				
				
				break;
				
			default:
				System.out.println("");	
				System.err.println("Opção inválida!");				
				System.out.println("");	
				
				break;
			}
						
		}while(opcao!=0);
		
	}

}
