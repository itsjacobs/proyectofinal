package org.example.dao;

import lombok.Data;
import org.example.domain.Casilla;
import org.example.domain.Tablero;

import java.util.ArrayList;
import java.util.Scanner;

@Data
public class Apuesta implements daoApuesta {

    private ArrayList<Casilla> casillasApostadas;


    @Override
    public void repetirTirada() {

    }
    @Override
    public void apostarNumero(double cantidad, int numeros,int apuesta) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < cantidad; i++) {
            if (numeros >= 0 && numeros <= 36) {
                Casilla casilla = new Casilla(numeros);
                casillasApostadas.add(casilla);
            } else {
                System.out.println("El numero no es valido");
            }
        }

    }
    @Override
    public void apostarfila(int fila, int apuesta, Tablero tab) {

    }
    @Override
    public void apostarDocena(int docena, int apuesta) {

    }

    @Override
    public void apostarColor(int apuesta) {

    }

    @Override
    public void apostarMayor(int apuesta) {

    }

    @Override
    public void apostarPar(boolean par, int apuesta) {

    }

    @Override
    public void apostarHuerfanos(boolean huerfanos, int apuesta) {

    }

    @Override
    public void cerrarApuestas() {

    }

    @Override
    public void cobrarGananciar() {

    }
}
