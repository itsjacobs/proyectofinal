import org.example.domain.Usuario;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ApuestasImplementacionTest {


    @Nested
    class cuandoElUsuarioNoExiste {
        @Test
        void registrarse(){
            Usuario usuario = new Usuario("01","Juan","1234");
            usuario.registrarse(usuario);
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
