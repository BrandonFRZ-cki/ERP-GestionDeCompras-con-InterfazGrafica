package ec.edu.ups.views;

import ec.edu.ups.controllers.ListsController;
import ec.edu.ups.views.busquedas.BusquedaProducto;
import ec.edu.ups.views.busquedas.BusquedaProveedor;
import ec.edu.ups.views.busquedas.BusquedaSolicitud;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class    Busqueda extends Frame {
    //Colores propuestos
    private Color azulPersonalizado = new Color(0,100,128);

    // Textos
    private Label lbVentana;

    //Botones
    private Button bBuscarProveedor;
    private Button bBuscarProducto;
    private Button bBuscarSulicitud;
    //Paneles
    private Panel header;
    private Panel container;

    private ListsController listsController;

    public Busqueda(ListsController listsController) {
        this.listsController = listsController;

        setLayout(null);
        setSize(400,300);
        setTitle("Buscar");
        setLocationRelativeTo(null);
        setResizable(false);

        lbVentana = new Label("Buscar");
        lbVentana.setFont(new Font("Arial", Font.BOLD, 20));
        lbVentana.setForeground(Color.white);


        header = new Panel();
        header.setBackground(azulPersonalizado);
        header.setLayout(null);
        header.setBounds(0,0,400,100);
        header.add(lbVentana);
        lbVentana.setBounds(20,15,600,100);

        bBuscarProveedor = new Button("Proveedor por ID");
        bBuscarProducto = new Button("Producto por nombre");
        bBuscarSulicitud = new Button("Sulicitud por numero");



        container = new Panel();
        container.setBounds(0,100,400,200);
        container.setLayout(null);

        bBuscarProveedor.setBounds(100,10,200,40);
        bBuscarProducto.setBounds(100,60,200,40);
        bBuscarSulicitud.setBounds(100,110,200,40);

        container.add(bBuscarProveedor);
        container.add(bBuscarProducto);
        container.add(bBuscarSulicitud);

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
        BusquedaProveedor proveedorID = new BusquedaProveedor(listsController);
        bBuscarProveedor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                proveedorID.setVisible(true);
            }
        });
        BusquedaProducto busquedaNombre = new BusquedaProducto(listsController);
        bBuscarProducto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                busquedaNombre.setVisible(true);
            }
        });
        BusquedaSolicitud solicitudNumero = new BusquedaSolicitud(listsController);
        bBuscarSulicitud.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                solicitudNumero.setVisible(true);
            }
        });
    }
}
