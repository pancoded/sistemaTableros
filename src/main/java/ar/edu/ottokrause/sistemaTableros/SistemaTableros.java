package ar.edu.ottokrause.sistemaTableros;

import ar.edu.ottokrause.sistemaTableros.gui.Principal;
import ar.edu.ottokrause.sistemaTableros.logica.Controladora;

public class SistemaTableros {

    public static void main(String[] args) {

        
        Principal princ = new Principal();
        princ.setVisible(true);
        
        /*
        

        LinkedList<Tablero> listaTableros = new LinkedList<Tablero>();
        LinkedList<Tablero> listaTableros2 = new LinkedList<Tablero>();

        // Crear usuario
        Usuario usu = new Usuario("Nicolás", "López", "47574911", TipoUsuario.ALUMNO);
        Usuario usu2 = new Usuario("José", "López", "18356332", TipoUsuario.PROFESOR);
        control.crearUsuario(usu);
        control.crearUsuario(usu2);

        // Crear prestamo
        Prestamo pre = new Prestamo(EstadoPrestamo.RETRASADO, new Date(), "", listaTableros, usu);
        Prestamo pre2 = new Prestamo(EstadoPrestamo.ACTIVO, new Date(), "", listaTableros2, usu2);
        
        control.crearPrestamo(pre);
        control.crearPrestamo(pre2);

        // Crear tablero, asociándolo correctamente con el prestamo
        Tablero tab = new Tablero("Pizzini", "Chico", EstadoTablero.PRESTADO, "", pre);
        Tablero tab2 = new Tablero("Pizzini", "Grande", EstadoTablero.PRESTADO, "", pre2);
        Tablero tab3 = new Tablero("Pizzini", "Grande", EstadoTablero.PRESTADO, "", pre2);
        Tablero tab4 = new Tablero("Pizzini", "Chico", EstadoTablero.PRESTADO, "", pre2);
        Tablero tab5 = new Tablero("Pizzini", "Chico", EstadoTablero.PRESTADO, "", pre2);
        
        control.crearTablero(tab);
        control.crearTablero(tab2);
        control.crearTablero(tab3);
        control.crearTablero(tab4);
        control.crearTablero(tab5);
        
        // Aquí puedes agregar tab a listaTableros si es necesario
        listaTableros.add(tab);
        listaTableros2.add(tab2);
        listaTableros2.add(tab3);
        listaTableros2.add(tab4);
        listaTableros2.add(tab5);

        // Si necesitas agregar el tablero al prestamo también, puedes hacerlo:
        pre.setTableros(listaTableros);
        pre2.setTableros(listaTableros);
        
        control.editarPrestamo(pre);
        control.editarPrestamo(pre2); */

    }
}
