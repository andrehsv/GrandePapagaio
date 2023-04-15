import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		GrandePapagaio gp = new GrandePapagaio();
        String comando = "";
        while (true) {
            comando = input().strip();
            if (comando.contains("->")) {
                gp.postar(comando.strip());
            } else if (comando.contains("mural")) {
                gp.ler(comando.strip());
            } else if (comando.contains("segue")) {
                try {
                    gp.seguir(comando.strip());
                } catch(UsuarioInexistenteException e) {
                    System.out.println("O usuário " + e.getNome() + " não existe");
                }
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
