package ec.edu.ups.views.registros.solicitud;

import ec.edu.ups.controllers.ListsController;
import ec.edu.ups.models.DetalleCompraProducto;
import ec.edu.ups.models.Producto;
import ec.edu.ups.models.SolicitudCompra;
import ec.edu.ups.models.UnidadMedida;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

public class AddDetalleProducto extends Frame {
    private ListsController listsController;
    private Color azulPersonalizado = new Color(0, 100, 128);
    private Label lbVentana;
    private Panel header;

    private Choice chProducto;
    private TextField tfCantidad;
    private Choice chUnidadMedida;
    private Button btAgregar;
    private int contadorDetalle;

    private SolicitudCompra solicitudCompra;


    public AddDetalleProducto(ListsController listsController, int contadorDetalle, SolicitudCompra solicitudCompra) {
        this.listsController = listsController;
        this.contadorDetalle = contadorDetalle;
        this.solicitudCompra = solicitudCompra;

        setTitle("Producto");
        setLayout(null);
        setSize(300, 400);
        setLocationRelativeTo(null);
        setResizable(false);

        lbVentana = new Label("Nueva Solicitud");
        lbVentana.setFont(new Font("Arial", Font.BOLD, 20));
        lbVentana.setForeground(Color.white);

        header = new Panel();
        header.setBackground(azulPersonalizado);
        header.setLayout(null);
        header.setBounds(0, 0, 400, 100);
        header.add(lbVentana);
        lbVentana.setBounds(20, 15, 700, 100);

        add(header);

        Label lbAgregar = new Label("Agregar:");
        lbAgregar.setBounds(50, 110, 200, 30);
        add(lbAgregar);
        chProducto = new Choice();
        chProducto.setBounds(50, 140, 200, 30);
        add(chProducto);

        Label lbCantidad = new Label("Cantidad:");
        lbCantidad.setBounds(50, 180, 200, 30);
        add(lbCantidad);
        tfCantidad = new TextField();
        tfCantidad.setBounds(50, 210, 200, 30);
        add(tfCantidad);

        Label lbUnidadMedida = new Label("Unidad Medida:");
        lbUnidadMedida.setBounds(50, 250, 200, 30);
        add(lbUnidadMedida);
        chUnidadMedida = new Choice();
        chUnidadMedida.setBounds(50, 280, 200, 30);
        for (UnidadMedida unidadMedida : UnidadMedida.values()) {
            chUnidadMedida.add(unidadMedida.name());
        }
        add(chUnidadMedida);

        btAgregar = new Button("Agregar");
        btAgregar.setBounds(50, 320, 200, 30);
        add(btAgregar);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
            public void windowActivated(WindowEvent e) {
                actualizarChoice();
            }
        });

        btAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int cantidad = Integer.parseInt(tfCantidad.getText());
                UnidadMedida unidadMedidaSeleccionada = UnidadMedida.valueOf(chUnidadMedida.getSelectedItem());

                Producto productoSeleccionado = null;
                for (Producto producto : listsController.getProductos()) {
                    if (chProducto.getSelectedItem().equals(producto.getNombre())) {
                        productoSeleccionado = producto;
                        break;
                    }
                }
                solicitudCompra.addDetalle(
                        new DetalleCompraProducto(
                                contadorDetalle,
                                cantidad,
                                unidadMedidaSeleccionada,
                                productoSeleccionado
                        )
                );
                tfCantidad.setText("");
                dispose();

            }
        });

    }

    private void actualizarChoice() {
        chProducto.removeAll();
        chProducto.add("Seleccione un producto");
        for (Producto producto : listsController.getProductos()) {
            chProducto.add(producto.getNombre());
        }
    }



}