package org.example.service;

import org.example.dao.Apuesta;
import org.example.dao.daoApuesta;
import org.example.domain.Casilla;
import org.example.domain.Tablero;
import org.example.domain.Usuario;

import java.util.List;

public class gestionApuestasImplementacion implements gestionApuestas {
    private daoApuesta daoApuesta;

    public gestionApuestasImplementacion(Apuesta daoApuesta) {
        this.daoApuesta = daoApuesta;
    }

    public gestionApuestasImplementacion() {
        this.daoApuesta = new Apuesta();
    }

    @Override
    public void repetirTirada() {

    }

    @Override
    public List<Casilla> apostarNumero(int cantidad, int numero, double apuesta, Tablero tab) {
        return daoApuesta.apostarNumero(cantidad, numero, apuesta, tab);
    }

    @Override
    public List<Casilla> apostarFila(int fila, int apuesta, Tablero tab) {
        return daoApuesta.apostarFila(fila, apuesta, tab);
    }

    @Override
    public List<Casilla> apostarDocena(int docena, int apuesta, Tablero tab) {
        return daoApuesta.apostarDocena(docena, apuesta, tab);
    }

    @Override
    public List<Casilla> apostarColor(int apuesta, boolean color, Tablero tab) {
        return daoApuesta.apostarColor(apuesta, color, tab);
    }

    @Override
    public List<Casilla> apostarMayor(int apuesta, Tablero tab, boolean mayor) {
        return daoApuesta.apostarMayor(apuesta, tab, mayor);
    }

    @Override
    public List<Casilla> apostarPar(boolean par, int apuesta, Tablero tab) {
        return daoApuesta.apostarPar(par, apuesta, tab);
    }

    @Override
    public List<Casilla> apostarHuerfanos(boolean huerfanos, int apuesta, Tablero tab) {
        return daoApuesta.apostarHuerfanos(huerfanos, apuesta, tab);
    }

    @Override
    public void recopilacionApuesta() {

    }

    @Override
    public void cobrarGananciar() {

    }

    @Override
    public boolean iniciarSesion(String id, String contraseña) {
        return daoApuesta.iniciarSesion(id, contraseña);
    }

    @Override
    public boolean registrarse(String id, String nombre, String contraseña) {
        return daoApuesta.registrarse(id, nombre, contraseña);
    }
}

