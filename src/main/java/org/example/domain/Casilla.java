package org.example.domain;

import org.example.commons.Constantes;

public class Casilla {
    private boolean color;
    private int numero;

    public Casilla(int numero){
       boolean a = false;
       this.numero = numero;
       for (int i = 0; i < Constantes.ROJOS.length && !a; i++) {
           if (Constantes.ROJOS[i] == numero){
               color = true;
               a = true;
           }
       }
       if(a==false){
           color = false;
       }

    }

    public boolean isColor() {
        return color;
    }

    public void setColor(boolean color) {
        this.color = color;
    }

    public int getNumero() {
                return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(numero);
       return sb.toString();
    }
}
