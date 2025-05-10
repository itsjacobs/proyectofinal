package org.example.dao;

import org.example.domain.Casilla;
import org.example.domain.Tirada;

public interface daoRuleta {
    public void repetirTirada();
    public void apostarNumero(Casilla casilla);
    public void apostarfila(int fila);
    public void apostarDocena(int docena);
    public void apostarColor();
    public void apostarMayor();
    public void apostarPar(boolean par);
    public void apostarHuerfanos(boolean huerfanos);
    public void cerrarApuestas();
    public void cobrarGananciar();
}
