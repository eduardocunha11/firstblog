import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

public class Principal {
	
	
	private static HashMap<String, Aluno> alunosPC2 = new HashMap<String, Aluno>();
	
	private static HashMap<String, String> estadosCapitaisMap = new HashMap<String, String>();
	private static HashMap<String, List<String>> cidadesEstadoMap = new HashMap<String, List<String>>();
	
	public static void main(String[] args) {

		// Coloca no mapa, algumas capitais de cada estado brasileiro
		estadosCapitaisMap.put("Minas Gerais", "Belo Horizonte");
		estadosCapitaisMap.put("Goi�s", "Goi�nia");
		estadosCapitaisMap.put("Pernambuco", "Recife");
		estadosCapitaisMap.put("Rio Grande do Norte", "Natal");
		estadosCapitaisMap.put("Alagoas", "Macei�");
		estadosCapitaisMap.put("S�o Paulo", "S�o Paulo");

	
		System.out.println("A capital de Minas Gerais eh: " + estadosCapitaisMap.get("Minas Gerais"));
		
		List<String> cidadesDeMinasGeraisList = new ArrayList<String>();
		cidadesDeMinasGeraisList.add("Ouro Preto");
		cidadesDeMinasGeraisList.add("Betim");
		cidadesDeMinasGeraisList.add("Contagem");
		cidadesDeMinasGeraisList.add("Nova Lima");
		cidadesDeMinasGeraisList.add("Uberl�ndia");
		cidadesDeMinasGeraisList.add("Uberaba");
		cidadesDeMinasGeraisList.add("Araguari");
		
		System.out.println("O tamanho da lista de cidades de MG eh: " + cidadesDeMinasGeraisList.size());
		
		
		List<String> cidadesDeGoiasList = new ArrayList<String>();
		cidadesDeGoiasList.add("Morrinhos");
		cidadesDeGoiasList.add("Aparecida de Goi�nia");
		cidadesDeGoiasList.add("Goiatuba");
		cidadesDeGoiasList.add("Hidrol�ndia");
		cidadesDeGoiasList.add("An�polis");
		cidadesDeGoiasList.add("Itumbiara");
		
		List<String> cidadesDeSaoPauloList = new ArrayList<String>();
		cidadesDeSaoPauloList.add("Campinas");
		cidadesDeSaoPauloList.add("S�o Jos� do Rio Preto");
		cidadesDeSaoPauloList.add("Guarulhos");
		cidadesDeSaoPauloList.add("Rio Claro");
		cidadesDeSaoPauloList.add("Ribeir�o Preto");
		
		
		// Coloca no mapa, algumas cidades de alguns estados brasileiros
		cidadesEstadoMap.put("Minas Gerais", cidadesDeMinasGeraisList);
		cidadesEstadoMap.put("Goi�s", cidadesDeGoiasList);
		cidadesEstadoMap.put("S�o Paulo", cidadesDeSaoPauloList);
		
		
		cidadesEstadoMap.get("Minas Gerais").add("Ouro Branco");
		cidadesEstadoMap.get("Minas Gerais").add("Ribeir�o das Neves");
		
		cidadesEstadoMap.get("Goi�s").add("Buriti Alegre");
		
		
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
			
			System.out.println("As Cidades do Estado de " + estado + " s�o: ");
			
			if (cidades.size() > 0) {				
				cidadesIt = cidades.iterator();
				while (cidadesIt.hasNext()) {
					cidade = cidadesIt.next();
					System.out.println("" + cidade);
				}
			}
			
		}
	}

}
