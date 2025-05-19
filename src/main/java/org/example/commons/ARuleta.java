package org.example.commons;

public class ARuleta extends Exception {
    public ARuleta() {
        super("El número tiene que estar entre 1 y 36");
    }
    public ARuleta(String message) {
        super(message);
    }
}
