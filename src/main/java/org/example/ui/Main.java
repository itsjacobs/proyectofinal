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
        ApuestaImplementacion apuesta = new ApuestaImplementacion();
        List<ApuestaImplementacion> apuestaImplementacion = new ArrayList<>();
        List<Casilla> casillasApostadas = new ArrayList<>();
        EntSalida es = new EntSalida(ge);
        Tablero tab = new Tablero();
        tab.rellenarTablero();
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
                                apuesta.setCasillasApostadas(es.apostarNumero(tab));
                                break;
                            case 2:
                                apuesta.setCasillasApostadas(es.apostarColor(tab));
                                break;
                            case 3:
                                apuesta.setCasillasApostadas(es.apostarPar(tab));
                                break;
                            case 4:
                                apuesta.setCasillasApostadas(es.apostarMayor(tab));
                                break;
                            case 5:
                                apuesta.setCasillasApostadas(es.apostarFila(tab));
                                break;
                            case 6:
                                apuesta.setCasillasApostadas(es.apostarDocena(tab));
                                break;
                            case 7:
                                apuesta.setCasillasApostadas(es.apostarHuerfano(tab));
                                break;
                            case 8:
                                int resultado = es.resultadoTirada();
                                Tirada tirada = new Tirada(resultado);
                                Casilla casilla = new Casilla(resultado);
                                listaTiradas.add(tirada);
                                System.out.println("La casilla ganadora es: " + resultado);
                                Ficheros.escribirFicheroTirada(Constantes.TIRADA_FILE, listaTiradas);
                                apuestaImplementacion.add(apuesta);
                                System.out.println(casillasApostadas);
                                Ficheros.escribirFicheroApuestas(Constantes.APUESTA_FILE, apuestaImplementacion);
                                apuesta.repetirTirada();
                                break;
                            case 9:
                                es.cobrarGanancias();
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

    }
}
