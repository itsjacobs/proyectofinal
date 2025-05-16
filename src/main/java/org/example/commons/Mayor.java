package org.example.commons;

public class Mayor extends Exception {
    public Mayor(){
        super("Solo puedes elegir mayor o menor");
    }
    public Mayor(String message) {
        super(message);
    }
}
