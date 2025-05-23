import org.example.commons.ARuleta;
import org.example.commons.Comprobaciones;
import org.example.dao.ApuestaImplementacion;
import org.example.domain.Casilla;
import org.example.domain.Tablero;
import org.example.domain.Usuario;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(OrderAnnotation.class)
class ApuestaImplementacionTest {

    ApuestaImplementacion apuesta;
    Tablero tablero;
    Usuario usuario;
    @BeforeEach
    void antesDePruebas() {
        apuesta = new ApuestaImplementacion();
        tablero = new Tablero();
        tablero.rellenarTablero();
        usuario = new Usuario("01", "Juan", "1234");

    }

    @Test
    @Order(1)
    void testApostarNumero() {
        List<Casilla> resultado = apuesta.apostarNumero(5, 10.0, tablero, usuario);
        assertThat(resultado).allMatch(c -> c.getNumero() == 5 && c.getValor() > 0);
    }

    @Test
    @Order(2)
    void testApostarColorRojo() {
        List<Casilla> resultado = apuesta.apostarColor(true, 5.0, tablero, usuario);
        assertThat(resultado).allMatch(c -> c.isColor());
    }

    @Test
    @Order(3)
    void testApostarFilaValida() {
        List<Casilla> resultado = apuesta.apostarFila(1, 20.0, tablero, usuario);
        assertThat(resultado).allMatch(c -> tablero.queFila(c) == 1);
    }

    @Test
    @Order(4)
    void testApostarDocena() {
        List<Casilla> resultado = apuesta.apostarDocena(2, 15.0, tablero, usuario);
        assertThat(resultado).allMatch(c -> tablero.queDocena(c) == 2);
    }

    @Test
    @Order(5)
    void testApostarMayor() {
        List<Casilla> resultado = apuesta.apostarMayor(true, 10.0, tablero, usuario);
        assertThat(resultado).allMatch(c -> tablero.esMayor(c));
    }
    @Test
    @Order(6)
    void testApostarPar() {
        List<Casilla> resultado = apuesta.apostarPar(true, 10.0, tablero, usuario);
        assertThat(resultado).allMatch(c -> tablero.esPar(c));
    }
    @Test
    @Order(7)
    void testApostarHuerfanos() {
        List<Casilla> resultado = apuesta.apostarHuerfanos(true, 10.0, tablero, usuario);
        assertThat(resultado).allMatch(c -> tablero.esHuerfano(c));
    }
    @Test
    @Order(8)
    void testToStringFichero() {
        apuesta.apostarNumero(5, 10.0, tablero, usuario);
        String resultado = apuesta.toStringFicheroApuesta();
        assertThat(resultado).contains("5");
    }
    @Nested
    class prueasUsuario {
        @Test
        void registrarse(){
            Usuario usuario = new Usuario("01","Juan","1234");
            boolean resultado = usuario.registrarse(usuario);
            assertTrue(resultado);

        }
        @Test
        void IniciarSesion(){
            Usuario usuario = new Usuario("01","Juan","1234");
            boolean resultado = usuario.inicioSesion("01","1234");
            assertTrue(resultado);

        }
    }

    @Test
    @Order(9)
    void testBorrarDuplicados() {
        apuesta.apostarNumero(5, 10.0, tablero, usuario);
        apuesta.apostarNumero(5, 10.0, tablero, usuario);
        List<Casilla> sinDuplicados = apuesta.borrarDuplicados(apuesta.getCasillasApostadas());
        assertThat(sinDuplicados).hasSizeLessThan(apuesta.getCasillasApostadas().size());
    }
    @Test
    @Order(10)
    void lanzaExcepcion() {
        ARuleta e = assertThrows(ARuleta.class, () -> {
            Comprobaciones.comprobarRuleta(37);
        });
        assertEquals("El número tiene que estar entre 0 y 36", e.getMessage());
    }
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void testApostarDocenasParametrizadas(int docena) {
        List<Casilla> resultado = apuesta.apostarDocena(docena, 5.0, tablero, usuario);
        assertThat(resultado).allMatch(c -> tablero.queDocena(c) == docena);
    }
}

