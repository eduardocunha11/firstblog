public class Aluno {

   private String nome;
   private String matricula;
   private Integer idade;
 
   public Aluno() {

   }

   public Aluno(String nome, String matricula, Integer idade) {
      this.nome = nome;
      this.matricula = matricula;
      this.idade = idade;
   }

   public String getNome() {
     return nome;
   }

   public String getMatricula() {
     return matricula;
   }

   public Integer getIdade() {
     return idade;
   }

   public void setNome(String nome) {
     this.nome = nome;
   }

   public void setMatricula(String matricula) {
     this.matricula = matricula;
   }

   public void setIdade(Integer idade) {
     this.idade = idade;
   }

}