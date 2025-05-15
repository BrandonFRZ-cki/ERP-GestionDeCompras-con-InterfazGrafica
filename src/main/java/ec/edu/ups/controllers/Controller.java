package ec.edu.ups.controllers;

import ec.edu.ups.models.*;
import ec.edu.ups.views.ShowConsole;

import java.util.GregorianCalendar;
import java.util.List;

public class Controller {
    private ShowConsole showConsole;
    private ListsController listsController;
    private Busqueda busqueda = new Busqueda();

    public Controller(ListsController listsController) {
        this.showConsole = new ShowConsole();
        this.listsController = listsController;
    }

    public void start() {
        int opcion = 0;
        do{
            opcion=showConsole.showMenuPrincipal();
            switch (opcion) {
                case 1:
                    op1RegistrarProveedor();
                    break;
                case 2:
                    op2RegistrarProducto();
                    break;
                case 3:
                    op3RegistrarSolicitud();
                    break;
                case 4:
                    op4ListarProveedores();
                    break;
                case 5:
                    op5ListarProductos();
                    break;
                case 6:
                    op6ListarSolicitudes();
                    break;
                case 7:
                   op7BuscarProveedorId();
                    break;
                case 8:
                    op8BuscarPorNombre();
                    break;
                case 9:
                   op9BuscarPorNumero();
                    break;
                case 10:
                    op10AprobarRechazar();
                    break;
                case 11:
                    showConsole.showMessage("\n---- Ha seleccionado la opcion 11. \n\t-------------- Salir del programa");
                    break;
            }
        }while(opcion!=11);
    }


    public  void op1RegistrarProveedor() {
        showConsole.showMessage("\n---- Ha seleccionado la opcion 1. \n\tRegistrar Proveedor para producto");
        showConsole.showMessage("Lista de productos sin proveedor");
        for (int i = 0; i < listsController.getProductos().size(); i++) {
            if (listsController.getProductos().get(i).getProveedor().getNombre()==null){
                System.out.println("id: ("+listsController.getProductos().get(i).getIdProducto()+"), Nombre: ("+listsController.getProductos().get(i).getNombre()+")");
            }
        }
        String productoElejido = showConsole.showIngreseProductoSinProveedor();
        for (int i = 0; i < listsController.getProductos().size(); i++) {
            if(productoElejido.equals(listsController.getProductos().get(i).getIdProducto())){
                listsController.getProductos().get(i).setProveedor(
                        new Proveedor(
                                showConsole.ingresoId("proveedor"),
                                showConsole.ingresoNombre("proveedor"),
                                showConsole.ingresoApellido("proveedor"),
                                showConsole.ingresoTexto("\t\tDetalle:"),
                                showConsole.ingresoDireccion(),
                                showConsole.ingresoTexto("\t\tTelefono: ")
                        )
                );
            }
        }


    }

    public void op2RegistrarProducto() {
        showConsole.showMessage("\n---- Ha seleccionado la opción 2. \n\tRegistrar Producto:");
        int opcionCreacionProducto =0;
        boolean menuCreacionProducto = true;
        do{
            opcionCreacionProducto = showConsole.showMenuIngresoProducto();
            switch (opcionCreacionProducto) {
                case 1:
                    listsController.agregarProducto(new Producto(
                            showConsole.ingresoId("producto"),
                            showConsole.ingresoNombre("producto"),
                            showConsole.ingresoPrecio("producto"),
                            showConsole.ingresoIVA("producto"),
                            new Proveedor()
                    ));
                    menuCreacionProducto = false;
                    break;
                case 2:
                    listsController.agregarProducto(new Producto(
                            showConsole.ingresoId("producto"),
                            showConsole.ingresoNombre("producto"),
                            showConsole.ingresoPrecio("producto"),
                            showConsole.ingresoIVA("producto"),
                            new Proveedor(
                                    showConsole.ingresoId("proveedor"),
                                    showConsole.ingresoNombre("proveedor"),
                                    showConsole.ingresoApellido("proveedor"),
                                    showConsole.ingresoTexto("\t\tDetalle:"),
                                    showConsole.ingresoDireccion(),
                                    showConsole.ingresoTexto("\t\tTelefono: ")
                            )
                    ));
                    menuCreacionProducto = false;
                    break;
                default:
                    showConsole.showError("Opcion no valida");
                    break;

            }
        }while(menuCreacionProducto);
    }

    public void op3RegistrarSolicitud() {
        showConsole.showMessage("\n---- Ha seleccionado la opción 3. \n\tRegistrar Solicitud");

        int opcionSolicitud = showConsole.showMenuIngresoSolicitud();

        if(opcionSolicitud==1){

            int nuevoId = listsController.getSolicitudes().size() + 1;

            Empleado empleadoSeleccionado=null;

            showConsole.showMessage("-------- QUIEN ERES");
            showConsole.showListaEmpleados(listsController.getEmpleados());
            String id =showConsole.ingresoId(" empleado (el suyo)");
            for (int i = 0; i < listsController.getEmpleados().size(); i++) {
                if(id.equals(listsController.getEmpleados().get(i).getIdentificacion())){
                    empleadoSeleccionado = listsController.getEmpleados().get(i);
                }
            }
            if(empleadoSeleccionado!=null){
                SolicitudCompra solicitud = new SolicitudCompra(
                        nuevoId,
                        empleadoSeleccionado,
                        EstadoSolicitud.SOLICITADA,
                        showConsole.ingresoTexto("--- Motivo : "),
                        new GregorianCalendar(
                                showConsole.ingresoNumero("\n\t\tAño: "),
                                showConsole.ingresoNumero("\n\t\tMes: ")-1,
                                showConsole.ingresoNumero("\n\t\tDia:")
                        ),
                        showConsole.ingresoTexto2("--- Detalle del Material : "),
                        showConsole.ingresoTexto2("--- Observacion :")
                );

                boolean agregarOtroDetalle=true;
                boolean agregarOtroProducto = true;
                int contadorDetalle = 1;
                while(agregarOtroDetalle){
                    int tipoDetalle = showConsole.showMenuTipoDetalle();
                    if(tipoDetalle==1){//Producto

                        Producto productoSeleccionado=null;
                        do {
                            System.out.println("Seleccione un producto para agregar a la solicitud:");
                            for (int i = 0; i < listsController.getProductos().size(); i++) {
                                System.out.println("ID: "+listsController.getProductos().get(i).getIdProducto()+" Nombre:"+listsController.getProductos().get(i).getNombre());
                            }

                            String idProd = showConsole.ingresoId("producto que quiere agregar ");
                            for (int i = 0; i < listsController.getProductos().size(); i++) {
                                if(listsController.getProductos().get(i).getIdProducto().equals(idProd)){
                                    productoSeleccionado = listsController.getProductos().get(i);
                                }
                            }
                            if(productoSeleccionado==null){
                                showConsole.showError("El producto no existe");
                            }
                        }while(productoSeleccionado==null);

                        DetalleCompraProducto detalle = new DetalleCompraProducto(
                                contadorDetalle++,
                                showConsole.ingresoNumero("\n\t\tCantidad : "),
                                showConsole.ingresoUnidadMedida(),
                                productoSeleccionado
                        );

                        solicitud.addDetalle(detalle);

                    } else if (tipoDetalle==2){//Pak
                        agregarOtroProducto = true;
                        List<Producto> productosSeleccionados = listsController.getProductos();
                        do {
                            Producto productoSeleccionado=null;

                            do {
                                System.out.println("Seleccione un producto para agregar a la solicitud:");
                                for (int i = 0; i < listsController.getProductos().size(); i++) {
                                    System.out.println("ID: "+listsController.getProductos().get(i).getIdProducto()+" Nombre:"+listsController.getProductos().get(i).getNombre());
                                }
                                String idProd = showConsole.ingresoId("producto que quiere agregar ");
                                for (int i = 0; i < listsController.getProductos().size(); i++) {
                                    if(listsController.getProductos().get(i).getIdProducto().equals(idProd)){
                                        productoSeleccionado = listsController.getProductos().get(i);
                                    }
                                }
                                if(productoSeleccionado==null){
                                    showConsole.showError("El producto no existe");
                                }
                            }while(productoSeleccionado==null);
                            productosSeleccionados.add(productoSeleccionado);
                            agregarOtroProducto = showConsole.ingresoTexto2("¿Desea agregar otro producto? (SI/NO): ").equalsIgnoreCase("si");
                        } while (agregarOtroProducto);

                        DetalleCompraPaquete detalle = new DetalleCompraPaquete(
                                contadorDetalle++,
                                showConsole.ingresoNumero("\n\t\tCantidad : "),
                                showConsole.ingresoNumero2("\n\t\tDescuento :")
                        );
                        detalle.setProductos(productosSeleccionados);
                        solicitud.addDetalle(detalle);
                    }
                    agregarOtroDetalle= showConsole.ingresoTexto2("¿Desea agregar otro detalle? (SI/NO): ").equalsIgnoreCase("si");
                };
                listsController.agregarSolicitudCompra(solicitud);
            }
            else{
                showConsole.showError("Usted no es parte de la empresa");
            }
        }
    }

    public void op4ListarProveedores() {
        showConsole.showMessage("\n---- Ha seleccionado la opcion 4. \n\tListar Proveedores");
        showConsole.showListaProveedores(listsController.getProductos());
    }

    public void op5ListarProductos() {
        showConsole.showMessage("\n---- Ha seleccionado la opción 5. \n\tListar Productos");
        showConsole.showListaProductos(listsController.getProductos());
    }

    public void op6ListarSolicitudes() {
        showConsole.showMessage("\n---- Ha seleccionado la opcion 6. \n\tListar Solicitud de compra");
        showConsole.showListaSolicitudes(listsController.getSolicitudes());

    }

    public void op7BuscarProveedorId(){

        showConsole.showMessage("\n---- Ha seleccionado la opcion 7. \n\t-------------- Buscar Proveedor por ID ");
        String id =showConsole.ingresoId("Proveedor a buscar");
        Proveedor proveedorTemp = busqueda.busquedaPorId(listsController.getProductos(),id);
        if (proveedorTemp == null){
            showConsole.showError("No se a encontrado el provedor");
        }else {
            System.out.println(proveedorTemp);
        }

    }

    public void op8BuscarPorNombre(){
        showConsole.showMessage("\n---- Ha seleccionado la opcion 8. \n\t-------------- Buscar Producto por nombre ");
        String nombre = showConsole.ingresoTexto2("Producto a buscar: ");
        Producto productoEn = busqueda.productoPorNombre(listsController.getProductos(),nombre);
        if (productoEn == null){
            showConsole.showError("No se ha encontrado el producto");
        }else {
            System.out.println(productoEn);
        }
    }

    public void op9BuscarPorNumero(){
        showConsole.showMessage("\n---- Ha seleccionado la opcion 9. \n\t-------------- Buscar Solicitud por numero");
        int numero = showConsole.ingresoNumero("Ingrese numero a buscar");
        SolicitudCompra solicitudEncon = busqueda.solicitudPorNumero(listsController.getSolicitudes(),numero);
        if (solicitudEncon == null){
            showConsole.showError("No se ha encontrado la solicitud con ese numero");
        }else {
            System.out.println(solicitudEncon);
        }
    }

    public void op10AprobarRechazar() {
        showConsole.showMessage("\n---- Ha seleccionado la opción 10. \n\tAprobar / Rechazar Solicitud de compra");

        // Solicitar la contraseña
        String psswIngresada = showConsole.ingresoPssw();

        // Validar la contraseña
        Default ejemplo = new Default();
        ejemplo.gerenteEjemplo();
        if (!psswIngresada.equals(ejemplo.getGerente().getPssw())){
            showConsole.showError("Contraseña incorrecta. Acceso denegado.");
            return;
        }

        // Mostrar solicitudes
        showConsole.showMessage("\nSolicitudes disponibles:");
        for (SolicitudCompra solicitud : listsController.getSolicitudes()) {
            System.out.println("ID: " + solicitud.getIdSolicitud() + " | Estado: " + solicitud.getEstado());
        }

        // Seleccionar solicitud
        int idSolicitud = showConsole.ingresoNumero("Ingrese el ID de la solicitud: ");
        SolicitudCompra solicitudSeleccionada = null;
        for (SolicitudCompra solicitud : listsController.getSolicitudes()) {
            if (solicitud.getIdSolicitud() == idSolicitud) {
                solicitudSeleccionada = solicitud;
                break;
            }
        }

        if (solicitudSeleccionada == null) {
            showConsole.showError("Solicitud no encontrada.");
            return;
        }

        // Aprobar o rechazar
        int opcion = showConsole.ingresoNumero("Seleccione:\n1. Aprobar\n2. Rechazar\nOpción: ");
        if (opcion == 1) {
            solicitudSeleccionada.setEstado(EstadoSolicitud.APROBADA);
            showConsole.showMessage("La solicitud ha sido APROBADA.");
        } else if (opcion == 2) {
            solicitudSeleccionada.setEstado(EstadoSolicitud.RECHAZADA);
            showConsole.showMessage("La solicitud ha sido RECHAZADA.");
        } else {
            showConsole.showError("Opción no válida.");
        }
    }


}