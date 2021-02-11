package tp1;
import java.util.Scanner;
import java.util.Vector;

public class TP1 {

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		imoveis = new Vector<Imovel>();
		menu();
		
	}
	/**
	 * Imprime as opções do menu.
	 */
	private static void imprimirMenu() {
		System.out.println("Escolha uma das opções a seguir: ");
		System.out.println("1 - Adicionar um imóvel à lista");
		System.out.println("2 - Listar imóveis existentes");
		System.out.println("3 - Descrever um imóvel");
		System.out.println("4 - Remover um imóvel da lista");
		System.out.println("5 - Sair do programa");
	}
	
	private static Vector<Imovel> imoveis;
	private static Scanner sc;
	
	/**
	 * Apresenta ao usuário as opções disponíveis e
	 * realiza a tarefa escolhida.
	 */
	private static void menu() {
		int escolha = -1;
		
		while (true) {
			imprimirMenu();
			escolha = sc.nextInt();
			switch (escolha) {
			case 1:
				criarImovel();
				break;
			case 2:
				listarImoveis();
				break;
			case 3:
				descreverImovel();
				break;
			case 4:
				removerImovel();
				break;
			case 5:
				System.out.println("Obrigado por utilizar a plataforma!");
				return;
			default:
				System.out.println("Opção inválida");
				break;
			}
		}
		
	}
	
	/**
	 * Remove um imóvel da lista de imóveis.
	 */
	private static void removerImovel() {
		int nImovel;
		listarImoveis();
		System.out.println("Entre com o índice do imóvel a ser descrito: ");
		nImovel = sc.nextInt();
		if (nImovel < 0 || nImovel >= imoveis.size()) {
			System.out.println("Índice do imóvel inválido!");
			return;
		}
		
		imoveis.remove(nImovel);
	}
	
	/**
	 * Descreve um imóvel com todas as suas informações
	 */
	private static void descreverImovel() {
		int nImovel;
		listarImoveis();
		System.out.println("Entre com o índice do imóvel a ser descrito: ");
		nImovel = sc.nextInt();
		if (nImovel < 0 || nImovel >= imoveis.size()) {
			System.out.println("Índice do imóvel inválido!");
			return;
		}
		System.out.println(imoveis.elementAt(nImovel).descrever());
		
	}
	
	/**
	 * Lista os imóveis disponíveis (com seu código e descrição)
	 */
	private static void listarImoveis() {
		System.out.println("Índice\tCódigo\tDescrição");
		System.out.println("------------------------------");
		for (int i = 0; i < imoveis.size(); i++) {
			Imovel im = imoveis.elementAt(i);
			System.out.println(i + "\t" + im.getCodigo() + "\t" + im.getDescricao());
		}
	}
	
	/**
	 * Cria um imóvel e o adiciona à lista.
	 */
	private static void criarImovel() {
		Imovel im = entradaDoImovel();
		imoveis.add(im);
		
		// Para comparar inteiros -->  x == y
		// Para comparar textos --> x.equals(y) ou x.equalsIgnoreCase(y)
 	}
	
	/**
	 * Entrada do imóvel pelo terminal.
	 * @return O imóvel criado.
	 */
	private static Imovel entradaDoImovel() {
		int codigo, m2, nq,  vg;
		float valor;
		String descricao, endereco;
		
		System.out.println("Entre com o código do seu imóvel: ");
		codigo = sc.nextInt();
		System.out.println("Entre com o endereço do seu imóvel (em uma linha): ");
		sc.nextLine();
		endereco = sc.nextLine();
		System.out.println("Entre com a descrição do seu imóvel (em uma linha): ");
		descricao = sc.nextLine();
		System.out.println("Entre com o número de quartos do seu imóvel: ");
		nq = sc.nextInt();
		System.out.println("Entre com o tamanho do seu imovel (em m^2): ");
		m2 = sc.nextInt();
		System.out.println("Entre com o número de vagas na garagem do seu imóvel: ");
		vg = sc.nextInt();
		System.out.println("Entre com o valor do seu imóvel (em R$) (use o '.' como separador de decimais): ");
		valor = sc.nextFloat();
		
		return new Imovel(codigo, endereco, descricao, nq, m2, vg, valor);
	}

}
