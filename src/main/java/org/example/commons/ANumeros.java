package org.example.commons;

public class ANumeros extends Exception {
    public ANumeros() {
        super("El numero tiene que ser entre 1 y 3");
    }
    public ANumeros(String message) {
        super(message);
    }
}
