package ec.edu.ups.views;

import ec.edu.ups.controllers.ListsController;
import ec.edu.ups.models.DetalleCompra;
import ec.edu.ups.models.DetalleCompraPaquete;
import ec.edu.ups.models.DetalleCompraProducto;
import ec.edu.ups.models.SolicitudCompra;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;

public class VistaSolicitud extends Frame {

    private Panel header;
    private Color azulPersonalizado = new Color(0,100,128);
    private Label lbVentana;

    // Campos para llenar con datos
    private TextField tfIdSolicitud;
    private TextField tfSolicitante;
    private TextField tfEstado;
    private TextField tfFecha;
    private TextField tfMotivo;
    private TextField tfDetalle;
    private TextField tfDescuento;
    private TextField tfObservacion;
    private TextField tfTotal;

    private Panel tabla; // Panel para la "tabla"

    private SolicitudCompra solicitudCompra;

    public VistaSolicitud(ListsController listsController, SolicitudCompra solicitudCompra) {
        this.solicitudCompra = solicitudCompra;

        setTitle("Solicitud");
        setSize(900, 750);
        setLayout(null);
        setResizable(false);
        setLocationRelativeTo(null);

        lbVentana = new Label("Solicitud");
        lbVentana.setFont(new Font("Arial", Font.BOLD, 20));
        lbVentana.setForeground(Color.white);
        // ---------------------- Header -------------------------
        header = new Panel();
        header.setLayout(null);
        header.setBackground(azulPersonalizado);
        header.setBounds(0, 0, 900, 100);
        header.add(lbVentana);
        lbVentana.setBounds(20,15,900,100);
        add(header);

        // ---------------------- Campos superiores -------------------------
        Label lbIdSolicitud = new Label("Id solicitud:");
        lbIdSolicitud.setBounds(50, 110, 100, 20);
        add(lbIdSolicitud);
        tfIdSolicitud = new TextField();
        tfIdSolicitud.setBounds(50, 130, 170, 25);
        tfIdSolicitud.setEditable(false);
        add(tfIdSolicitud);

        Label lbSolicitante = new Label("Solicitante:");
        lbSolicitante.setBounds(250, 110, 100, 20);
        add(lbSolicitante);
        tfSolicitante = new TextField();
        tfSolicitante.setBounds(250, 130, 170, 25);
        tfSolicitante.setEditable(false);
        add(tfSolicitante);

        Label lbEstado = new Label("Estado:");
        lbEstado.setBounds(440, 110, 100, 20);
        add(lbEstado);
        tfEstado = new TextField();
        tfEstado.setBounds(440, 130, 170, 25);
        tfEstado.setEditable(false);
        add(tfEstado);

        Label lbFecha = new Label("Fecha:");
        lbFecha.setBounds(640, 110, 100, 20);
        add(lbFecha);
        tfFecha = new TextField();
        tfFecha.setBounds(640, 130, 170, 25);
        tfFecha.setEditable(false);
        add(tfFecha);

        Label lbMotivo = new Label("Motivo:");
        lbMotivo.setBounds(50, 160, 50, 20);
        add(lbMotivo);
        tfMotivo = new TextField();
        tfMotivo.setBounds(50, 180, 800, 25);
        tfMotivo.setEditable(false);
        add(tfMotivo);

        Label lbDetalle = new Label("Detalle:");
        lbDetalle.setBounds(50, 210, 50, 20);
        add(lbDetalle);
        tfDetalle = new TextField();
        tfDetalle.setBounds(50, 230, 800, 25);
        tfDetalle.setEditable(false);
        add(tfDetalle);

        // ---------------------- Tabla simulada -------------------------
        tabla = new Panel(null);
        tabla.setBackground(new Color(220, 220, 220));
        tabla.setBounds(50, 275, 800, 300);

        Label lbDescuento = new Label("Descuento:");
        lbDescuento.setBounds(560, 210, 80, 20); // Debajo del campo de Precio Unitario
        tabla.add(lbDescuento);

        tfDescuento = new TextField();
        tfDescuento.setBounds(10, 200, 100, 25); // Alineado con Precio Compra
        tfDescuento.setEditable(false);
        tabla.add(tfDescuento);

        add(tabla);

        // ---------------------- Observación -------------------------
        Label lbObservacion = new Label("Observacion:");
        lbObservacion.setBounds(50, 620, 100, 20);
        add(lbObservacion);
        tfObservacion = new TextField();
        tfObservacion.setBounds(50, 640, 800, 30);
        tfObservacion.setEditable(false);
        add(tfObservacion);

        // ---------------------- Total -------------------------
        Label lbTotal = new Label("Total:");
        lbTotal.setBounds(650, 600, 50, 20);
        add(lbTotal);
        tfTotal = new TextField();
        tfTotal.setBounds(700, 600, 100, 30);
        tfTotal.setEditable(false);
        add(tfTotal);

        cargarDatosSolicitud();

        // ---------------------- Cierre ventana -------------------------
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
    }

    private void cargarDatosSolicitud() {
        SimpleDateFormat fecha = new SimpleDateFormat("dd/MM/yyyy");

        // Campos superiores
        tfIdSolicitud.setText(String.valueOf(solicitudCompra.getIdSolicitud()));
        tfSolicitante.setText(solicitudCompra.getSolicitante() != null ? solicitudCompra.getSolicitante().getNombre() : "");
        tfEstado.setText(solicitudCompra.getEstado() != null ? solicitudCompra.getEstado().toString() : "");
        tfFecha.setText(solicitudCompra.getFechaCreacion() != null ? fecha.format(solicitudCompra.getFechaCreacion().getTime()) : "");
        tfMotivo.setText(solicitudCompra.getMotivo());
        tfDetalle.setText(solicitudCompra.getDetalleMaterialesSolcitados());
        tfObservacion.setText(solicitudCompra.getObservaciones());
        tfTotal.setText("$ " + solicitudCompra.calcularCostoTotal());

        // Descuento solo si hay detalle tipo paquete
        double descuentoTotal = 0;
        for (DetalleCompra detalle : solicitudCompra.getDetalles()) {
            if (detalle instanceof DetalleCompraPaquete) {
                descuentoTotal += ((DetalleCompraPaquete) detalle).getDescuento();
            }
        }
        tfDescuento.setText(descuentoTotal > 0 ? String.format("%.2f %%", descuentoTotal) : "0 %");

        // Limpiar tabla
        tabla.removeAll();

        // Columnas
        String[] columnas = {"Id", "Cantidad", "Unidad Medida", "Detalle", "Precio Unitario", "Precio Compra"};
        int[] x = {10, 90, 170, 270, 560, 650};
        int ancho = 70;

        // Añadir encabezados
        for (int i = 0; i < columnas.length; i++) {
            Label col = new Label(columnas[i]);
            col.setBounds(x[i], 10, 100, 20);
            tabla.add(col);
        }

        // Mostrar cada detalle
        int y = 40;
        for (DetalleCompra detalle : solicitudCompra.getDetalles()) {
            TextField tfId = new TextField(String.valueOf(detalle.getId()));
            tfId.setBounds(x[0], y, 50, 25);
            tfId.setEditable(false);
            tabla.add(tfId);

            TextField tfCantidad = new TextField(String.valueOf(detalle.getCantidad()));
            tfCantidad.setBounds(x[1], y, 50, 25);
            tfCantidad.setEditable(false);
            tabla.add(tfCantidad);

            String unidadMedida = "";
            String detalleDesc = "";
            String precioUnitario = "";
            String precioCompra = "";

            if (detalle instanceof DetalleCompraProducto) {
                DetalleCompraProducto detalleCompraProducto = (DetalleCompraProducto) detalle;
                unidadMedida = detalleCompraProducto.getUnidadMedida() != null ? detalleCompraProducto.getUnidadMedida().toString() : "";
                detalleDesc = detalleCompraProducto.getProducto() != null ? detalleCompraProducto.getProducto().getNombre() : "";
                precioUnitario = detalleCompraProducto.getProducto() != null ? String.format("%.2f", detalleCompraProducto.getProducto().getPrecioUnitario()) : "";
                precioCompra = String.format("%.2f", detalleCompraProducto.calcularCostoTotal());

            } else if (detalle instanceof DetalleCompraPaquete) {
                DetalleCompraPaquete detalleCompraPaquete = (DetalleCompraPaquete) detalle;
                unidadMedida = "Paquete";
                // Mostrar descripción personalizada según el ID del paquete
                int idPaquete = detalleCompraPaquete.getId();
                if (idPaquete == 4) {
                    detalleDesc = "Tintas para impresión a color";
                } else if (idPaquete == 5) {
                    detalleDesc = "Materiales médicos básicos para botiquín";
                } else {
                    detalleDesc = "Productos: " + detalleCompraPaquete.getProductos().size();
                }

                precioUnitario = "-";
                precioCompra = String.format("%.2f", detalleCompraPaquete.calcularCostoTotal());
            }

            TextField tfUnidad = new TextField(unidadMedida);
            tfUnidad.setBounds(x[2], y, 80, 25);
            tfUnidad.setEditable(false);
            tabla.add(tfUnidad);

            TextField tfDetalle = new TextField(detalleDesc);
            tfDetalle.setBounds(x[3], y, 280, 25);
            tfDetalle.setEditable(false);
            tabla.add(tfDetalle);

            TextField tfPrecioUnitario = new TextField(precioUnitario);
            tfPrecioUnitario.setBounds(x[4], y, 80, 25);
            tfPrecioUnitario.setEditable(false);
            tabla.add(tfPrecioUnitario);

            TextField tfPrecioCompra = new TextField(precioCompra);
            tfPrecioCompra.setBounds(x[5], y, 80, 25);
            tfPrecioCompra.setEditable(false);
            tabla.add(tfPrecioCompra);

            y += 30;
        }

        tabla.repaint();
        tabla.revalidate();
    }
}