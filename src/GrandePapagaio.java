import java.util.ArrayList;
import java.util.List;

/**
 * Atividade que fiz para disciplina de Linguagem de Programação.
 * Essa é a classe pai do programa.
 * @author André Victor
 * 
 */

public class GrandePapagaio {
    List<Usuario> listaUsuarios = new ArrayList<>();
    
    /**
     * Identifica o usuário pelo nome, retornando {@code true} caso o encontre
     * @param nomeUsuario
     * @return retorna {@code true} ou {@code false}
     */
    public boolean existeUsuario(String nomeUsuario) {
        for(Usuario u : listaUsuarios)
            if(u.getNome().equals(nomeUsuario))
                return true;
        return false;
    }
    
    /**
     * Mostra os posts de um determinado usuário
     * @param nomeUsuario
     */
    public void mostrarPosts(String nomeUsuario) {
        for(Usuario u : listaUsuarios) {
            if(u.getNome().equals(nomeUsuario))
                u.getPosts();
        }
    }
    
    /**
     * Identifica o comando "segue" e realiza operação de adicionar seguidor a um usuário.
     * @category Identificador de comando
     * @param comando
     * @throws UsuarioInexistenteException
     */
    public void seguir(String comando) throws UsuarioInexistenteException {
        String[] comandoSplit = comando.split("segue");
        final String SEGUIDOR = comandoSplit[0].strip();
        final String SEGUIDO = comandoSplit[1].strip();
        
        if(!existeUsuario(SEGUIDOR)) {
            Usuario user = new Usuario(SEGUIDOR);
            this.listaUsuarios.add(user);
        }
        
        if(existeUsuario(SEGUIDO)) {
            for (Usuario u : listaUsuarios) {
                if (u.getNome().equals(SEGUIDO)) {
                    for (Usuario v : listaUsuarios) {
                        if (v.getNome().equals(SEGUIDOR)) {
                            u.adicionarSeguidor(v);
                        }
                    }
                }
            }
        } else {
            throw new UsuarioInexistenteException("O usuario nao existe", SEGUIDO);
        }
        
    }
    
    /**
     * Identifica o comando "->" e adicionar post ao mural do usuário.
     * @param comando
     * @category Identificador de comando
     */
    public void postar(String comando) {
        String[] comandoSplit = comando.split("->");
        final String NOME = comandoSplit[0].strip();
        final String CONTEUDO = comandoSplit[1].strip();
        Post post = new Post(CONTEUDO, NOME);
        
        if(!existeUsuario(NOME)) {
            Usuario u = new Usuario(NOME);
            u.adicionarPost(post);
            this.listaUsuarios.add(u);
        } else {
            for(Usuario u : listaUsuarios) {
                if(u.getNome().equals(NOME)) {
                    u.adicionarPost(post);
                }
            }
        }
    }
    
    /**
     * Identifica o comando "mural" e mostra o mural de posts do usuário
     * @category Identificador de comando
     * @param comando
     */
    public void ler(String comando) throws UsuarioInexistenteException {
        String[] comandoSplit = comando.split("mural");
        final String NOME = comandoSplit[1].strip();
        
        if(existeUsuario(NOME))
        	mostrarPosts(NOME);
        else
        	throw new UsuarioInexistenteException("O usuario nao existe", NOME);
    }
    
    /**
     * Getter de {@code listaUsuarios}
     * @return Objeto ArrayList do tipo {@code Usuario}
     */
    public List<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }
}