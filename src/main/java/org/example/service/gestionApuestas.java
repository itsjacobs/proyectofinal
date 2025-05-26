package org.example.service;

import org.example.domain.ApuestasUsuario;
import org.example.domain.Casilla;
import org.example.domain.Tablero;
import org.example.domain.Usuario;
import java.util.List;

public interface gestionApuestas {
    List<Casilla> apostarNumero(int numero, double apuesta, Tablero tab, Usuario usuario);
    List<Casilla> apostarFila(int fila, double apuesta, Tablero tab, Usuario usuario);
    List<Casilla> apostarDocena(int docena, double apuesta, Tablero tab, Usuario usuario);
    List<Casilla> apostarColor(boolean color,double apuesta, Tablero tab, Usuario usuario);
    List<Casilla> apostarMayor(boolean mayor,double apuesta,Tablero tab, Usuario usuario);
    List<Casilla> apostarPar(boolean par, double apuesta,Tablero tab, Usuario usuario);
    List<Casilla> apostarHuerfanos(boolean huerfanos, double apuesta,Tablero tab, Usuario usuario);
    void terminarApuestas(Usuario usuarioLogado, Tablero tab);
    String getApuesta();
    List<Casilla> borrarDuplicados(List<Casilla> casillasApostadas);
    List<Usuario> listaUsuarios();
    void mostrarUsuariosDesdeFicheroBinario();
    boolean iniciarSesion(String id, String contrasena);
    boolean registrarse(String id, String contrasena, String nombre,double cartera);
    double ingresarDinero(String id, double cantidad);
    int resultadoTirada();
    Usuario dameUsuario(String id);

    List<ApuestasUsuario> ordenarApuestas();
}
