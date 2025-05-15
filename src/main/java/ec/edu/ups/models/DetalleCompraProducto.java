package ec.edu.ups.models;

public class DetalleCompraProducto extends DetalleCompra implements Calculable {
    private UnidadMedida unidadMedida;
    private Producto producto;

    public DetalleCompraProducto() {

    }

    public DetalleCompraProducto(int id, int cantidad, UnidadMedida unidadMedida, Producto producto) {
        super(id, cantidad);
        this.unidadMedida = unidadMedida;
        this.producto = producto;
    }

    public UnidadMedida getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(UnidadMedida unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    @Override
    public double generarModificadorDeCosto() {
        if (producto.isAplicaIVA()) {
            return 1.15;
        } else {
            return 1.0;
        }
    }

    @Override
    public double calcularCostoTotal() {
        double costoTotal = producto.getPrecioUnitario() * getCantidad() * generarModificadorDeCosto();
        return costoTotal;
    }



    @Override
    public String toString() {
        return  super.toString()+
                "| " + unidadMedida +
                " | \n\t" + producto ;
    }
}
