package ec.edu.ups.views.registros;

import ec.edu.ups.controllers.ListsController;
import ec.edu.ups.models.Direccion;
import ec.edu.ups.models.Empleado;
import ec.edu.ups.models.Producto;
import ec.edu.ups.models.Proveedor;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class RegistroSolicitud extends Frame {
    private TextField tfCedSolicitante;
    private TextField tfNombreSolicitante;
    private TextField tfDepartamento;
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
    private String cedula;

    private Panel header;
    private Color azulPersonalizado = new Color(0,100,128);
    private Label lbVentana;


    public RegistroSolicitud(ListsController listsController, String cedula) {
        this.listsController = listsController;
        this.cedula = cedula;

        setTitle("Nueva Solicitud");
        setSize(400, 800);
        setLocationRelativeTo(null);
        setLayout(null);
        setResizable(false);

        //---------------------------------------------------------------Encabezado
        lbVentana = new Label("Nueva Solicitud");
        lbVentana.setFont(new Font("Arial", Font.BOLD, 20));
        lbVentana.setForeground(Color.white);


        header = new Panel();
        header.setBackground(azulPersonalizado);
        header.setLayout(null);
        header.setBounds(0,0,400,100);
        header.add(lbVentana);
        lbVentana.setBounds(20,15,700,100);

        add(header);


        Label lbSolicitud = new Label("Datos Solicitud:");
        lbSolicitud.setFont(new Font("Tahoma", Font.BOLD, 14));
        lbSolicitud.setBounds(50, 50, 300, 20);
        add(lbSolicitud);


        Label lbSolicitante = new Label("Solicitante:");
        lbSolicitante.setFont(new Font("Tahoma", Font.BOLD, 14));
        lbSolicitante.setBounds(50, 125, 80, 30);
        add(lbSolicitante);

        Label lbCedSolicitante = new Label("Cedula:");
        lbCedSolicitante.setBounds(50, 165, 80, 30);
        add(lbCedSolicitante);
        tfCedSolicitante = new TextField(cedula);
        tfCedSolicitante.setBounds(150, 165, 200, 30);
        tfCedSolicitante.setEditable(false);
        add(tfCedSolicitante);

        Empleado empleadoSeleccionado = new Empleado();
        for (int i = 0; i < listsController.getEmpleados().size(); i++) {
            if(listsController.getEmpleados().get(i).getIdentificacion().equals(cedula)) {
                empleadoSeleccionado = listsController.getEmpleados().get(i);
            }
        }
        Label lbNombreSolicitante = new Label("Nombre:");
        lbNombreSolicitante.setBounds(50, 205, 80, 30);
        add(lbNombreSolicitante);
        tfNombreSolicitante = new TextField(empleadoSeleccionado.getNombre());
        tfNombreSolicitante.setEditable(false);
        tfNombreSolicitante.setBounds(150, 205, 200, 30);
        add(tfNombreSolicitante);

        Label lbDepSolicitante = new Label("Departamento:");
        lbDepSolicitante.setBounds(50, 245, 80, 30);
        add(lbDepSolicitante);
        tfDepartamento = new TextField(""+empleadoSeleccionado.getDepartameto());
        tfDepartamento.setBounds(150, 245, 200, 30);
        tfDepartamento.setEditable(false);
        add(tfDepartamento);

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
        add(chProducto);


        taControl = new TextArea();
        taControl.setEditable(false);
        taControl.setBounds(20,640,360,95);
        add(taControl);


        btGuardar = new Button("Guardar");
        btGuardar.setBounds(150, 740, 100, 30);
        add(btGuardar);


        //setVisible(true);
    }
}
