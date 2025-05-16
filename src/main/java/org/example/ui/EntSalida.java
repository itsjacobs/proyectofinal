package org.example.ui;

import org.example.commons.*;
import org.example.domain.Tablero;
import org.example.service.gestionApuestas;
import org.example.service.gestionApuestasImplementacion;

import java.util.Scanner;

public class EntSalida {
    private gestionApuestas servicio;

    public EntSalida(gestionApuestas servicio) {
        this.servicio = servicio;
    }

    public EntSalida() {
        this.servicio = new gestionApuestasImplementacion();
    }

    public void iniciarSesion() {
        Scanner sc = new Scanner(System.in);
        String id = "";
        String contraseña = "";
        String nombre = "";
        boolean a = false;
        while (!a){
            System.out.println(Constantes.MENU_IS);
            int opc = sc.nextInt();
            switch (opc) {
                case 1:
                    System.out.println("Ingresa el DNI/NIE:");
                    id = sc.next();
                    System.out.println("Ingresa la contraseña:");
                    contraseña = sc.next();
                    if(servicio.iniciarSesion(id, contraseña)){
                        System.out.println("Has iniciado sesión correctamente");
                        a = true;
                    }
                    else{
                        System.out.println("La contraseña o el DNI/NIE son incorrectos");
                    }
                    break;
                case 2:
                    System.out.println("Ingresa el DNI/NIE:");
                    sc.nextLine();
                    id = sc.nextLine();
                    System.out.println("Ingresa tu nombre");
                    nombre = sc.nextLine();
                    System.out.println("Ingresa una contraseña");
                    contraseña = sc.nextLine();
                    if(servicio.registrarse(id, nombre, contraseña)){
                        System.out.println("Te has registrado correctamente");
                    }else{
                        System.out.println("El usuario ya existe");
                    }
                    break;
                default:
                    System.out.println(Constantes.MENSAJE_OPCION_INVALIDA);
            }
        }

    }
    public void repetirTirada(){

    }
    public void apostarNumero(int cantidad, int numero, double apuesta,Tablero tab){
        Scanner sc = new Scanner(System.in);
        boolean a = false;
        System.out.println("Cuanto quieres apostar?");
        apuesta = sc.nextDouble();
        System.out.println("Que numero quieres apostar?");
        numero = sc.nextInt();
        do{
            try{
                Comprobaciones.comprobarRuleta(numero);
            } catch(Ruleta e){
                System.out.println(e.getMessage());
                a = true;
            }
            if (!a){
                numero = sc.nextInt();
            }
        }while(!a);
        servicio.apostarNumero(cantidad, numero, apuesta, tab);
    }
    public void apostarFila(int fila, int apuesta, Tablero tab){
        Scanner sc = new Scanner(System.in);
        boolean a = false;
        System.out.println("Cuanto quieres apostar?");
        apuesta = sc.nextInt();
        System.out.println("Que fila quieres apostar?");
        fila = sc.nextInt();
        do{
            try{
                Comprobaciones.comprobarNumero(fila);
            } catch (Numeros e){
                System.out.println(e.getMessage());
                a = true;
            }
            if(!a){
                fila = sc.nextInt();
            }
        }while (!a);
        servicio.apostarFila(fila, apuesta, tab);
    }
    public void apostarDocena(int docena, int apuesta, Tablero tab){
        Scanner sc = new Scanner(System.in);
        boolean a = false;
        System.out.println("Cuanto quieres apostar?");
        apuesta = sc.nextInt();
        System.out.println("Que docena quieres apostar?");
        docena = sc.nextInt();
        do{
            try{
                Comprobaciones.comprobarNumero(docena);
            } catch (Numeros e){
                System.out.println(e.getMessage());
                a = true;
            }
            if(!a){
                docena = sc.nextInt();
            }
        }while (!a);
        servicio.apostarDocena(docena, apuesta, tab);
    }
    public void apostarColor(int apuesta, boolean color, Tablero tab) {
        Scanner sc = new Scanner(System.in);
        boolean a = true;
        System.out.println("Cuanto quieres apostar?");
        apuesta = sc.nextInt();
        System.out.println("Que color quieres apostar?");
        String colorElegido = sc.nextLine();
        do{
            a = false;
            try{
                Comprobaciones.comprobarColor(colorElegido);
            } catch (Color e){
                System.out.println(e.getMessage());
                a = true;
            }
            if (a){
                if(colorElegido.equalsIgnoreCase("rojo")){
                    color = true;
                }
                else if(colorElegido.equalsIgnoreCase("negro")){
                    color = false;
                }
            }
        } while (a);
        servicio.apostarColor(apuesta, color, tab);
    }
    public void apostarMayor(int apuesta, boolean mayor, Tablero tab){
        Scanner sc = new Scanner(System.in);
        boolean a = false;
        System.out.println("Cuanto quieres apostar?");
        apuesta = sc.nextInt();
        System.out.println("Quieres apostar a mayor o menor?");
        String mayorElegido = sc.nextLine();
        do{
            try{
                Comprobaciones.comprobarMayor(mayorElegido);
            } catch (Mayor e){
                System.out.println(e.getMessage());
                a = true;
            }
            if (!a){
                if(mayorElegido.equalsIgnoreCase("mayor")){
                    mayor = true;
                }
                else if(mayorElegido.equalsIgnoreCase("menor")){
                    mayor = false;
                }
            }
        } while (!a);
        servicio.apostarMayor(apuesta, tab, mayor);
    }
    public void apostarPar(boolean par,int apuesta, Tablero tab){
        Scanner sc = new Scanner(System.in);
        boolean a = false;
        System.out.println("Cuanto quieres apostar?");
        apuesta = sc.nextInt();
        System.out.println("Quieres apostar a par o impar?");
        String parElegido = sc.nextLine();
        do{
            try{
                Comprobaciones.comprobarPar(parElegido);
            } catch (Par e){
                System.out.println(e.getMessage());
                a = true;
            }
            if (!a){
                if(parElegido.equalsIgnoreCase("par")){
                    par = true;
                }
                else if(parElegido.equalsIgnoreCase("impar")){
                   par = false;
                }
            }
        } while (!a);
        servicio.apostarPar(par, apuesta, tab);
    }
}
