package org.example.commons;

public class Constantes {
    public static final  int[] NEGROS = {2,4,6,8,10,11,13,15,17,20,22,24,26,28,29,31,33,35};
    public static final int[] ROJOS = {1,3,5,7,9,12,14,16,18,19,21,23,25,27,30,32,34,36};
    public static final String RULETA_FILE = "ruleta.txt";
    public static final String USUARIO_FILE = "usuario.txt";
    public static final String APUESTA_FILE = "apuesta.txt";
    public static final String TIRADA_FILE = "tirada.txt";
    public static final String MENU_IS = "---------------Bienvenido al menu de Inicio de sesion---------------\n" +
            "1.Iniciar sesión\n" +
            "2.Registrarse\n";
    public static final String MENU_USUARIO = "---------------Bienvenido al menu de Usuario---------------\n" +
            "1.Apostar\n" +
            "2.Salir\n";
    public static final String MENU_Apuestas = "---------------Bienvenido al menu de Apuestas---------------\n" +
            "1.Apostar a numero\n" +
            "2.Apostar a color\n" +
            "3. Apostar a par/impar" +
            "4.Apostar a mayor/menor\n" +
            "5.Apostar a fila\n" +
            "6.Apostar a docena\n" +
            "7. Tirar\n";
    public static final String MENSAJE_OPCION_INVALIDA = "Opcion invalida, por favor elija una opcion valida\n";
    public static final String MENSAJE_ERROR_ESCRITURA = "No se pudo escribir el fichero, no se ha encontrado";
    public static final String MENSAJE_ERROR_LECTURA = "No se pudo leer el fichero";
}
