package ec.edu.ups.views.listados;

import java.awt.*;

import ec.edu.ups.controllers.ListsController;
import ec.edu.ups.models.Producto;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

public class ListadoProductos extends Frame {
    private ListsController listsController;

    //Colores propuestos
    private Color azulPersonalizado = new Color(0,100,128);
    private Color grisPersonalizado = new Color(217,217,217);

    // Textos
    private Label lbVentana;

    //Paneles
    private Panel header;
    private TextArea textArea;



    public ListadoProductos(ListsController listsController) {
        this.listsController = listsController;

        setTitle("Listado");
        setSize(700, 500);
        setLocationRelativeTo(null);
        setLayout(null);
        setResizable(false);

        lbVentana = new Label("Listado de Productos");
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

        List<Producto> productos = listsController.getProductos();
        for (Producto producto : productos) {
            textArea.append(producto.toString() + "\n");
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
    }
}

