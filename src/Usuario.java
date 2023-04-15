import java.util.ArrayList;
import java.util.List;

/**
 * Classe filha {@code Usuario}
 * @author André Victor
 */

public class Usuario extends GrandePapagaio {
    private String nome;
    private List<Usuario> seguidores = new ArrayList<>();
    private List<Usuario> seguindo = new ArrayList<>();
    private List<Post> posts = new ArrayList<>();
    
    /**
     * Construtor da classe. Recebe como parâmetro uma {@code String}
     * @param nome
     */
    public Usuario(String nome) {
        this.nome = nome;
    }
    
    /**
     * Retorna o atributo {@code nome} de um objeto {@code Usuario}
     * @return
     */
    public String getNome() {
        return nome;
    }
    
    /**
     * Adiciona um objeto {@code Post} a {@code ArrayList} {@code posts} de um objeto {@code Usuario}
     * @param post
     */
    public void adicionarPost(Post post) {
        this.posts.add(post);
        System.out.println("Post adicionado com sucesso ao mural de " + nome);
    }
    
    /**
     * Adiciona um objeto {@code Usuario} a lista {@code seguidores} de um objeto {@code Usuario}.
     * Recebe como parâmetro outro objeto {@code Usuario} (seguidor), cuja lista de posts receberá todos os posts
     * do objeto {@code Usuario} que está seguindo
     * @param seguidor
     */
    public void adicionarSeguidor(Usuario seguidor) {
        seguidores.add(seguidor);
        for(Post post : posts) {
            seguidor.adicionarPost(post);
        }
    }
    
    /**
     * Imprime os posts na lista de posts
     */
    public void getPosts() {
        for(Post post : posts) {
            System.out.println(post);
        }
    }
}