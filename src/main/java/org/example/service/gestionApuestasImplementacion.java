package org.example.service;

import org.example.dao.ApuestaImplementacion;
import org.example.dao.daoApuesta;
import org.example.domain.Casilla;
import org.example.domain.Tablero;

import java.util.List;

public class gestionApuestasImplementacion implements gestionApuestas {
    private daoApuesta daoApuesta;

    public gestionApuestasImplementacion(ApuestaImplementacion daoApuestaImplementacion) {
        this.daoApuesta = daoApuestaImplementacion;
    }

    public gestionApuestasImplementacion() {
        this.daoApuesta = new ApuestaImplementacion();
    }


    //Métodos de Apuestas


    @Override
    public void repetirTirada() {

    }

    @Override
    public List<Casilla> apostarNumero(int numero, double apuesta, Tablero tab) {
        return daoApuesta.apostarNumero(numero, apuesta, tab);
    }

    @Override
    public List<Casilla> apostarFila(int fila, double apuesta, Tablero tab) {
        return daoApuesta.apostarFila(fila, apuesta, tab);
    }

    @Override
    public List<Casilla> apostarDocena(int docena, double apuesta, Tablero tab) {
        return daoApuesta.apostarDocena(docena, apuesta, tab);
    }


    @Override
    public List<Casilla> apostarColor(boolean color,double apuesta, Tablero tab) {
        return daoApuesta.apostarColor(color, apuesta,tab);
    }

    @Override
    public List<Casilla> apostarMayor( boolean mayor,double apuesta, Tablero tab) {
        return daoApuesta.apostarMayor( mayor,apuesta,tab);
    }

    @Override
    public List<Casilla> apostarPar(boolean par, double apuesta, Tablero tab) {
        return daoApuesta.apostarPar(par, apuesta, tab);
    }

    @Override
    public List<Casilla> apostarHuerfanos(boolean huerfanos, double apuesta, Tablero tab) {
        return daoApuesta.apostarHuerfanos(huerfanos, apuesta, tab);
    }

    @Override
    public List<Casilla> borrarDuplicados(List<Casilla> casillasApostadas) {
        return daoApuesta.borrarDuplicados(casillasApostadas);
    }


    @Override
    public void recopilacionApuesta() {

    }


    @Override
    public double cobrarGanancias(){
        return daoApuesta.cobrarGanancias();
    }

    //Métodos de Usuario


    @Override
    public boolean iniciarSesion(String id, String contraseña) {
        return daoApuesta.iniciarSesion(id, contraseña);
    }

    @Override
    public boolean registrarse(String id, String nombre, String contraseña) {
        return daoApuesta.registrarse(id, nombre, contraseña);
    }


    //Métodos de Tirada


    @Override
    public int resultadoTirada() {
        return daoApuesta.resultadoTirada();
    }


}

