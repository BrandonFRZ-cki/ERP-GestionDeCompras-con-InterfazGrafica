package ec.edu.ups.views;

import ec.edu.ups.controllers.ListsController;

import java.awt.*;
import java.awt.event.*;

public class MenuPrincipal extends Frame {
    //Colores propuestos
    private Color azulPersonalizado = new Color(0,100,128);
    private Color grisPersonalizado = new Color(217,217,217);

    // Textos
    private Label lbVentana;
    private Label lbMenu;

    //Botones
    private Button bRegistar;
    private Button bListar;
    private Button bBuscar;
    private Button bAprobar;
    private Button bSalir;

    //Paneles
    private Panel header;
    private Panel container;


    private ListsController listsController;
    public MenuPrincipal(ListsController listsController) {
        this.listsController = listsController;
        setLayout(null);
        setSize(600,600);
        setTitle("MenuPrincipal");
        setLocationRelativeTo(null);
        setResizable(false);

        lbVentana = new Label("Sistema de Gestion de Compras");
        lbVentana.setFont(new Font("Arial", Font.BOLD, 20));
        lbVentana.setForeground(Color.white);

        lbMenu = new Label("Menu Principal");
        lbMenu.setFont(new Font("Tahoma", Font.BOLD, 14));

        bRegistar = new Button("Registrar");
        bListar = new Button("Listado");
        bBuscar = new Button("Busqueda");
        bAprobar= new Button("Aprobacion");
        bSalir = new Button("Salir");


        lbMenu.setBounds(  150,50, 150, 40);
        bRegistar.setBounds(125,125,150,40);
        bListar.setBounds(  125,175,150,40);
        bBuscar.setBounds(  125,225,150,40);
        bAprobar.setBounds( 125,275,150,40);
        bSalir.setBounds(   125,325,150,40);

        bSalir.setForeground(Color.red);

        header = new Panel();
        header.setBackground(azulPersonalizado);
        header.setLayout(null);
        header.setBounds(0,0,600,100);
        header.add(lbVentana);
        lbVentana.setBounds(20,15,600,100);

        container = new Panel();
        container.setLayout(null);
        container.setBounds(100,150,400,400);
        container.setBackground(grisPersonalizado);

        container.add(lbMenu);
        container.add(bRegistar);
        container.add(bListar);
        container.add(bBuscar);
        container.add(bAprobar);
        container.add(bSalir);

        add(header);
        add(container);

        //--------------------- Funcionalidades Botones

        Registro registro = new Registro();
        Listado listado = new Listado();
        Busqueda  buscar = new Busqueda(listsController);
        Aprobacion aprobacion = new Aprobacion();

        bSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        bRegistar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registro.setVisible(true);
            }
        });
        bListar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listado.setVisible(true);
            }
        });
        bBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscar.setVisible(true);
            }
        });
        bAprobar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                aprobacion.setVisible(true);
            }
        });
        // -------------------------- Funcionalidades de Ventana
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
    }
}

