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
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        boolean menu1 = false;
        boolean menu2 = false;
        Scanner sc = new Scanner(System.in);
        gestionApuestasImplementacion ge = new gestionApuestasImplementacion();
        List<ApuestaImplementacion> apuestaImplementacions = new ArrayList<ApuestaImplementacion>();
        EntSalida es = new EntSalida(ge);
        Tablero tab = new Tablero();
        Tirada tirada = new Tirada();
        ArrayList<Tirada> listaTiradas = new ArrayList<>();

        es.iniciarSesion();
        do{
            System.out.println(Constantes.MENU_USUARIO);
            int opc = sc.nextInt();
            switch(opc){
                case 1:
                    do{
                        System.out.println(Constantes.MENU_APUESTAS);
                        int opc2 = sc.nextInt();
                        switch(opc2){
                            case 1:
                                ApuestaImplementacion apuesta = new ApuestaImplementacion();
                                es.apostarNumero(tab);
                                apuestaImplementacions.add(apuesta);
                                break;
                            case 2:
                                es.apostarColor(tab);
                                break;
                            case 3:
                                es.apostarPar(tab);
                                break;
                            case 4:
                                es.apostarMayor(tab);
                                break;
                            case 5:
                                es.apostarFila(tab);
                                break;
                            case 6:
                                es.apostarDocena(tab);
                                break;
                            case 7:
                                es.apostarHuerfano(tab);
                                break;
                            case 8:
                                es.resultadoTirada();
                                listaTiradas.add(tirada);
                                Ficheros.escribirFicheroTirada(Constantes.TIRADA_FILE, listaTiradas);
                                Ficheros.escribirFicheroApuestas(Constantes.APUESTA_FILE, apuestaImplementacions);
                                break;
                            case 9:
                                break;
                            case 10:
                                System.out.println("¿Quieres salir del programa? (si/no)");
                                String salir = sc.next();
                                if(salir.equalsIgnoreCase("si")){
                                    menu2 = true;
                                    menu1 = true;
                                }
                                else if(salir.equalsIgnoreCase("no")){
                                    menu2 = false;
                                }
                                else{
                                    System.out.println("Opcion no valida");
                                }
                                break;
                        }
                    }while(!menu2);

            }
        }while(!menu1);






























        /*Ficheros ficheros = new Ficheros();
        List<Usuario> listaUsuarios = new ArrayList<>();
        ficheros.escribirFicheroUsuario(Constantes.USUARIO_FILE, listaUsuarios);
        gestionApuestas ga = new gestionApuestasImplementacion();
        EntSalida es = new EntSalida(ga);
        es.iniciarSesion();
        Tablero tab = new Tablero();
        Tirada tirada = new Tirada();
        Casilla casilla = new Casilla(tirada.tirar());
        tab.rellenarTablero();
        tab.pintarTablero();
        ArrayList<ApuestaImplementacion> apuestaImplementacions = new ArrayList<ApuestaImplementacion>();
        ArrayList<Tirada> listaTiradas = new ArrayList<>();
        listaTiradas.add(tirada);
        ApuestaImplementacion one = new ApuestaImplementacion();
        ApuestaImplementacion two = new ApuestaImplementacion();
        ApuestaImplementacion three = new ApuestaImplementacion();
        one.apostarNumero(1, 1, 50, tab);
        two.apostarMayor(50, tab, true);
        three.apostarFila(3, 50, tab);
        apuestaImplementacions.add(one);
        apuestaImplementacions.add(two);
        apuestaImplementacions.add(three);
        //apuesta.borrarDuplicados(apuesta.getCasillasApostadas());
        ficheros.escribirFicheroApuestas(Constantes.APUESTA_FILE, apuestaImplementacions);
        ficheros.escribirFicheroTirada(Constantes.TIRADA_FILE, listaTiradas);
        tirada.resultadoTirada(casilla);
        System.out.println("el color de la casilla es: "+ casilla.isColor());
        System.out.println("es huerfano: "+ tab.esHuerfano(casilla));
        System.out.println("es par: "+ tab.esPar(casilla));
        System.out.println("es Mayor: "+ tab.esMayor(casilla));
        System.out.println("que fila: "+ tab.queFila(casilla));
        System.out.println("que Docena: "+ tab.queDocena(casilla));*/
    }
}
