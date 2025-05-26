package org.example.dao;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import lombok.extern.log4j.Log4j2;
import org.example.commons.Constantes;
import org.example.domain.ApuestasUsuario;
import org.example.domain.Tirada;
import org.example.domain.Usuario;
import java.io.*;
import java.lang.reflect.Type;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Log4j2
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
            log.error("Error al leer el fichero: {}", e.getMessage());
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
    public static boolean escribirFicheroApuestasUsuario(String fichero, List<ApuestasUsuario> lista) {
        PrintWriter escribir = null;
        boolean a = false;
        try {
            escribir = new PrintWriter(new FileWriter(fichero, true));
        } catch (FileNotFoundException e) {
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        for (int i = 0; i < lista.size(); i++) {
            escribir.println(lista.get(i).toStringFicheroApuestaUsuario());
            a = true;
        }
        escribir.close();
        return a;
    }
    public static List<ApuestasUsuario> leerFicheroApuestasUsuario(String fichero) {
        List<ApuestasUsuario> lista = new ArrayList<>();
        String Linea = null;
        try {
            Scanner sc = new Scanner(new File(fichero));
            while (sc.hasNextLine()) {
                Linea = sc.nextLine();
                String[] partes = Linea.split(";");
                String nombre = partes[0];
                String Apuesta = partes[1];
                double ganancia = Double.parseDouble(partes[2]);
                LocalDate fecha = LocalDate.parse(partes[3]);
                ApuestasUsuario apuesta = new ApuestasUsuario(nombre, Apuesta,ganancia,fecha);
                lista.add(apuesta);
            }
        } catch (FileNotFoundException e) {
            log.error("Error al leer el fichero: {}", e.getMessage());
        }
        return lista;
    }

    public static void escribirFicheroBinario(String fichero, List<Usuario> lista) {
        try {
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(fichero));
            os.writeObject(lista);
            os.close();
        } catch (IOException e) {
            log.error("Error al leer el fichero: {}", e.getMessage());
        }
    }
    public static List<Usuario> leerFicheroBinario(String fichero) {
        List<Usuario> lista = null;
        try {
            ObjectInputStream os = new ObjectInputStream(new FileInputStream(fichero));
            lista = (List<Usuario>) os.readObject();
            os.close();
        } catch (IOException | ClassNotFoundException e) {
            log.error("Error al leer el fichero: {}", e.getMessage());
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
    public static List<Usuario> leerUsuariosJson() {
        Gson gson = new Gson();
        Type tipoListaUsuarios = new TypeToken<List<Usuario>>() {}.getType();

        try (Reader reader = new FileReader(Constantes.USUARIOJSON)) {
            return gson.fromJson(reader, tipoListaUsuarios);
        } catch (IOException e) {
            System.err.println("Error al leer el archivo JSON: " + e.getMessage());
            return List.of();
        }
    }
}

