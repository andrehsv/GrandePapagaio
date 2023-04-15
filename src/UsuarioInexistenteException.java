/**
 * Exception criada para caso o usuário não exista
 * @author André Victor
 *
 */
public class UsuarioInexistenteException extends Exception {
    private String nome;
    
    public UsuarioInexistenteException(String msg, String nome) {
        super(msg);
        this.nome = nome;
    }
    
    public String getNome() {
        return nome;
    }
}