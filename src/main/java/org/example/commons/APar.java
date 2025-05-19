package org.example.commons;

public class APar extends Exception {
    public APar(){
        super("La opcion tiene que ser par o impar");
    }
    public APar(String message) {
        super(message);
    }
}
