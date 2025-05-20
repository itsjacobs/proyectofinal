import org.example.domain.Usuario;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.security.Provider;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/*@ExtendWith(MockitoExtension.class)
public class serviceTest {
    @Mock
    private DAO daomock;
    @InjectMocks
    private Provider.Service service;

    @Test
    void registrarUsuario() {
        Usuario usuario = new Usuario("01","Juan","1234");
        when(daomock.registrarUsuario(usuario)).thenReturn(true);
        boolean resultado = service.registrarUsuario(usuario);
        assertTrue(resultado);
        verify(daomock).registrarUsuario(usuario);

    }
}*/
