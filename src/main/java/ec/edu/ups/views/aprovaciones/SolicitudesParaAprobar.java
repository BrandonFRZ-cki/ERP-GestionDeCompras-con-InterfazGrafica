package ec.edu.ups.views.aprovaciones;

import ec.edu.ups.controllers.ListsController;
import ec.edu.ups.models.EstadoSolicitud;
import ec.edu.ups.models.SolicitudCompra;
import ec.edu.ups.views.listados.ListadoSolicitudes;

import java.awt.*;
import java.awt.event.*;
import java.util.List;

public class SolicitudesParaAprobar extends Frame{
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

    private Button bIr;
    private Button bAprobar;
    private Button bRechazar;
    private TextField tfSolicitud;

    public SolicitudesParaAprobar(ListsController listsController) {
        this.listsController = listsController;


        setTitle("Solicitudes Para Aprobar");
        setSize(700, 550);
        setLocationRelativeTo(null);
        setLayout(null);
        setResizable(false);

        lbVentana = new Label("Solicitudes Para Aprobar");
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

        List<SolicitudCompra> solicitudes = this.listsController.getSolicitudes();

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
        });
        // ------------------------- Fuicion como tal
        bAprobar = new Button("Aprobar");
        bRechazar = new Button("Rechazar");
        tfSolicitud = new TextField();
        tfSolicitud.setBounds(300,475,100,25);
        bAprobar.setBounds(200,475,100,25);
        bRechazar.setBounds(400,475,100,25);

        bAprobar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                bAprobar.setBackground(Color.green);

            }

            @Override
            public void mouseExited(MouseEvent e) {
                bAprobar.setBackground(null);
            }
        });
        bRechazar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                bRechazar.setBackground(Color.RED);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                bRechazar.setBackground(null);
            }
        });


        add(tfSolicitud);
        add(bAprobar);
        add(bRechazar);

        ListadoSolicitudes listadoSolicitudes = new ListadoSolicitudes(listsController);
        bAprobar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int idSolicitud = Integer.parseInt(tfSolicitud.getText());
                SolicitudCompra solicitudSeleccionada = null;
                for (SolicitudCompra solicitud : listsController.getSolicitudes()) {
                    if (solicitud.getIdSolicitud() == idSolicitud) {
                        solicitudSeleccionada = solicitud;
                        break;
                    }
                }
                if (solicitudSeleccionada != null){
                    solicitudSeleccionada.setEstado(EstadoSolicitud.APROBADA);
                    actualizarList();
                    tfSolicitud.setText("");
                }

            }
        });
        bRechazar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int idSolicitud = Integer.parseInt(tfSolicitud.getText());
                SolicitudCompra solicitudSeleccionada = null;
                for (SolicitudCompra solicitud : listsController.getSolicitudes()) {
                    if (solicitud.getIdSolicitud() == idSolicitud) {
                        solicitudSeleccionada = solicitud;
                        break;
                    }
                }
                if (solicitudSeleccionada != null){
                    solicitudSeleccionada.setEstado(EstadoSolicitud.RECHAZADA);
                    actualizarList();
                    tfSolicitud.setText("");
                }
            }
        });
        actualizarList();
    }
    public void actualizarList() {
        textArea.setText(""); // Limpiar el área
        List<SolicitudCompra> lista = listsController.getSolicitudes();
        for (SolicitudCompra solicitud : lista) {
            textArea.append(solicitud.toString() + "\n");
        }
    }

}
