package org.example.domain;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ApuestasUsuario {
    private String id;
    private double ganancia;
    private String user_id;
    private LocalDate fecha = LocalDate.now();
}
