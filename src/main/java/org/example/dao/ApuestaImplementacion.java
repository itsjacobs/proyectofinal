package org.example.dao;

import lombok.Data;
import org.example.commons.Constantes;
import org.example.domain.Casilla;
import org.example.domain.Tablero;
import org.example.domain.Tirada;
import org.example.domain.Usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Data
public class ApuestaImplementacion implements daoApuesta {
    private String id;
    private List<Casilla> casillasApostadas;
    private List<Usuario> usuarios;

    public ApuestaImplementacion() {
        Random rnd = new Random();
        this.casillasApostadas = new ArrayList<>();
        this.id = String.valueOf(rnd.nextInt(0,10));
        this.usuarios = Ficheros.leerFicheroUsuario(Constantes.USUARIO_FILE);
    }


    public void setCasillasApostadasManual(List<Casilla> casillasApostadas) {
        this.casillasApostadas = casillasApostadas;
    }

    //Metodos Apuestas


    @Override
    public List<Casilla> apostarNumero(int numeros, double apuesta, Tablero tab,Usuario usuario) {
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 3; j++) {
                Casilla casilla = tab.getTablero()[i][j];
                if (casilla != null && casilla.getNumero() == numeros) {
                    casilla.setValor(casilla.getValor() + (36 * apuesta));
                    casillasApostadas.add(casilla);
                }
            }
        }
        if (usuario != null){
            usuario.setCartera(usuario.getCartera() - apuesta);
        }
        return casillasApostadas;
    }

    @Override
    public List<Casilla> apostarFila(int fila, double apuesta, Tablero tab,Usuario usuario) {
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 3; j++) {
                Casilla casilla = tab.getTablero()[i][j];
                if (tab.getTablero()[i][j] != null && tab.queFila(tab.getTablero()[i][j]) == fila) {
                    casilla.setValor(casilla.getValor() + (3 * apuesta));
                    casillasApostadas.add(casilla);
                }
            }
        }
        if (usuario != null){
            usuario.setCartera(usuario.getCartera() - apuesta);
        }
        return casillasApostadas;
    }

    @Override
    public List<Casilla> apostarDocena(int docena, double apuesta, Tablero tab,Usuario usuario) {
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 3; j++) {
                if (tab.getTablero()[i][j] != null && tab.queDocena(tab.getTablero()[i][j]) == docena) {
                    Casilla casilla = tab.getTablero()[i][j];
                    casilla.setValor(casilla.getValor() + (3 * apuesta));
                    casillasApostadas.add(casilla);
                }
            }
        }
        usuario.setCartera(usuario.getCartera() - apuesta);
        return casillasApostadas;
    }

    @Override
    public List<Casilla> apostarColor(boolean color, double apuesta, Tablero tab,Usuario usuario) {
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 3; j++) {
                Casilla casilla = tab.getTablero()[i][j];
                if (casilla != null && casilla.isColor() == color) {
                    casilla.setValor(casilla.getValor() + (2 * apuesta));
                    casillasApostadas.add(casilla);

                }
            }
        }
        if (usuario != null){
            usuario.setCartera(usuario.getCartera() - apuesta);
        }
        return casillasApostadas;
    }

    @Override
    public List<Casilla> apostarMayor(boolean mayor, double apuesta, Tablero tab,Usuario usuario) {
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 3; j++) {
                if (tab.getTablero()[i][j] != null && tab.esMayor(tab.getTablero()[i][j]) == mayor) {
                    Casilla casilla = tab.getTablero()[i][j];
                    casilla.setValor(casilla.getValor() + (2 * apuesta));
                    casillasApostadas.add(casilla);
                }
            }
        }
        usuario.setCartera(usuario.getCartera() - apuesta);
        return casillasApostadas;
    }

    @Override
    public List<Casilla> apostarPar(boolean par, double apuesta, Tablero tab,Usuario usuario) {
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 3; j++) {
                if (tab.getTablero()[i][j] != null && tab.esPar(tab.getTablero()[i][j]) == par) {
                    Casilla casilla = tab.getTablero()[i][j];
                    casilla.setValor(casilla.getValor() + (2 * apuesta));
                    casillasApostadas.add(casilla);
                }
            }
        }
        if (usuario != null){
            usuario.setCartera(usuario.getCartera() - apuesta);
        }
        return casillasApostadas;
    }

    @Override
    public List<Casilla> apostarHuerfanos(boolean huerfanos, double apuesta, Tablero tab,Usuario usuario) {
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 3; j++) {
                if (tab.getTablero()[i][j] != null && tab.esHuerfano(tab.getTablero()[i][j]) == huerfanos) {
                    Casilla casilla = tab.getTablero()[i][j];
                    casilla.setValor(casilla.getValor() + (10 * apuesta));
                    casillasApostadas.add(casilla);
                }
            }
        }
        if (usuario != null){
            usuario.setCartera(usuario.getCartera() - apuesta);
        }
        return casillasApostadas;
    }

    public List<Casilla> borrarDuplicados(List<Casilla> lista) {
        List<Casilla> listaSinDuplicados = new ArrayList<>();
        listaSinDuplicados = casillasApostadas.stream().distinct().toList();
        return listaSinDuplicados;
    }

    @Override
    public double cobrarGanancias() {
        for (Casilla casilla : casillasApostadas){
            if (casilla.getValor() > 0){
                return casilla.getValor();
            }
        }
        return 0;
    }

    public void resetApuesta() {
        casillasApostadas.clear();
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
    public Usuario dameUsuario(String id){
        for (Usuario usuario: usuarios){
            if (usuario.getId().equalsIgnoreCase(id)){
                return usuario;
            }
        }
        return null;
    }


    //Métodos Tirada


    @Override
    public int resultadoTirada() {
       Tirada tirada = new Tirada();
       return tirada.tirar();
    }




    public String toStringFicheroApuesta(){
        StringBuilder sb = new StringBuilder();
        sb.append("Apuesta: ").append(id).append("\n");
        for (Casilla casilla: casillasApostadas){
            sb.append(casilla.toStringFicheroCasilla()).append("\n");
        }
        return sb.toString();
    }
}
