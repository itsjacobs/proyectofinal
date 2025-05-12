package org.example.dao;

import org.example.domain.Casilla;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Ficheros {
    public static boolean escribirFicheroC(String fichero, List<Casilla> lista){
        PrintWriter escribir = null;
        boolean a = false;
        try{
            escribir = new PrintWriter(fichero);
        }
        catch(FileNotFoundException e){
            System.out.println("No se pudo escribir el fichero, no se ha encontrado");
        }
        for(int i = 0; i< lista.size(); i++){
            escribir.println(lista.get(i).toStringFicheroC());
            a = true;
        }
        escribir.close();
        return a;
    }
    public static boolean escribirFicheroG(String fichero, ArrayList<Casilla> lista){
        PrintWriter escribir = null;
        boolean a = false;
        try{
            escribir = new PrintWriter(fichero);
        }
        catch(FileNotFoundException e){
            System.out.println("No se pudo escribir el fichero, no se ha encontrado");
        }
        for(int i = 0; i< lista.size(); i++){
           escribir.println(lista.get(i).toString());
            a = true;
        }
        escribir.close();
        return a;
    }
}
