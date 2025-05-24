package ec.edu.ups.views.registros;

import ec.edu.ups.controllers.ListsController;
import ec.edu.ups.models.Direccion;
import ec.edu.ups.models.Producto;
import ec.edu.ups.models.Proveedor;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class RegistroProducto extends Frame {
    private ListsController listsController;

    private Panel header;
    private Color azulPersonalizado = new Color(0,100,128);
    private Label lbVentana;


    private TextField tfIdProducto;
    private TextField tfNombreProducto;
    private TextField tfPrecioProducto;
    private TextField tfIdProveedor;

    private Checkbox cbIva;

    private Button btnCrearProducto;

    private TextField tfNombreProveedor;
    private TextField tfApellidoProveedor;
    private TextField tfDetalleProveedor;
    private TextField tfTelefonoProveedor;

    private TextField tfCalle1;
    private TextField tfCalleSec;
    private TextField tfNumeracion;
    private TextField tfCiudad;
    private TextField tfProvincia;
    private TextField tfPais;

    private TextArea taControl;

    public RegistroProducto(ListsController listsController) {
        this.listsController = listsController;
        setLayout(null);
        setSize(700, 600);
        setTitle("Registro de Producto");
        setLocationRelativeTo(null);
        setResizable(false);

        //---------------------------------------------------------------Encabezado
        lbVentana = new Label("Registrar Producto");
        lbVentana.setFont(new Font("Arial", Font.BOLD, 20));
        lbVentana.setForeground(Color.white);


        header = new Panel();
        header.setBackground(azulPersonalizado);
        header.setLayout(null);
        header.setBounds(0,0,700,100);
        header.add(lbVentana);
        lbVentana.setBounds(20,15,700,100);

        add(header);


        // -------------------------------------------------------- Producto
        Label lbProducto = new Label("Crear Producto:");
        lbProducto.setFont(new Font("Tahoma", Font.BOLD, 14));
        lbProducto.setBounds(20, 150, 150, 20);
        add(lbProducto);

        Label lbIdProducto = new Label("ID:");
        lbIdProducto.setBounds(20, 180, 80, 20);
        add(lbIdProducto);
        tfIdProducto = new TextField();
        tfIdProducto.setBounds(120, 180, 150, 20);
        add(tfIdProducto);

        Label lbNombreProducto = new Label("Nombre:");
        lbNombreProducto.setBounds(20, 210, 80, 20);
        add(lbNombreProducto);
        tfNombreProducto = new TextField();
        tfNombreProducto.setBounds(120, 210, 150, 20);
        add(tfNombreProducto);

        Label lbPrecioProducto = new Label("Precio:");
        lbPrecioProducto.setBounds(20, 240, 80, 20);
        add(lbPrecioProducto);
        tfPrecioProducto = new TextField();
        tfPrecioProducto.setBounds(120, 240, 150, 20);
        add(tfPrecioProducto);

        cbIva = new Checkbox("IVA");
        cbIva.setBounds(120, 270, 180, 20);
        add(cbIva);

        btnCrearProducto = new Button("Crear Solo Producto");
        btnCrearProducto.setBounds(120, 450, 150, 30);
        btnCrearProducto.setBackground(Color.white);
        add(btnCrearProducto);

        taControl = new TextArea("AVISOS: \n- El Producto Se puede crear sin necesidad de Proveedor\n" +
                                 "- Pero si agrega datos en Proveedor automaticamente.\n" +
                                 "- Todos los datos en Proveedor son Obligatorios");
        taControl.setEditable(false);
        taControl.setBounds(50, 330, 270, 100);

        add(taControl);

        // ------------------------------------------------------------------------ Sección de proveedor

        Label lbProveedor = new Label("Datos del Proveedor:");
        lbProveedor.setFont(new Font("Tahoma", Font.BOLD, 14));
        lbProveedor.setBounds(350, 50, 300, 20);
        add(lbProveedor);

        Label lbIdProveedorDetalle = new Label("ID:");
        lbIdProveedorDetalle.setBounds(350, 180, 80, 20);
        add(lbIdProveedorDetalle);
        tfIdProveedor = new TextField();
        tfIdProveedor.setBounds(450, 180, 150, 20);
        add(tfIdProveedor);

        Label lbNombreProveedor = new Label("Nombre:");
        lbNombreProveedor.setBounds(350, 210, 80, 20);
        add(lbNombreProveedor);
        tfNombreProveedor = new TextField();
        tfNombreProveedor.setBounds(450, 210, 150, 20);
        add(tfNombreProveedor);

        Label lbApellidoProveedor = new Label("Apellido:");
        lbApellidoProveedor.setBounds(350, 240, 80, 20);
        add(lbApellidoProveedor);
        tfApellidoProveedor = new TextField();
        tfApellidoProveedor.setBounds(450, 240, 150, 20);
        add(tfApellidoProveedor);

        Label lbDetalleProveedor = new Label("Detalle:");
        lbDetalleProveedor.setBounds(350, 270, 80, 20);
        add(lbDetalleProveedor);
        tfDetalleProveedor = new TextField();
        tfDetalleProveedor.setBounds(450, 270, 150, 20);
        add(tfDetalleProveedor);

        Label lbTelefonoProveedor = new Label("Teléfono:");
        lbTelefonoProveedor.setBounds(350, 300, 80, 20);
        add(lbTelefonoProveedor);
        tfTelefonoProveedor = new TextField();
        tfTelefonoProveedor.setBounds(450, 300, 150, 20);
        add(tfTelefonoProveedor);

        Label lbDireccion = new Label("Dirección del Proveedor:");
        lbDireccion.setFont(new Font("Tahoma", Font.BOLD, 14));
        lbDireccion.setBounds(350, 330, 200, 20);
        add(lbDireccion);

        Label lbCalle1 = new Label("Calle Principal:");
        lbCalle1.setBounds(350, 360, 100, 20);
        add(lbCalle1);
        tfCalle1 = new TextField();
        tfCalle1.setBounds(450, 360, 150, 20);
        add(tfCalle1);

        Label lbCalleSec = new Label("Calle Secun...:");
        lbCalleSec.setBounds(350, 390, 100, 20);
        add(lbCalleSec);
        tfCalleSec = new TextField();
        tfCalleSec.setBounds(450, 390, 150, 20);
        add(tfCalleSec);

        Label lbNumeracion = new Label("Numeracion:");
        lbNumeracion.setBounds(350, 420, 100, 20);
        add(lbNumeracion);
        tfNumeracion = new TextField();
        tfNumeracion.setBounds(450, 420, 150, 20);
        add(tfNumeracion);

        Label lbCiudad = new Label("Ciudad:");
        lbCiudad.setBounds(350, 450, 100, 20);
        add(lbCiudad);
        tfCiudad = new TextField();
        tfCiudad.setBounds(450, 450, 150, 20);
        add(tfCiudad);

        Label lbProvincia = new Label("Provincia:");
        lbProvincia.setBounds(350, 480, 100, 20);
        add(lbProvincia);
        tfProvincia = new TextField();
        tfProvincia.setBounds(450, 480, 150, 20);
        add(tfProvincia);

        Label lbPais = new Label("Pais:");
        lbPais.setBounds(350, 510, 100, 20);
        add(lbPais);
        tfPais = new TextField();
        tfPais.setBounds(450, 510, 150, 20);
        add(tfPais);


        // Evento para cerrar la ventana
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
        btnCrearProducto.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if(tfIdProducto.getText().isEmpty()||tfNombreProducto.getText().isEmpty()||tfPrecioProducto.getText().isEmpty()) {
                    taControl.setForeground(Color.RED);
                    taControl.setText("ERROR: Complete todos los datos de Pooducto");

                }else{
                    if(datosProveedorVacio()){
                        try { // Error si lo que se ingresa no es un numero o es un numero con , en vez de punto, pero depende de la compu
                            double precio = Double.parseDouble(tfPrecioProducto.getText());
                            listsController.agregarProducto( new Producto(
                                            tfIdProducto.getText(),
                                            tfNombreProducto.getText(),
                                            precio,
                                            cbIva.getState(),
                                            new Proveedor()
                                    )
                            );
                            tfIdProducto.setText("");
                            tfNombreProducto.setText("");
                            tfPrecioProducto.setText("");
                            cbIva.setState(false);
                            taControl.setForeground(new Color(0, 102, 51));
                            taControl.setText("Producto creado");
                        }catch(NumberFormatException nfe){
                            taControl.setForeground(Color.RED);
                            taControl.setText("ERROR: Ingresa un precio (numero) valido con punto");
                        }
                    }else{
                        if(datosProveedorIncompletos()){
                            taControl.setForeground(Color.RED);
                            taControl.setText("ERROR: Completar datos de Proveedor");
                        }
                        else{

                            try {
                                double precio = Double.parseDouble(tfPrecioProducto.getText());
                                listsController.agregarProducto( new Producto(
                                                tfIdProducto.getText(),
                                                tfNombreProducto.getText(),
                                                precio,
                                                cbIva.getState(),
                                                new Proveedor(
                                                        tfIdProveedor.getText(),
                                                        tfNombreProveedor.getText(),
                                                        tfApellidoProveedor.getText(),
                                                        tfDetalleProveedor.getText(),
                                                        new Direccion(
                                                                tfCalle1.getText(),
                                                                tfCalleSec.getText(),
                                                                tfNumeracion.getText(),
                                                                tfCiudad.getText(),
                                                                tfProvincia.getText(),
                                                                tfPais.getText()
                                                        ),
                                                        tfTelefonoProveedor.getText()

                                                )
                                        )
                                );
                                tfIdProducto.setText("");
                                tfNombreProducto.setText("");
                                tfPrecioProducto.setText("");
                                cbIva.setState(false);
                                taControl.setForeground(new Color(0, 102, 51));
                                taControl.setText("Producto creado");
                            }catch(NumberFormatException nfe){
                                taControl.setForeground(Color.RED);
                                taControl.setText("ERROR: Ingresa un precio (numero) valido con punto");
                            }
                        }
                    }
                }
            }
        });



    }
    private boolean datosProveedorVacio() {
        return tfIdProveedor.getText().isEmpty()&&tfNombreProveedor.getText().isEmpty()&&tfApellidoProveedor.getText().isEmpty()&&tfDetalleProveedor.getText().isEmpty()
                &&tfTelefonoProveedor.getText().isEmpty()&&tfCalle1.getText().isEmpty()&&tfCalleSec.getText().isEmpty()&&tfNumeracion.getText().isEmpty()&&tfCiudad.getText().isEmpty()&&tfProvincia.getText().isEmpty()&&tfPais.getText().isEmpty();
    }
    private boolean datosProveedorIncompletos() {
        return tfIdProveedor.getText().isEmpty()||tfNombreProveedor.getText().isEmpty()||tfApellidoProveedor.getText().isEmpty()||tfDetalleProveedor.getText().isEmpty()
                ||tfTelefonoProveedor.getText().isEmpty()||tfCalle1.getText().isEmpty()||tfCalleSec.getText().isEmpty()||tfNumeracion.getText().isEmpty()||tfCiudad.getText().isEmpty()||tfProvincia.getText().isEmpty()||tfPais.getText().isEmpty();
    }


}
