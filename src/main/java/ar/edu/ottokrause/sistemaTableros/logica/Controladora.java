package ar.edu.ottokrause.sistemaTableros.logica;

import ar.edu.ottokrause.sistemaTableros.persistencia.ControladoraPersistencia;
import java.util.ArrayList;

public class Controladora {

    ControladoraPersistencia controlPersis = new ControladoraPersistencia();

    // -------------------------------------  USUARIO  -----------------------------------------------
    public void crearUsuario(Usuario u) {
        controlPersis.crearUsuario(u);
    }

    public void eliminarUsuario(int id) {
        controlPersis.eliminarUsuario(id);
    }

    public void editarUsuario(Usuario u) {
        controlPersis.editarUsuario(u);
    }

    public Usuario traerUsuario(int id) {
        return controlPersis.traerUsuario(id);
    }

    public ArrayList<Usuario> traerListaUsuarios() {
        return controlPersis.traerListaUsuarios();
    }

    // -------------------------------------  TABLERO  -----------------------------------------------
    public void crearTablero(Tablero t) {
        controlPersis.crearTablero(t);
    }

    public void eliminarTablero(int id) {
        controlPersis.eliminarTablero(id);
    }

    public void editarTablero(Tablero t) {
        controlPersis.editarTablero(t);
    }

    public Tablero traerTablero(int id) {
        return controlPersis.traerTablero(id);
    }

    public ArrayList<Tablero> traerListaTableros() {
        return controlPersis.traerListaTableros();
    }

    // -------------------------------------  PRESTAMO  -----------------------------------------------
    public void crearPrestamo(Prestamo p) {
        controlPersis.crearPrestamo(p);
    }

    public void eliminarPrestamo(int id) {
        controlPersis.eliminarPrestamo(id);
    }

    public void editarPrestamo(Prestamo p) {
        controlPersis.editarPrestamo(p);
    }

    public Prestamo traerPrestamo(int id) {
        return controlPersis.traerPrestamo(id);
    }

    public ArrayList<Prestamo> traerListaPrestamos() {
        return controlPersis.traerListaPrestamos();
    }
}
