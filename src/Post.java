import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


/**
 * Classe {@code Post}
 * @author André Victor
 *
 */
public class Post {
    private String autor;
    private String conteudo;
    private LocalDateTime dataHora = LocalDateTime.now();
    
    /**
     * Construtor da classe. Recebe como parâmetros as {@code String} conteudo e autor
     * @param conteudo
     * @param autor
     */
    public Post(String conteudo, String autor) {
        this.autor = autor;
        this.conteudo = conteudo;
    } 
    
    /**
     * Método {@code .toString()} reescrito para exibir o autor, o conteúdo do post e a data em que foi postado
     */
    @Override
    public String toString() {
        DateTimeFormatter formatar = DateTimeFormatter.ofPattern("dd-MM-yyy HH:mm:ss");
        String dataFormatada = dataHora.format(formatar);
        
        return autor + " --> " + conteudo + " (" + dataFormatada + ")";
    }
}