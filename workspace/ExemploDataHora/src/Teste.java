import java.util.Calendar;

public class Teste {
	
	public static void main(String[] args) {
		Calendar c = Calendar.getInstance();
		System.out.println("Data/Hora atual: "+c.getTime());
		
		
		Calendar dataCanlelamento = Calendar.getInstance();



        dataCanlelamento.set(Calendar.YEAR, 2020);

        dataCanlelamento.set(Calendar.MONTH, Calendar.OCTOBER);

        dataCanlelamento.set(Calendar.DAY_OF_MONTH, 22);

        dataCanlelamento.getTime();



//        telefones.get(0).setFimDia(dataCanlelamento.get(Calendar.DAY_OF_MONTH));
//
//        telefones.get(0).setFimMes(dataCanlelamento.get(Calendar.MONTH));
//
//        telefones.get(0).setFimAno(dataCanlelamento.get(Calendar.YEAR));
		
	}

}
