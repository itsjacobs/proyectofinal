package org.example.dao;

import org.example.domain.Casilla;
import org.example.domain.Tablero;
import org.example.domain.Tirada;
import org.example.domain.Usuario;

import java.util.ArrayList;
import java.util.List;

public interface daoApuesta {
    public List<Casilla> apostarNumero(int numero, double apuesta, Tablero tab, Usuario usuario);
    public List<Casilla> apostarFila(int fila, double apuesta, Tablero tab, Usuario usuario);
    public List<Casilla> apostarDocena(int docena, double apuesta, Tablero tab, Usuario usuario);
    public List<Casilla> apostarColor(boolean color, double apuesta, Tablero tab, Usuario usuario);
    public List<Casilla> apostarMayor(boolean mayor, double apuesta, Tablero tab, Usuario usuario);
    public List<Casilla> apostarPar(boolean par, double apuesta,Tablero tab, Usuario usuario);
    public List<Casilla> apostarHuerfanos(boolean huerfanos, double apuesta, Tablero tab, Usuario usuario);
    public List<Casilla> borrarDuplicados(List<Casilla> casillasApostadas);
    public List<Usuario> listaUsuarios();
    public Usuario dameUsuario(String id);
    public double cobrarGanancias();
    public boolean iniciarSesion(String nombre, String contrasena);
    public boolean registrarse(String id, String nombre, String contrasena,double cartera);
    public double ingresarDinero(String id, double cantidad);
    public int resultadoTirada();


}
