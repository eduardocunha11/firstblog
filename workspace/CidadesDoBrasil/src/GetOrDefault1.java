import java.util.HashMap;
import java.util.Map;

public class GetOrDefault1 {
  
	public static void main(String[] args) {
		Map<Integer, String> studentMap = new HashMap<>();
		studentMap.put(101, "Mahesh");
		studentMap.put(102, "Suresh");
		studentMap.put(103, "Krishna");

		String defaultValue = "No Student";
		String stdName = studentMap.getOrDefault(102, defaultValue);
		System.out.println(stdName);

		// A chave 104 nao existe no mapa! Entao, retorna o valor padrao (default)
		// O valor default deve possuir o mesmo tipo do valor do HashMap (String)
		stdName = studentMap.getOrDefault(104, defaultValue);
		System.out.println(stdName);

		// A chave 105 nao existe no mapa! Entao, retorna o valor padrao (default)
		// O valor default deve possuir o mesmo tipo do valor do HashMap (String)
		stdName = studentMap.getOrDefault(105, defaultValue);
		System.out.println(stdName);     
     
  }
} 