import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Principal {
	
	private static final String SEPARATOR = "/";
	private static final String COMMA = ",";
	private static final String PATH = "D:/provas/dados";
	private static final String OK = "certo";
	private static final String ERRO = "erro";
	private static List<String> BUFFER = new ArrayList<String>();
 	private static final String INPUT = PATH + SEPARATOR + "questoes.txt";
	private static final String OUTPUT = PATH + SEPARATOR + "resultado.txt";
	private static final String GAB_TIPO_1[] = {"c","d","a","e","d","c","d"};
	private static final String GAB_TIPO_2[] = {"d","c","d","e","a","d","c"};
	private static final Double VALOR_QUESTAO_TIPO_1[] = {3.5,3.5,3.5,3.5,3.5,3.5,4.0};
	private static final Double VALOR_QUESTAO_TIPO_2[] = {4.0,3.5,3.5,3.5,3.5,3.5,3.5};
	
	
	public static void main(String[] args) {
		
		if (GAB_TIPO_1 != null && GAB_TIPO_2 != null) {
			if (GAB_TIPO_1.length == GAB_TIPO_2.length) {
				
				int tam1 = GAB_TIPO_1.length;
				int j = 0;
				for (int i = tam1 - 1; i >= 0; i--, j++) {
						if (!GAB_TIPO_1[i].equals(GAB_TIPO_2[j])) {
							System.err.println("Problema nos Gabaritos!!");
							return;
						}
				}
				
			} else {
				System.err.println("O tamanho dos vetores de gabaritos e diferente!");
				return;
			}
			
		} else {
			System.err.println("O(s) vetor(es) de gabarito(s) esta(o) nulo(s)!");
			return;
		}
		
		if (VALOR_QUESTAO_TIPO_1 != null && VALOR_QUESTAO_TIPO_2 != null) {
			if (VALOR_QUESTAO_TIPO_1.length == VALOR_QUESTAO_TIPO_2.length) {
				int aux1 = VALOR_QUESTAO_TIPO_1.length;
				int j = 0;
				
				for (int i = aux1 - 1; i >= 0; i--, j++) {
					if (!VALOR_QUESTAO_TIPO_1[i].equals(VALOR_QUESTAO_TIPO_2[j])) {
						System.err.println("Problema nos Valores Das Questoes!!");
						return;
					}
				}
			}
		}
		
		BufferedReader reader = null;

		try {
		    File file = new File(INPUT);
		    reader = new BufferedReader(new FileReader(file));

		    String lineVet[];
		    String line;
		    String matricula;
		    Integer lineVetSize;
		    Integer tipoProva;
		    Integer nroQuestoes;
		    String respLine;
		    Double somaNota = 0d; 
		    
		    while ((line = reader.readLine()) != null) {
		        System.out.println(line);
		        
		        respLine = "";
		        somaNota = 0d;
		        
		        lineVet = line.split(",");
		        lineVetSize = lineVet.length;
		        matricula = lineVet[0];
		        tipoProva = Integer.valueOf(lineVet[1]);
		        
		        nroQuestoes = lineVetSize - 2;
		        
		        respLine = matricula + COMMA + tipoProva + COMMA;
		        
		        if (tipoProva != 1) {
		        	// PROVA TIPO 2
		        	int index = 0;
		        	for (int i = 2; i < lineVetSize; i++) {
		        		if (GAB_TIPO_2[index].equals(lineVet[i])) {
		        			// Caso em que houve um acerto da alternativa!
		        			respLine = respLine + OK + COMMA;
		        			somaNota = somaNota + VALOR_QUESTAO_TIPO_2[index];
		        		} else {
		        			// Caso em que houve um erro da alternativa!
		        			respLine = respLine + ERRO + COMMA;
		        		}
		        		index++;
		        	}
		        	
		        	respLine = respLine + somaNota;
		        	BUFFER.add(respLine);
		        	
		        } else {
		        	// PROVA TIPO 1
		        	
		        	int pos = 0;
		        	for (int i = 2; i < lineVetSize; i++) {
		        		if (GAB_TIPO_1[pos].equals(lineVet[i])) {
		        			// Caso em que houve um acerto da alternativa!
		        			respLine = respLine + OK + COMMA;
		        			somaNota = somaNota + VALOR_QUESTAO_TIPO_1[pos];
		        		} else {
		        			// Caso em que houve um erro da alternativa!
		        			respLine = respLine + ERRO + COMMA;
		        		}
		        		pos++;
		        	}
		        	
		        	respLine = respLine + somaNota;
		        	BUFFER.add(respLine);
		        }
		        	        
		    }

		} catch (IOException e) {
		    e.printStackTrace();
		} finally {
		    try {
		        reader.close();
		    } catch (IOException e) {
		        e.printStackTrace();
		    }
		}
		
		BufferedWriter writer = null;
		
		try
	    {
	        File file = new File(OUTPUT);
	        file.createNewFile();

	        writer = new BufferedWriter(new FileWriter(file));
	        
	        for (String line : BUFFER) {
	        	writer.write(line);
		        writer.newLine();
	        }
	        
	        writer.flush();
	        writer.close();
	        
	        System.out.println("Arquivo gerado com sucesso!");
	    }
	    catch(FileNotFoundException e)
	    {
	        System.out.println("File Not Found");
	        System.exit(1);
	    }
	    catch(IOException e)
	    {
	        System.out.println("something messed up");
	        System.exit(1);
	    }
	}
}
