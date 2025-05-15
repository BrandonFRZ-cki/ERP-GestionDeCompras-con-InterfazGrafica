package ec.edu.ups.principal;

import ec.edu.ups.controllers.Controller;
import ec.edu.ups.controllers.Default;

public class Principal {
    public static void main(String[] args) {
        Default ejemplo = new Default();
        ejemplo.productosEjemplo();
        ejemplo.empleadoEjemplo();
        ejemplo.gerenteEjemplo();
        ejemplo.solicitudEjemplo();

        Controller controller = new Controller(ejemplo.getListsController());
        controller.start();

    }
}