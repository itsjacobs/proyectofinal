package org.example.dao;

import org.example.domain.Casilla;
import org.example.domain.Tablero;

public interface daoApuesta {
    public void repetirTirada();
    public void apostarNumero(int cantidad, int numeros,double apuesta);
    public void apostarfila(int fila, int apuesta, Tablero tab);
    public void apostarDocena(int docena, int apuesta, Tablero tab);
    public void apostarColor(int apuesta, boolean color);
    public void apostarMayor(int apuesta,Tablero tab, boolean mayor);
    public void apostarPar(boolean par, int apuesta,Tablero tab);
    public void apostarHuerfanos(boolean huerfanos, int apuesta,Tablero tab);
    public void recopilacionApuesta();
    public void cobrarGananciar();
    public String toStringFicheroG();
}
