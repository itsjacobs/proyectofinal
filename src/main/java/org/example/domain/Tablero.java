package org.example.domain;

public class Tablero {
    private Casilla Tablero [][] = new Casilla[12][3];

    public void rellenarTablero(){
        int contador = 1;
        for(int i = 0; i < 12; i++){
            for(int j = 0; j < 3; j++){
                Tablero[i][j] = new Casilla(contador++);
            }
        }
    }

    public void pintarTablero(){
        int col = 1;
        for(int j = 2; j >= 0; j--){
            for(int i = 0; i < 12; i++){
                System.out.print(Tablero[i][j] + "\t");
            }
            System.out.println("columna: " + col);
            System.out.println();
            col++;
        }
        System.out.println("1-18\t par\t rojo\t negro\t impar\t 19-36");
    }

}
