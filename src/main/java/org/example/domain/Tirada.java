package org.example.domain;

import lombok.Data;

import java.util.Random;

@Data
public class Tirada {
    private int numero;
    public int tirar(){
        Random rnd = new Random();
        this.numero = rnd.nextInt(0,36);
        return numero;
    }

    public Casilla resultadoTirada(Casilla casilla){
        System.out.println("La casilla ganadora es " + casilla.getNumero());
        return casilla;
    }

    public double calcularGanancia(Casilla casilla){
        double ganancia = casilla.getValor();
        return ganancia;
    }

    public String toStringFicheroTirada(){
        StringBuilder sb = new StringBuilder();
        sb.append(numero).append("-");
        return sb.toString();
    }
}
