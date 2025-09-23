import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class Principal {
	
	public static void main(String[] args) {
		
		Map<Integer, Convenio> conveniosMap = new HashMap<Integer, Convenio>();
		Map<Integer, Especialidade> especialidadesMap = new HashMap<Integer, Especialidade>();
		Map<String, Medico> medicosMap = new HashMap<String, Medico>();
		Map<String, Paciente> pacientesMap = new HashMap<String, Paciente>();
		
		int opcao;
		Scanner scan = new Scanner(System.in);
		Scanner scan2 = new Scanner(System.in);
		
		System.out.println("========== MENU ==========");
		System.out.println("1. Gerenciar Convenio");
		System.out.println("2. Gerenciar Especialidade");
		System.out.println("3. Gerenciar Paciente");
		System.out.println("4. Gerenciar Medico");
		System.out.println("5. Sair");
		
		opcao = scan.nextInt();
		
		do {
			
			switch (opcao) {
			case 1: gerenciarConvenio(scan, scan2, conveniosMap);
					break;
				
			case 2: gerenciarEspecialidade(scan, scan2, especialidadesMap);
					break;
				
			case 3: gerenciarPaciente(scan, scan2, pacientesMap, conveniosMap);
					break;
				
			case 4: gerenciarMedico(scan, scan2, medicosMap);
					break;
				
			case 5: System.out.println("Obrigado por usar o sistema!");
					break;
			default: System.err.println("Opcao Invalida!");
			
			}
			

		} while (opcao != 5);
		
		
	}

	private static void gerenciarMedico(Scanner scan, Scanner scan2, Map<String, Medico> medicosMap) {
		// Mesma lógica do gerenciarPaciente, porem a chave do Map sera o CRM do Medico...
		
	}

	private static void gerenciarPaciente(Scanner scan, Scanner scan2, Map<String, Paciente> pacientesMap, Map<Integer, Convenio> conveniosMapa) {
		
		int escolha;
		
		Integer codigoConvenio = null;
		
		String nome, cpf, telefone, endereco, rg, estadoCivil, nacionalidade, naturalidade;
		
		Paciente paciente = null;
		Convenio convenio = null;
		
		System.out.println("========== Gerenciar Paciente ==========");
		System.out.println("1. Cadastrar Paciente");
		System.out.println("2. Editar Paciente");
		System.out.println("3. Excluir Paciente");
		System.out.println("4. Listar Paciente(s)");
		System.out.println("5. Sair");
		
		escolha = scan.nextInt();
		
		do {
			
			switch (escolha) {
			case 1:  System.out.println("=== Cadastrar novo paciente ===");
					 System.out.println("=== Digite o CPF do paciente ===");
					 cpf = scan.next();
					 
					 System.out.println("=== Digite o RG do paciente ===");
					 rg = scan.next();
					 
					 System.out.println("=== Digite o nome do paciente ===");
					 nome = scan2.nextLine();
					 
					 System.out.println("=== Digite o telefone do paciente ===");
					 telefone = scan2.nextLine();
					 
					 System.out.println("=== Digite o endereco do paciente ===");
					 endereco = scan2.nextLine();
					 
					 System.out.println("=== Digite o estado civil do paciente ===");
					 estadoCivil = scan2.nextLine();
					 
					 System.out.println("=== Digite a nacionalidade do paciente ===");
					 nacionalidade = scan2.nextLine();
					 
					 System.out.println("=== Digite a naturalidade do paciente ===");
					 naturalidade = scan2.nextLine();
					 
					 System.out.println("=== Digite o codigo do convenio do paciente ===");
					 codigoConvenio = scan.nextInt();
					 
					 if (conveniosMapa.containsKey(codigoConvenio)) {
						 convenio = conveniosMapa.get(codigoConvenio);
						 
						// Criar um objeto do tipo Paciente
						 paciente = new Paciente(cpf, rg, nome, endereco, telefone, estadoCivil, 
								  naturalidade, nacionalidade, convenio);
						
						 // Adicionar o paciente no Mapa de Pacientes
						 pacientesMap.put(cpf, paciente);
						 
					 } else {
						 System.err.println("Convenio nao encontrado!");
						 
					 }
	
			case 2: System.out.println("=== Editar um paciente ===");
			        System.out.println("=== Digite o CPF do paciente ===");
					cpf = scan.next();
					
					if (pacientesMap.containsKey(cpf)) {
						// Caso em que encontrou o paciente para editar...
						
						 System.out.println("Digite o novo endereco do paciente:");
						 endereco = scan2.nextLine(); 
						 
						 // Editar o objeto que esta dentro do mapa
						 pacientesMap.get(cpf).setEndereco(endereco);
						
					} else {
						System.err.println("Paciente nao encontrado!");
					}
					
					break;

			case 3: System.out.println("=== Excluir um paciente ===");
					System.out.println("=== Digite o CPF do paciente ===");
					cpf = scan.next();
					
					 if (pacientesMap.containsKey(cpf)) {
							
						// Exclui o objeto Paciente associado ao CPF informado
						pacientesMap.remove(cpf);
					} else {
						System.err.println("Paciente nao encontrado!");	
					}
					 
					break;
			case 4: System.out.println("=== Listar paciente(s) ===");
					Paciente pacienteAtual = null;
					for (String key : pacientesMap.keySet()) {
						pacienteAtual = pacientesMap.get(key);
						System.out.println("" + pacienteAtual.toString());
					}
			
				    break;
			case 5: System.out.println("Voltar para o Menu Principal");
					break;
			
			default: System.err.println("Opcao Invalida!");
			 		 break;

			}
			
		} while (escolha != 5);
		
	}

	private static void gerenciarEspecialidade(Scanner scan, Scanner scan2, Map<Integer, Especialidade> especialidadesMap) {
		// Mesma lógica do gerenciarConvenio...
		
	}

	private static void gerenciarConvenio(Scanner scan, Scanner scan2, Map<Integer, Convenio> conveniosMap) {
		
		int escolha, codigo; 
		String nome;
		
		Convenio convenio = null;
		
		System.out.println("========== Gerenciar Convenio ==========");
		System.out.println("1. Cadastrar Convenio");
		System.out.println("2. Editar Convenio");
		System.out.println("3. Excluir Convenio");
		System.out.println("4. Listar Convenio(s)");
		System.out.println("5. Sair");
		
		escolha = scan.nextInt();
		
		do {
			
			switch (escolha) {
			case 1: System.out.println("=== Cadastrar novo convenio ===");
				    System.out.println("Digite o codigo do convenio:");
				    codigo = scan.nextInt(); 
			
				    System.out.println("Digite o nome do convenio:");
					nome = scan2.nextLine(); 
					
					// Cria o objeto convenio
					convenio = new Convenio(codigo, nome);
					
					// Adicionar o objeto convenio no Mapa
					conveniosMap.put(codigo, convenio);
					break;
			
			case 2: System.out.println("=== Editar um convenio ===");
					System.out.println("Digite o codigo do convenio:");
					codigo = scan.nextInt(); 
					
					if (conveniosMap.containsKey(codigo)) {
						// Caso em que encontrou o convenio para editar...
						
						 System.out.println("Digite o novo nome do convenio:");
						 nome = scan2.nextLine(); 
						 
						 // Editar o objeto que esta dentro do mapa
						 conveniosMap.get(codigo).setDescricao(nome);
						
					} else {
						System.err.println("Convenio nao encontrado!");
					}
					
					break;
			case 3: System.out.println("=== Excluir um convenio ===");
					System.out.println("Digite o codigo do convenio:");
					codigo = scan.nextInt(); 
					
					if (conveniosMap.containsKey(codigo)) {
						
						// Exclui o objeto convenio associado ao codigo informado
						conveniosMap.remove(codigo);
						
					} else {
						System.err.println("Convenio nao encontrado!");
						
					}
			
					break;
					
			case 4: System.out.println("=== Listagem de convenio(s) ===");
				    Convenio convenioMedico = null;
				    for (Integer key : conveniosMap.keySet()) {
				    	convenioMedico = conveniosMap.get(key);
				    	System.out.println("" + convenioMedico.toString());
					}
					
					/*Integer key = null;
					Convenio convenioMedico = null;
				
				    for (Entry<Integer, Convenio> registro : conveniosMap.entrySet()) {
				    	
				    	key = registro.getKey();
				    	convenioMedico = registro.getValue();
				    	
				    	System.out.println("Codigo: " + key + 
						         " convenioMedico: " + convenioMedico.getDescricao());

				    }*/
				    
					break;
			case 5: System.out.println("Voltar para o Menu Principal!");
					break;
			default: System.err.println("Opcao Invalida!");
					 break;
			
			}
	
		} while (escolha != 5);
	}
	
}
