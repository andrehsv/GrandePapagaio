import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Classe de teste. Ainda não concluida
 * @author André Victor
 *
 */
public class GrandePapagaioTest extends GrandePapagaio{
	
	@Test
	public void testExisteUsuario() {
		GrandePapagaio instancia = new GrandePapagaio();
		String nome = "André";
		instancia.listaUsuarios.add(new Usuario(nome));
		assertTrue(instancia.existeUsuario(nome));
	}

	@Test
	public void testMostrarPosts() {
		fail("Not yet implemented");
	}

	@Test
	public void testSeguir() {
		fail("Not yet implemented");
	}

	@Test
	public void testPostar() {
		fail("Not yet implemented");
	}

	@Test
	public void testLer() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetListaUsuarios() {
		fail("Not yet implemented");
	}

}
