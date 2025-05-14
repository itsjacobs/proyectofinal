package org.example.domain;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ApuestasUsuario {
    private String id;
    //ganancias de las apuestas
    //user id
    LocalDate fecha = LocalDate.now();
}
