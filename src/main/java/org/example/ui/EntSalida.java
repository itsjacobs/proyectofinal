package org.example.ui;

import org.example.commons.*;
import org.example.dao.ApuestaImplementacion;
import org.example.dao.Ficheros;
import org.example.domain.Casilla;
import org.example.domain.Tablero;
import org.example.domain.Usuario;
import org.example.service.gestionApuestas;
import org.example.service.gestionApuestasImplementacion;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import lombok.Data;

@Data
public class EntSalida {
    private gestionApuestas servicio;


    public EntSalida(gestionApuestas servicio) {
        this.servicio = servicio;
    }

    public EntSalida() {
        this.servicio = new gestionApuestasImplementacion();
    }


    //Métodos de Usuario


    public void iniciarSesion() {
        Scanner sc = new Scanner(System.in);
        String id = "";
        String contraseña = "";
        String nombre = "";
        Ficheros ficheros = new Ficheros();
        List<Usuario> listaUsuarios = new ArrayList<>();
        boolean a = false;
        boolean b = false;
        while (!a) {
            int opc = 0;
            do {
                try{
                    System.out.println(Constantes.MENU_IS);
                    opc = sc.nextInt();
                    b = true;
                } catch(InputMismatchException e){
                    System.out.println("Caracter incorrecto");
                    sc.nextLine();
                }
            } while(!b);

            switch (opc) {
                case 1:
                    System.out.println("Ingresa el DNI/NIE:");
                    id = sc.next();
                    System.out.println("Ingresa la contraseña:");
                    contraseña = sc.next();
                    if (servicio.iniciarSesion(id, contraseña)) {
                        System.out.println("Has iniciado sesión correctamente");
                        a = true;
                    } else {
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
                    if (servicio.registrarse(id, nombre, contraseña)) {
                        System.out.println("Te has registrado correctamente");
                        Ficheros.escribirFicheroUsuario(Constantes.USUARIO_FILE, listaUsuarios);
                    } else {
                        System.out.println("El usuario ya existe");
                    }
                    break;
                default:
                    System.out.println(Constantes.MENSAJE_OPCION_INVALIDA);
            }
        }

    }


    //Métodos de Apuestas


    public void repetirTirada() {

    }

    public List<Casilla> apostarNumero(Tablero tab) {
        Scanner sc = new Scanner(System.in);
        System.out.println("¿Cuánto quieres apostar?");
        double apuesta = sc.nextDouble();
        sc.nextLine();
        int numero = 0;
        boolean a = false;
        do {
            System.out.println("¿Qué número quieres apostar?");
            numero = sc.nextInt();
            try {
                Comprobaciones.comprobarRuleta(numero);
                a = true;
            } catch (Ruleta e) {
                System.out.println(e.getMessage());            }
        } while (!a);


        return servicio.apostarNumero(numero, apuesta, tab);
    }


    public List<Casilla> apostarFila(Tablero tab) {
        Scanner sc = new Scanner(System.in);
        boolean a = false;
        System.out.println("Cuanto quieres apostar?");
        Double apuesta = sc.nextDouble();
        sc.nextLine();
        int fila = 0;
        do {
            System.out.println("Que fila quieres apostar?");
            fila = sc.nextInt();
            try {
                Comprobaciones.comprobarNumero(fila);
                a = true;
            } catch (Numeros e) {
                System.out.println(e.getMessage());
            }
        } while (!a);
       return servicio.apostarFila(fila, apuesta, tab);
    }

    public List<Casilla> apostarDocena(Tablero tab) {
        Scanner sc = new Scanner(System.in);
        boolean a = false;
        int docena = 0;
        System.out.println("Cuanto quieres apostar?");
        int apuesta = sc.nextInt();
        sc.nextLine();
        do {
            System.out.println("Que docena quieres apostar?");
            docena = sc.nextInt();
            try {
                Comprobaciones.comprobarNumero(docena);
                a = true;
            } catch (Numeros e) {
                System.out.println(e.getMessage());
            }
        } while (!a);
        return servicio.apostarDocena(docena, apuesta, tab);

    }

    public List<Casilla> apostarColor(Tablero tab) {
        Scanner sc = new Scanner(System.in);
        boolean a = false;
        boolean color = false;
        String colorElegido = "";
        System.out.println("Cuanto quieres apostar?");
        int apuesta = sc.nextInt();
        sc.nextLine();
        do {
            System.out.println("Que color quieres apostar?");
            colorElegido = sc.nextLine();
            try {
                Comprobaciones.comprobarColor(colorElegido);
                a = true;
            } catch (Color e) {
                System.out.println(e.getMessage());
            }

        } while (!a);

        if (colorElegido.equalsIgnoreCase("rojo")) {
            color = true;
        } else if (colorElegido.equalsIgnoreCase("negro")) {
            color = false;
        }

        return servicio.apostarColor(color, apuesta, tab);

    }

    public List<Casilla> apostarMayor(Tablero tab) {
        Scanner sc = new Scanner(System.in);
        boolean a = false;
        boolean mayor = false;
        String mayorElegido = "";
        System.out.println("Cuanto quieres apostar?");
        Double apuesta = sc.nextDouble();
        sc.nextLine();
        do {
            System.out.println("Quieres apostar a mayor o menor?");
            mayorElegido = sc.nextLine();
            try {
                Comprobaciones.comprobarMayor(mayorElegido);
                a = true;
            } catch (Mayor e) {
                System.out.println(e.getMessage());
            }
        } while (!a);

            if (mayorElegido.equalsIgnoreCase("mayor")) {
                mayor = true;
            } else if (mayorElegido.equalsIgnoreCase("menor")) {
                mayor = false;
            }

        return servicio.apostarMayor(mayor, apuesta, tab);

    }

    public List<Casilla> apostarPar(Tablero tab) {
        Scanner sc = new Scanner(System.in);
        boolean a = false;
        boolean par = false;
        String parElegido = "";
        System.out.println("Cuánto quieres apostar?");
        double apuesta = sc.nextDouble();
        sc.nextLine();
        do {
            System.out.println("¿Quieres apostar a par o impar?");
            parElegido = sc.nextLine();
            try {
                Comprobaciones.comprobarPar(parElegido);
                a = true;
            } catch (Par e) {
                System.out.println(e.getMessage());
            }
        } while (!a);

        if (parElegido.equalsIgnoreCase("par")) {
            par = true;
        } else if (parElegido.equalsIgnoreCase("impar")) {
            par = false;
        }
        return servicio.apostarPar(par, apuesta, tab);

    }

    public List<Casilla> apostarHuerfano(Tablero tab) {
        Scanner sc = new Scanner(System.in);
        boolean a = false;
        System.out.println("Cuanto quieres apostar?");
        double apuesta = sc.nextDouble();
        return servicio.apostarHuerfanos(true, apuesta, tab);
    }

    public void cobrarGanancias() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Cuanto quieres cobrar?");
        double cantidad = sc.nextDouble();
        sc.nextLine();
        servicio.cobrarGanancias();
    }

    //Métodos de tirada


    public int resultadoTirada() {
        return servicio.resultadoTirada();
    }
}
