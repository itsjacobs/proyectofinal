import org.example.domain.Casilla;
import org.example.domain.Tablero;
import org.example.domain.Usuario;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

public class daoTest {
    @Test
    void apostarNumero() {
        Tablero tab = new Tablero();
        tab.rellenarTablero();
        List<Casilla> casillas = new ArrayList<>();
        int numero = 19;
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 3; j++) {
                Casilla casilla = tab.getTablero()[i][j];
                if (casilla != null && casilla.getNumero() == numero) {
                    casillas.add(casilla);
                    assertEquals(numero, casilla.getNumero());
                }
            }
        }
    }
    @Test
    void apostarColor() {
        Tablero tab = new Tablero();
        tab.rellenarTablero();
        List<Casilla> casillas = new ArrayList<>();
        boolean colorRojo = true;
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 3; j++) {
                Casilla casilla = tab.getTablero()[i][j];
                if (casilla != null && casilla.isColor() == colorRojo) {
                    assertEquals(colorRojo, casilla.isColor());
                }
            }
        }
    }
    @Test
    void apostarMayor() {
        Tablero tab = new Tablero();
        tab.rellenarTablero();
        List<Casilla> casillas = new ArrayList<>();
        boolean mayor = true;
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 3; j++) {
                if (tab.getTablero()[i][j] != null && tab.esMayor(tab.getTablero()[i][j]) == mayor) {
                    assertEquals(mayor, tab.esMayor(tab.getTablero()[i][j]));
                }
            }
        }
    }
    /*@Test
    void excepcionAPar() {
       assertThrows(APar.class, () -> {
           System.out.println("Excepcion APar lanzada");
       });
    }*/

    @Nested
    class cuandoElUsuarioNoExiste {
        @Test
        void registrarse(){
            Usuario usuario = new Usuario("01","Juan","1234");
            usuario.registrarse(usuario);
            boolean resultado = usuario.registrarse(usuario);


            assertFalse(resultado);
            assertEquals("01",usuario.getId());
            assertEquals("Juan",usuario.getNombre());
            assertThat(usuario.getNombre(),startsWith("J"));
            assertEquals("1234",usuario.getContraseña());
        }

    }
    @Nested
    class cuandoElUsuarioExiste{
        @Test
        void IniciarSesion(){
            Usuario usuario = new Usuario("01","Juan","1234");
            boolean resultado = usuario.inicioSesion(usuario);
            assertTrue(resultado);

        }
    }

}
