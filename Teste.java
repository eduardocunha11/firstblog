public class Teste {
	
	private Double iptu, ipva;
	private Double pis;
	
	public Teste() {
		
	}
	
	public Teste(Double iptu, Double ipva) {
		this.iptu = iptu;
		this.ipva = ipva;
	}
	
	public Teste(Double iptu, Double ipva, Double pis) {
		this.iptu = iptu;
		this.ipva = ipva;
		this.pis = pis;
	}
	
	public Double soma(Double x, Double u, Double v) {
		return (x + u + v);
	}
	
	public Double soma(Double x, Double u) {
		return (x + u);
	}
	
	// Assinatura 1: public Teste()
	// Assinatura 2: public Teste(Double iptu, Double ipva)
	// Assinatura 3: public Teste(Double iptu, Double ipva, Double pis)
	
	
	
}