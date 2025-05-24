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
import java.util.GregorianCalendar;

public class RegistroSolicitud extends Frame {
    private TextField tfCedSolicitante;
    private TextField tfNombreSolicitante;
    private TextField tfDepartamento;
    private TextField tfFecha;
    private TextArea taMotivo;
    private TextArea tfDetalleMat;
    private TextArea taObservacion;

    private TextArea taControl;
    private Button btGuardar;
    private Choice chProducto = new Choice();

    private ListsController listsController;
    private String cedula;

    private Panel header;
    private Color azulPersonalizado = new Color(0,100,128);
    private Label lbVentana;


    public
    RegistroSolicitud(ListsController listsController, String cedula) {
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
        tfNombreSolicitante = new TextField(empleadoSeleccionado.getNombre()+" "+empleadoSeleccionado.getApellido());
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

        GregorianCalendar gregorianCalendar =  new GregorianCalendar();
        int year = gregorianCalendar.get(GregorianCalendar.YEAR);
        int mes = gregorianCalendar.get(GregorianCalendar.MONTH)+1;
        int dia = gregorianCalendar.get(GregorianCalendar.DAY_OF_MONTH);
        Label lbFecha = new Label("Fecha:");
        lbFecha.setBounds(50, 285, 80, 30);
        add(lbFecha);
        tfFecha = new TextField(dia+" / "+mes+" / "+year);
        tfFecha.setBounds(150, 285, 200, 30);
        tfFecha.setEditable(false);
        add(tfFecha);

        Label lbDetalle = new Label("Detalle:");
        lbDetalle.setFont(new Font("Tahoma", Font.BOLD, 14));
        lbDetalle.setBounds(50, 330, 200, 20);
        add(lbDetalle);

        Label lbMotivo = new Label("Motivo:");
        lbMotivo.setBounds(25, 360, 100, 20);
        add(lbMotivo);
        taMotivo = new TextArea();
        taMotivo.setBounds(25, 380, 350, 75);
        add(taMotivo);

        Label lbDetalleMaterial = new Label("Detalle Material:");
        lbDetalleMaterial.setBounds(25, 460, 100, 20);
        add(lbDetalleMaterial);
        tfDetalleMat = new TextArea();
        tfDetalleMat.setBounds(25, 485, 350, 75);
        add(tfDetalleMat);

        Label lbObservacion = new Label("Observaciones:");
        lbObservacion.setBounds(25, 560, 100, 20);
        add(lbObservacion);

        taObservacion = new TextArea();
        taObservacion.setBounds(25, 580, 350, 75);
        add(taObservacion);

        btGuardar = new Button("Agregar Porductos o Paquetes");
        btGuardar.setBounds(50, 660, 300, 30);
        add(btGuardar);

        taControl = new TextArea();
        taControl.setEditable(false);
        taControl.setBounds(20,700,360,75);
        add(taControl);



        //setVisible(true);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
    }
}
