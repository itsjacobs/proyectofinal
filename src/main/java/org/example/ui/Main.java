package org.example.ui;

import org.example.commons.Constantes;
import org.example.dao.ApuestaImplementacion;
import org.example.dao.Ficheros;
import org.example.domain.Casilla;
import org.example.domain.Tablero;
import org.example.domain.Tirada;
import org.example.domain.Usuario;
import org.example.service.gestionApuestas;
import org.example.service.gestionApuestasImplementacion;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

//
public class Main {
    public static void main(String[] args) {
        gestionApuestasImplementacion ge = new gestionApuestasImplementacion();
        ApuestaImplementacion apuesta = new ApuestaImplementacion();
        EntSalida es = new EntSalida(ge);
        Tablero tab = new Tablero();
        es.menuInicioSesion(tab,apuesta);
    }
}