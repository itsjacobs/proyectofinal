package org.example.dao;

import org.example.domain.Casilla;

import java.util.Scanner;

public class Ruleta implements daoRuleta{
    private int [] numeros;
    private boolean apuestaColor;
    private boolean apostarPar;
    private boolean apostarMayor;
    private boolean apostarHuerfanos;
    private int apostarFila;
    private int apostarDocena;

    public Ruleta(){
        this.numeros = new int[36];
        this.apuestaColor = false;
        this.apostarPar = false;
        this.apostarMayor = false;
        this.apostarHuerfanos = false;
        this.apostarFila = 0;
        this.apostarDocena = 0;
    }


    public boolean isApuestaColor() {
        return apuestaColor;
    }

    public void setApuestaColor(boolean apuestaColor) {
        this.apuestaColor = apuestaColor;
    }

    public int[] getNumeros() {
        return numeros;
    }

    public void setNumeros(int[] numeros) {
        this.numeros = numeros;
    }

    public boolean isApostarPar() {
        return apostarPar;
    }

    public void setApostarPar(boolean apostarPar) {
        this.apostarPar = apostarPar;
    }

    public boolean isApostarMayor() {
        return apostarMayor;
    }

    public void setApostarMayor(boolean apostarMayor) {
        this.apostarMayor = apostarMayor;
    }

    public boolean isApostarHuerfanos() {
        return apostarHuerfanos;
    }

    public void setApostarHuerfanos(boolean apostarHuerfanos) {
        this.apostarHuerfanos = apostarHuerfanos;
    }

    public int getApostarFila() {
        return apostarFila;
    }

    public void setApostarFila(int apostarFila) {
        this.apostarFila = apostarFila;
    }

    public int getApostarDocena() {
        return apostarDocena;
    }

    public void setApostarDocena(int apostarDocena) {
        this.apostarDocena = apostarDocena;
    }

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
