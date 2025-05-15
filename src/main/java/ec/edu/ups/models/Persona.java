package ec.edu.ups.models;

import java.util.Objects;

public class Persona {
    private String identificacion;
    private String nombre;
    private String apellido;

    public Persona() {

    }

    public Persona(String identificacion, String nombre, String apellido) {
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
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

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Persona persona = (Persona) o;
        return Objects.equals(identificacion, persona.identificacion);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(identificacion);
    }

    @Override
    public String toString() {
        return  "\n\t\t\t◌ Identificacion='" + identificacion +
                "\n\t\t\t◌ nombre='" + nombre +
                "\n\t\t\t◌ apellido='" + apellido ;
    }
}
