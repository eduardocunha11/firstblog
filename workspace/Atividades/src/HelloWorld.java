import com.cefet.exercicios.Pessoa;

public class HelloWorld {
	
	public static void main(String[] args) {
		System.out.println("Ola mundo!");
		
		Pessoa p1 = new Pessoa("Alan", 21);
		p1.setCpf("088.256.89-32");
		
		Pessoa p2 = new Pessoa("Alana", 24);
		p2.setCpf("092.440.266-22");
		
		System.out.println("O cpf da Alana eh: " + p2.getCpf());
		
		Pessoa p3 = new Pessoa("Joao Guilherme", 22);
		
		Pessoa p4 = new Pessoa();
		p4.setNome("Lucas");
		p4.setIdade(25);
		
		Pessoa p5 = new Pessoa("Gabriela", 23, "089.256.78-21");
		
	}

}