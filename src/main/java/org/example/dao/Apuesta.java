package org.example.dao;

import lombok.Data;
import org.example.domain.Casilla;
import org.example.domain.Tablero;

import java.util.ArrayList;
import java.util.Scanner;

@Data
public class Apuesta implements daoApuesta {
    private ArrayList<Casilla> casillasApostadas;
    private double ganancia;


    @Override
    public void repetirTirada() {

    }
    @Override
    public void apostarNumero(int cantidad, int numeros,double apuesta) {
        for (int i = 0; i < cantidad; i++) {
            Casilla casilla = new Casilla(numeros);
            casillasApostadas.add(casilla);
        }
        ganancia = apuesta * 36;
    }
    @Override
    public void apostarfila(int fila, int apuesta, Tablero tab) {
        for (int i = 1; i<=36;i++){
            if (tab.queFila(new Casilla(i))==fila){
                Casilla casilla = new Casilla(i);
                casillasApostadas.add(casilla);
            }
        }
        ganancia = apuesta * 3;
    }
    @Override
    public void apostarDocena(int docena, int apuesta, Tablero tab) {
        for (int i = 1; i<=36;i++){
            if (tab.queDocena(new Casilla(i))==docena){
                Casilla casilla = new Casilla(i);
                casillasApostadas.add(casilla);
            }
        }
        ganancia = apuesta * 3;
    }

    @Override
    public void apostarColor(int apuesta, boolean color) {
        for (int i = 1; i<=36;i++){
            Casilla casilla = new Casilla(i);
            if (casilla.isColor()==color){
                casillasApostadas.add(casilla);
            }
        }
        ganancia = apuesta * 2;
    }

    @Override
    public void apostarMayor(int apuesta,Tablero tab, boolean mayor) {
        for (int i = 1; i<=36;i++){
            if (tab.esMayor(new Casilla(i))==mayor){
                Casilla casilla = new Casilla(i);
                casillasApostadas.add(casilla);
            }
        }
        ganancia = apuesta * 2;
    }

    @Override
    public void apostarPar(boolean par, int apuesta,Tablero tab) {
        for (int i = 1; i<=36;i++){
            if (tab.esPar(new Casilla(i))==par){
                Casilla casilla = new Casilla(i);
                casillasApostadas.add(casilla);
            }
        }
        ganancia = apuesta * 2;

    }

    @Override
    public void apostarHuerfanos(boolean huerfanos, int apuesta,Tablero tab) {
        for (int i = 1; i<=36;i++){
            if (tab.esHuerfano(new Casilla(i))==huerfanos){
                Casilla casilla = new Casilla(i);
                casillasApostadas.add(casilla);
            }
        }
        ganancia = apuesta * 10;
    }

    @Override
    public void recopilacionApuesta() {

    }

    @Override
    public void cobrarGananciar() {
    }
    public String toStringFicheroG(){
        StringBuilder sb = new StringBuilder();
        sb.append(casillasApostadas).append("-");
        return sb.toString();
    }
}
