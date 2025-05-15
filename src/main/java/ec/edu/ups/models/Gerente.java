package ec.edu.ups.models;

public class Gerente extends Empleado {
    private String pssw;

    public Gerente() {

    }

    public Gerente(String identificacion, String nombre, String apellido, Departamento departameto, String pssw) {
        super(identificacion, nombre, apellido, departameto);
        this.pssw = pssw;
    }

    public String getPssw() {
        return pssw;
    }

    public void setPssw(String pssw) {
        this.pssw = pssw;
    }

    @Override
    public String toString() {
        return "Gerente{" +
                "pssw='" + pssw + '\'' +
                '}';
    }
}
