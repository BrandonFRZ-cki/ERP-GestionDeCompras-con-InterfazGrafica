package ec.edu.ups.views.registros;

import ec.edu.ups.controllers.ListsController;
import ec.edu.ups.models.Direccion;
import ec.edu.ups.models.Producto;
import ec.edu.ups.models.Proveedor;

import java.awt.*;
import java.awt.event.*;

public class RegistroProveedor extends Frame {
    private TextField tfNombreProveedor;
    private TextField tfApellidoProveedor;
    private TextField tfDetalleProveedor;
    private TextField tfTelefonoProveedor;
    private TextField tfIdProveedor;
    private TextField tfCalle1;
    private TextField tfCalleSec;
    private TextField tfNumeracion;
    private TextField tfCiudad;
    private TextField tfProvincia;
    private TextField tfPais;

    private TextArea taControl;
    private Button btGuardar;
    private Choice chProducto = new Choice();

    private ListsController listsController;

    private Panel header;
    private Color azulPersonalizado = new Color(0,100,128);
    private Label lbVentana;

    public RegistroProveedor(ListsController listsController) {
        this.listsController = listsController;

        setTitle("Registro Proveedor");
        setSize(400, 800);
        setLocationRelativeTo(null);
        setLayout(null);
        setResizable(false);

        //---------------------------------------------------------------Encabezado
        lbVentana = new Label("Registrar Proveedor");
        lbVentana.setFont(new Font("Arial", Font.BOLD, 20));
        lbVentana.setForeground(Color.white);


        header = new Panel();
        header.setBackground(azulPersonalizado);
        header.setLayout(null);
        header.setBounds(0,0,400,100);
        header.add(lbVentana);
        lbVentana.setBounds(20,15,700,100);

        add(header);


        Label lbProveedor = new Label("Datos del Proveedor:");
        lbProveedor.setFont(new Font("Tahoma", Font.BOLD, 14));
        lbProveedor.setBounds(50, 50, 300, 20);
        add(lbProveedor);

        Label lbIdProveedorDetalle = new Label("ID:");
        lbIdProveedorDetalle.setBounds(50, 125, 80, 30);
        add(lbIdProveedorDetalle);
        tfIdProveedor = new TextField();
        tfIdProveedor.setBounds(150, 125, 200, 30);
        add(tfIdProveedor);

        Label lbNombreProveedor = new Label("Nombre:");
        lbNombreProveedor.setBounds(50, 165, 80, 30);
        add(lbNombreProveedor);
        tfNombreProveedor = new TextField();
        tfNombreProveedor.setBounds(150, 165, 200, 30);
        add(tfNombreProveedor);

        Label lbApellidoProveedor = new Label("Apellido:");
        lbApellidoProveedor.setBounds(50, 205, 80, 30);
        add(lbApellidoProveedor);
        tfApellidoProveedor = new TextField();
        tfApellidoProveedor.setBounds(150, 205, 200, 30);
        add(tfApellidoProveedor);

        Label lbDetalleProveedor = new Label("Detalle:");
        lbDetalleProveedor.setBounds(50, 245, 80, 30);
        add(lbDetalleProveedor);
        tfDetalleProveedor = new TextField();
        tfDetalleProveedor.setBounds(150, 245, 200, 30);
        add(tfDetalleProveedor);

        Label lbTelefonoProveedor = new Label("Teléfono:");
        lbTelefonoProveedor.setBounds(50, 285, 80, 30);
        add(lbTelefonoProveedor);
        tfTelefonoProveedor = new TextField();
        tfTelefonoProveedor.setBounds(150, 285, 200, 30);
        add(tfTelefonoProveedor);

        Label lbDireccion = new Label("Dirección del Proveedor:");
        lbDireccion.setFont(new Font("Tahoma", Font.BOLD, 14));
        lbDireccion.setBounds(50, 330, 200, 20);
        add(lbDireccion);

        Label lbCalle1 = new Label("Calle Principal:");
        lbCalle1.setBounds(50, 360, 100, 20);
        add(lbCalle1);
        tfCalle1 = new TextField();
        tfCalle1.setBounds(150, 360, 200, 30);
        add(tfCalle1);

        Label lbCalleSec = new Label("Calle Secun...:");
        lbCalleSec.setBounds(50, 400, 100, 20);
        add(lbCalleSec);
        tfCalleSec = new TextField();
        tfCalleSec.setBounds(150, 400, 200, 30);
        add(tfCalleSec);

        Label lbNumeracion = new Label("Numeracion:");
        lbNumeracion.setBounds(50, 440, 100, 20);
        add(lbNumeracion);
        tfNumeracion = new TextField();
        tfNumeracion.setBounds(150, 440, 200, 30);
        add(tfNumeracion);

        Label lbCiudad = new Label("Ciudad:");
        lbCiudad.setBounds(50, 480, 100, 20);
        add(lbCiudad);
        tfCiudad = new TextField();
        tfCiudad.setBounds(150, 480, 200, 30);
        add(tfCiudad);

        Label lbProvincia = new Label("Provincia:");
        lbProvincia.setBounds(50, 520, 100, 20);
        add(lbProvincia);
        tfProvincia = new TextField();
        tfProvincia.setBounds(150, 520, 200, 30);
        add(tfProvincia);

        Label lbPais = new Label("Pais:");
        lbPais.setBounds(50, 560, 100, 20);
        add(lbPais);
        tfPais = new TextField();
        tfPais.setBounds(150, 560, 200, 30);
        add(tfPais);

        Label lbProducto = new Label("Asignar:");
        lbProducto.setBounds(50, 600, 100, 20);
        add(lbProducto);
        chProducto.setBounds(150, 600, 200, 30);
        actualizarChoice();
        add(chProducto);


        taControl = new TextArea();
        taControl.setEditable(false);
        taControl.setBounds(20,640,360,95);
        add(taControl);


        btGuardar = new Button("Guardar");
        btGuardar.setBounds(150, 740, 100, 30);
        add(btGuardar);

        btGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String productoSeleccionado = chProducto.getSelectedItem();
                if(datosProveedorIncompletos()) {
                    taControl.setText("Complete los datos del proveedor");
                    taControl.setForeground(Color.RED);
                    return;
                }
                if (productoSeleccionado.equals("Productos Sin Proveedor")) {
                    taControl.setText("Seleccione un producto antes de guardar.");
                    taControl.setForeground(Color.RED);
                    return;
                }
                Proveedor nuevoProveedor = new Proveedor(
                        tfIdProveedor.getText(),
                        tfNombreProveedor.getText(),
                        tfApellidoProveedor.getText(),
                        tfDetalleProveedor.getText(),
                        new Direccion(
                                tfCalle1.getText(),
                                tfCalleSec.getText(),
                                tfNumeracion.getText(),
                                tfCiudad.getText(),
                                tfProvincia.getText(),
                                tfPais.getText()
                        ),
                        tfTelefonoProveedor.getText()
                );

                for (Producto producto : listsController.getProductos()) {
                    if (producto.getNombre().equals(productoSeleccionado)) {
                        producto.setProveedor(nuevoProveedor);
                        taControl.setText("Proveedor asignado correctamente a " + productoSeleccionado);
                        taControl.setForeground(new Color(0, 102, 51));
                        return;
                    }
                }
            }
        });
        // -------------------------- Funcionalidades de Ventana
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dispose();
            }
            @Override
            public void windowActivated(WindowEvent e) {
                actualizarChoice();
            }
        });


    }
    private void actualizarChoice(){
        chProducto.removeAll();
        chProducto.add("Productos Sin Proveedor");
        for (int i = 0; i < listsController.getProductos().size(); i++) {
            if(listsController.getProductos().get(i).getProveedor().getNombre()== null){
                chProducto.add(listsController.getProductos().get(i).getNombre());
            }
        }
    }
    private boolean datosProveedorIncompletos() {
        return tfIdProveedor.getText().isEmpty()||tfNombreProveedor.getText().isEmpty()||tfApellidoProveedor.getText().isEmpty()||tfDetalleProveedor.getText().isEmpty()
                ||tfTelefonoProveedor.getText().isEmpty()||tfCalle1.getText().isEmpty()||tfCalleSec.getText().isEmpty()||tfNumeracion.getText().isEmpty()||tfCiudad.getText().isEmpty()||tfProvincia.getText().isEmpty()||tfPais.getText().isEmpty();
    }
}
