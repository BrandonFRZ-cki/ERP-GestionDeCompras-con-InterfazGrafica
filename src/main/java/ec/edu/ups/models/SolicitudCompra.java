package ec.edu.ups.models;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Objects;

public class SolicitudCompra implements Calculable {
    private int idSolicitud;
    private GregorianCalendar fechaCreacion;
    private Empleado solicitante;
    private EstadoSolicitud estado;
    private String motivo;
    private String detalleMaterialesSolcitados;
    private String observaciones;
    private List<DetalleCompra> detalles;
    private double total;


    public SolicitudCompra(){
        detalles = new ArrayList<>();
    }

    public SolicitudCompra(int idSolicitud, Empleado solicitante, EstadoSolicitud estado, String motivo, GregorianCalendar fechaCreacion, String detalleMaterialesSolcitados, String observaciones) {
        this.idSolicitud = idSolicitud;
        this.solicitante = solicitante;
        this.estado = estado;
        this.motivo = motivo;
        this.fechaCreacion = fechaCreacion;
        this.detalleMaterialesSolcitados = detalleMaterialesSolcitados;
        this.observaciones = observaciones;
        detalles = new ArrayList<>();
    }

    public int getIdSolicitud() {
        return idSolicitud;
    }

    public void setIdSolicitud(int idSolicitud) {
        this.idSolicitud = idSolicitud;
    }

    public Empleado getSolicitante() {
        return solicitante;
    }

    public void setSolicitante(Empleado solicitante) {
        this.solicitante = solicitante;
    }

    public EstadoSolicitud getEstado() {
        return estado;
    }

    public void setEstado(EstadoSolicitud estado) {
        this.estado = estado;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public GregorianCalendar getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(GregorianCalendar fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getDetalleMaterialesSolcitados() {
        return detalleMaterialesSolcitados;
    }

    public void setDetalleMaterialesSolcitados(String detalleMaterialesSolcitados) {
        this.detalleMaterialesSolcitados = detalleMaterialesSolcitados;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public List<DetalleCompra> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<DetalleCompra> detalles) {
        this.detalles = detalles;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getTotal() {
        return total;
    }

    public void addDetalle(DetalleCompra detalle){
        this.detalles.add(detalle);
    }




    @Override
    public double calcularCostoTotal() {
        double total = 0;
        for (DetalleCompra detalle : detalles) {
            total += detalle.calcularCostoTotal();
        }
        return total;
    }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        SolicitudCompra that = (SolicitudCompra) o;
        return idSolicitud == that.idSolicitud && Objects.equals(solicitante, that.solicitante) && estado == that.estado && Objects.equals(motivo, that.motivo) && Objects.equals(fechaCreacion, that.fechaCreacion) && Objects.equals(detalleMaterialesSolcitados, that.detalleMaterialesSolcitados) && Objects.equals(observaciones, that.observaciones) && Objects.equals(detalles, that.detalles) && Objects.equals(total, that.total);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idSolicitud, solicitante, estado, motivo, fechaCreacion, detalleMaterialesSolcitados, observaciones, detalles, total);
    }

    @Override
    public String toString() {
        return    "\n=================== Solicitud de Compra ======================" +
                "\n\t = Fecha-----------------: " + (fechaCreacion != null ? new SimpleDateFormat("dd/MM/yyyy").format(fechaCreacion.getTime()) : "null") +
                "\n\t = Numero de Solicitud---: " + idSolicitud +
                "\n\t = Solicitante-----------: " + solicitante +
                "\n\t = Estado----------------: " + estado +
                "\n\t-------------------------------------------------------------"+
                "\n\t - Motivo  : " + motivo +
                "\n\t - Detalle : " + detalleMaterialesSolcitados +
                "\n\t+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++"+
                "\n\t " + detalles +
                "\n\t-++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++"+
                "\n\t observaciones : " + observaciones+
                "\n\t-------------------------------------------------------------"+
                "\n\t Total = " + total+
                "\n\t-------------------------------------------------------------"
        ;

    }
}
