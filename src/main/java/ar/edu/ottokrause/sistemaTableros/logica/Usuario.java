package ar.edu.ottokrause.sistemaTableros.logica;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import java.io.Serializable;

@Entity
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_USUARIO")
    private int id; // IDENTIFICADOR DE USUARIO

    @NotBlank(message = "El nombre no puede estar vacío")
    @Column(name = "NOMBRE", nullable = false)
    private String nombre; // NOMBRE DE USUARIO

    @NotBlank(message = "El apellido no puede estar vacío")
    @Column(name = "APELLIDO", nullable = false)
    private String apellido; // APELLIDO DE USUARIO
    
    @Enumerated(EnumType.STRING)
    @Column(name = "TIPO_USUARIO", nullable = false)
    private TipoUsuario tipoUsuario; // TIPO DE USUARIO
    
    @Column(name = "CURSO", nullable = false)
    private String curso; // CURSO (EN CASO DE SER ALUMNO)

    public Usuario(){
        
    }
    
    public Usuario(String nombre, String apellido, String curso, TipoUsuario tipoUsuario) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.curso = curso;
        this.tipoUsuario = tipoUsuario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }
    
    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", tipoUsuario=" + tipoUsuario + '}';
    }
}
