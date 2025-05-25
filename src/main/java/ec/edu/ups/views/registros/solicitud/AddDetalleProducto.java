package ec.edu.ups.views.registros.solicitud;

import ec.edu.ups.controllers.ListsController;
import ec.edu.ups.models.DetalleCompraProducto;
import ec.edu.ups.models.Producto;
import ec.edu.ups.models.UnidadMedida;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class AddDetalleProducto extends Frame {
    private ListsController listsController;
    private Color azulPersonalizado = new Color(0, 100, 128);
    private Label lbVentana;
    private Panel header;
    private TextArea taControl;

    private Choice chProducto;
    private TextField tfCantidad;
    private Choice chUnidadMedida;
    private Button btAgregar;
    private int contadorDetalle;

    private DetalleCompraProducto detalleProducto;

    public AddDetalleProducto(ListsController listsController, int contadorDetalle,TextArea taControl) {
        this.listsController = listsController;
        this.contadorDetalle = contadorDetalle;
        this.taControl = taControl;

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
                try {
                    int cantidad = Integer.parseInt(tfCantidad.getText());
                    UnidadMedida unidadMedidaSeleccionada = UnidadMedida.valueOf(chUnidadMedida.getSelectedItem());

                    Producto productoSeleccionado = null;
                    for (Producto producto : listsController.getProductos()) {
                        if (chProducto.getSelectedItem().equals(producto.getNombre())) {
                            productoSeleccionado = producto;
                            break;
                        }
                    }

                    if (productoSeleccionado == null) {
                        taControl.setForeground(Color.RED);
                        taControl.setText(taControl.getText() + "\nERROR: Debe seleccionar un producto válido.");
                        return;
                    }

                    detalleProducto = new DetalleCompraProducto(
                            contadorDetalle,
                            cantidad,
                            unidadMedidaSeleccionada,
                            productoSeleccionado
                    );

                    taControl.setForeground(new Color(0, 102, 51));
                    taControl.setText(taControl.getText() + "\nProducto agregado correctamente: " + productoSeleccionado.getNombre());

                    tfCantidad.setText("");
                    dispose();

                } catch (NumberFormatException ex) {
                    taControl.setForeground(Color.RED);
                    taControl.setText(taControl.getText() + "\nERROR: Ingrese un número válido en la cantidad.");
                } catch (IllegalArgumentException ex) {
                    taControl.setForeground(Color.RED);
                    taControl.setText(taControl.getText() + "\nERROR: Seleccione una unidad de medida válida.");
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

    public DetalleCompraProducto getDetalleProducto() {
        return detalleProducto;
    }


}