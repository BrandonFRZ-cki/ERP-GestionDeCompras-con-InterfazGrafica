package ec.edu.ups.views.registros;

import ec.edu.ups.controllers.ListsController;
import ec.edu.ups.views.busquedas.Resultado;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ValidacionEmpleado extends Frame {
    //Colores propuestos
    private Color azulPersonalizado = new Color(0,100,128);

    // Textos
    private Label lbVentana;
    //Ingreso
    private TextField txtIngresoCedula;
    //Botones
    private Button bIr;
    //Paneles
    private Panel header;
    private Panel container;

    private ListsController listsController;
    private Resultado resultado;


    public ValidacionEmpleado (ListsController listsController){
        this.listsController = listsController;

        setLayout(null);
        setSize(400,300);
        setTitle("Login");
        setLocationRelativeTo(null);
        setResizable(false);

        lbVentana = new Label("Login");
        lbVentana.setFont(new Font("Arial", Font.BOLD, 20));
        lbVentana.setForeground(Color.white);

        header = new Panel();
        header.setBackground(azulPersonalizado);
        header.setLayout(null);
        header.setBounds(0,0,400,100);
        header.add(lbVentana);
        lbVentana.setBounds(20,15,600,100);

        bIr = new Button("ir");
        Label indicacion = new Label("Ingrece cedula:");
        txtIngresoCedula = new TextField();


        container = new Panel();
        container.setBounds(0,100,400,200);
        container.setLayout(null);

        indicacion.setBounds(100,10,200,25);
        txtIngresoCedula.setBounds(100,40,200,30);
        bIr.setBounds(100,100,200,40);

        container.add(bIr);
        container.add(indicacion);
        container.add(txtIngresoCedula);

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
        resultado = new Resultado();

        bIr.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cedulaIngresada = txtIngresoCedula.getText();
                RegistroSolicitud registroSolicitud = new RegistroSolicitud(listsController,cedulaIngresada);
                for(int i = 0; i < listsController.getEmpleados().size(); i++){
                    if(cedulaIngresada.equals(listsController.getEmpleados().get(i).getIdentificacion())){
                        registroSolicitud.setVisible(true);
                    }
                }
                txtIngresoCedula.setText("");
            }
        });
    }

}
