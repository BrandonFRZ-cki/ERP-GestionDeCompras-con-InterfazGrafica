package ec.edu.ups.views;

import ec.edu.ups.controllers.ListsController;

import java.awt.*;

public class VistaSolicitud extends Frame {
    private ListsController listsController;

    private Label lbSolicitante;
    private Label lbEmail;
    private Label lbTelefono;

    public VistaSolicitud(ListsController listsController) {
        this.listsController = listsController;

        setLayout(null);
        setTitle("Solicitud de compras");
        setSize(700,500);
        setLocationRelativeTo(null);
        setResizable(false);




    }
}
