package ar.edu.ottokrause.sistemaTableros.logica;

import ar.edu.ottokrause.sistemaTableros.persistencia.ControladoraPersistencia;
import java.util.ArrayList;

public class Controladora {

    ControladoraPersistencia controlPersis = new ControladoraPersistencia();

    // -------------------------------------  USUARIO  -----------------------------------------------

    /**
     * Alta de un usuario en la bdd
     * @param u :Usuario a dar de alta
     */
    public void crearUsuario(Usuario u) {
        controlPersis.crearUsuario(u);
    }

    /**
     * Baja de un usuario de la bdd
     * @param id :Identificador del usuario a eleminar
     */
    public void eliminarUsuario(int id) {
        controlPersis.eliminarUsuario(id);
    }

    /**
     * Modificación de un usuario de la bdd
     * @param u :Usuario a editar
     */
    public void editarUsuario(Usuario u) {
        controlPersis.editarUsuario(u);
    }

    /**
     * Busca y trae un usuario de la bdd mediante su {@code id}
     * @param id :Identificador del usuario a buscar
     * @return {@code Usuario} que tenga la {@code id} asignada
     */
    public Usuario traerUsuario(int id) {
        return controlPersis.traerUsuario(id);
    }

    /**
     * Trae una lista de usuarios de la bdd
     * @return ArrayList de {@code Usuario}
     */
    public ArrayList<Usuario> traerListaUsuarios() {
        return controlPersis.traerListaUsuarios();
    }

    // -------------------------------------  TABLERO  -----------------------------------------------

    /**
     * Alta de un tablero en la bdd
     * @param t :Tablero a dar de alta
     */
    public void crearTablero(Tablero t) {
        controlPersis.crearTablero(t);
    }

    /**
     * Baja de un tablero de la bdd
     * @param id :Identificador del tablero a eleminar
     */
    public void eliminarTablero(int id) {
        controlPersis.eliminarTablero(id);
    }

    /**
     * Modificación de un tablero de la bdd
     * @param t :Tablero a editar
     */
    public void editarTablero(Tablero t) {
        controlPersis.editarTablero(t);
    }

    /**
     * Busca y trae un tablero de la bdd mediante su {@code id}
     * @param id Identificador del tablero a buscar
     * @return {@code Tablero} que tenga la {@code id} asignada
     */
    public Tablero traerTablero(int id) {
        return controlPersis.traerTablero(id);
    }

    /**
     * Trae una lista de tableros de la bdd
     * @return ArrayList de {@code Tablero}
     */
    public ArrayList<Tablero> traerListaTableros() {
        return controlPersis.traerListaTableros();
    }

    // -------------------------------------  PRESTAMO  -----------------------------------------------

    /**
     * Alta de un Prestamo en la bdd
     * @param p Prestamo a dar de alta
     */
    public void crearPrestamo(Prestamo p) {
        controlPersis.crearPrestamo(p);
    }

    /**
     * Baja de un prestamo de la bdd
     * @param id :Identificador del prestamo a eleminar
     */
    public void eliminarPrestamo(int id) {
        controlPersis.eliminarPrestamo(id);
    }

    /**
     * Modificación de un prestamo de la bdd
     * @param p Prestamo a editar
     */
    public void editarPrestamo(Prestamo p) {
        controlPersis.editarPrestamo(p);
    }

    /**
     * Busca y trae un prestamo de la bdd mediante su {@code id}
     * @param id :Identificador del prestamo a buscar
     * @return {@code Prestamo} que tenga la {@code id} asignada
     */
    public Prestamo traerPrestamo(int id) {
        return controlPersis.traerPrestamo(id);
    }

    /**
     * Trae una lista de prestamos de la bdd
     * @return ArrayList de {@code Prestamo}
     */
    public ArrayList<Prestamo> traerListaPrestamos() {
        return controlPersis.traerListaPrestamos();
    }
}
