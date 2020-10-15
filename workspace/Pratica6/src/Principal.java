import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
				
		Scanner scan = new Scanner(System.in);
		
		Scanner scan2 = new Scanner(System.in);
		
		List<Pessoa> agenda = new ArrayList<Pessoa>();
				
		Integer opcao;
		String nome;
		
		do {
			
			System.out.println("Menu");
			System.out.println("1 - Cadastrar Pessoa Fisica");
			System.out.println("2 - Cadastrar Pessoa Juridica");
			System.out.println("3 - Buscar pessoa pelo nome");
			System.out.println("4 - Buscar pessoa pelo CPF");
			System.out.println("5 - Buscar pessoa pelo CNPJ");
			System.out.println("6 - Excluir Pessoa Fisica");
			System.out.println("7 - Excluir Pessoa Juridica");
			System.out.println("8 - Editar Pessoa Fisica");
			System.out.println("9 - Editar Pessoa Juridica");
			System.out.println("10 - Listar pessoas");
			System.out.println("11 - Sair");
			System.out.println("Digite uma opcao: ");
			
			opcao = scan.nextInt();
			
			switch(opcao) {
			
			case 1: cadastrarPessoaFisica(scan, scan2, agenda);
				    break; 
			case 2: cadastrarPessoaJuridica(scan, scan2, agenda);
				 	break; 
			case 3: 
					System.out.println("Digite o nome da pessoa a ser buscada: ");
					nome = scan2.nextLine();
					buscarPessoaPeloNome(nome, agenda);
				break;
			case 4:
				break;
			case 5:
				break;
			case 6:
				break;
			case 7:
				break;
			case 8:
				break;
			case 9: 
				break;
			case 10:
				for (Pessoa pessoa: agenda) {
					System.out.println(pessoa.getNome());
				}
				break;
			case 11:
				break;
			
			default: System.out.println("Opcao Invalida!");
			
			}
		} while (opcao != 11);
		
		
	}

	private static void cadastrarPessoaJuridica(Scanner scan, Scanner scan2, List<Pessoa> agenda) {
		
		
	}

	private static void cadastrarPessoaFisica(Scanner scan, Scanner scan2, List<Pessoa> pessoas) {
		
		String nome, cidade, email, nomeRua, bairro, estado, CEP, CPF, complemento;
		Endereco address;
		Integer numero;
		PessoaFisica pessoa;
		
		System.out.println("Digite o CPF da pessoa:");
		CPF = scan.next();
		
		System.out.println("Digite o nome da pessoa:");
		nome = scan2.nextLine();
		
		System.out.println("Digite o e-mail da pessoa:");
		email = scan.next();
		
		System.out.println("Digite o nome da rua:");
		nomeRua = scan2.nextLine();
		
		System.out.println("Digite o complemento:");
		complemento = scan.next();

		System.out.println("Digite o numero da casa/apto");
		numero = scan.nextInt();
		
		System.out.println("Digite o nome do bairro:");
		bairro = scan2.nextLine();
		
		System.out.println("Digite o estado:");
		estado = scan.next();
		
		System.out.println("Digite o CEP:");
		CEP = scan.next();
		
		System.out.println("Digite a cidade:");
		cidade = scan2.nextLine();
		
		
		address = new Endereco();
		address.setBairro(bairro);
		address.setCep(CEP);
		address.setNomeDaRua(nomeRua);
		address.setCidade(cidade);
		address.setEstado(estado);
		address.setNumero(numero);
		address.setComplemento(complemento);
		
		
		pessoa = new PessoaFisica();
		pessoa.setCPF(CPF);
		pessoa.setNome(nome);
		pessoa.setEndereco(address);
		pessoa.setEmail(email);
		
		// Adicionar o objeto PessoaFisica na lista
		pessoas.add(pessoa);
		
		System.out.println("Registro cadastrado com sucesso!");

	}
	
	private static void buscarPessoaPeloNome(String nome, List<Pessoa> agenda) {
		boolean achou = false;
		
		for (Pessoa pessoa: agenda) {
			if (pessoa.getNome().equalsIgnoreCase(nome)) {
				
				achou = true;
				
				if (pessoa instanceof PessoaFisica) {
					// caso em que e uma PessoaFisica
					PessoaFisica pessoaFisica = (PessoaFisica) pessoa;
					imprimeDadosPessoaFisica(pessoaFisica);
					
				} else {
					// caso que e uma PessoaJuridica
					PessoaJuridica pessoaJuridica = (PessoaJuridica) pessoa;
 					imprimeDadosPessoaJuridica(pessoaJuridica);
				}
			}
		}
		
		if (!achou) {
			System.out.println("A pessoa " + nome + " nao foi encontrada!");
		}
	}
	
	private static void imprimeDadosPessoaFisica(PessoaFisica pessoa) {
		System.out.println("Dados da Pessoa Fisica");
		System.out.println("CPF: " + pessoa.getCPF());
		System.out.println("Nome: " + pessoa.getNome());
		System.out.println("Endereco: " + pessoa.getEndereco().toString());
		System.out.println("E-mail: " + pessoa.getEmail());
	}

	private static void imprimeDadosPessoaJuridica(PessoaJuridica pessoa) {
		System.out.println("Dados da Pessoa Juridica");
		System.out.println("CNPJ: " + pessoa.getCNPJ());
		System.out.println("RazaoSocial: " + pessoa.getRazaoSocial());
		System.out.println("Nome: " + pessoa.getNome());
		System.out.println("Endereco: " + pessoa.getEndereco().toString());
		System.out.println("E-mail: " + pessoa.getEmail());		
	}
}
