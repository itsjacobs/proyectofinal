package org.example.domain;

import lombok.Data;
import java.time.LocalDate;


@Data
public class ApuestasUsuario implements Comparable<Double> {
    private String id;
    private double ganancia;
    private LocalDate fecha;
    private String nombre;
    private String apuesta;

    public ApuestasUsuario(String nombre, double ganancia, String apuesta){
        this.nombre = nombre;
        this.ganancia = ganancia;
        this.apuesta = apuesta;
        fecha = LocalDate.now();
    }
    public ApuestasUsuario(String nombre, String apuesta,double ganancia,LocalDate fecha){
        this.nombre = nombre;
        this.ganancia = ganancia;
        this.apuesta = apuesta;
        this.fecha = fecha;
    }

    public String toStringFicheroApuestaUsuario(){
        StringBuilder sb = new StringBuilder();
        sb.append(nombre).append(";").append(apuesta).append(";").append(ganancia).append(";").append(fecha);
        return sb.toString();
    }

    public String toString() {
        return "El usuario " + nombre +
                " ha ganado " + ganancia + "€ haciendo estas apuestas: \"" +
                apuesta + "\" el día " + fecha + "\n";
    }

    @Override
    public int compareTo(Double o) {
        return Double.compare(this.ganancia, o);
    }
}
