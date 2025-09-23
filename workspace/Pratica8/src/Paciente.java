
public class Paciente extends Pessoa {

	private Convenio convenio;
	
	public Paciente() {
		
	}
	
	public Paciente(String cpf, String rg, String nome, String endereco, 
            		String telefone, String estadoCivil,
            		String naturalidade, String nacionalidade, Convenio convenio) {
		
		super(cpf, rg, nome, endereco, telefone, estadoCivil, naturalidade, nacionalidade);
		this.convenio = convenio;
	}

	public Convenio getConvenio() {
		return convenio;
	}

	public void setConvenio(Convenio convenio) {
		this.convenio = convenio;
	}

	@Override
	public String toString() {
		return "Paciente [convenio=" + convenio + ", cpf=" + cpf + ", rg=" + rg + ", nome=" + nome + ", endereco="
				+ endereco + ", telefone=" + telefone + ", estadoCivil=" + estadoCivil + ", naturalidade="
				+ naturalidade + ", nacionalidade=" + nacionalidade + "]";
	}
	
}
