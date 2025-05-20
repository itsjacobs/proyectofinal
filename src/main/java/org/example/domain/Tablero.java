package org.example.domain;

import lombok.Data;
import org.example.commons.Constantes;
import org.example.dao.ApuestaImplementacion;

import java.util.List;
@Data
public class Tablero {
    private Casilla[][] Tablero = new Casilla[12][3];
    private boolean par;
    private boolean mayor;
    private boolean huerfano;
    private int fila;
    private int docena;


    public void rellenarTablero(){
        int contador = 1;
        for(int i = 0; i < 12; i++){
            for(int j = 0; j < 3; j++){
                Tablero[i][j] = new Casilla(contador++);
            }
        }
    }
    public void pintarTablero(ApuestaImplementacion apuesta){
        int fil = 1;

        System.out.println(Constantes.BG_GREEN);
        System.out.println(Constantes.BG_GREEN);
        System.out.println(Constantes.BG_GREEN);
        for(int j = 2; j >= 0; j--){
            for(int i = 0; i < 12; i++){
                if (apuesta.getCasillasApostadas().contains(Tablero[i][j])){
                    System.out.print(Constantes.BG_APOSTADA + Constantes.WHITE_BRIGHT + " " + Tablero[i][j] + "\t");
                }
                if (Tablero[i][j]!=null && Tablero[i][j].isColor() && !apuesta.getCasillasApostadas().contains(Tablero[i][j])){
                    System.out.print(Constantes.BG_RED +Constantes.WHITE_BRIGHT + " " + Tablero[i][j] + "\t");
                }else if (Tablero[i][j]!=null && !Tablero[i][j].isColor() && !apuesta.getCasillasApostadas().contains(Tablero[i][j])){
                    System.out.print(Constantes.BG_GRAY +Constantes.WHITE_BRIGHT + " " + Tablero[i][j] + "\t");
                }
                System.out.print(Constantes.RESET);
            }
            System.out.println(Constantes.BG_GREEN + Constantes.BLACK_LETTER  + "  fila " + fil);
            fil++;
        }
        System.out.println(Constantes.BLACK_LETTER +  "  1ª docena\t\t  2ª docena\t\t  3ª docena");
        System.out.println(Constantes.BLACK_LETTER +"1-18\t par\t rojo\t negro\t impar\t 19-36");
        System.out.println(Constantes.BG_GREEN);
        System.out.println(Constantes.BG_GREEN);
        System.out.println(Constantes.RESET);
    }
    public boolean esPar(Casilla casilla){
        if (casilla.getNumero() % 2==0){
            par = true;
        }else{
            par = false;
        }
        return par;
    }
    public boolean esMayor(Casilla casilla){
        if (casilla.getNumero() >18){
            mayor = true;
        }else {
            mayor=false;
        }
        return mayor;
    }
    public boolean esHuerfano(Casilla casilla){
        int numero = casilla.getNumero();
        if (numero == 1 || numero == 6 || numero == 9 || numero == 14 ||
                numero == 17 || numero == 20 || numero == 31 || numero == 34) {
            huerfano =true;

        }else {
            huerfano = false;
        }
        return huerfano;
    }
    public int queFila(Casilla casilla) {
        if(casilla.getNumero()%3==0){
            fila=1;
        }else if((casilla.getNumero()+1)%3==0){
            fila=2;
        }else {
            fila = 3;
        }
        return fila;
    }
    public int queDocena(Casilla casilla) {
        if (casilla.getNumero() >= 1 && casilla.getNumero() <= 12) {
            docena = 1;
        } else if (casilla.getNumero() >= 13 && casilla.getNumero() <= 24) {
            docena = 2;
        } else {
            docena = 3;
        }
        return docena;
    }

    public void resetTablero() {
        int contador = 1;
        for(int i = 0; i < 12; i++){
            for(int j = 0; j < 3; j++){
                Tablero[i][j] = new Casilla(contador++);
            }
        }
    }
}
