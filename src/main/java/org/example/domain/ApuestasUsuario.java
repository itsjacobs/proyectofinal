package org.example.domain;

import lombok.Data;
import org.example.dao.ApuestaImplementacion;

import java.awt.*;
import java.time.LocalDate;
import java.util.ArrayList;

@Data
public class ApuestasUsuario {
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




}
