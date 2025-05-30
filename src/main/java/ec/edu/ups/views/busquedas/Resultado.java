package ec.edu.ups.views.busquedas;

import ec.edu.ups.controllers.ListsController;
import ec.edu.ups.models.Proveedor;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Resultado extends Frame {
    private Color azulPersonalizado = new Color(0,100,128);

    // Textos
    private Label lbVentana;

    private Panel header;
    private Panel container;
    private TextArea textArea;

    public Resultado() {
        setTitle("Resultado");
        setSize(400, 400);
        setLocationRelativeTo(null);
        setLayout(null);
        setResizable(false);
        setVisible(false);


        lbVentana = new Label("Resultado");
        lbVentana.setFont(new Font("Arial", Font.BOLD, 20));
        lbVentana.setForeground(Color.white);

        textArea = new TextArea();
        textArea.setEditable(true);
        textArea.setBounds(0, 100, 400, 300);
        textArea.setText(null);


        header = new Panel();
        header.setBackground(azulPersonalizado);
        header.setLayout(null);
        header.setBounds(0,0,400,100);
        header.add(lbVentana);
        lbVentana.setBounds(20,15,400,100);

        add(header);

        // -------------------------- Funcionalidades de Ventana
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
    }
    public void mostrarResultado(Object objeto) {
        lbVentana.setText("Resultado");
        lbVentana.setFont(new Font("Arial", Font.BOLD, 20));
        lbVentana.setForeground(Color.white);
        header.setBackground(azulPersonalizado);


        textArea.setText(objeto.toString());
        textArea.setEditable(false);
        add(textArea);

        setVisible(true);
    }
    public void noEncontrado(){
        lbVentana.setText("No Encontrado");
        header.setBackground(Color.red);
        textArea.setText("\n\n\n\tVerifica los datos ingrsados de la busqueda...");
        textArea.setEditable(false);
        add(textArea);
        setVisible(true);
    }
    public void contasenaIncorrecta(){
        lbVentana.setText("Contrasena Incorrecta");
        header.setBackground(Color.red);
        textArea.setText("\n\n\n\t Ingrese la contrasena correctamente...");
        textArea.setEditable(false);
        add(textArea);
        setVisible(true);
    }
}
