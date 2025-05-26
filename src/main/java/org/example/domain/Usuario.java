package org.example.domain;

import lombok.Data;
import org.example.commons.Constantes;
import org.example.dao.Ficheros;

import java.io.Serializable;
import java.util.List;

@Data
public class Usuario implements Serializable {
    private String id;
    private String nombre;
    private String contraseña;
    private double cartera;

    public Usuario(String id, String nombre, String contraseña,double cartera) {
        this.id = id;
        this.nombre = nombre;
        this.contraseña = contraseña;
        this.cartera = cartera;
    }
    public Usuario(String id,String contraseña) {
        this.id = id;
        this.nombre ="";
        this.contraseña = contraseña;
    }
    public Usuario(String nombre) {
        this.id = "";
        this.nombre = nombre;
        this.contraseña = "";
        this.cartera = 0.0;
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
        SB.append(id).append("-").append(nombre).append("-").append(contraseña).append("-").append(cartera);
        return SB.toString();
    }
}


