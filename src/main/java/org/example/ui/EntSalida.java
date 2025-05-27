package org.example.ui;

import lombok.extern.log4j.Log4j2;
import org.example.commons.*;
import org.example.dao.ApuestaImplementacion;
import org.example.dao.Ficheros;
import org.example.domain.*;
import org.example.service.gestionApuestas;
import org.example.service.gestionApuestasImplementacion;

import java.io.InputStream;
import java.util.*;
import java.util.regex.Pattern;

import lombok.Data;

@Data
@Log4j2
public class EntSalida {
    private gestionApuestas servicio;
    private Usuario usuarioLogado;


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
                    log.error(Constantes.CARACTER);
                    sc.nextLine();
                }
            } while (!b);

            switch (opc) {
                case 1:
                    System.out.println(Constantes.DNI);
                    id = sc.next();
                    System.out.println(Constantes.CONTRASEñA);
                    contraseña = sc.next();
                    if (servicio.iniciarSesion(id, contraseña)) {
                        usuarioLogado = servicio.dameUsuario(id);
                        System.out.println("Bienvenido " + usuarioLogado.getNombre() + " has iniciado sesión correctamente");
                        a = true;
                    } else {
                        log.error(Constantes.INICIOINCORRECTO);
                    }
                    break;
                case 2:
                    boolean c = false;
                    System.out.println(Constantes.DNI);
                    sc.nextLine();
                    id = sc.nextLine();
                    System.out.println(Constantes.NOMBRE);
                    nombre = sc.nextLine();
                    do{
                        System.out.println(Constantes.CONTRASEñA);
                        contraseña = sc.nextLine();
                        try (InputStream input = EntSalida.class.getClassLoader().getResourceAsStream("config.properties")) {
                            Properties prop = new Properties();
                            prop.load(input);
                            String pattern = prop.getProperty("password.pattern");
                            if (Pattern.matches(pattern, contraseña)) {
                                c = true;
                            } else {
                                System.out.println(Constantes.CONTRASEÑA_ERROR);
                            }
                        } catch (Exception e) {
                            log.error("Error cargando config.properties: " + e.getMessage());
                            sc.nextLine();
                        }
                    }while (!c);

                    System.out.println(Constantes.CARTERA);
                    double cartera = sc.nextDouble();
                    if (servicio.registrarse(id, nombre, contraseña,cartera)) {
                        System.out.println(Constantes.REGISTRO);

                    } else {
                        System.out.println(Constantes.EXISTE);
                        log.error(Constantes.EXISTE);
                    }
                    break;
                case 3:
                    servicio.mostrarUsuariosDesdeFicheroBinario();
                    System.out.println(Constantes.TEXTOBINARIO);
                    break;
                case 4:
                    servicio.mostrarUsuariosJson();
                    System.out.println(Constantes.TEXTOJSON);
                    break;
                default:
                    log.error(Constantes.MENSAJE_OPCION_INVALIDA);
            }

        }

    }
    //Métodos de Apuestas

    public List<Casilla> apostarNumero(Tablero tab) {
        Scanner sc = new Scanner(System.in);

        double apuesta = 0;
        int numero = 0;
        boolean a = false;
        boolean b = false;
        while (!b){
            try {
                System.out.println(Constantes.APUESTA);
                apuesta = sc.nextInt();
                b = true;
            } catch (InputMismatchException e) {
                log.info(Constantes.INTRODUCIDO);
                sc.nextLine();
            }
        }
        do {
            System.out.println(Constantes.NUMERO);
            numero = sc.nextInt();
            try {
                Comprobaciones.comprobarRuleta(numero);
                a = true;
            } catch (ARuleta e) {
                log.error(e.getMessage());
            }
        } while (!a);
        return servicio.apostarNumero(numero, apuesta, tab, usuarioLogado);
    }


    public List<Casilla> apostarFila(Tablero tab) {
        Scanner sc = new Scanner(System.in);
        boolean a = false;
        boolean b = false;
        double apuesta = 0;
        int fila = 0;
        while (!b){
            try {
                System.out.println(Constantes.APUESTA);
                apuesta = sc.nextInt();
                b = true;
            } catch (InputMismatchException e) {
                log.info(Constantes.NONUMERO);
                sc.nextLine();
            }
        }
        sc.nextLine();
        do {
            System.out.println(Constantes.FILA);
            fila = sc.nextInt();

            try {
                Comprobaciones.comprobarNumero(fila);
                a = true;
            } catch (ANumeros e) {
                log.error(e.getMessage());
            }
        } while (!a);
        return servicio.apostarFila(fila, apuesta, tab, usuarioLogado);
    }

    public List<Casilla> apostarDocena(Tablero tab) {
        Scanner sc = new Scanner(System.in);
        boolean a = false;
        boolean b = false;
        int docena = 0;
        double apuesta = 0;
        while (!b){
            try {
                System.out.println(Constantes.APUESTA);
                apuesta = sc.nextInt();
                b = true;
            } catch (InputMismatchException e) {
                log.info(Constantes.NONUMERO);
                sc.nextLine();
            }
        }
        sc.nextLine();
        do {
            System.out.println(Constantes.DOCENA);
            docena = sc.nextInt();
            try {
                Comprobaciones.comprobarNumero(docena);
                a = true;
            } catch (ANumeros e) {
                log.error(e.getMessage());
            }
        } while (!a);
        return servicio.apostarDocena(docena, apuesta, tab, usuarioLogado);
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
                System.out.println(Constantes.APUESTA);
                apuesta = sc.nextInt();
                b = true;
            } catch (InputMismatchException e) {
                log.info(Constantes.NONUMERO);
                sc.nextLine();
            }
        }
        sc.nextLine();
        do {
            System.out.println(Constantes.COLOR);
            colorElegido = sc.nextLine();
            try {
                Comprobaciones.comprobarColor(colorElegido);
                a = true;
            } catch (AColor e) {
                log.error(e.getMessage());
            }

        } while (!a);

        if (colorElegido.equalsIgnoreCase("rojo")) {
            color = true;
        } else if (colorElegido.equalsIgnoreCase("negro")) {
            color = false;
        }

        return servicio.apostarColor(color, apuesta, tab,usuarioLogado);

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
                System.out.println(Constantes.APUESTA);
                apuesta = sc.nextInt();
                b = true;
            } catch (InputMismatchException e) {
                log.info(Constantes.NONUMERO);
                sc.nextLine();
            }
        }
        sc.nextLine();
        do {
            System.out.println(Constantes.MAYOR);
            mayorElegido = sc.nextLine();
            try {
                Comprobaciones.comprobarMayor(mayorElegido);
                a = true;
            } catch (AMayor e) {
                log.error(e.getMessage());
            }
        } while (!a);

        if (mayorElegido.equalsIgnoreCase("mayor")) {
            mayor = true;
        } else if (mayorElegido.equalsIgnoreCase("menor")) {
            mayor = false;
        }

        return servicio.apostarMayor(mayor, apuesta, tab,usuarioLogado);

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
                System.out.println(Constantes.APUESTA);
                apuesta = sc.nextInt();
                b = true;
            } catch (InputMismatchException e) {
                log.info(Constantes.NONUMERO);
                sc.nextLine();
            }
        }
        sc.nextLine();
        do {
            System.out.println(Constantes.PAR);
            parElegido = sc.nextLine();
            try {
                Comprobaciones.comprobarPar(parElegido);
                a = true;
            } catch (APar e) {
                log.error(e.getMessage());
            }
        } while (!a);

        if (parElegido.equalsIgnoreCase("par")) {
            par = true;
        } else if (parElegido.equalsIgnoreCase("impar")) {
            par = false;
        }
        return servicio.apostarPar(par, apuesta, tab, usuarioLogado);

    }

    public List<Casilla> apostarHuerfano(Tablero tab) {
        Scanner sc = new Scanner(System.in);
        boolean a = false;
        double apuesta = 0;
        while (!a){
            try {
                System.out.println(Constantes.APUESTA);
                apuesta = sc.nextInt();
                a = true;
            } catch (InputMismatchException e) {
                log.info(Constantes.NONUMERO);
                sc.nextLine();
            }
        }
        return servicio.apostarHuerfanos(true, apuesta, tab,usuarioLogado);
    }


    //Métodos de tirada


    public int resultadoTirada() {
        return servicio.resultadoTirada();
    }

    //Metodos de Menu

    public void menuApuestas(Tablero tab) {
        Scanner sc = new Scanner(System.in);
        int resultado = resultadoTirada();
        Tirada tirada = new Tirada(resultado);

        boolean menu = false;
        tab.rellenarTablero();
        ApuestaImplementacion apuesta = new ApuestaImplementacion();

        do {
            int opc2 = 0;
            tab.pintarTablero(apuesta);
            try {
                System.out.println("Tu saldo es: " + usuarioLogado.getCartera() + "€");
                System.out.println(Constantes.MENU_APUESTAS);
                opc2 = sc.nextInt();
            } catch (InputMismatchException e) {
                log.error(Constantes.CARACTER);
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
                    servicio.terminarApuestas(usuarioLogado, tab);

                    break;
                case 9:
                    System.out.println(Constantes.INGRESO);
                    double ingreso = sc.nextDouble();
                    if (ingreso > 0) {
                        servicio.ingresarDinero(usuarioLogado.getId(), ingreso);
                        System.out.println("Has ingresado " + ingreso + "€ ");
                    } else {
                        log.error(Constantes.INGRESOERROR);
                    }
                    break;
                case 10:
                    List<Usuario> listaUsuarios = servicio.listaUsuarios();
                    List<ApuestasUsuario> apuestasUsuario = servicio.ordenarApuestas();
                    System.out.println(Constantes.SALIR);
                    String salir = sc.next();
                    if (salir.equalsIgnoreCase("si")) {
                        menu = true;
                        Ficheros.archivoJSON(servicio.listaUsuarios());
                        Ficheros.escribirFicheroUsuario(Constantes.USUARIO_FILE, listaUsuarios);
                        Ficheros.escribirFicheroBinario(Constantes.BINARIO_FILE, listaUsuarios);
                    } else if (salir.equalsIgnoreCase("no")) {
                        menu = false;
                    } else {
                        log.error(Constantes.MENSAJE_OPCION_INVALIDA);
                    }
                    break;
            }

        } while (!menu);
    }

    public void menuInicioSesion(Tablero tab) {
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
                        menuApuestas(tab);
                        break;
                    case 2:
                        List <ApuestasUsuario> lista= servicio.ordenarApuestas();
                        System.out.println(lista.toString());
                        break;
                    case 3:
                        System.out.println(Constantes.SALIR);
                        String salir = sc.next();
                        if (salir.equalsIgnoreCase("si")) {
                            menu = true;
                        } else if (salir.equalsIgnoreCase("no")) {
                            menu = false;
                        } else {
                            log.error(Constantes.MENSAJE_OPCION_INVALIDA);
                        }
                        break;
                }
            } while (!menu);
    }
}
