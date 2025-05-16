package org.example.commons;

public class Color extends Exception {
    public Color(String message) {
        super(message);
    }
    public Color(){
      super("El color tiene que ser rojo o negro");
    }
}
