package ar.edu.ottokrause.sistemaTableros.persistencia;

import ar.edu.ottokrause.sistemaTableros.logica.Prestamo;
import ar.edu.ottokrause.sistemaTableros.logica.Tablero;
import ar.edu.ottokrause.sistemaTableros.logica.Usuario;
import ar.edu.ottokrause.sistemaTableros.persistencia.exceptions.IllegalOrphanException;
import ar.edu.ottokrause.sistemaTableros.persistencia.exceptions.NonexistentEntityException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ControladoraPersistencia {

    // -------------------------------------  USUARIO  -----------------------------------------------
    UsuarioJpaController uJpa = new UsuarioJpaController();

    public void crearUsuario(Usuario u) {
        uJpa.create(u);
    }

    public void eliminarUsuario(int id) {
        try {
            uJpa.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void editarUsuario(Usuario u) {
        try {
            uJpa.edit(u);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Usuario traerUsuario(int id) {
        return uJpa.findUsuario(id);
    }

    public ArrayList<Usuario> traerListaUsuarios() {
        return new ArrayList<>(uJpa.findUsuarioEntities());
    }

    // -------------------------------------  TABLERO  -----------------------------------------------
    TableroJpaController tJpa = new TableroJpaController();

    public void crearTablero(Tablero t) {
        tJpa.create(t);
    }

    public void eliminarTablero(int id) {
        try {
            tJpa.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void editarTablero(Tablero t) {
        try {
            tJpa.edit(t);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Tablero traerTablero(int id) {
        return tJpa.findTablero(id);
    }

    public ArrayList<Tablero> traerListaTableros() {
        return new ArrayList<>(tJpa.findTableroEntities());
    }

    // -------------------------------------  PRESTAMO  -----------------------------------------------
    PrestamoJpaController pJpa = new PrestamoJpaController();

    public void crearPrestamo(Prestamo p) {
        pJpa.create(p);
    }

    public void eliminarPrestamo(int id) {
        try {
            pJpa.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void editarPrestamo(Prestamo p) {
        try {
            pJpa.edit(p);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Prestamo traerPrestamo(int id) {
        return pJpa.findPrestamo(id);
    }

    public ArrayList<Prestamo> traerListaPrestamos() {
        return new ArrayList<>(pJpa.findPrestamoEntities());
    }

}
