package org.example.ui;

import org.example.domain.Tablero;

public class Main {
    public static void main(String[] args) {
        Tablero tab = new Tablero();
        tab.rellenarTablero();
        tab.pintarTablero();
    }
}
