package org.example.dao;

import org.example.domain.Casilla;
import org.example.domain.Usuario;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ficheros {
    public static boolean escribirFicheroApuestas(String fichero, ArrayList<Apuesta> lista){
        PrintWriter escribir = null;
        boolean a = false;
        try{
            escribir = new PrintWriter(fichero);
        }
        catch(FileNotFoundException e){
            System.out.println("No se pudo escribir el fichero, no se ha encontrado");
        }
        for(int i = 0; i< lista.size(); i++){
           escribir.println(lista.get(i).toStringFicheroApuesta());
            a = true;
        }
        escribir.close();
        return a;
    }
    public static boolean escribirFicheroUsuario(String fichero, List<Usuario> lista){
        PrintWriter escribir = null;
        boolean a = false;
        try{
            escribir = new PrintWriter(fichero);
        }
        catch(FileNotFoundException e){
            System.out.println("No se pudo escribir el fichero, no se ha encontrado");
        }
        for(int i = 0; i< lista.size(); i++){
            escribir.println(lista.get(i).toStringFicheroUsuario());
            a = true;
        }
        escribir.close();
        return a;
    }
    public static List<Usuario> leerFicheroUsuario(String fichero){
        List<Usuario> lista = new ArrayList<>();
        String Linea = null;
        try{
            Scanner sc = new Scanner(new File(fichero));
            while(sc.hasNextLine()){
                Linea = sc.nextLine();
                String[] partes = Linea.split("-");
                String id = partes[0];
                String nombre = partes[1];
                String contraseña = partes[2];
                Usuario usuario = new Usuario();
                usuario.Registrarse(id, nombre, contraseña);
                lista.add(usuario);
            }
        }
        catch (FileNotFoundException e){
            System.out.println("No se ha podido leer el fichero");
        }
        return lista;
    }

}
