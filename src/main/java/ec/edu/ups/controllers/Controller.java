package ec.edu.ups.controllers;


import ec.edu.ups.views.MenuPrincipal;
public class Controller  {
    private ListsController listsController;
    public Controller(ListsController listsController) {
        this.listsController = listsController;
    }

    public void start() {
        MenuPrincipal menu = new MenuPrincipal(listsController);
        menu.setVisible(true);
    }

}