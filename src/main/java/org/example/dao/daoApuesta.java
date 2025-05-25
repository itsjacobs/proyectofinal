package org.example.dao;

import org.example.domain.*;
import java.util.List;

public interface daoApuesta {
    List<Casilla> apostarNumero(int numero, double apuesta, Tablero tab, Usuario usuario);
    List<Casilla> apostarFila(int fila, double apuesta, Tablero tab, Usuario usuario);
    List<Casilla> apostarDocena(int docena, double apuesta, Tablero tab, Usuario usuario);
    List<Casilla> apostarColor(boolean color, double apuesta, Tablero tab, Usuario usuario);
    List<Casilla> apostarMayor(boolean mayor, double apuesta, Tablero tab, Usuario usuario);
    List<Casilla> apostarPar(boolean par, double apuesta,Tablero tab, Usuario usuario);
    List<Casilla> apostarHuerfanos(boolean huerfanos, double apuesta, Tablero tab, Usuario usuario);
    List<Casilla> borrarDuplicados(List<Casilla> casillasApostadas);
    List<Usuario> listaUsuarios();
    String getApuesta();
    double cobrarGanancias();
    boolean iniciarSesion(String nombre, String contrasena);
    boolean registrarse(String id, String nombre, String contrasena,double cartera);
    double ingresarDinero(String id, double cantidad);
    void terminarApuestas(Usuario usuarioLogado, Tablero tab);
    int resultadoTirada();
    Usuario dameUsuario(String id);
    List<ApuestasUsuario> ordenarApuestas();
}
