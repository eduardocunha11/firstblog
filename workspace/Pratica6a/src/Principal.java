import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Principal {
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		Scanner scan2 = new Scanner(System.in); // apenas o metodo nextLine()
		
		List<PessoaFisica> agendaPessoaFisica = new ArrayList<PessoaFisica>();
		
		List<PessoaJuridica> agendaEmpresas = new ArrayList<PessoaJuridica>();
		
		Integer nroPessoasCadastradas = 0, nroEmpresasCadastradas = 0;
		Integer diaDoNascimento, mesDoNascimento, anoDoNascimento;

		String nomePessoa, cpf, endereco, email, estadoCivil, cnpj;
		Calendar dataDeNascimento;
		
		boolean achouPessoa = false, achouEmpresa = false;
		
		PessoaFisica pessoa = null;
		PessoaJuridica empresa = null;
		
		
		System.out.println("========= Menu =========");
		System.out.println("1. Cadastrar uma pessoa");
		System.out.println("2. Cadastrar uma empresa");
		System.out.println("3. Editar uma pessoa");
		System.out.println("4. Editar uma empresa");
		System.out.println("5. Excluir uma pessoa");
		System.out.println("6. Excluir uma empresa");
		System.out.println("7. Listar todas as pessoas");
		System.out.println("8. Listar todas as empresas");
		System.out.println("9. Sair");
		
		int opcao = scan.nextInt();
		
		do {
			
			switch (opcao) {
			case 1: System.out.println("Digite o nome completo da pessoa: ");
					nomePessoa = scan2.nextLine();
			        
					System.out.println("Digite o CPF da pessoa: ");
					cpf = scan.next();
					
					System.out.println("Digite o endereco da pessoa: ");
					endereco = scan2.nextLine();
					
					
					System.out.println("Digite o dia de nascimento da pessoa: ");
					diaDoNascimento = scan.nextInt();
					
					System.out.println("Digite o mes de nascimento da pessoa (Número entre 1 e 12): ");
					mesDoNascimento = scan.nextInt();
					
					System.out.println("Digite o ano de nascimento da pessoa: ");
					anoDoNascimento = scan.nextInt();
					
					dataDeNascimento = Calendar.getInstance();
					dataDeNascimento.set(Calendar.YEAR, anoDoNascimento);
					dataDeNascimento.set(Calendar.MONTH, mesDoNascimento - 1); // Jan - 0, Fev - 1, ..., Dez - 11
					dataDeNascimento.set(Calendar.DAY_OF_MONTH, diaDoNascimento);
					
					
					System.out.println("Digite o e-mail da pessoa: ");
					email = scan.next();
					
					System.out.println("Digite o estado civil da pessoa: ");
					estadoCivil = scan.next();

					
					PessoaFisica pessoaFisicaTemp = new PessoaFisica(cpf, nomePessoa, endereco, 
							dataDeNascimento, email, estadoCivil); 
					                                                                       
					
					// Adicionar objeto do tipo Pessoa Fisica dentro do ArrayList
					
					if (!agendaPessoaFisica.contains(pessoaFisicaTemp)) {						
						agendaPessoaFisica.add(pessoaFisicaTemp);
						nroPessoasCadastradas++;
					} else {
						System.out.println("Esta pessoa já existe! Por favor, cadastre uma outra pessoa");
					}
					
				    break;
			case 2:
				
				   break;
			
			case 3: System.out.println("Digite o CPF da pessoa que deseja alterar:");
					cpf = scan.next();
					
					achouPessoa = false;
					for (PessoaFisica temp : agendaPessoaFisica) {
						if (temp.getCPF().equals(cpf)) {
							achouPessoa = true;
							pessoa = temp;
							break;
						}
					}
					
					if (achouPessoa) {						
						criarSubMenuPessoa(scan, scan2, pessoa);
					} else {
						System.err.println("Essa pessoa nao existe no sistema!");
					}

				    break;
			
			case 4: System.out.println("Digite o CNPJ da pessoa que deseja alterar:");
					cnpj = scan.next();
					
					achouEmpresa = false;
					
					for (PessoaJuridica temp : agendaEmpresas) {
						if (temp.getCNPJ().equals(cnpj)) {
							achouEmpresa = true;
							empresa = temp;
							break;
						}
					}
					
					if (achouEmpresa) {						
						criarSubMenuEmpresa(scan, scan2, empresa);
					} else {
						System.err.println("Essa pessoa nao existe no sistema!");
					}
					
					
				   break;
			
			case 5: System.out.println("Digite o cpf da pessoa que deseja excluir: ");
			        cpf = scan.next();
			        
			        Iterator<PessoaFisica> pessoaFisicaIt = agendaPessoaFisica.iterator();
			        
			        while (pessoaFisicaIt.hasNext()) {
			        	pessoa = pessoaFisicaIt.next();
			        	
			        	if (pessoa.getCPF().equals(cpf)) {
			        		// Achou vc
			        		break;
			        	} else {
			        		// Nao achou vc
			        	}
			        }
			        
			        int indice = agendaPessoaFisica.indexOf(pessoa);
			        agendaPessoaFisica.remove(indice);
			        
				   break;
			
			case 6:
				   break;
			
			case 7: for (PessoaFisica pf : agendaPessoaFisica) {
						System.out.println(pf.toString());
					}
			
			        System.out.println("Numero de pessoas cadastradas: " + agendaPessoaFisica.size());
			        
			        System.out.println("Numero de pessoas cadastradas: " + nroPessoasCadastradas);

			        
			        
			        
				   break;
			
			default: System.out.println("Opcao Invalida!");
				     break;
			
			}
			
			
		} while (opcao != 9);
		
		
		
	}

	private static void criarSubMenuEmpresa(Scanner scan, Scanner scan2, PessoaJuridica empresa) {
       // Mesma logica de programacao do metodo abaixo criarSubMenuPessoa()...
	}

	private static void criarSubMenuPessoa(Scanner scan, Scanner scan2, PessoaFisica pessoa) {
		
		String nomePessoa, endereco, email;
		
		System.out.println("1. Nome");
		System.out.println("2. Endereco");
		System.out.println("3. Email");
		System.out.println("4. Sair");
		
		System.out.println("Qual o atributo que você deseja alterar?");
		
		int opcao = scan.nextInt();
		
		do {
			
			switch(opcao) {
			
			
			case 1:  System.out.println("Digite o novo nome da pessoa:");
					 nomePessoa = scan2.nextLine();
					 pessoa.setNome(nomePessoa);
					 break;
			case 2: System.out.println("Digite o novo endereco da pessoa:");
					endereco = scan2.nextLine();
					pessoa.setEndereco(endereco);
					break;
			case 3: System.out.println("Digite o novo email da pessoa:");
					email = scan2.nextLine();
					pessoa.setEmail(email);
					break;
			
			case 4: break;
				
			default: System.out.println("Opcao Invalida!");
					 break;
			
			}
	
		} while (opcao != 4);
		
	}

}
