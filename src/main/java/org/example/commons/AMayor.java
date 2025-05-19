package org.example.commons;

public class AMayor extends Exception {
    public AMayor(){
        super("Solo puedes elegir mayor o menor");
    }
    public AMayor(String message) {
        super(message);
    }
}
