package ec.edu.ups.models;

public class Proveedor extends Persona {
    private String detalleProvedor;
    private Direccion direccion;
    private String telefono;

    public Proveedor() {}

    public Proveedor(String identificacion, String nombre, String apellido, String detalleProvedor, Direccion direccion, String telefono) {
        super(identificacion, nombre, apellido);
        this.detalleProvedor = detalleProvedor;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public String getDetalleProvedor() {
        return detalleProvedor;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    @Override
    public String toString() {
        return  super.toString() +
                "\n\t◌ Detalle   : " + detalleProvedor +
                "\n\t◌ Telefono  : " + telefono+
                "\n\t◌ Direccion : " + direccion;
    }
}