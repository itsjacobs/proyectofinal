package org.example.ui;

import org.example.commons.Constantes;
import org.example.dao.Apuesta;
import org.example.dao.Ficheros;
import org.example.domain.Casilla;
import org.example.domain.Tablero;
import org.example.domain.Tirada;
import org.example.domain.Usuario;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Tablero tab = new Tablero();
        Tirada tirada = new Tirada();
        Casilla casilla = new Casilla(tirada.Tirar());
        tab.rellenarTablero();
        tab.pintarTablero();
        Ficheros ficheros = new Ficheros();
        List<Usuario> listaUsuarios = new java.util.ArrayList<>();
        Usuario usuario = new Usuario();
        usuario.Registrarse("12345678A", "Ethan", "1234");
        Usuario usuario2 = new Usuario();
        usuario2.Registrarse("12345678B", "Ethan", "1234");
        listaUsuarios.add(usuario2);
        listaUsuarios.add(usuario);
        ficheros.escribirFicheroUsuario(Constantes.USUARIO_FILE, listaUsuarios);
        ArrayList<Apuesta> apuestas = new java.util.ArrayList<>();
        Apuesta apuesta = new Apuesta();
        Apuesta apuesta2 = new Apuesta();
        Apuesta apuesta3 = new Apuesta();
        apuesta.apostarMayor(50, tab, true);
        apuesta2.apostarfila(3, 50, tab);
        apuesta3.apostarNumero(1,19, 2, tab);
        apuestas.add(apuesta);
        apuestas.add(apuesta2);
        apuestas.add(apuesta3);
        ficheros.escribirFicheroApuestas(Constantes.APUESTA_FILE, apuestas);
        tirada.resultadoTirada(casilla);
        System.out.println("el color de la casilla es: "+ casilla.isColor());
        System.out.println("es huerfano: "+ tab.esHuerfano(casilla));
        System.out.println("es par: "+ tab.esPar(casilla));
        System.out.println("es Mayor: "+ tab.esMayor(casilla));
        System.out.println("que fila: "+ tab.queFila(casilla));
        System.out.println("que Docena: "+ tab.queDocena(casilla));
    }
}
