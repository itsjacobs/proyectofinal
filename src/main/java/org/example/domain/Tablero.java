package org.example.domain;

public class Tablero {
    private Casilla Tablero [][] = new Casilla[12][3];
    private boolean par;
    private boolean mayor;
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

    public void pintarTablero(){
        int fil = 1;
        for(int j = 2; j >= 0; j--){
            for(int i = 0; i < 12; i++){
                System.out.print(Tablero[i][j] + "\t");
            }
            System.out.println("fila " + fil);
            System.out.println();
            fil++;
        }
        System.out.println("  1ª docena\t\t  2ª docena\t\t  3ª docena");
        System.out.println("1-18\t par\t rojo\t negro\t impar\t 19-36");
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
        }else if(casilla.getNumero() <= 18){
            mayor=false;
        }
        return mayor;
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

}
