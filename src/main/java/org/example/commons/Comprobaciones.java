package org.example.commons;

public class Comprobaciones {
    public static void comprobarColor(String color) throws Color {
        if (!color.equalsIgnoreCase("rojo") && !color.equalsIgnoreCase("negro")) {
            throw new Color("El color " + color + "no es ni rojo, ni negro");
        }
    }
    public static void comprobarNumero(int numero) throws Numeros {
        if (numero < 1 || numero > 3) {
            throw new Numeros("El numero tiene que ser entre 1 y 3");
        }
    }
    public static void comprobarRuleta(int numero) throws Ruleta {
        if (numero < 0 || numero > 36) {
            throw new Ruleta("El número tiene que estar entre 0 y 36");
        }
    }
    public static void comprobarMayor(String mayor) throws Mayor {
        if (!mayor.equalsIgnoreCase("mayor") && !mayor.equalsIgnoreCase("menor")) {
            throw new Mayor("La opcion elegida tiene que ser mayor o menor");
        }
    }
    public static void comprobarPar(String par) throws Par {
        if (!par.equalsIgnoreCase("par") && !par.equalsIgnoreCase("impar")) {
            throw new Par("La opcion elegida tiene que ser par o impar");
        }
    }
}
