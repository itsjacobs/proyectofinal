package org.example.ui;

import org.example.commons.Constantes;
import org.example.domain.Usuario;
import org.example.service.gestionApuestas;
import org.example.service.gestionApuestasImplementacion;

import java.util.Scanner;

public class EntSalida               {
    private gestionApuestas servicio;

    public EntSalida(gestionApuestas servicio) {
        this.servicio = servicio;
    }
    public EntSalida() {
        this.servicio = new gestionApuestasImplementacion();
    }
    public void iniciarSesion() {
        Scanner sc = new Scanner(System.in);
        System.out.println(Constantes.MENU_IS);
        int opc = sc.nextInt();
        switch (opc) {
            case 1:
                System.out.println("Ingresa el nombre de usuario:");
                String nombre = sc.next();
                System.out.println("Ingresa la contraseña:");
                String contrasena = sc.next();
                servicio.iniciarSesion(nombre, contrasena);
                break;
            case 2:

            default:
                System.out.println(Constantes.MENSAJE_OPCION_INVALIDA);
        }
    }
}
