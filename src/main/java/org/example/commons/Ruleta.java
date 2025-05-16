package org.example.commons;

public class Ruleta extends Exception {
    public Ruleta() {
        super("El número tiene que estar entre 1 y 36");
    }
    public Ruleta(String message) {
        super(message);
    }
}
