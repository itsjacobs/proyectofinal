package org.example.commons;

public class Par extends Exception {
    public Par(){
        super("La opcion tiene que ser par o impar");
    }
    public Par(String message) {
        super(message);
    }
}
