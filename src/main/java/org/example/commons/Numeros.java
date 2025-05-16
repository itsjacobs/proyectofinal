package org.example.commons;

public class Numeros extends Exception {
    public Numeros() {
        super("El numero tiene que ser entre 1 y 3");
    }
    public Numeros(String message) {
        super(message);
    }
}
