package org.example.dao;

import org.example.commons.ACartera;
import org.example.commons.Comprobaciones;
import org.example.commons.Constantes;
import org.example.domain.*;

import java.util.*;

import lombok.Data;

@Data
public class ApuestaImplementacion implements daoApuesta {
    private String id;
    private List<Casilla> casillasApostadas;
    private List<Usuario> usuarios;
    private List<ApuestasUsuario> apuestasUsuario;
    private String apuesta;
    private StringBuilder sb = new StringBuilder();

    public ApuestaImplementacion() {
        Random rnd = new Random();
        this.casillasApostadas = new ArrayList<>();
        this.id = String.valueOf(rnd.nextInt(0, 10));
        this.usuarios = Ficheros.leerFicheroUsuario(Constantes.USUARIO_FILE);
    }

    //Metodos Apuestas


    @Override
    public List<Casilla> apostarNumero(int numeros, double apuesta, Tablero tab, Usuario usuario) {
        try {
            Comprobaciones.comprobarCartera(usuario.getCartera(), apuesta);
        } catch (ACartera e) {
            System.out.println("No tienes suficiente dinero en la cartera para realizar esta apuesta.");
            return new ArrayList<>();
        }

        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 3; j++) {
                Casilla casilla = tab.getTablero()[i][j];
                if (casilla != null && casilla.getNumero() == numeros) {
                    casilla.setValor(casilla.getValor() + (36 * apuesta));
                    casillasApostadas.add(casilla);

                }
            }
        }
        sb.append(numeros).append(",");
        if (usuario != null) {
            usuario.setCartera(usuario.getCartera() - apuesta);
        }

        return casillasApostadas;
    }

    @Override
    public List<Casilla> apostarFila(int fila, double apuesta, Tablero tab, Usuario usuario) {
        try {
            Comprobaciones.comprobarCartera(usuario.getCartera(), apuesta);
        } catch (ACartera e) {
            System.out.println("No tienes suficiente dinero en la cartera para realizar esta apuesta.");
            return new ArrayList<>();
        }
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 3; j++) {
                Casilla casilla = tab.getTablero()[i][j];
                if (tab.getTablero()[i][j] != null && tab.queFila(tab.getTablero()[i][j]) == fila) {
                    casilla.setValor(casilla.getValor() + (3 * apuesta));
                    casillasApostadas.add(casilla);

                }
            }
        }
        sb.append(fila).append(",");
        if (usuario != null) {
            usuario.setCartera(usuario.getCartera() - apuesta);
        }
        return casillasApostadas;
    }

    @Override
    public List<Casilla> apostarDocena(int docena, double apuesta, Tablero tab, Usuario usuario) {
        try {
            Comprobaciones.comprobarCartera(usuario.getCartera(), apuesta);
        } catch (ACartera e) {
            System.out.println("No tienes suficiente dinero en la cartera para realizar esta apuesta.");
            return new ArrayList<>();
        }
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 3; j++) {
                if (tab.getTablero()[i][j] != null && tab.queDocena(tab.getTablero()[i][j]) == docena) {
                    Casilla casilla = tab.getTablero()[i][j];
                    casilla.setValor(casilla.getValor() + (3 * apuesta));
                    casillasApostadas.add(casilla);

                }
            }
        }
        sb.append(docena).append(",");
        usuario.setCartera(usuario.getCartera() - apuesta);
        return casillasApostadas;
    }

    @Override
    public List<Casilla> apostarColor(boolean color, double apuesta, Tablero tab, Usuario usuario) {
        try {
            Comprobaciones.comprobarCartera(usuario.getCartera(), apuesta);
        } catch (ACartera e) {
            System.out.println("No tienes suficiente dinero en la cartera para realizar esta apuesta.");
            return new ArrayList<>();
        }
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 3; j++) {
                Casilla casilla = tab.getTablero()[i][j];
                if (casilla != null && casilla.isColor() == color) {
                    casilla.setValor(casilla.getValor() + (2 * apuesta));
                    casillasApostadas.add(casilla);


                }
            }
        }
        if (color) {
            sb.append("rojo").append(",");
        } else {
            sb.append("negro").append(",");
        }

        if (usuario != null) {
            usuario.setCartera(usuario.getCartera() - apuesta);
        }
        return casillasApostadas;
    }

    @Override
    public List<Casilla> apostarMayor(boolean mayor, double apuesta, Tablero tab, Usuario usuario) {
        try {
            Comprobaciones.comprobarCartera(usuario.getCartera(), apuesta);
        } catch (ACartera e) {
            System.out.println("No tienes suficiente dinero en la cartera para realizar esta apuesta.");
            return new ArrayList<>();
        }
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 3; j++) {
                if (tab.getTablero()[i][j] != null && tab.esMayor(tab.getTablero()[i][j]) == mayor) {
                    Casilla casilla = tab.getTablero()[i][j];
                    casilla.setValor(casilla.getValor() + (2 * apuesta));
                    casillasApostadas.add(casilla);

                }
            }
        }
        if (mayor) {
            sb.append("mayor").append(",");
        } else {
            sb.append("menor").append(",");
        }
        usuario.setCartera(usuario.getCartera() - apuesta);
        return casillasApostadas;
    }

    @Override
    public List<Casilla> apostarPar(boolean par, double apuesta, Tablero tab, Usuario usuario) {
        try {
            Comprobaciones.comprobarCartera(usuario.getCartera(), apuesta);
        } catch (ACartera e) {
            System.out.println("No tienes suficiente dinero en la cartera para realizar esta apuesta.");
            return new ArrayList<>();
        }
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 3; j++) {
                if (tab.getTablero()[i][j] != null && tab.esPar(tab.getTablero()[i][j]) == par) {
                    Casilla casilla = tab.getTablero()[i][j];
                    casilla.setValor(casilla.getValor() + (2 * apuesta));
                    casillasApostadas.add(casilla);

                }
            }
        }
        if (par) {
            sb.append("par").append(",");
        } else {
            sb.append("impar").append(",");
        }
        if (usuario != null) {
            usuario.setCartera(usuario.getCartera() - apuesta);
        }
        return casillasApostadas;
    }

    @Override
    public List<Casilla> apostarHuerfanos(boolean huerfanos, double apuesta, Tablero tab, Usuario usuario) {
        try {
            Comprobaciones.comprobarCartera(usuario.getCartera(), apuesta);
        } catch (ACartera e) {
            System.out.println("No tienes suficiente dinero en la cartera para realizar esta apuesta.");
            return new ArrayList<>();
        }
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 3; j++) {
                if (tab.getTablero()[i][j] != null && tab.esHuerfano(tab.getTablero()[i][j]) == huerfanos) {
                    Casilla casilla = tab.getTablero()[i][j];
                    casilla.setValor(casilla.getValor() + (10 * apuesta));
                    casillasApostadas.add(casilla);

                }
            }
        }

        if (usuario != null) {
            usuario.setCartera(usuario.getCartera() - apuesta);
        }
        return casillasApostadas;
    }

    @Override
    public String getApuesta() {
        apuesta = sb.toString();
        return apuesta;
    }

    public List<Casilla> borrarDuplicados(List<Casilla> lista) {
        List<Casilla> listaSinDuplicados = new ArrayList<>();
        listaSinDuplicados = casillasApostadas.stream().distinct().toList();
        return listaSinDuplicados;
    }

    public void resetApuesta() {
        casillasApostadas.clear();
    }

    //Metodos Usuario

    @Override
    public List<Usuario> listaUsuarios() {
        return usuarios;
    }

    @Override
    public void mostrarUsuariosDesdeFicheroBinario() {
        List<Usuario> usuarios = Ficheros.leerFicheroBinario(Constantes.BINARIO_FILE);
        if (usuarios != null && !usuarios.isEmpty()) {
            usuarios.forEach(System.out::println);
        } else {
            System.out.println("No se encontraron usuarios en el fichero binario.");
        }
    }

    @Override
    public boolean iniciarSesion(String id, String contraseña) {
        Usuario usuario = new Usuario(id, contraseña);
        boolean a = false;
        List<Usuario> comprobacion = usuarios.stream().filter(u -> u.getId().equalsIgnoreCase(usuario.getId())).filter(u -> u.getContraseña().equals(usuario.getContraseña())).toList();
        if (!comprobacion.isEmpty()) {
            a = true;
            usuario.inicioSesion(usuario);
        }
        return a;
    }

    @Override
    public boolean registrarse(String id, String nombre, String contrasena, double cartera) {
        boolean a = false;
        Usuario usuario = new Usuario(id, nombre, contrasena, cartera);
        List<Usuario> comprobacion = usuarios.stream().filter(u -> u.getId().equalsIgnoreCase(usuario.getId())).toList();
        if (comprobacion.isEmpty()) {
            a = usuarios.add(usuario);
        }
        return a;
    }

    @Override
    public Usuario dameUsuario(String id) {
        for (Usuario usuario : usuarios) {
            if (usuario.getId().equalsIgnoreCase(id)) {
                return usuario;
            }
        }
        return null;
    }

    @Override
    public double ingresarDinero(String id, double dinero) {
        Usuario usuario = dameUsuario(id);
        if (usuario != null) {
            usuario.setCartera(usuario.getCartera() + dinero);
            return usuario.getCartera();
        } else {
            throw new IllegalArgumentException("Usuario no encontrado");
        }
    }

    @Override
    public void terminarApuestas(Usuario usuario, Tablero tab) {
        int resultado = resultadoTirada();
        Tirada tirada = new Tirada(resultado);
        ArrayList<Tirada> listaTiradas = new ArrayList<>();
        apuestasUsuario = new ArrayList<>();
        listaTiradas.add(tirada);
        Ficheros.escribirFicheroTirada(Constantes.TIRADA_FILE, listaTiradas);
        System.out.println(Constantes.GANADORA + resultado);

        //Comprobamos si la casilla ganadora es una de las apostadas. Si es as, mostramos el mensaje de que ha ganado y la cantidad ganada
        int finalResultado = resultado;
        Casilla casillaGanadora = getCasillasApostadas().stream().filter(casilla -> casilla.getNumero() == finalResultado).findFirst().orElse(null);
        if (casillaGanadora != null && casillaGanadora.getValor() > 0) {
            System.out.println(Constantes.GANADORACARTERA + casillaGanadora.getValor() + "€");
            usuario.setCartera(usuario.getCartera() + casillaGanadora.getValor());
            List<ApuestasUsuario> apuestasUsuario = Ficheros.leerFicheroApuestasUsuario(Constantes.APUESTASUSUARIO_FILE);
            apuestasUsuario.add(new ApuestasUsuario(usuario.getNombre(), casillaGanadora.getValor(), getApuesta()));
            Ficheros.escribirFicheroApuestasUsuario(Constantes.APUESTASUSUARIO_FILE, apuestasUsuario);

        } else {
            System.out.println(Constantes.PERDEDORA);
            sb.setLength(0);
        }
        resetApuesta();
        resultado = resultadoTirada();
        tab.rellenarTablero();
    }

    //Métodos Tirada


    @Override
    public int resultadoTirada() {
        Tirada tirada = new Tirada();
        return tirada.tirar();
    }

    //Métodos ApuestaUsuario
    @Override
    public List<ApuestasUsuario> ordenarApuestas() {
        apuestasUsuario = Ficheros.leerFicheroApuestasUsuario(Constantes.APUESTASUSUARIO_FILE);
        Comparator<ApuestasUsuario> com = new Comparator<ApuestasUsuario>() {
            public int compare(ApuestasUsuario i, ApuestasUsuario j) {
                return Double.compare(j.getGanancia(), i.getGanancia());
            }
        };
        return apuestasUsuario.stream().sorted(com).toList();
    }
}