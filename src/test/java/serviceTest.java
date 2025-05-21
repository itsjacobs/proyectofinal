import org.example.dao.daoApuesta;
import org.example.domain.Usuario;
import org.example.service.gestionApuestasImplementacion;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class serviceTest {
    @InjectMocks
    private gestionApuestasImplementacion service;
    @Mock
    private daoApuesta daomock;


    @Test
    void registrarUsuario() {
        when(daomock.registrarse("01", "Alberto", "1234")).thenReturn(true);

        boolean resultado = service.registrarse("01", "Alberto", "1234");

        assertTrue(resultado);
        verify(daomock).registrarse("01", "Alberto", "1234");
    }
}
