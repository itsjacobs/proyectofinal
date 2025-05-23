package org.example.service;

import org.example.domain.Casilla;
import org.example.domain.Tablero;
import org.example.domain.Usuario;

import java.util.List;

public interface gestionApuestas {
    public List<Casilla> apostarNumero(int numero, double apuesta, Tablero tab, Usuario usuario);
    public List<Casilla> apostarFila(int fila, double apuesta, Tablero tab, Usuario usuario);
    public List<Casilla> apostarDocena(int docena, double apuesta, Tablero tab, Usuario usuario);
    public List<Casilla> apostarColor(boolean color,double apuesta, Tablero tab, Usuario usuario);
    public List<Casilla> apostarMayor(boolean mayor,double apuesta,Tablero tab, Usuario usuario);
    public List<Casilla> apostarPar(boolean par, double apuesta,Tablero tab, Usuario usuario);
    public List<Casilla> apostarHuerfanos(boolean huerfanos, double apuesta,Tablero tab, Usuario usuario);
    public List<Casilla> borrarDuplicados(List<Casilla> casillasApostadas);
    public void recopilacionApuesta();
    public double cobrarGanancias();
    public boolean iniciarSesion(String id, String contrasena);
    public boolean registrarse(String id, String contrasena, String nombre,double cartera);

    //devuelve la lista de usuarios del dao
    List<Usuario> listaUsuarios();

    public int resultadoTirada();
    public Usuario dameUsuario(String id);
    public List<Usuario> listaUsuario();
}
