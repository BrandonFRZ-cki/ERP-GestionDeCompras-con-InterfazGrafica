package ec.edu.ups.models;

import java.util.Objects;

public class Producto{
    private String idProducto;
    private String nombre;
    private double precioUnitario;
    private boolean aplicaIVA;
    private Proveedor proveedor;

    public Producto(String idProducto, String nombre, double precioUnitario, boolean aplicaIVA, Proveedor proveedor) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.precioUnitario = precioUnitario;
        this.aplicaIVA = aplicaIVA;
        this.proveedor = proveedor;
    }

    public String getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(String idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public boolean isAplicaIVA() {
        return aplicaIVA;
    }

    public void setAplicaIVA(boolean aplicaIVA) {
        this.aplicaIVA = aplicaIVA;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Producto producto = (Producto) o;
        return Objects.equals(idProducto, producto.idProducto);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(idProducto);
    }

    @Override
    public String toString() {
        return    "\t\t ● Producto:" +
                "\n\t\t ○ id---------------: " + idProducto +
                "\n\t\t ○ Nombre-----------: " + nombre +
                "\n\t\t ○ precioUnitario---: " + precioUnitario +
                "\n\t\t ○ aplicaIVA--------: " + aplicaIVA +
                "\n\t\t ○ proveedor--------: " + proveedor +
        "\n\t-------------------------------------------------------------\n";
    }
}