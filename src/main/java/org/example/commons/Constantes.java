package org.example.commons;

import org.example.ui.EntSalida;

public class Constantes {
    public static final  int[] NEGROS = {2,4,6,8,10,11,13,15,17,20,22,24,26,28,29,31,33,35};
    public static final int[] ROJOS = {1,3,5,7,9,12,14,16,18,19,21,23,25,27,30,32,34,36};
    public static final String USUARIO_FILE = "usuario.txt";
    public static final String APUESTASUSUARIO_FILE = "apuestasUsuario.txt";
    public static final String USUARIOJSON = "usuarios.json";
    public static final String TIRADA_FILE = "tirada.txt";
    public static final String MENU_IS = "---------------Bienvenido al menu de Inicio de sesion---------------\n" +
            "1.Iniciar sesión\n" +
            "2.Registrarse\n";
    public static final String MENU_USUARIO = "---------------Bienvenido al menu de Usuario---------------\n" +
            "1.Apostar\n" +
            "2.Salir\n";
    public static final String MENU_APUESTAS = "---------------Bienvenido al menu de Apuestas---------------\n" +
            "1.Apostar a numero\n" +
            "2.Apostar a color\n" +
            "3.Apostar a par/impar\n" +
            "4.Apostar a mayor/menor\n" +
            "5.Apostar a fila\n" +
            "6.Apostar a docena\n" +
            "7.Apostar a huerfanos\n" +
            "8.Terminar apuesta\n" +
            "9.Ingresar dinero\n" +
            "10.Salir\n";
    public static final String MENSAJE_OPCION_INVALIDA = "Opcion invalida, por favor elija una opcion valida\n";

    public static final String RESET = "\u001B[0m";
    public static final String WHITE_BRIGHT = "\u001B[97m";
    public static final String BG_GRAY = "\u001B[48;5;236m";
    public static final String BG_RED = "\u001B[41m";
    public static final String BG_APOSTADA = "\u001B[43m";
    public static final String BG_GREEN = "\u001B[48;5;28m";
    public static final String BLACK_LETTER =  "\u001B[30m";
    public static final String DNI =  "Ingresa el DNI/NIE:";
    public static final String NOMBRE =  "Ingresa tu nombre:";
    public static final String CONTRASEñA =  "Ingresa tu contraseña:";
    public static final String CARTERA =  "Ingresa la cantidad de dinero que quieres tener en tu cartera";
    public static final String REGISTRO =  "Te has registrado correctamente";
    public static final String CARACTER =  "Caracter incorrecto";
    public static final String INICIOINCORRECTO = "La contraseña o el DNI/NIE son incorrectos";
    public static final String EXISTE = "El usuario ya existe";
    public static final String APUESTA = "¿Cuánto quieres apostar?";
    public static final String INTRODUCIDO = "Lo introducido no es un número";
    public static final String NUMERO = "¿Qué número quieres apostar?";
    public static final String NONUMERO = "Lo introducido no es un número";
    public static final String COLOR = "¿Qué color quieres apostar?";
    public static final String PAR = "¿Quieres apostar a par/impar?";
    public static final String MAYOR = "¿Quieres apostar a mayor/menor?";
    public static final String FILA = "¿Qué fila quieres apostar?";
    public static final String DOCENA = "¿Qué docena quieres apostar?";
    public static final String GANADORA = "La bola ha caído en el número: ";
    public static final String GANADORACARTERA = "Has ganado:";
    public static final String PERDEDORA = "Has perdido!!!";
    public static final String INGRESO = "¿Cuánto dinero quieres ingresar?";
    public static final String INGRESOERROR = "El ingreso debe ser mayor que 0";
    public static final String SALIR = "¿Quieres salir del programa? (si/no)";

}

