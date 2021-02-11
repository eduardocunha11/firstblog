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
	 * Imprime as op��es do menu.
	 */
	private static void imprimirMenu() {
		System.out.println("Escolha uma das op��es a seguir: ");
		System.out.println("1 - Adicionar um im�vel � lista");
		System.out.println("2 - Listar im�veis existentes");
		System.out.println("3 - Descrever um im�vel");
		System.out.println("4 - Remover um im�vel da lista");
		System.out.println("5 - Sair do programa");
	}
	
	private static Vector<Imovel> imoveis;
	private static Scanner sc;
	
	/**
	 * Apresenta ao usu�rio as op��es dispon�veis e
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
				System.out.println("Op��o inv�lida");
				break;
			}
		}
		
	}
	
	/**
	 * Remove um im�vel da lista de im�veis.
	 */
	private static void removerImovel() {
		int nImovel;
		listarImoveis();
		System.out.println("Entre com o �ndice do im�vel a ser descrito: ");
		nImovel = sc.nextInt();
		if (nImovel < 0 || nImovel >= imoveis.size()) {
			System.out.println("�ndice do im�vel inv�lido!");
			return;
		}
		
		imoveis.remove(nImovel);
	}
	
	/**
	 * Descreve um im�vel com todas as suas informa��es
	 */
	private static void descreverImovel() {
		int nImovel;
		listarImoveis();
		System.out.println("Entre com o �ndice do im�vel a ser descrito: ");
		nImovel = sc.nextInt();
		if (nImovel < 0 || nImovel >= imoveis.size()) {
			System.out.println("�ndice do im�vel inv�lido!");
			return;
		}
		System.out.println(imoveis.elementAt(nImovel).descrever());
		
	}
	
	/**
	 * Lista os im�veis dispon�veis (com seu c�digo e descri��o)
	 */
	private static void listarImoveis() {
		System.out.println("�ndice\tC�digo\tDescri��o");
		System.out.println("------------------------------");
		for (int i = 0; i < imoveis.size(); i++) {
			Imovel im = imoveis.elementAt(i);
			System.out.println(i + "\t" + im.getCodigo() + "\t" + im.getDescricao());
		}
	}
	
	/**
	 * Cria um im�vel e o adiciona � lista.
	 */
	private static void criarImovel() {
		Imovel im = entradaDoImovel();
		imoveis.add(im);
		
		// Para comparar inteiros -->  x == y
		// Para comparar textos --> x.equals(y) ou x.equalsIgnoreCase(y)
 	}
	
	/**
	 * Entrada do im�vel pelo terminal.
	 * @return O im�vel criado.
	 */
	private static Imovel entradaDoImovel() {
		int codigo, m2, nq,  vg;
		float valor;
		String descricao, endereco;
		
		System.out.println("Entre com o c�digo do seu im�vel: ");
		codigo = sc.nextInt();
		System.out.println("Entre com o endere�o do seu im�vel (em uma linha): ");
		sc.nextLine();
		endereco = sc.nextLine();
		System.out.println("Entre com a descri��o do seu im�vel (em uma linha): ");
		descricao = sc.nextLine();
		System.out.println("Entre com o n�mero de quartos do seu im�vel: ");
		nq = sc.nextInt();
		System.out.println("Entre com o tamanho do seu imovel (em m^2): ");
		m2 = sc.nextInt();
		System.out.println("Entre com o n�mero de vagas na garagem do seu im�vel: ");
		vg = sc.nextInt();
		System.out.println("Entre com o valor do seu im�vel (em R$) (use o '.' como separador de decimais): ");
		valor = sc.nextFloat();
		
		return new Imovel(codigo, endereco, descricao, nq, m2, vg, valor);
	}

}
