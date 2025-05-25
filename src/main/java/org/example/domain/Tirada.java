package org.example.domain;

import lombok.Data;
import java.util.Random;

@Data
public class Tirada {
    private int numero;
    public Tirada(int numero) {
        this.numero = numero;
    }
    public Tirada() {
        Random rnd = new Random();
        this.numero = rnd.nextInt(1,36);
    }
    public int tirar(){
        Random rnd = new Random();
        this.numero = rnd.nextInt(1,36);
        return numero;
    }

    public String toStringFicheroTirada(){
        StringBuilder sb = new StringBuilder();
        sb.append(numero);
        return sb.toString();
    }
}
