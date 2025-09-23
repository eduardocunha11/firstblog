
public class Medico extends Pessoa {
	
	private String crm;
	private Especialidade especialidade;
	
	public Medico() {
		
	}
	
	public Medico(String crm, Especialidade especialidade) {
		this.crm = crm;
		this.especialidade = especialidade;
	}
	
	public String getCrm() {
		return crm;
	}
	public void setCrm(String crm) {
		this.crm = crm;
	}
	public Especialidade getEspecialidade() {
		return especialidade;
	}
	public void setEspecialidade(Especialidade especialidade) {
		this.especialidade = especialidade;
	}

	@Override
	public String toString() {
		return "Medico [crm=" + crm + ", especialidade=" + especialidade + "]";
	}


}
