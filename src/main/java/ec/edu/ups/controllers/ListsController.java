package ec.edu.ups.controllers;

import ec.edu.ups.models.Empleado;
import ec.edu.ups.models.Producto;
import ec.edu.ups.models.SolicitudCompra;
import ec.edu.ups.views.ShowConsole;

import java.util.ArrayList;
import java.util.List;

public class ListsController {
    private List<Producto> productos;
    private List<Empleado> empleados;
    private List<SolicitudCompra> solicitudes;
    private ShowConsole showConsole;

    public ListsController() {
        this.productos = new ArrayList<>();
        this.empleados = new ArrayList<>();
        this.solicitudes = new ArrayList<>();
        this.showConsole = new ShowConsole();
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public List<Empleado> getEmpleados() {
        return empleados;
    }

    public List<SolicitudCompra> getSolicitudes() {
        return solicitudes;
    }

    public void setSolicitudes(List<SolicitudCompra> solicitudes) {
        this.solicitudes = solicitudes;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    public void setEmpleados(List<Empleado> empleados) {
        this.empleados = empleados;
    }

    public void agregarProducto(Producto producto) {
        productos.add(producto);
        showConsole.showMessage("\n\t* Producto agregado exitosamente\n\t* Lista de Productos Modificada");
    }
    public void agregarEmpleado(Empleado empleado) {
        empleados.add(empleado);
        showConsole.showMessage("\n\t* Empleado agregado exitosamente\n\t* Lista de Empleados Modificada");
    }
    public void agregarSolicitudCompra(SolicitudCompra solicitud){
        solicitudes.add(solicitud);
        showConsole.showMessage("\n\t* Solicitud agregada exitosamente\n\t* Solicitud de Compra Modificada");
    }

}