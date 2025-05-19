package org.example.dao;

import org.example.domain.Casilla;
import org.example.domain.Tablero;
import org.example.domain.Usuario;

import java.util.List;

public interface daoApuesta {
    public void repetirTirada();
    public List<Casilla> apostarNumero(int numero, double apuesta, Tablero tab);
    public List<Casilla> apostarFila(int fila, double apuesta, Tablero tab);
    public List<Casilla> apostarDocena(int docena, double apuesta, Tablero tab);
    public List<Casilla> apostarColor(boolean color, double apuesta, Tablero tab);
    public List<Casilla> apostarMayor(boolean mayor, double apuesta, Tablero tab);
    public List<Casilla> apostarPar(boolean par, double apuesta,Tablero tab);
    public List<Casilla> apostarHuerfanos(boolean huerfanos, double apuesta, Tablero tab);
    public List<Casilla> borrarDuplicados(List<Casilla> casillasApostadas);
    public double cobrarGanancias();
    public boolean iniciarSesion(String nombre, String contrasena);
    public boolean registrarse(String id, String nombre, String contrasena);
    public int resultadoTirada();

}
