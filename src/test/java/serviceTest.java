import org.example.dao.daoApuesta;
import org.example.domain.Casilla;
import org.example.domain.Tablero;
import org.example.service.gestionApuestasImplementacion;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@ExtendWith(MockitoExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class serviceTest {

    @InjectMocks
    private gestionApuestasImplementacion gestion;

    @Mock
    private daoApuesta daoApuesta;

    @Test
    @Order(1)
    void testIniciarSesion() {
        when(daoApuesta.iniciarSesion("Manolo", "1234")).thenReturn(true);
        boolean result = gestion.iniciarSesion("Manolo", "1234");
        assertTrue(result);
    }
    @Test
    @Order(2)
    void testApostarNumero() {
        Tablero tab = new Tablero();
        List<Casilla> casillas = List.of(new Casilla(true, 1, 2));
        when(daoApuesta.apostarNumero(anyInt(), anyDouble(), tab)).thenReturn(casillas);
        List<Casilla> resultado = gestion.apostarNumero(5, 100.0, tab);
        assertNotNull(resultado);
        assertEquals(1, resultado.size());
    }
    @Test
    @Order(3)
    void testApostarFila() {
        Tablero tab = new Tablero();
        List<Casilla> casillas = List.of(new Casilla(false, 19, 2));
        when(daoApuesta.apostarFila(anyInt(), anyDouble(), tab)).thenReturn(casillas);
        List<Casilla> resultado = gestion.apostarFila(1, 50.0, tab);
        assertNotNull(resultado);
        assertEquals(1, resultado.size());
    }
    @Test
    @Order(4)
    void testCobrarGanancias() {
        when(daoApuesta.cobrarGanancias()).thenReturn(100.0);
        double ganancias = gestion.cobrarGanancias();
        assertEquals(100.0, ganancias);
    }
    @Test
    @Order(5)
    void testApostarColor() {
        Tablero tab = new Tablero();
        List<Casilla> casillas = List.of(new Casilla(true, 1, 2));
        when(daoApuesta.apostarColor(anyBoolean(), anyDouble(), tab)).thenReturn(casillas);
        List<Casilla> resultado = gestion.apostarColor(true, 50.0, tab);
        assertThat(resultado.size(), is(1));
    }
    @Test
    @Order(6)
    void testApostarPar() {
        Tablero tab = new Tablero();
        List<Casilla> casillas = List.of(new Casilla(true, 2, 2));
        when(daoApuesta.apostarPar(anyBoolean(), anyDouble(), tab)).thenReturn(casillas);
        List<Casilla> resultado = gestion.apostarPar(true, 30.0, tab);
        assertThat(resultado, hasSize(greaterThan(0)));
    }
    @Test
    @Order(7)
    void testApostarHuerfanos() {
        Tablero tab = new Tablero();
        List<Casilla> casillas = List.of(new Casilla(true, 3, 2));
        when(daoApuesta.apostarHuerfanos(anyBoolean(), anyDouble(), tab)).thenReturn(casillas);

        List<Casilla> resultado = gestion.apostarHuerfanos(true, 50.0, tab);
        assertNotNull(resultado);
        assertTrue(!resultado.isEmpty());
    }
    @Test
    @Order(8)
    void testParametrizadoApostarNumero() {
        double[] apuestas = {10.0, 20.0, 50.0};
        for (double apuesta : apuestas) {
            Tablero tab = new Tablero();
            List<Casilla> resultado = gestion.apostarNumero(5, apuesta, tab);
            assertNotNull(resultado);
        }
    }
    @Test
    @Order(9)
    void testRegistrarUsuario() {
        when(daoApuesta.registrarse("id123", "Juan", "pass123")).thenReturn(true);
        boolean result = gestion.registrarse("id123", "Juan", "pass123");
        assertTrue(result);
    }
    @Test
    @Order(10)
    void testResultadoTirada() {
        when(daoApuesta.resultadoTirada()).thenReturn(25);
        int resultado = gestion.resultadoTirada();
        assertEquals(25, resultado);
    }
}

