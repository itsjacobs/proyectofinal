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

    public Usuario(String id, String nombre, String contraseña) {
        this.id = id;
        this.nombre = nombre;
        this.contraseña = contraseña;
    }
    public Usuario() {
        this.id = "";
        this.nombre ="";
        this.contraseña = "";
         }

    public void inicioSesion(String id, String contraseña) {
        List<Usuario> lista = Ficheros.leerFicheroUsuario(Constantes.USUARIO_FILE);
        for (Usuario usuario : lista) {
            if (usuario.getId().equals(this.id) && usuario.getContraseña().equals(this.contraseña)) {
                System.out.println("Inicio de sesión exitoso");
            }
        }
    }
    public String toStringFicheroUsuario() {
        StringBuilder SB = new StringBuilder();
        SB.append(id).append("-").append(nombre).append("-").append(contraseña);
        return SB.toString();
    }
}


