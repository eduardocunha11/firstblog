import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Scanner;

public class Principal {
		
	private static HashMap<String, String> estadosCapitaisMap = new HashMap<String, String>();
	private static HashMap<String, List<String>> cidadesEstadoMap = new HashMap<String, List<String>>();
	
	private static HashMap<String, List<Cidade>> cidadesEstadosInfoMap = new HashMap<String, List<Cidade>>();
	
	public static void main(String[] args) {
		
		
//		cadastrarCidadeNoEstado(cidadesEstadoMap, "SP");

		// Coloca no mapa, algumas cidades de Minas Gerais 
		
		List<Cidade> listaCidadesMG = new ArrayList<Cidade>();
		
		List<String> bairrosBetim = new ArrayList<String>();
		bairrosBetim.add("Capelinha");
		bairrosBetim.add("Açude");
		
		Cidade betim = new Cidade();
		betim.setNome("Betim");
		betim.setIDH(0.749);
		betim.setPopulacao(439340);
		betim.setBairros(bairrosBetim);
		
		listaCidadesMG.add(betim);
		
		
		cidadesEstadosInfoMap.put("MG", listaCidadesMG);
		
		List<String> bairrosNovaLima = new ArrayList<String>();
		bairrosNovaLima.add("Centro");
		bairrosNovaLima.add("Vila da Serra");
		bairrosNovaLima.add("Vale do Sereno");
		
	
		Cidade novaLima = new Cidade();
		novaLima.setNome("Nova Lima");
		novaLima.setIDH(0.813);
		novaLima.setPopulacao(93577);
		novaLima.setBairros(bairrosNovaLima);
		
		
		cidadesEstadosInfoMap.get("MG").add(novaLima);
		
		
		
		// Coloca no mapa, algumas capitais de cada estado brasileiro
		estadosCapitaisMap.put("Minas Gerais", "Belo Horizonte");
		estadosCapitaisMap.put("Goiás", "Goiânia");
		estadosCapitaisMap.put("Pernambuco", "Recife");
		estadosCapitaisMap.put("Rio Grande do Norte", "Natal");
		estadosCapitaisMap.put("Alagoas", "Maceió");
		estadosCapitaisMap.put("São Paulo", "São Paulo");
		estadosCapitaisMap.put("Tocantis", "Palmas");

	
//		System.out.println("A capital de Minas Gerais eh: " + estadosCapitaisMap.get("Minas Gerais"));
		
		List<String> cidadesDeMinasGeraisList = new ArrayList<String>();
		cidadesDeMinasGeraisList.add("Betim");
		cidadesDeMinasGeraisList.add("Contagem");
		cidadesDeMinasGeraisList.add("Nova Lima");
		cidadesDeMinasGeraisList.add("Uberlândia");
		cidadesDeMinasGeraisList.add("Uberaba");
		cidadesDeMinasGeraisList.add("Araguari");
		
//		System.out.println("O tamanho da lista de cidades de MG eh: " + cidadesDeMinasGeraisList.size());
		
		
		List<String> cidadesDeGoiasList = new ArrayList<String>();
		cidadesDeGoiasList.add("Morrinhos");
		cidadesDeGoiasList.add("Aparecida de Goiânia");
		cidadesDeGoiasList.add("Goiatuba");
		cidadesDeGoiasList.add("Hidrolândia");
		cidadesDeGoiasList.add("Anápolis");
		cidadesDeGoiasList.add("Itumbiara");
		
		List<String> cidadesDeSaoPauloList = new ArrayList<String>();
		cidadesDeSaoPauloList.add("Campinas");
		cidadesDeSaoPauloList.add("São José do Rio Preto");
		cidadesDeSaoPauloList.add("Guarulhos");
		cidadesDeSaoPauloList.add("Rio Claro");
		cidadesDeSaoPauloList.add("Ribeirão Preto");
		
		
		// Coloca no mapa, algumas cidades de alguns estados brasileiros
		cidadesEstadoMap.put("Minas Gerais", cidadesDeMinasGeraisList);
		cidadesEstadoMap.put("Goiás", cidadesDeGoiasList);
		cidadesEstadoMap.put("São Paulo", cidadesDeSaoPauloList);
		
		
		cidadesEstadoMap.get("Minas Gerais").add("Ouro Branco");
		cidadesEstadoMap.get("Minas Gerais").add("Ouro Preto");
		cidadesEstadoMap.get("Minas Gerais").add("Ribeirão das Neves");
		
		cidadesEstadoMap.get("Goiás").add("Buriti Alegre");
		
		
		String capital = "";
		for (String estado : estadosCapitaisMap.keySet()) {
			capital = estadosCapitaisMap.get(estado);
			System.out.println("A capital do estado de " + estado + " eh: " + capital);
		}
		
		String estado = "";
		String cidade = "";
		List<String> cidades = null;
		Iterator<String> cidadesIt = null;
		
		for (Entry<String, List<String>> tupla : cidadesEstadoMap.entrySet()) {
			estado = tupla.getKey();
			cidades = tupla.getValue();
			
			System.out.println("As Cidades do Estado de " + estado + " são: ");
			
			if (cidades.size() > 0) {				
				cidadesIt = cidades.iterator();
				while (cidadesIt.hasNext()) {
					cidade = cidadesIt.next();
					System.out.println("" + cidade);
				}
			}
			
		}
		
		// Verificar se a palavra "Ouro" aparece dentro da lista de cidades mineiras
		// Caso aparecer, imprimir quais são as cidades de MG que possuem esta palavra no nome
		// Como fazer isso???
		
		System.out.println("EXEMPLO DE USO DO METODO CONTAINS()");
		
		List<String> cidadesMineiras = cidadesEstadoMap.get("Minas Gerais");
		Iterator<String> cidadesMineirasIterator = cidadesMineiras.iterator();
		String cidadeMineira = "";
		String keyword = "Ouro"; // palavra-chave
		Integer tamanhoPalavra = 0;
		
		while (cidadesMineirasIterator.hasNext()) {
			cidadeMineira = cidadesMineirasIterator.next();
			if (cidadeMineira.contains(keyword)) {
				System.out.println("A cidade " + cidadeMineira + " possui a palavra 'Ouro' no nome...");
				tamanhoPalavra = cidadeMineira.length();
				System.out.println("A palavra " + cidadeMineira.substring(5, tamanhoPalavra) + " aparece apos a palavra 'Ouro'");
			}
		}
	} // fim do main
	
	
	public static void cadastrarCidadeNoEstado(HashMap<String, List<String>> mapa, String estado) {
		
		
		Scanner scan = new Scanner(System.in);
		
		String cidadePaulista = "";
		
		System.out.println("Digite uma cidade paulista");
		cidadePaulista = scan.nextLine();
		
		List<String> cidadesDeSP = new ArrayList<String>();
		cidadesDeSP.add(cidadePaulista);
		
		mapa.put(estado, cidadesDeSP);
		
	}

}
