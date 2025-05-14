package org.example.domain;

import lombok.Data;

import java.util.List;

@Data
public class Usuario {
    private String id;
    private String nombre;
    private String contraseña;

    public void Registrarse(String id, String nombre, String contraseña) {
        this.id = id;
        this.nombre = nombre;
        this.contraseña = contraseña;
    }
    public void inicioSesion(String linea,String ide, String contraseñas) {
        String[] token = linea.split("-");
        if (token[0].equals(ide) && token[2].equals(contraseñas)) {
            this.id = token[0];
            this.nombre = token[1];
            this.contraseña = token[2];
        } else {
            System.out.println("Usuario o contraseña incorrectos");
        }
    }
    public String toStringFicheroUsuario() {
        StringBuilder SB = new StringBuilder();
        SB.append(id).append("-").append(nombre).append("-").append(contraseña);
        return SB.toString();
    }
}


