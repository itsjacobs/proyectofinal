package org.example.dao;

import lombok.Data;
import org.example.domain.Casilla;
import org.example.domain.Tablero;
import org.example.domain.Usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Data
public class Apuesta implements daoApuesta {
    private String id;
    private List<Casilla> casillasApostadas;
    private List<Usuario> usuarios;

    public Apuesta() {
        Random rnd = new Random();
        this.id = String.valueOf(rnd.nextInt(0,10));
    }

    //Metodos Apuestas


    @Override
    public void repetirTirada() {

    }
    @Override
    public List<Casilla> apostarNumero(int cantidad, int numeros, double apuesta, Tablero tab) {
        this.casillasApostadas = new ArrayList<>();
        int contador = 0;
        for (int i = 0; i < 12 && contador < cantidad; i++) {
            for (int j = 0; j < 3 && contador < cantidad; j++) {
                if (tab.getTablero()[i][j].getNumero() == numeros) {
                    Casilla casilla = tab.getTablero()[i][j];
                    casilla.setValor(casilla.getValor() + (36 * apuesta));
                    casillasApostadas.add(casilla);
                    contador++;
                }
            }
        }

        return casillasApostadas;
    }

    @Override
    public List<Casilla> apostarFila(int fila, int apuesta, Tablero tab) {
        this.casillasApostadas = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 3; j++) {
                if (tab.queFila(tab.getTablero()[i][j]) == fila) {
                    Casilla casilla = tab.getTablero()[i][j];
                    casilla.setValor(casilla.getValor() + (3 * apuesta));
                    casillasApostadas.add(casilla);
                }
            }
        }

        return casillasApostadas;
    }

    @Override
    public List<Casilla> apostarDocena(int docena, int apuesta, Tablero tab) {
        this.casillasApostadas = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 3; j++) {
                if (tab.queDocena(tab.getTablero()[i][j]) == docena) {
                    Casilla casilla = tab.getTablero()[i][j];
                    casilla.setValor(casilla.getValor() + (3 * apuesta));
                    casillasApostadas.add(casilla);
                }
            }
        }

        return casillasApostadas;
    }

    @Override
    public List<Casilla> apostarColor(int apuesta, boolean color, Tablero tab) {
        this.casillasApostadas = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 3; j++) {
                Casilla casilla = tab.getTablero()[i][j];
                if (casilla.isColor() == color) {
                    casilla.setValor(casilla.getValor() + (2 * apuesta));
                    casillasApostadas.add(casilla);

                }
            }
        }
        return casillasApostadas;
    }

    @Override
    public List<Casilla> apostarMayor(int apuesta, Tablero tab, boolean mayor) {
        this.casillasApostadas = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 3; j++) {
                if (tab.esMayor(tab.getTablero()[i][j]) == mayor) {
                    Casilla casilla = tab.getTablero()[i][j];
                    casilla.setValor(casilla.getValor() + (2 * apuesta));
                    casillasApostadas.add(casilla);
                }
            }
        }

        return casillasApostadas;
    }

    @Override
    public List<Casilla> apostarPar(boolean par, int apuesta, Tablero tab) {
        this.casillasApostadas = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 3; j++) {
                if (tab.esPar(tab.getTablero()[i][j]) == par) {
                    Casilla casilla = tab.getTablero()[i][j];
                    casilla.setValor(casilla.getValor() + (2 * apuesta));
                    casillasApostadas.add(casilla);
                }
            }
        }
        return casillasApostadas;
    }

    @Override
    public List<Casilla> apostarHuerfanos(boolean huerfanos, int apuesta, Tablero tab) {
        this.casillasApostadas = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 3; j++) {
                if (tab.esHuerfano(tab.getTablero()[i][j]) == huerfanos) {
                    Casilla casilla = tab.getTablero()[i][j];
                    casilla.setValor(casilla.getValor() + (10 * apuesta));
                    casillasApostadas.add(casilla);
                }
            }
        }

        return casillasApostadas;
    }

    public List<Casilla> borrarDuplicados(List<Casilla> lista) {
        List<Casilla> listaSinDuplicados = new ArrayList<>();
        listaSinDuplicados = casillasApostadas.stream().distinct().toList();
        return listaSinDuplicados;
    }

    @Override
    public void recopilacionApuesta() {

    }

    @Override
    public void cobrarGananciar() {
    }

    //Metodos Usuario


    @Override
    public boolean iniciarSesion(String id, String contraseña) {
        Usuario usuario = new Usuario(id,contraseña);
        return usuario.inicioSesion(usuario);
    }

    @Override
    public boolean registrarse(String id, String nombre, String contrasena) {
        Usuario usuario = new Usuario(id, nombre, contrasena);
        return usuario.registrarse(usuario);

    }

    public String toStringFicheroApuesta(){
        StringBuilder sb = new StringBuilder();
        sb.append("Apuesta: ").append(id).append("\n");
        for (Casilla casilla: casillasApostadas){
            sb.append(casilla.toStringFicheroCasilla()).append("\n");
        }
        return sb.toString();
    }

    /*public String toStringGanancias(){
        StringBuilder sb = new StringBuilder();
        sb.append("Apuesta: ").append(id).append("\n");
        for (Casilla casilla: casillasApostadas){
            sb.append(casilla.getValor()).append("\n");
        }
        return sb.toString();
    }*/


}
