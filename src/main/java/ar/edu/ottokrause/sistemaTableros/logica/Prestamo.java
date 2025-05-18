package ar.edu.ottokrause.sistemaTableros.logica;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
public class Prestamo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PRESTAMO")
    private int id; // ESTADO DEL TABLERO

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "ENUM('ACTIVO', 'INACTIVO', 'RETRASADO') DEFAULT 'ACTIVO'", name = "ESTADO_PRESTAMO", nullable = false)
    private EstadoPrestamo estadoPrestamo; // ESTADO DEL PRESTAMO

    @Temporal(TemporalType.DATE)
    @Column(name = "FECHA_PRESTAMO", nullable = false)
    private Date fechaPrestamo; // FECHA DEL PRESTAMO

    @OneToMany(mappedBy = "prestamo")
    private List<Tablero> tableros; // RELACION CON TABLERO 1 A N

    @OneToOne(optional = false)
    @JoinColumn(name = "ID_USUARIO", nullable = false)
    private Usuario usuario; // RELACION CON USUARIO 1 A 1

    public Prestamo() {
    }

    public Prestamo(EstadoPrestamo estadoPrestamo, Date fechaPrestamo, List<Tablero> tableros, Usuario usuario) {
        this.estadoPrestamo = estadoPrestamo;
        this.fechaPrestamo = fechaPrestamo;
        this.tableros = tableros;
        this.usuario = usuario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public EstadoPrestamo getEstadoPrestamo() {
        return estadoPrestamo;
    }

    public void setEstadoPrestamo(EstadoPrestamo estadoPrestamo) {
        this.estadoPrestamo = estadoPrestamo;
    }

    public Date getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(Date fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public List<Tablero> getTableros() {
        return tableros;
    }

    public void setTableros(List<Tablero> tableros) {
        this.tableros = tableros;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return "Prestamo{" + "id=" + id + ", estadoPrestamo=" + estadoPrestamo + ", fechaPrestamo=" + fechaPrestamo + '\'' + ", tableros=" + tableros + ", usuario=" + usuario + '}';
    }
}
