package org.example.ui;

import org.example.domain.Casilla;
import org.example.domain.Tablero;
import org.example.domain.Tirada;

public class Main {
    public static void main(String[] args) {
        Tablero tab = new Tablero();
        Tirada tirada = new Tirada();
        Casilla casilla = new Casilla(tirada.Tirar());
        tab.rellenarTablero();
        tab.pintarTablero();
        tirada.resultadoTirada(casilla);
        System.out.println("es par: "+ tab.esPar(casilla));
        System.out.println("es Mayor: "+ tab.esMayor(casilla));
        System.out.println("que fila: "+ tab.queFila(casilla));
        System.out.println("que Docena: "+ tab.queDocena(casilla));


    }
}
