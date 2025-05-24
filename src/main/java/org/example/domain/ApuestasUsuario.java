package org.example.domain;

import lombok.Data;
import org.example.dao.ApuestaImplementacion;

import java.awt.*;
import java.time.LocalDate;
import java.util.ArrayList;

@Data
public class ApuestasUsuario implements Comparable<Double> {
    private String id;
    private double ganancia;
    private LocalDate fecha;
    private Usuario usuario;
    private ApuestaImplementacion apuesta;

    public ApuestasUsuario(Usuario usuario, ApuestaImplementacion apuesta) {
        this.usuario = usuario;
        this.apuesta = apuesta;
        fecha = LocalDate.now();
    }



    public String toStringFicheroApuestaUsuario(){
        StringBuilder sb = new StringBuilder();
        sb.append(id).append("-").append(ganancia).append("-").append(fecha).append("-").append(usuario.getId());
        return sb.toString();
    }

    @Override
    public int compareTo(Double o) {
        return Double.compare(this.ganancia, o);
    }
}
