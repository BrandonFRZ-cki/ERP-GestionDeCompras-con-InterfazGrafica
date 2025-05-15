package ec.edu.ups.models;

public class Empleado extends Persona {
    private Departamento departameto;

    public Empleado(){

    }

    public Empleado(Departamento departameto) {
        this.departameto = departameto;
    }

    public Empleado(String identificacion, String nombre, String apellido, Departamento departameto) {
        super(identificacion, nombre, apellido);
        this.departameto = departameto;
    }

    public Departamento getDepartameto() {
        return departameto;
    }

    public void setDepartameto(Departamento departameto) {
        this.departameto = departameto;
    }



    @Override
    public String toString() {
        return super.getNombre()+" "+super.getApellido()+". Empleado" +
                " de " + departameto;
    }
}
