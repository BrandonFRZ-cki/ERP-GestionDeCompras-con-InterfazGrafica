package ec.edu.ups.views.registros;

import ec.edu.ups.controllers.ListsController;
import ec.edu.ups.models.*;
import ec.edu.ups.views.registros.solicitud.AddDetallePaquete;
import ec.edu.ups.views.registros.solicitud.AddDetalleProducto;

import java.awt.*;
import java.awt.event.*;
import java.util.GregorianCalendar;

public class RegistroSolicitud extends Frame {
    private ListsController listsController;
    private SolicitudCompra solicitudCompra;
    private Color azulPersonalizado = new Color(0, 100, 128);
    private Panel header;
    private Label lbVentana;

    private TextField tfCedSolicitante;
    private TextField tfNombreSolicitante;
    private TextField tfDepartamento;
    private TextField tfFecha;

    private TextArea taMotivo;
    private TextArea taDetalleMat;
    private TextArea taObservacion;
    private TextArea taControl;

    private Button btDetalleProducto;
    private Button btDetallePaquete;
    private Button btGenerarSolicitud;

    private String cedula;
    private int contadorDetalle = 1;

    private AddDetalleProducto addDetalleProducto;
    private AddDetallePaquete addDetallePaquete;

    public RegistroSolicitud(ListsController listsController, String cedula) {
        this.listsController = listsController;
        this.cedula = cedula;

        solicitudCompra = new SolicitudCompra(
                listsController.getSolicitudes().size() + 1,
                obtenerEmpleadoPorCedula(cedula),
                EstadoSolicitud.SOLICITADA,
                "",
                new GregorianCalendar(),
                "",
                ""
        );

        setTitle("Nueva Solicitud");
        setSize(400, 860);
        setLocationRelativeTo(null);
        setLayout(null);
        setResizable(false);

        addDetalleProducto = new AddDetalleProducto(listsController, contadorDetalle, solicitudCompra);
        addDetallePaquete = new AddDetallePaquete(listsController,contadorDetalle, solicitudCompra);

        //---------------------------------------------------------------Encabezado
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

        Label lbSolicitud = new Label("Datos Solicitud:");
        lbSolicitud.setFont(new Font("Tahoma", Font.BOLD, 14));
        lbSolicitud.setBounds(50, 50, 300, 20);
        add(lbSolicitud);

        Label lbSolicitante = new Label("Solicitante:");
        lbSolicitante.setFont(new Font("Tahoma", Font.BOLD, 14));
        lbSolicitante.setBounds(50, 125, 80, 30);
        add(lbSolicitante);

        Label lbCedSolicitante = new Label("Cédula:");
        lbCedSolicitante.setBounds(50, 165, 80, 30);
        add(lbCedSolicitante);
        tfCedSolicitante = new TextField(cedula);
        tfCedSolicitante.setBounds(150, 165, 200, 30);
        tfCedSolicitante.setEditable(false);
        add(tfCedSolicitante);

        Empleado empleadoSeleccionado = obtenerEmpleadoPorCedula(cedula);

        Label lbNombreSolicitante = new Label("Nombre:");
        lbNombreSolicitante.setBounds(50, 205, 80, 30);
        add(lbNombreSolicitante);
        tfNombreSolicitante = new TextField(empleadoSeleccionado.getNombre() + " " + empleadoSeleccionado.getApellido());
        tfNombreSolicitante.setEditable(false);
        tfNombreSolicitante.setBounds(150, 205, 200, 30);
        add(tfNombreSolicitante);

        Label lbDepSolicitante = new Label("Departamento:");
        lbDepSolicitante.setBounds(50, 245, 80, 30);
        add(lbDepSolicitante);
        tfDepartamento = new TextField("" + empleadoSeleccionado.getDepartameto());
        tfDepartamento.setBounds(150, 245, 200, 30);
        tfDepartamento.setEditable(false);
        add(tfDepartamento);

        GregorianCalendar fechaActual = new GregorianCalendar();
        int year = fechaActual.get(GregorianCalendar.YEAR);
        int mes = fechaActual.get(GregorianCalendar.MONTH) + 1;
        int dia = fechaActual.get(GregorianCalendar.DAY_OF_MONTH);
        fechaActual.set(year, mes, dia);
        Label lbFecha = new Label("Fecha:");
        lbFecha.setBounds(50, 285, 80, 30);
        add(lbFecha);
        tfFecha = new TextField(dia + " / " + mes + " / " + year);
        tfFecha.setBounds(150, 285, 200, 30);
        tfFecha.setEditable(false);
        add(tfFecha);

        Label lbMotivo = new Label("Motivo:");
        lbMotivo.setBounds(25, 360, 100, 20);
        add(lbMotivo);
        taMotivo = new TextArea();
        taMotivo.setBounds(25, 380, 350, 75);
        add(taMotivo);

        Label lbDetalleMaterial = new Label("Detalle Material:");
        lbDetalleMaterial.setBounds(25, 460, 100, 20);
        add(lbDetalleMaterial);
        taDetalleMat = new TextArea();
        taDetalleMat.setBounds(25, 485, 350, 75);
        add(taDetalleMat);

        Label lbObservacion = new Label("Observaciones:");
        lbObservacion.setBounds(25, 560, 100, 20);
        add(lbObservacion);
        taObservacion = new TextArea();
        taObservacion.setBounds(25, 580, 350, 75);
        add(taObservacion);

        btDetalleProducto = new Button("Agregar Producto");
        btDetalleProducto.setBounds(50, 660, 150, 30);
        add(btDetalleProducto);
        btDetallePaquete = new Button("Agregar Paquete");
        btDetallePaquete.setBounds(200, 660, 150, 30);
        add(btDetallePaquete);

        taControl = new TextArea();
        taControl.setEditable(false);
        taControl.setBounds(20, 700, 360, 75);
        add(taControl);

        btGenerarSolicitud = new Button("Generar Solicitud");
        btGenerarSolicitud.setBounds(100, 800, 200, 30);
        add(btGenerarSolicitud);

        btDetallePaquete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                contadorDetalle++;
                addDetallePaquete.setVisible(true);
            }
        });

        btDetalleProducto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                contadorDetalle++;
                addDetalleProducto.setVisible(true);
            }
        });

        btGenerarSolicitud.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (taMotivo.getText().isEmpty() || taObservacion.getText().isEmpty() || taDetalleMat.getText().isEmpty()) {
                    taControl.setForeground(Color.RED);
                    taControl.setText("Agregue los datos faltantes");
                } else if (solicitudCompra.getDetalles().isEmpty()) {
                    taControl.setForeground(Color.RED);
                    taControl.setText("Agregue algún detalle (producto o paquete)");
                } else {
                    solicitudCompra.setMotivo(taMotivo.getText());
                    solicitudCompra.setDetalleMaterialesSolcitados(taDetalleMat.getText());
                    solicitudCompra.setObservaciones(taObservacion.getText());

                    listsController.agregarSolicitudCompra(solicitudCompra);
                    dispose();
                }
            }
        });
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dispose();
            }

            @Override
            public void windowActivated(WindowEvent e) {
                mostrarDetallesDeSolicitud();
            }
        });
    }
    private Empleado obtenerEmpleadoPorCedula(String cedula) {
        for (Empleado empleado : listsController.getEmpleados()) {
            if (empleado.getIdentificacion().equals(cedula)) {
                return empleado;
            }
        }
        return new Empleado();
    }
    private void mostrarDetallesDeSolicitud() {
        taControl.setText("");
        taControl.setForeground(new Color(0, 102, 51));
        taControl.append(solicitudCompra.getDetalles()+"\n");
    }
}