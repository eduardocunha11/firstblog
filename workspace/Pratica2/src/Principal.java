
public class Principal {
	
	public static void main(String[] args) {
		try {
            // System.out.println(args[0]);
			for (String str: args) {
				System.out.println("" + str);
			}
            
        } catch (ArrayIndexOutOfBoundsException aiofbex) {
            System.out.println("Passe um arquivo por parametro");
        }
	}
}
