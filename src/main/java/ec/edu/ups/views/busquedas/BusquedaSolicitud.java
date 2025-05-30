package ec.edu.ups.views.busquedas;

import ec.edu.ups.controllers.Busqueda;
import ec.edu.ups.controllers.ListsController;
import ec.edu.ups.models.SolicitudCompra;
import ec.edu.ups.views.VistaSolicitud;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class BusquedaSolicitud extends Frame {
    //Colores propuestos
    private Color azulPersonalizado = new Color(0,100,128);
    // Textos
    private Label lbVentana;
    //Ingreso
    private TextField txtBusqueda;
    //Botones
    private Button bIr;
    //Paneles
    private Panel header;
    private Panel container;

    private ListsController listsController;
    private Busqueda busqueda = new Busqueda();
    private Resultado resultado;

    public BusquedaSolicitud(ListsController listsController) {
        this.listsController = listsController;

        setLayout(null);
        setSize(400, 300);
        setTitle("Buscar Proveedor");
        setLocationRelativeTo(null);
        setResizable(false);

        lbVentana = new Label("Buscar Numero");
        lbVentana.setFont(new Font("Arial", Font.BOLD, 20));
        lbVentana.setForeground(Color.white);


        header = new Panel();
        header.setBackground(azulPersonalizado);
        header.setLayout(null);
        header.setBounds(0, 0, 400, 100);
        header.add(lbVentana);
        lbVentana.setBounds(20, 15, 600, 100);

        bIr = new Button("ir");
        Label indicacion = new Label("Ingrece el numero:");
        txtBusqueda = new TextField();

        container = new Panel();
        container.setBounds(0, 100, 400, 200);
        container.setLayout(null);

        indicacion.setBounds(100, 10, 200, 25);
        txtBusqueda.setBounds(100, 40, 200, 30);
        bIr.setBounds(100, 100, 200, 40);

        container.add(bIr);
        container.add(indicacion);
        container.add(txtBusqueda);

        add(header);
        add(container);

        // -------------------------- Funcionalidades de Ventana
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });

        // ------------------------- Fuicion como tal
        busqueda = new Busqueda();
        resultado = new Resultado();
        bIr.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int numero = Integer.parseInt(txtBusqueda.getText());
                SolicitudCompra solicitudEncon = busqueda.solicitudPorNumero(listsController.getSolicitudes(),numero);

                if (solicitudEncon == null){
                    System.out.println("No se a encontrado la solicitud");
                    resultado.noEncontrado();
                }else {
                    VistaSolicitud vistaSolicitud =new VistaSolicitud(listsController,solicitudEncon);
                    vistaSolicitud.setVisible(true);
                }
            }
        });
    }
}
