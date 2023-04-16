import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Main {

	public static void main(String[] args) {
		Pattern regexPostar = Pattern.compile("->"),
			regexLer = Pattern.compile("mural"),
			regexSegue = Pattern.compile("segue");
		
		Matcher matchPostar,
			matchLer,
			matchSegue;
		
		GrandePapagaio gp = new GrandePapagaio();
        String comando;
        String prompt = "----------------------------\n" +
        		"G R A N D E  P A P A G A I O\n" +
        		"----------------------------\n\n" +
        		"COMANDOS:\n" +
        		"- Postar: <nomedousuario> -> <post>\n" +
        		"- Ler: mural <nomedousuario>\n" +
        		"- Seguir: <nomedousuario> segue <outrousuario>\n" +
        		"*Novos usuarios sao criados ao postar e ao seguir\n";
        System.out.println(prompt);
        
        while (true) {
            comando = input();
            String comandoFormatado = comando.strip();
            
            matchPostar = regexPostar.matcher(comandoFormatado);
            matchLer = regexLer.matcher(comandoFormatado);
            matchSegue = regexSegue.matcher(comandoFormatado);
            
            boolean isPostar = matchPostar.find(),
            	    isLer = matchLer.find(),
            	    isSegue = matchSegue.find();
            
            if (isPostar) {
                gp.postar(comandoFormatado);
            } else if (isLer) {
                try {
                    gp.ler(comandoFormatado);
                } catch(UsuarioInexistenteException e) {
                    System.out.println("O usuario " + e.getNome() + " nao existe");
                }
            } else if (isSegue) {
                try {
                    gp.seguir(comandoFormatado);
                } catch(UsuarioInexistenteException e) {
                    System.out.println("O usuario " + e.getNome() + " nao existe");
                }
            } else {
            	System.out.println("Comando nao identificado");
            }
        }
    }
    
    static String input() {
        System.out.print("> ");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        return input;
    }
}
