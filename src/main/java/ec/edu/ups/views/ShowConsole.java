package ec.edu.ups.views;

import ec.edu.ups.models.*;

import java.util.List;
import java.util.Scanner;

public class ShowConsole {
    Scanner scanner = new Scanner(System.in);
    //--------------------------------------------------------- MENSAJES
    public void showMessage(String mensaje) {
        System.out.println(mensaje);
    }
    public void showError(String mensaje) {
        System.err.println("ERROR: "+mensaje);
    }

    //--------------------------------------------------------- MENUS
    public int showMenuPrincipal() {
        System.out.println("\n======= SISTEMA DE GESTIÓN DE COMPRAS =======");
        System.out.println("-------------- MENU PRINCIPAL ---------------");
        System.out.println("1.  Registrar Proveedor");
        System.out.println("2.  Registrar Producto");
        System.out.println("3.  Registrar Solicitud de compra");
        System.out.println("4.  Listar Proveedores");
        System.out.println("5.  Listar Productos");
        System.out.println("6.  Listar Solicitud de compra");
        System.out.println("7.  Buscar Proveedor por ID");
        System.out.println("8.  Buscar Producto por nombre");
        System.out.println("9.  Buscar Solicitud por numero");
        System.out.println("10. Aprobar / Rechazar Solicitud de compra");
        System.out.println("11. Salir");
        System.out.println("--------------------------------------------");
        System.out.print("Opcion: ");
        return scanner.nextInt();
    }
    public int showMenuIngresoProducto() {
        System.out.println("-------------- MENU CREACION DE PRODUCTOS ---------------");
        System.out.println("1.  Desea Crear Solo El Producto");
        System.out.println("2.  Producto con proveedor");
        System.out.println("---------------------------------------------------------");
        System.out.print("Opcion: ");
        return scanner.nextInt();
    }
    public int showMenuIngresoSolicitud() {
        System.out.println("-------------- MENU CREACION DE SOLICITUD ---------------");
        System.out.println("1.  Crear solicitud de compra con elementos exisstentes" +
                            "\n\t○ Producto con proveedor");
        System.out.println("2. Salir");
        System.out.println("---------------------------------------------------------");
        System.out.print("Opcion: ");
        return scanner.nextInt();
    }
    public int showMenuTipoDetalle(){
        System.out.println("------- TIPO DE DETALLE DE SOLICITUD --------");
        System.out.println("1. Producto");
        System.out.println("2. Paquete");
        System.out.println("---------------------------------------------");
        System.out.print("Opcion: ");
        return scanner.nextInt();
    }




    //--------------------------------------------------------- INGRESAR
    public String ingresoId(String mensaje){
        System.out.print("\n\t\tIngrese id del "+mensaje+": ");
        String id = scanner.next();
        scanner.nextLine();
        return id;
    }
    public String ingresoNombre(String mensaje){
        System.out.print("\n\t\tIngrese el nombre del "+mensaje+": ");
        String nombre = scanner.nextLine();
        return nombre;
    }
    public String ingresoApellido(String mensaje){
        System.out.print("\n\t\tIngrese apellido del "+mensaje+": ");
        String apellido = scanner.nextLine();
        return apellido;
    }
    public double ingresoPrecio(String mensaje){
        System.out.print("\n\t\tIngrese el precio del "+mensaje+" (con coma , ) : ");
        double precio = scanner.nextDouble();
        return precio;
    }
    public String ingresoPssw(){
        System.out.println("Ingrese contrasena");
        return scanner.next();
    }
    public boolean ingresoIVA(String mensaje){
        System.out.print("\n\t\tEl "+mensaje+" tiene IVA? Si/NO: ");
        return scanner.next().equalsIgnoreCase("Si");
    }
    public Direccion ingresoDireccion(){
        System.out.println("\n\t\tDireccion- --  ");
        return new Direccion(
                ingresoTexto("\n\t\t\tCalle Principal  : "),
                ingresoTexto("\n\t\t\tCalle Segundaria : "),
                ingresoTexto("\n\t\t\tNumeracion       : "),
                ingresoTexto("\n\t\t\tCiudad           : "),
                ingresoTexto("\n\t\t\tProvincia        : "),
                ingresoTexto("\n\t\t\tPais             : ")
        );
    }
    public String ingresoTexto(String mensaje){
        System.out.print(mensaje);
        String ingresado = scanner.nextLine();
        return ingresado;
    }
    public String ingresoTexto2(String mensaje){
        System.out.print(mensaje);
        String ingresado = scanner.next();
        return ingresado;
    }
    public String showIngreseProductoSinProveedor() {
        ingresoTexto("A que producto desea registrar el proveedor \n\tIngresa el id del producto : ");
        String productoElegido = scanner.nextLine();
        return productoElegido;
    }
    public int ingresoNumero(String mensaje){
        System.out.print(mensaje);
        int ingresado = scanner.nextInt();
        return ingresado;
    }
    public double ingresoNumero2(String mensaje){
        System.out.print(mensaje);
        double ingresado = scanner.nextDouble();
        return ingresado;
    }
    public UnidadMedida ingresoUnidadMedida(){
        System.out.println("Seleccione la unidad de medida:");
        for (UnidadMedida unidad : UnidadMedida.values()) {
            System.out.println(unidad.ordinal() + 1 + ". " + unidad);
        }
        System.out.print("Ingrese el número de la unidad de medida: ");
        int unidadIndex = scanner.nextInt() - 1;
        UnidadMedida unidadSeleccionada = UnidadMedida.values()[unidadIndex];
        return unidadSeleccionada;
    }



    //--------------------------------------------------------- LISTAR
    public void showListaProductos(List<Producto> productos) {
        for (Producto producto : productos) {
            System.out.println(producto);
        }
    }
    public void showListaProveedores(List<Producto> productos) {
        for (int i = 0; i < productos.size(); i++) {
            if (i == productos.size() - 1 || !productos.get(i).getProveedor().equals(productos.get(i + 1).getProveedor())) {
                System.out.println(productos.get(i).getProveedor());
            }
        }
    }
    public void showListaSolicitudes(List<SolicitudCompra> solicitudes) {
        for (SolicitudCompra solicitud : solicitudes) {
            solicitud.setTotal(solicitud.calcularCostoTotal());
            System.out.println(solicitud);
        }
    }
    public void showListaEmpleados(List<Empleado> empleados) {
        for (Empleado empleado : empleados) {
            System.out.println(empleado.getNombre());
        }
    }


}
