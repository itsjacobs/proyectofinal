import org.example.dao.ApuestaImplementacion;
import org.example.domain.Casilla;
import org.example.domain.Usuario;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class ApuestasImplementacionTest {
    @Test
    void borrarDuplicados() {
        List<Casilla> lista = new ArrayList<>();
        ApuestaImplementacion apuesta = new ApuestaImplementacion();
        Casilla casilla1 = new Casilla(true, 1, 1);
        Casilla casilla2 = new Casilla(false, 2, 10);
        Casilla casilla3 = new Casilla(true, 3, 100);
        Casilla casilla4 = new Casilla(true, 1, 1);
        lista.add(casilla1);
        lista.add(casilla2);
        lista.add(casilla3);
        lista.add(casilla4);
        List<Casilla> resultado = apuesta.borrarDuplicados(lista);

        assertEquals(3, resultado.size());
        assertTrue(resultado.contains(casilla1));
        assertFalse(resultado.contains(casilla4));


    }

    @Nested
    class cuandoElUsuarioNoExiste {
        @Test
        void registrarse(){
            Usuario usuario = new Usuario("01","Juan","1234");
            usuario.registrarse(usuario);
            boolean resultado = usuario.registrarse(usuario);


            assertTrue(resultado);
            assertEquals("01",usuario.getId());
            assertEquals("Juan",usuario.getNombre());
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
