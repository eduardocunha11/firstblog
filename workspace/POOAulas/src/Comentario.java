// Cada post (mensagem) deverá ter um identificador único
// Cada comentário também deverá ter um identificador único

//Para verificar se uma string está dentro de outra, utilize o método substring
//da classe String, como no exemplo abaixo:

str = "casa"

str2 = "A casa e bela"

str.substring(str2)

Id: "m1"

Id: "c1",
    "c2",
	"c3"

HashMap<String, ArrayList<Comentario>> comentariosMap = 
                 new HashMap<String, ArrayList<Comentario>>();
		
// "m1" -> ["c1", "c2", "c3"]

comentariosMap.get("m1").add(new Comentario("c4", "Legal esse filme!"));

// "m1" -> ["c1", "c2", "c3", "c4"]
		
HashMap<String, Comentario> idComentarioMap = 
                 new HashMap<String, Comentario>();   

// "c1" -> obj1. do tipo Comentario (texto: "Gostei desse post!")
// "c2" -> obj2. do tipo Comentario (texto: "Isso é um absurdo!")