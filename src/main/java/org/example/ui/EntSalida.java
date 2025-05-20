package org.example.ui;

import lombok.extern.log4j.Log4j2;
import org.example.commons.*;
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
                try {
                    System.out.println(Constantes.MENU_IS);
                    opc = sc.nextInt();
                    b = true;
                } catch (InputMismatchException e) {
                    System.out.println("Caracter incorrecto");
                    sc.nextLine();
                }
            } while (!b);

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
        double apuesta = 0;
        int numero = 0;
        boolean a = false;
        boolean b = false;
        while (!b){
            try {
                System.out.println("¿Cuánto quieres apostar?");
                apuesta = sc.nextInt();
                b = true;
            } catch (InputMismatchException e) {
                System.out.println("Lo introducido no es un número");
                sc.nextLine();
            }
        }
        do {
            System.out.println("¿Qué número quieres apostar?");
            numero = sc.nextInt();
            try {
                Comprobaciones.comprobarRuleta(numero);
                a = true;
            } catch (ARuleta e) {
                System.out.println(e.getMessage());
            }
        } while (!a);
        return servicio.apostarNumero(numero, apuesta, tab);
    }


    public List<Casilla> apostarFila(Tablero tab) {
        Scanner sc = new Scanner(System.in);
        boolean a = false;
        boolean b = false;
        double apuesta = 0;
        int fila = 0;
        while (!b){
            try {
                System.out.println("¿Cuánto quieres apostar?");
                apuesta = sc.nextInt();
                b = true;
            } catch (InputMismatchException e) {
                System.out.println(Constantes.BG_RED +Constantes.WHITE_BRIGHT+"Lo introducido no es un número");
                sc.nextLine();
            }
        }
        sc.nextLine();
        do {
            System.out.println("Que fila quieres apostar?");
            fila = sc.nextInt();

            try {
                Comprobaciones.comprobarNumero(fila);
                a = true;
            } catch (ANumeros e) {
                System.out.println(e.getMessage());
            }
        } while (!a);
        return servicio.apostarFila(fila, apuesta, tab);
    }

    public List<Casilla> apostarDocena(Tablero tab) {
        Scanner sc = new Scanner(System.in);
        boolean a = false;
        boolean b = false;
        int docena = 0;
        double apuesta = 0;
        while (!b){
            try {
                System.out.println("¿Cuánto quieres apostar?");
                apuesta = sc.nextInt();
                b = true;
            } catch (InputMismatchException e) {
                System.out.println(Constantes.BG_RED +Constantes.WHITE_BRIGHT+"Lo introducido no es un número");
                sc.nextLine();
            }
        }
        sc.nextLine();
        do {
            System.out.println("Que docena quieres apostar?");
            docena = sc.nextInt();
            try {
                Comprobaciones.comprobarNumero(docena);
                a = true;
            } catch (ANumeros e) {
                System.out.println(e.getMessage());
            }
        } while (!a);
        return servicio.apostarDocena(docena, apuesta, tab);
    }

    public List<Casilla> apostarColor(Tablero tab) {
        Scanner sc = new Scanner(System.in);
        boolean a = false;
        boolean b = false;
        boolean color = false;
        String colorElegido = "";
        double apuesta = 0;
        while (!b){
            try {
                System.out.println("¿Cuánto quieres apostar?");
                apuesta = sc.nextInt();
                b = true;
            } catch (InputMismatchException e) {
                System.out.println(Constantes.BG_RED +Constantes.WHITE_BRIGHT+"Lo introducido no es un número");
                sc.nextLine();
            }
        }
        sc.nextLine();
        do {
            System.out.println("Que color quieres apostar?");
            colorElegido = sc.nextLine();
            try {
                Comprobaciones.comprobarColor(colorElegido);
                a = true;
            } catch (AColor e) {
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
        boolean b = false;
        boolean mayor = false;
        String mayorElegido = "";
        double apuesta = 0;
        while (!b){
            try {
                System.out.println("¿Cuánto quieres apostar?");
                apuesta = sc.nextInt();
                b = true;
            } catch (InputMismatchException e) {
                System.out.println(Constantes.BG_RED +Constantes.WHITE_BRIGHT+"Lo introducido no es un número");
                sc.nextLine();
            }
        }
        sc.nextLine();
        do {
            System.out.println("Quieres apostar a mayor o menor?");
            mayorElegido = sc.nextLine();
            try {
                Comprobaciones.comprobarMayor(mayorElegido);
                a = true;
            } catch (AMayor e) {
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
        boolean b = false;
        boolean par = false;
        String parElegido = "";
        double apuesta = 0;
        while (!b){
            try {
                System.out.println("¿Cuánto quieres apostar?");
                apuesta = sc.nextInt();
                b = true;
            } catch (InputMismatchException e) {
                System.out.println(Constantes.BG_RED +Constantes.WHITE_BRIGHT+"Lo introducido no es un número");
                sc.nextLine();
            }
        }
        sc.nextLine();
        do {
            System.out.println("¿Quieres apostar a par o impar?");
            parElegido = sc.nextLine();
            try {
                Comprobaciones.comprobarPar(parElegido);
                a = true;
            } catch (APar e) {
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
        double apuesta = 0;
        while (!a){
            try {
                System.out.println("¿Cuánto quieres apostar?");
                apuesta = sc.nextInt();
                a = true;
            } catch (InputMismatchException e) {
                System.out.println(Constantes.BG_RED +Constantes.WHITE_BRIGHT+"Lo introducido no es un número");
                sc.nextLine();
            }
        }
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

    //Metodos de Menu

    public void menuApuestas(ApuestaImplementacion apuesta, Tablero tab) {
        Scanner sc = new Scanner(System.in);
        int resultado = resultadoTirada();
        Tirada tirada = new Tirada(resultado);
        List<ApuestaImplementacion> apuestaImplementacion = new ArrayList<>();
        List<Casilla> casillasApostadas = new ArrayList<>();
        ArrayList<Tirada> listaTiradas = new ArrayList<>();
        boolean menu = false;
        tab.rellenarTablero();


        do {
            int opc2 = 0;
            tab.pintarTablero(apuesta);
            try {
                System.out.println(Constantes.MENU_APUESTAS);
                opc2 = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Caracter incorrecto");
                sc.nextLine();
            }

            switch (opc2) {

                case 1:
                    apuesta.setCasillasApostadas(apostarNumero(tab));
                    break;
                case 2:
                    apuesta.setCasillasApostadas(apostarColor(tab));
                    break;
                case 3:
                    apuesta.setCasillasApostadas(apostarPar(tab));
                    break;
                case 4:
                    apuesta.setCasillasApostadas(apostarMayor(tab));
                    break;
                case 5:
                    apuesta.setCasillasApostadas(apostarFila(tab));
                    break;
                case 6:
                    apuesta.setCasillasApostadas(apostarDocena(tab));
                    break;
                case 7:
                    apuesta.setCasillasApostadas(apostarHuerfano(tab));
                    break;
                case 8:
                    //Metodos sobre la tirada en si. Añade al historico de tiradas la nueva, la mete en el fichero y la muestra por pantalla
                    listaTiradas.add(tirada);
                    Ficheros.escribirFicheroTirada(Constantes.TIRADA_FILE, listaTiradas);
                    System.out.println("La casilla ganadora es: " + resultado);

                    //Creamos una apuesta nueva y le añadimos las casillas apostadas de la ultima apuesta. Ademas las añadimos al fuchero de las casillas apostadas
                    casillasApostadas = apuesta.borrarDuplicados(casillasApostadas);
                    apuesta.setCasillasApostadas(casillasApostadas);
                    apuestaImplementacion.add(apuesta);
                    Ficheros.escribirFicheroApuestas(Constantes.APUESTA_FILE, apuestaImplementacion);

                    //Comprobamos si la casilla ganadora es una de las apostadas. Si es asi, mostramos el mensaje de que ha ganado y la cantidad ganada
                    int finalResultado = resultado;
                    Casilla casillaGanadora = apuesta.getCasillasApostadas().stream().filter(casilla -> casilla.getNumero() == finalResultado).findFirst().orElse(null);
                    if (casillaGanadora != null && casillaGanadora.getValor() > 0) {
                        System.out.println("Has ganado");
                        System.out.println("Has ganado " + casillaGanadora.getValor());
                    } else {
                        System.out.println("Has perdido");
                    }
                    //Reiniciamos la apuesta
                    apuesta.setCasillasApostadas(new ArrayList<>());

                    break;
                case 9:

                    break;
                case 10:
                    System.out.println("¿Quieres salir del programa? (si/no)");
                    String salir = sc.next();
                    if (salir.equalsIgnoreCase("si")) {
                        menu = true;

                    } else if (salir.equalsIgnoreCase("no")) {
                        menu = false;
                    } else {
                        System.out.println("Opcion no valida");
                    }
                    break;
            }

        } while (!menu);
    }

    public void menuInicioSesion(Tablero tab, ApuestaImplementacion apuesta) {
            Scanner sc = new Scanner(System.in);
            boolean menu = false;
            iniciarSesion();
            do {
                int opc = 0;
                try {
                    System.out.println(Constantes.MENU_USUARIO);
                    opc = sc.nextInt();
                } catch (InputMismatchException e) {
                    sc.nextLine();
                }

                switch (opc) {
                    case 1:
                        menuApuestas(apuesta, tab);
                        break;
                    case 2:
                        System.out.println("¿Quieres salir del programa? (si/no)");
                        String salir = sc.next();
                        if (salir.equalsIgnoreCase("si")) {
                            menu = true;
                        } else if (salir.equalsIgnoreCase("no")) {
                            menu = false;
                        } else {
                            System.out.println("Opcion no valida");
                        }
                        break;
                }
            } while (!menu);
    }
}
