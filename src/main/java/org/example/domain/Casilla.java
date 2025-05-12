package org.example.domain;

import lombok.Data;
import org.example.commons.Constantes;

@Data
public class Casilla {
    private boolean color;
    private int numero;
    private double valor;

    public Casilla(int numero){
       boolean a = false;
       this.numero = numero;
       for (int i = 0; i < Constantes.ROJOS.length && !a; i++) {
           if (Constantes.ROJOS[i] == numero){
               color = true;
               a = true;
           }
       }
       if(!a){
           color = false;
       }
       this.valor = 0;
    }
    public Casilla(String linea){
        String [] token = linea.split("-");
        this.color = Boolean.parseBoolean(token[0]);
        this.numero = Integer.parseInt(token[1]);
    }
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(numero);
        return sb.toString();
    }
    public String toStringFicheroC(){
        StringBuilder sb = new StringBuilder();
        sb.append(color).append("-").append(numero);
        return sb.toString();
    }
}
