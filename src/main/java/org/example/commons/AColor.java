package org.example.commons;

public class AColor extends Exception {
    public AColor(String message) {
        super(message);
    }
    public AColor(){
      super("El color tiene que ser rojo o negro");
    }
}
