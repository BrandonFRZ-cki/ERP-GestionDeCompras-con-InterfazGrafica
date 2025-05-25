package ec.edu.ups.views.registros.solicitud;

import ec.edu.ups.controllers.ListsController;
import ec.edu.ups.models.DetalleCompraPaquete;
import ec.edu.ups.models.Producto;
import ec.edu.ups.models.SolicitudCompra;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

public class AddDetallePaquete extends Frame {
    private ListsController listsController;
    private Color azulPersonalizado = new Color(0, 100, 128);
    private Label lbVentana;
    private Panel header;

    private Choice chProducto;
    private TextField tfCantidadPaquetes;
    private TextField tfDescuento;
    private Button btAgregarProducto;
    private Button btConfirmarPaquete;
    private TextArea taControl;
    private int contadorDetalle;

    private SolicitudCompra solicitudCompra;
    private List<Producto> productosSeleccionados;

    public AddDetallePaquete(ListsController listsController, int contadorDetalle, SolicitudCompra solicitudCompra) {
        this.listsController = listsController;
        this.contadorDetalle = contadorDetalle;
        this.solicitudCompra = solicitudCompra;
        this.productosSeleccionados = new ArrayList<>();

        setTitle("Agregar Paquete");
        setLayout(null);
        setSize(350, 550);
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

        Label lbProducto = new Label("Seleccione producto:");
        lbProducto.setBounds(50, 110, 200, 30);
        add(lbProducto);
        chProducto = new Choice();
        chProducto.setBounds(50, 140, 200, 30);
        add(chProducto);

        btAgregarProducto = new Button("Agregar Producto");
        btAgregarProducto.setBounds(50, 180, 200, 30);
        add(btAgregarProducto);

        Label lbCantidad = new Label("Cantidad paquetes:");
        lbCantidad.setBounds(50, 220, 200, 30);
        add(lbCantidad);
        tfCantidadPaquetes = new TextField();
        tfCantidadPaquetes.setBounds(50, 250, 200, 30);
        add(tfCantidadPaquetes);

        Label lbDescuento = new Label("Descuento:");
        lbDescuento.setBounds(50, 290, 200, 30);
        add(lbDescuento);
        tfDescuento = new TextField();
        tfDescuento.setBounds(50, 320, 200, 30);
        add(tfDescuento);

        Label lbListaProductos = new Label("Productos en el paquete:");
        lbListaProductos.setBounds(50, 360, 200, 30);
        add(lbListaProductos);
        taControl = new TextArea();
        taControl.setBounds(50, 390, 250, 80);
        taControl.setEditable(false);
        add(taControl);

        btConfirmarPaquete = new Button("Confirmar Paquete");
        btConfirmarPaquete.setBounds(50, 480, 200, 30);
        add(btConfirmarPaquete);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
            public void windowActivated(WindowEvent e) {
                actualizarChoice();
            }
        });

        btAgregarProducto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Producto productoSeleccionado = null;
                for (Producto producto : listsController.getProductos()) {
                    if (chProducto.getSelectedItem().equals(producto.getNombre())) {
                        productoSeleccionado = producto;
                        break;
                    }
                }

                if (productoSeleccionado != null) {
                    productosSeleccionados.add(productoSeleccionado);
                    taControl.append(productoSeleccionado.getNombre() + "\n");
                    System.out.println("Producto agregado: " + productoSeleccionado.getNombre()); // Debug
                }
            }
        });

        btConfirmarPaquete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int cantidadPaquetes = Integer.parseInt(tfCantidadPaquetes.getText());
                double descuento = Double.parseDouble(tfDescuento.getText());

                if (!productosSeleccionados.isEmpty()) {
                    DetalleCompraPaquete detalle = new DetalleCompraPaquete(
                            contadorDetalle,
                            cantidadPaquetes,
                            descuento
                    );
                    detalle.setProductos(new ArrayList<>(productosSeleccionados));
                    solicitudCompra.addDetalle(detalle);

                    tfCantidadPaquetes.setText("");
                    tfDescuento.setText("");
                    taControl.setText("");
                    productosSeleccionados.clear();
                    dispose();
                } else {
                    taControl.append("Debe agregar al menos un producto.\n");
                }
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