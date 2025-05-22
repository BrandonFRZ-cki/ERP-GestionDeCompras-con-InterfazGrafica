package ec.edu.ups.views.listados;

import java.awt.*;

import ec.edu.ups.controllers.ListsController;
import ec.edu.ups.models.Producto;
import ec.edu.ups.models.SolicitudCompra;
import ec.edu.ups.views.VistaSolicitud;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

public class ListadoSolicitudes extends Frame {
    private ListsController listsController;

    //Colores propuestos
    private Color azulPersonalizado = new Color(0,100,128);
    private Color grisPersonalizado = new Color(217,217,217);

    // Textos
    private Label lbVentana;

    //Paneles
    private Panel header;
    private TextArea textArea;

    //Boton
    private Button bAcceder;
    private TextField tfSolicitud;



    public ListadoSolicitudes(ListsController listsController) {
        this.listsController = listsController;

        setTitle("Listado");
        setSize(700, 550);
        setLocationRelativeTo(null);
        setLayout(null);
        setResizable(false);

        lbVentana = new Label("Listado Solicitudes");
        lbVentana.setFont(new Font("Arial", Font.BOLD, 20));
        lbVentana.setForeground(Color.white);

        header = new Panel();
        header.setBackground(azulPersonalizado);
        header.setLayout(null);
        header.setBounds(0,0,700,100);
        header.add(lbVentana);
        lbVentana.setBounds(20,15,700,100);


        textArea = new TextArea();
        textArea.setBounds(50,150,600,300);
        textArea.setBackground(grisPersonalizado);

        List<SolicitudCompra> solicitudes = listsController.getSolicitudes();

        for (SolicitudCompra solicitudCompra : solicitudes) {
            textArea.append(solicitudCompra.toString() + "\n");
        }

        textArea.setEditable(false);
        add(header);
        add(textArea);

        // -------------------------- Funcionalidades de Ventana
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dispose();
            }

            @Override
            public void windowActivated(WindowEvent e) {
                actualizarList();
            }
        });

        bAcceder = new Button("Acceder");
        tfSolicitud = new TextField();
        tfSolicitud.setBounds(350,475,100,25);
        bAcceder.setBounds(250,475,100,25);


        add(tfSolicitud);
        add(bAcceder);

        VistaSolicitud vistaSolicitud = new VistaSolicitud(listsController);
        bAcceder.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vistaSolicitud.setVisible(true);
            }
        });
    }
    public void actualizarList() {
        textArea.setText(""); // Limpiar el área
        List<SolicitudCompra> lista = listsController.getSolicitudes();
        for (SolicitudCompra solicitud : lista) {
            textArea.append(solicitud.toString() + "\n");
        }
    }
}

