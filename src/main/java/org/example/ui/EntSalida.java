package org.example.ui;

import jdk.swing.interop.SwingInterOpUtils;
import org.example.commons.Constantes;
import org.example.domain.Usuario;
import org.example.service.gestionApuestas;
import org.example.service.gestionApuestasImplementacion;

import java.util.Scanner;

public class EntSalida {
    private gestionApuestas servicio;

    public EntSalida(gestionApuestas servicio) {
        this.servicio = servicio;
    }

    public EntSalida() {
        this.servicio = new gestionApuestasImplementacion();
    }

    public void iniciarSesion() {
        Scanner sc = new Scanner(System.in);
        String id = "";
        String contraseña = "";
        String nombre = "";
        boolean a = false;
        while (!a){
            System.out.println(Constantes.MENU_IS);
            int opc = sc.nextInt();
            switch (opc) {
                case 1:
                    System.out.println("Ingresa el DNI/NIE:");
                    id = sc.next();
                    System.out.println("Ingresa la contraseña:");
                    contraseña = sc.next();
                    if(servicio.iniciarSesion(id, contraseña)){
                        System.out.println("Has iniciado sesión correctamente");
                        a = true;
                    }
                    else{
                        System.out.println("La contraseña o el DNI/NIE son incorrectos");
                    }
                    break;
                case 2:
                    System.out.println("Ingresa el DNI/NIE:");
                    sc.nextLine();
                    id = sc.nextLine();
                    System.out.println("Ingresa tu nombre");
                    nombre = sc.nextLine();
                    System.out.println("Ingresa una ccontraseña");
                    contraseña = sc.nextLine();
                    if(servicio.registrarse(id, nombre, contraseña)){
                        System.out.println("Te has registrado correctamente");
                    }else{
                        System.out.println("El usuario ya existe");
                    }
                default:
                    System.out.println(Constantes.MENSAJE_OPCION_INVALIDA);
            }
        }

    }

}
