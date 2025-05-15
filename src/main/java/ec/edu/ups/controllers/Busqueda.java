package ec.edu.ups.controllers;

import ec.edu.ups.models.Producto;
import ec.edu.ups.models.Proveedor;
import ec.edu.ups.models.SolicitudCompra;

import java.util.List;

public class Busqueda {
    public Proveedor busquedaPorId(List<Producto> productos,String id){
        for (int i = 0; i < productos.size(); i++) {
            if (id.equals(productos.get(i).getProveedor().getIdentificacion())) {
                return productos.get(i).getProveedor();
            }
        }
        return null;
    }
    public Producto productoPorNombre(List<Producto> productos, String nombre){
        for (Producto producto : productos){
            if(producto.getNombre().equalsIgnoreCase(nombre)){
                return producto;
            }
        }
        return null;
    }
    public SolicitudCompra solicitudPorNumero(List<SolicitudCompra> solicitudes,int numero){
        for (SolicitudCompra solicitud : solicitudes){
            if (solicitud.getIdSolicitud() == numero){
                return solicitud;
            }
        }
        return null;
    }
}
