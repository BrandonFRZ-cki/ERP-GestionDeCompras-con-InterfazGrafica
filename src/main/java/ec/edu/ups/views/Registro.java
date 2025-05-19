package ec.edu.ups.views;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Registro extends Frame {

    public Registro() {
        setTitle("Registro");
        setSize(500, 500);
        setLocationRelativeTo(null);
        setLayout(null);


        // -------------------------- Funcionalidades de Ventana
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
    }
}
