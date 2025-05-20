package ec.edu.ups.views;

import ec.edu.ups.controllers.ListsController;
import ec.edu.ups.views.listados.ListadoProductos;
import ec.edu.ups.views.listados.ListadoProveedores;
import ec.edu.ups.views.listados.ListadoSolicitudes;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Listado extends Frame {
    //Colores propuestos
    private Color azulPersonalizado = new Color(0,100,128);

    // Textos
    private Label lbVentana;

    //Botones
    private Button bProveedor;
    private Button bProducto;
    private Button bSulicitud;
    //Paneles
    private Panel header;
    private Panel container;

    private ListsController listsController;

    public Listado(ListsController listsController) {
        this.listsController = listsController;

        setLayout(null);
        setSize(400,300);
        setTitle("Listar");
        setLocationRelativeTo(null);
        setResizable(false);

        lbVentana = new Label("Listar");
        lbVentana.setFont(new Font("Arial", Font.BOLD, 20));
        lbVentana.setForeground(Color.white);

        header = new Panel();
        header.setBackground(azulPersonalizado);
        header.setLayout(null);
        header.setBounds(0,0,400,100);
        header.add(lbVentana);
        lbVentana.setBounds(20,15,600,100);

        bProveedor = new Button("Proveedores");
        bProducto  = new Button("Productos");
        bSulicitud = new Button("Solicitudes");

        container = new Panel();
        container.setBounds(0,100,400,200);
        container.setLayout(null);

        bProveedor.setBounds(100,10,200,40);
        bProducto.setBounds(100,60,200,40);
        bSulicitud.setBounds(100,110,200,40);

        container.add(bProveedor);
        container.add(bProducto);
        container.add(bSulicitud);

        add(header);
        add(container);

        // -------------------------- Funcionalidades de Ventana
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
        //-------------------------- Funcionalidades Botones

        ListadoProveedores listadoProveedores = new ListadoProveedores(listsController);
        ListadoProductos listadoProductos = new ListadoProductos(listsController);
        ListadoSolicitudes listadoSolicitudes = new ListadoSolicitudes(listsController);

        bProveedor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listadoProveedores.setVisible(true);
            }
        });
        bProducto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listadoProductos.setVisible(true);
            }
        });
        bSulicitud.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listadoSolicitudes.setVisible(true);
            }
        });
    }
}
