package org.example.dao;

import org.example.domain.Casilla;
import org.example.domain.Tablero;

import java.util.ArrayList;
import java.util.List;

public interface daoApuesta {
    public void repetirTirada();
    public List<Casilla> apostarNumero(int cantidad, int numeros, double apuesta, Tablero tab);
    public List<Casilla> apostarfila(int fila, int apuesta, Tablero tab);
    public List<Casilla> apostarDocena(int docena, int apuesta, Tablero tab);
    public List<Casilla> apostarColor(int apuesta, boolean color, Tablero tab);
    public List<Casilla> apostarMayor(int apuesta,Tablero tab, boolean mayor);
    public List<Casilla> apostarPar(boolean par, int apuesta,Tablero tab);
    public List<Casilla> apostarHuerfanos(boolean huerfanos, int apuesta,Tablero tab);
    public void recopilacionApuesta();
    public void cobrarGananciar();
}
