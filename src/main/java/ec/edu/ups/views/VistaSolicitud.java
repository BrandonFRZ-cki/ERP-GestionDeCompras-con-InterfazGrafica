package ec.edu.ups.views;

import ec.edu.ups.controllers.ListsController;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class VistaSolicitud extends Frame {

        private Color azulPersonalizado = new Color(0, 100, 128);

        public VistaSolicitud(ListsController listsController) {
            setTitle("Solicitud");
            setSize(900, 750);
            setLayout(null);
            setResizable(false);
            setLocationRelativeTo(null);


            // ---------------------- Header -------------------------
            Panel header = new Panel(null);
            header.setBackground(azulPersonalizado);
            header.setBounds(0, 0, 900, 40);
            Label titulo = new Label("Solicitud");
            titulo.setFont(new Font("Arial", Font.BOLD, 16));
            titulo.setForeground(Color.white);
            titulo.setBounds(10, 10, 200, 20);

            // ---------------------- Campos superiores -------------------------
            Label lbIdSolicitud = new Label("Id solicitud:");
            lbIdSolicitud.setBounds(10, 50, 100, 20);
            add(lbIdSolicitud);
            TextField tfIdSolicitud = new TextField();
            tfIdSolicitud.setBounds(10, 70, 170, 25);
            add(tfIdSolicitud);

            Label lbSolicitante = new Label("Solicitante:");
            lbSolicitante.setBounds(200, 50, 100, 20);
            add(lbSolicitante);
            TextField tfSolicitante = new TextField();
            tfSolicitante.setBounds(200, 70, 170, 25);
            add(tfSolicitante);

            Label lbEstado = new Label("Estado:");
            lbEstado.setBounds(390, 50, 100, 20);
            add(lbEstado);
            TextField tfEstado = new TextField();
            tfEstado.setBounds(390, 70, 170, 25);
            add(tfEstado);

            Label lbFecha = new Label("Fecha:");
            lbFecha.setBounds(580, 50, 100, 20);
            add(lbFecha);
            TextField tfFecha = new TextField();
            tfFecha.setBounds(580, 70, 170, 25);
            add(tfFecha);

            Label lbMotivo = new Label("Motivo:");
            lbMotivo.setBounds(10, 100, 100, 20);
            add(lbMotivo);
            TextField tfMotivo = new TextField();
            tfMotivo.setBounds(10, 120, 170, 25);
            add(tfMotivo);

            Label lbDetalle = new Label("Detalle:");
            lbDetalle.setBounds(200, 100, 100, 20);
            add(lbDetalle);
            TextField tfDetalle = new TextField();
            tfDetalle.setBounds(200, 120, 170, 25);
            add(tfDetalle);

            // ---------------------- Tabla simulada -------------------------
            Panel tabla = new Panel(null);
            tabla.setBackground(new Color(220, 220, 220));
            tabla.setBounds(30, 160, 820, 200);
            String[] columnas = {"Id", "Cantidad", "Unidad\nMedida", "Detalle", "Precio\nUnitario", "Precio\nCompra"};
            int[] x = {10, 90, 170, 270, 560, 650};
            int ancho = 70;

            for (int i = 0; i < columnas.length; i++) {
                Label col = new Label(columnas[i]);
                col.setBounds(x[i], 10, 100, 20);
                tabla.add(col);

                TextField campo = new TextField();
                campo.setBounds(x[i], 40, (i == 3) ? 260 : ancho, 100);
                tabla.add(campo);
            }
            add(tabla);

            // ---------------------- Observación -------------------------
            Label lbObservacion = new Label("Observacion:");
            lbObservacion.setBounds(10, 370, 100, 20);
            add(lbObservacion);
            TextField tfObservacion = new TextField();
            tfObservacion.setBounds(10, 390, 850, 30);
            add(tfObservacion);

            // ---------------------- Total -------------------------
            Label lbTotal = new Label("Total:");
            lbTotal.setBounds(10, 430, 100, 20);
            add(lbTotal);
            TextField tfTotal = new TextField();
            tfTotal.setBounds(10, 450, 850, 30);
            add(tfTotal);

            // ---------------------- Cierre ventana -------------------------
            addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    dispose();
                }
            });

        }
    }
