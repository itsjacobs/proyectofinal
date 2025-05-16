package org.example.service;

import org.example.domain.Casilla;
import org.example.domain.Tablero;
import org.example.domain.Usuario;

import java.util.List;

public interface gestionApuestas {
    public void repetirTirada();
    public List<Casilla> apostarNumero(int cantidad, int numero, double apuesta, Tablero tab);
    public List<Casilla> apostarFila(int fila, int apuesta, Tablero tab);
    public List<Casilla> apostarDocena(int docena, int apuesta, Tablero tab);
    public List<Casilla> apostarColor(int apuesta, boolean color, Tablero tab);
    public List<Casilla> apostarMayor(int apuesta,Tablero tab, boolean mayor);
    public List<Casilla> apostarPar(boolean par, int apuesta,Tablero tab);
    public List<Casilla> apostarHuerfanos(boolean huerfanos, int apuesta,Tablero tab);
    public void recopilacionApuesta();
    public void cobrarGananciar();
    public boolean iniciarSesion(String id, String contrasena);
    public boolean registrarse(String id, String contrasena, String nombre);
}
