package org.example.dao;

import org.example.domain.Casilla;
import org.example.domain.Tablero;

import java.util.ArrayList;

public interface daoApuesta {
    public void repetirTirada();
    public ArrayList<Casilla> apostarNumero(int cantidad, int numeros,double apuesta, Tablero tab);
    public ArrayList<Casilla> apostarfila(int fila, int apuesta, Tablero tab);
    public ArrayList<Casilla> apostarDocena(int docena, int apuesta, Tablero tab);
    public ArrayList<Casilla> apostarColor(int apuesta, boolean color, Tablero tab);
    public ArrayList<Casilla> apostarMayor(int apuesta,Tablero tab, boolean mayor);
    public ArrayList<Casilla> apostarPar(boolean par, int apuesta,Tablero tab);
    public ArrayList<Casilla> apostarHuerfanos(boolean huerfanos, int apuesta,Tablero tab);
    public void recopilacionApuesta();
    public void cobrarGananciar();
}
