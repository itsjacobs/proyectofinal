package org.example.ui;

import org.example.commons.Constantes;
import org.example.dao.Apuesta;
import org.example.dao.Ficheros;
import org.example.domain.Casilla;
import org.example.domain.Tablero;
import org.example.domain.Tirada;
import org.example.domain.Usuario;
import org.example.service.gestionApuestas;
import org.example.service.gestionApuestasImplementacion;

import java.util.ArrayList;
import java.util.List;

//List<Casilla> casillasApostadas2 = casillasApostadas.stream().map(casilla :: getNumero).distinct().toList();

public class Main {
    public static void main(String[] args) {
        Ficheros ficheros = new Ficheros();
        List<Usuario> listaUsuarios = new ArrayList<>();
        Usuario usuario = new Usuario("12345678A", "Ethan", "1234");
        Usuario usuario2 = new Usuario("12345678B", "Ethan", "1234");
        listaUsuarios.add(usuario2);
        listaUsuarios.add(usuario);
        ficheros.escribirFicheroUsuario(Constantes.USUARIO_FILE, listaUsuarios);
        gestionApuestas ga = new gestionApuestasImplementacion();
        EntSalida es = new EntSalida(ga);
        es.iniciarSesion();
        Tablero tab = new Tablero();
        Tirada tirada = new Tirada();
        Casilla casilla = new Casilla(tirada.tirar());
        tab.rellenarTablero();
        tab.pintarTablero();
        ArrayList<Apuesta> apuestas = new ArrayList<Apuesta>();
        ArrayList<Tirada> listaTiradas = new ArrayList<>();
        listaTiradas.add(tirada);
        Apuesta apuesta = new Apuesta();
        Apuesta apuesta2 = new Apuesta();
        Apuesta apuesta3 = new Apuesta();
        apuesta.apostarMayor(50, tab, true);
        apuesta2.apostarFila(3, 50, tab);
        apuesta3.apostarNumero(1,19, 2, tab);
        apuestas.add(apuesta);
        apuestas.add(apuesta2);
        apuestas.add(apuesta3);
        ficheros.escribirFicheroApuestas(Constantes.APUESTA_FILE, apuestas);
        ficheros.escribirFicheroTirada(Constantes.TIRADA_FILE, listaTiradas);
        tirada.resultadoTirada(casilla);
        System.out.println("el color de la casilla es: "+ casilla.isColor());
        System.out.println("es huerfano: "+ tab.esHuerfano(casilla));
        System.out.println("es par: "+ tab.esPar(casilla));
        System.out.println("es Mayor: "+ tab.esMayor(casilla));
        System.out.println("que fila: "+ tab.queFila(casilla));
        System.out.println("que Docena: "+ tab.queDocena(casilla));
    }
}
