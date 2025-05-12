package org.example.domain;

import java.util.Random;

public class Tirada {
    public int Tirar(){
        Random rnd = new Random();

        int numero = rnd.nextInt(0,36);
        return numero;
    }

    public void resultadoTirada(Casilla casilla){
        System.out.println("La casilla ganadora es " + casilla.getNumero());
    }


}
