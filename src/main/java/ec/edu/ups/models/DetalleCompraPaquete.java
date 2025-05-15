package ec.edu.ups.models;

import java.util.ArrayList;
import java.util.List;


public class DetalleCompraPaquete extends DetalleCompra implements Calculable{
    private List<Producto> productos;
    private double descuento;

    public DetalleCompraPaquete() {
        this.productos = new ArrayList<>();
    }

    public DetalleCompraPaquete(int id, int cantidad, double descuento) {
        super(id, cantidad);
        this.descuento = descuento;

        this.productos = new ArrayList<>();
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    public void addProducto(Producto producto){
        productos.add(producto);
    }

    @Override
    public double generarModificadorDeCosto() {
        return descuento / 100;
    }

    @Override
    public double calcularCostoTotal() {
        double sumaPreciosProductos = 0;
        for (Producto producto : productos) {
            sumaPreciosProductos += producto.getPrecioUnitario();
        }
        double costoTotal = sumaPreciosProductos * generarModificadorDeCosto() * getCantidad();
        return costoTotal;
    }




    @Override
    public String toString() {
        return "⨷ PAQUETE:"+
                super.toString() +
                "| Descuento " + descuento +
                " % |\n Lista de Productos en el paquete : \n" + productos ;
    }
}
