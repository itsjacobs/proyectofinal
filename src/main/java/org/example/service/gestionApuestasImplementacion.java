package org.example.service;

import lombok.Data;
import org.example.dao.ApuestaImplementacion;
import org.example.dao.daoApuesta;
import org.example.domain.ApuestasUsuario;
import org.example.domain.Casilla;
import org.example.domain.Tablero;
import org.example.domain.Usuario;
import java.util.List;

@Data
public class gestionApuestasImplementacion implements gestionApuestas {
    private daoApuesta daoApuesta;

    public gestionApuestasImplementacion(ApuestaImplementacion daoApuestaImplementacion) {
        this.daoApuesta = daoApuestaImplementacion;
    }
    public gestionApuestasImplementacion(daoApuesta daoApuesta) {
        this.daoApuesta = daoApuesta;
    }

    public gestionApuestasImplementacion() {
        this.daoApuesta = new ApuestaImplementacion();
    }


    //Métodos de Apuestas


    @Override
    public List<Casilla> apostarNumero(int numero, double apuesta, Tablero tab, Usuario usuario) {
        return daoApuesta.apostarNumero(numero, apuesta, tab,usuario);
    }

    @Override
    public List<Casilla> apostarFila(int fila, double apuesta, Tablero tab,Usuario usuario) {
        return daoApuesta.apostarFila(fila, apuesta, tab,usuario);
    }

    @Override
    public List<Casilla> apostarDocena(int docena, double apuesta, Tablero tab,Usuario usuario) {
        return daoApuesta.apostarDocena(docena, apuesta, tab,usuario);
    }


    @Override
    public List<Casilla> apostarColor(boolean color,double apuesta, Tablero tab, Usuario usuario) {
        return daoApuesta.apostarColor(color, apuesta,tab, usuario);
    }

    @Override
    public List<Casilla> apostarMayor( boolean mayor,double apuesta, Tablero tab, Usuario usuario) {
        return daoApuesta.apostarMayor( mayor,apuesta,tab, usuario);
    }

    @Override
    public List<Casilla> apostarPar(boolean par, double apuesta, Tablero tab, Usuario usuario) {
        return daoApuesta.apostarPar(par, apuesta, tab, usuario);
    }

    @Override
    public List<Casilla> apostarHuerfanos(boolean huerfanos, double apuesta, Tablero tab, Usuario usuario) {
        return daoApuesta.apostarHuerfanos(huerfanos, apuesta, tab,usuario);
    }

    @Override
    public void terminarApuestas(Usuario usuarioLogado, Tablero tab) {
        daoApuesta.terminarApuestas(usuarioLogado, tab);
    }

    @Override
    public List<Casilla> borrarDuplicados(List<Casilla> casillasApostadas) {
        return daoApuesta.borrarDuplicados(casillasApostadas);
    }

    @Override
    public String getApuesta() {
        return daoApuesta.getApuesta();
    }


    //Métodos de Usuario


    @Override
    public List<Usuario> listaUsuarios() {
        return daoApuesta.listaUsuarios();
    }

    @Override
    public void mostrarUsuariosDesdeFicheroBinario() {
        daoApuesta.mostrarUsuariosDesdeFicheroBinario();
    }

    @Override
    public boolean iniciarSesion(String id, String contraseña) {
        return daoApuesta.iniciarSesion(id, contraseña);
    }

    @Override
    public boolean registrarse(String id, String nombre, String contraseña,double cartera) {
        return daoApuesta.registrarse(id, nombre, contraseña,cartera);
    }

    @Override
    public Usuario dameUsuario(String id) {
        return daoApuesta.dameUsuario(id);
    }

    @Override
    public double ingresarDinero(String id, double dinero) {
        return daoApuesta.ingresarDinero(id, dinero);
    }



    //Métodos de Tirada


    @Override
    public int resultadoTirada() {
        return daoApuesta.resultadoTirada();
    }


    //Métodos ApuestasUsuario

    @Override
    public List<ApuestasUsuario> ordenarApuestas(){
        return daoApuesta.ordenarApuestas();
    }


}

