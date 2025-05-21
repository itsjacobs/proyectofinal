package org.example.domain;

import lombok.Data;
import org.example.commons.Constantes;
import org.example.dao.Ficheros;

import java.util.List;

@Data
public class Usuario {
    private String id;
    private String nombre;
    private String contraseña;
    private double saldo;

    public Usuario(String id, String nombre, String contraseña) {
        this.id = id;
        this.nombre = nombre;
        this.contraseña = contraseña;
    }
    public Usuario(String id,String contraseña) {
        this.id = id;
        this.nombre ="";
        this.contraseña = contraseña;
         }

    public boolean registrarse(Usuario usuario) {
        boolean a = true;
        List<Usuario> lista = Ficheros.leerFicheroUsuario(Constantes.USUARIO_FILE);
        List<Usuario> comprobacion = lista.stream().filter(u -> u.id.equalsIgnoreCase(usuario.id)).toList();
        if (comprobacion.isEmpty()) {
            lista.add(usuario);
            a = Ficheros.escribirFicheroUsuario(Constantes.USUARIO_FILE, lista);
        }
        return a;
    }

    public boolean inicioSesion(Usuario usuario) {
        boolean a = false;
        List<Usuario> lista = Ficheros.leerFicheroUsuario(Constantes.USUARIO_FILE);
        List<Usuario> comprobacion = lista.stream().filter(u -> u.id.equalsIgnoreCase(usuario.id)).filter(u -> u.contraseña.equals(usuario.contraseña)).toList();
        if (!comprobacion.isEmpty()) {
            a =  true;
        }
        return a;
    }
    public String toStringFicheroUsuario() {
        StringBuilder SB = new StringBuilder();
        SB.append(id).append("-").append(nombre).append("-").append(contraseña);
        return SB.toString();
    }
}


