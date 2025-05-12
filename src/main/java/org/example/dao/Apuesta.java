package org.example.dao;

import lombok.Data;
import org.example.domain.Casilla;
import java.util.Scanner;

@Data
public class Apuesta implements daoApuesta {
    private int [] numeros;
    private boolean apuestaColor;
    private boolean apostarPar;
    private boolean apostarMayor;
    private boolean apostarHuerfanos;
    private int apostarFila;
    private int apostarDocena;


    @Override
    public void repetirTirada() {
        boolean a = false;
        Scanner sc = new Scanner(System.in);
        System.out.println("Quieres repetir la tirada anterior");
        String op = sc.nextLine();
        if (op.equalsIgnoreCase("si")) {
            a = true;
        }
    }
    @Override
    public void apostarNumero(Casilla casilla) {

    }
    @Override
    public void apostarfila(int fila) {
        if (fila<1 || fila > 3){
            System.out.println("Opción incorrecta");
        }
        else {
            this.apostarFila = fila;
        }
    }
    @Override
    public void apostarDocena(int docena) {
        if (docena<1 || docena > 3){
            System.out.println("Opcion incorrecta");
        }
        else {
            this.apostarDocena = docena;
        }
    }

    @Override
    public void apostarColor() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Que color quieres apostar");
        String op = sc.nextLine();
        if (op.equalsIgnoreCase("rojo")){
            apuestaColor = true;
        }
        if (op.equalsIgnoreCase("negro")){
            apuestaColor = false;
        }
    }

    @Override
    public void apostarMayor() {
        Scanner sc = new Scanner(System.in);
        System.out.println("quieres apostar a mayores o menores?");
        String op = sc.nextLine();
        if (op.equalsIgnoreCase("mayor")){
            apostarMayor = true;
        }
        if (op.equalsIgnoreCase("menor")){
            apostarMayor = false;
        }

    }

    @Override
    public void apostarPar(boolean par) {

    }

    @Override
    public void apostarHuerfanos(boolean huerfanos) {

    }

    @Override
    public void cerrarApuestas() {

    }

    @Override
    public void cobrarGananciar() {

    }
}
