package ec.edu.ups.models;

import java.util.Objects;

public abstract class DetalleCompra implements Calculable {
    private int id;
    private int cantidad;

    public DetalleCompra(){

    }

    public DetalleCompra(int id, int cantidad) {
        this.id = id;
        this.cantidad = cantidad;

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public abstract double generarModificadorDeCosto();


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        DetalleCompra that = (DetalleCompra) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return  "\n\t | n# : " + id +
                " | Cantidad : " + cantidad +
                " | ";
    }
}
