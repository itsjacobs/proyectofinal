package org.example.dao;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.example.commons.Constantes;
import org.example.domain.ApuestasUsuario;
import org.example.domain.Tirada;
import org.example.domain.Usuario;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ficheros {
    public static boolean escribirFicheroUsuario(String fichero, List<Usuario> lista) {
        PrintWriter escribir = null;
        boolean a = false;
        try {
            escribir = new PrintWriter(fichero);
        } catch (FileNotFoundException e) {
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        for (Usuario usuario : lista) {
            escribir.println(usuario.toStringFicheroUsuario());
            a = true;
        }
        escribir.close();
        return a;
    }

    public static List<Usuario> leerFicheroUsuario(String fichero) {
        List<Usuario> lista = new ArrayList<>();
        String Linea = null;
        try {
            Scanner sc = new Scanner(new File(fichero));
            while (sc.hasNextLine()) {
                Linea = sc.nextLine();
                String[] partes = Linea.split("-");
                String id = partes[0];
                String nombre = partes[1];
                String contraseña = partes[2];
                double cartera = Double.parseDouble(partes[3]);
                Usuario usuario = new Usuario(id, nombre, contraseña,cartera);
                lista.add(usuario);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error al leer el fichero: " + e.getMessage());
        }
        return lista;
    }

    public static boolean escribirFicheroTirada(String fichero, List<Tirada> lista) {
        PrintWriter escribir = null;
        boolean a = false;
        try {
            escribir = new PrintWriter(new FileWriter(fichero, true));
        } catch (FileNotFoundException e) {
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        for (int i = 0; i < lista.size(); i++) {
            escribir.println(lista.get(i).toStringFicheroTirada());
            a = true;
        }
        escribir.close();
        return a;
    }

    public static List<Tirada> leerFicheroTirada(String fichero) {
        List<Tirada> lista = new ArrayList<>();
        String Linea = null;
        try {
            Scanner sc = new Scanner(new File(fichero));
            while (sc.hasNextLine()) {
                Linea = sc.nextLine();
                String[] partes = Linea.split("-");
                int numero = Integer.parseInt(partes[0]);
                Tirada tirada = new Tirada(numero);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return lista;
    }
    public static void escribirFicheroBinario(String fichero, List<Usuario> lista) {
        try {
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(fichero));
            os.writeObject(lista);
            os.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static List<ApuestasUsuario> leerFicheroBinario(String fichero) {
        List<ApuestasUsuario> lista = null;
        try {
            ObjectInputStream os = new ObjectInputStream(new FileInputStream(fichero));
            lista = (List<ApuestasUsuario>) os.readObject();
            os.close();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return lista;
    }
    public static void archivoJSON(List<Usuario> usuarios) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(usuarios);

        try (FileWriter writer = new FileWriter(Constantes.USUARIOJSON)) {
            writer.write(json);
            System.out.println("Archivo JSON creado exitosamente.");
        } catch (IOException e) {
            System.err.println("Error al escribir el archivo JSON: " + e.getMessage());
        }
    }
}

