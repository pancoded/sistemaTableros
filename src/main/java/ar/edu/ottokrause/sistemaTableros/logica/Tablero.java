package ar.edu.ottokrause.sistemaTableros.logica;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.io.Serializable;

@Entity
public class Tablero implements Serializable {

    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_TABLERO") 
    private int id; // IDENTIFICADOR DEL TABLERO

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "ENUM('DISPONIBLE', 'PRESTADO', 'MANTENIMIENTO') DEFAULT 'DISPONIBLE'", name = "ESTADO_TABLERO", nullable = false)
    private EstadoTablero estado; // ESTADO DEL TABLERO

    @ManyToOne
    @JoinColumn(name = "ID_PRESTAMO", nullable = true) 
    private Prestamo prestamo; // RELACION CON PRESTAMO N A 1

    public Tablero(EstadoTablero estado, String descripcion, Prestamo prestamo) {
        this.estado = estado;
        this.prestamo = prestamo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public EstadoTablero getEstado() {
        return estado;
    }

    public void setEstado(EstadoTablero estado) {
        this.estado = estado;
    }

    public Prestamo getPrestamo() {
        return prestamo;
    }

    public void setPrestamo(Prestamo prestamo) {
        this.prestamo = prestamo;
    }

    @Override
    public String toString() {
        return "Tablero{" + "id=" + id + ", estado=" + estado + ", prestamo=" + prestamo + '}';
    }

}
