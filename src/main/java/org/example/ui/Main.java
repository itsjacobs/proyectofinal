package org.example.ui;

import org.example.domain.Tablero;
import org.example.service.gestionApuestasImplementacion;

public class Main {
    public static void main(String[] args) {
        gestionApuestasImplementacion ge = new gestionApuestasImplementacion();
        EntSalida es = new EntSalida(ge);
        Tablero tab = new Tablero();
        es.menuInicioSesion(tab);
    }
}