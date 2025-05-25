package org.example.domain;

import lombok.Data;
import org.example.commons.Constantes;
import java.util.Objects;

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
    public Casilla(String linea) {
        String[] token = linea.split("-");
        this.color = Boolean.parseBoolean(token[0]);
        this.numero = Integer.parseInt(token[1]);
        this.valor = Integer.parseInt(token[2]);
    }
    public Casilla(boolean color, int numero, double valor) {
        this.color = color;
        this.numero = numero;
        this.valor = valor;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(numero);
        return sb.toString();
    }
    public String toStringFicheroCasilla(){
        StringBuilder SB = new StringBuilder();
        SB.append(color).append("-").append(numero).append("-").append(valor);
        return SB.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Casilla casilla = (Casilla) o;
        return numero == casilla.numero;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(numero);
    }
}
