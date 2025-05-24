package org.example.commons;

public class ACartera extends Exception {
    public ACartera(String message) {
        super(message);
    }
    public ACartera(){
        super("No tienes suficiente saldo en la tarjeta. Por favor, recarga tu cartera.");
    }
}
