package org.example.commons;

public class Comprobaciones {
    public static void comprobarColor(String color) throws AColor {
        if (!color.equalsIgnoreCase("rojo") && !color.equalsIgnoreCase("negro")) {
            throw new AColor("El color " + color + "no es ni rojo, ni negro");
        }
    }
    public static void comprobarNumero(int numero) throws ANumeros {
        if (numero < 1 || numero > 3) {
            throw new ANumeros("El numero tiene que ser entre 1 y 3");
        }
    }
    public static void comprobarRuleta(int numero) throws ARuleta {
        if (numero < 0 || numero > 36) {
            throw new ARuleta("El número tiene que estar entre 0 y 36");
        }
    }
    public static void comprobarMayor(String mayor) throws AMayor {
        if (!mayor.equalsIgnoreCase("mayor") && !mayor.equalsIgnoreCase("menor")) {
            throw new AMayor("La opcion elegida tiene que ser mayor o menor");
        }
    }
    public static void comprobarPar(String par) throws APar {
        if (!par.equalsIgnoreCase("par") && !par.equalsIgnoreCase("impar")) {
            throw new APar("La opcion elegida tiene que ser par o impar");
        }
    }
}
