import java.util.Calendar;

public class Principal {
	
	public static void main(String[] args) {		
			
		Calendar c = Calendar.getInstance();
		c.set(Calendar.YEAR, 2020);
		c.set(Calendar.MONTH, Calendar.OCTOBER);
		c.set(Calendar.DAY_OF_MONTH, 22);
	
		c.set(Calendar.HOUR_OF_DAY, 15);
		c.set(Calendar.MINUTE, 30);
		c.set(Calendar.MILLISECOND, 0);

		System.out.println("Data/Hora atual: "+c.getTime());
		System.out.println("Ano: "+c.get(Calendar.YEAR));
		System.out.println("M�s: "+c.get(Calendar.MONTH));
		System.out.println("Dia do M�s: "+c.get(Calendar.DAY_OF_MONTH));
		
			
		/**
		 * Cria um objeto Calendar contendo o dia e hora atual
		 */
		
		Calendar c2 = Calendar.getInstance();
		c2.set(Calendar.YEAR, 2020);
		c2.set(Calendar.MONTH, Calendar.OCTOBER);
		c2.set(Calendar.DAY_OF_MONTH, 22);

		System.out.println("Data/Hora atual: "+c2.getTime());
		System.out.println("Ano: "+c2.get(Calendar.YEAR));
		System.out.println("M�s: "+c2.get(Calendar.MONTH));
		System.out.println("Dia do M�s: "+c2.get(Calendar.DAY_OF_MONTH));
		
		
		if (c2.after(c)) {
			System.out.println("Calendar 2 vem depois do Calendar 1 no tempo...");
		}
		
		/**
		 * Calcula a dura��o da chamada
		 * 1 minuto = 60 segundos = 60000 milissegundos
		 */
		
		long duration = (c2.getTimeInMillis() - c.getTimeInMillis()) / 60000;
		System.out.println("Intervalo: " + duration + " minutos");
		
		
		/**
		 * Outro exemplo: Recupera a hora do dia e verifica qual deve ser a msg de sauda��o
		 */
		
		Calendar c1 = Calendar.getInstance();
		int hora = c1.get(Calendar.HOUR_OF_DAY);
		
		System.out.println("hora: " + hora);

		if(hora >= 6 && hora < 12){
			System.out.println("Bom Dia");
		} else if (hora >= 12 && hora <= 18){
			System.out.println("Boa Tarde");
		} else {
			System.out.println("Boa Noite");
		}
	}		
}
