package ec.edu.ups.models;

public class Direccion {
    private String callePrincipal;
    private String calleSegundaria;
    private String numeracion;
    private String ciudad;
    private String provincia;
    private String pais;

    public Direccion(String callePrincipal, String calleSegundaria, String numeracion, String ciudad, String provincia, String pais) {
        this.callePrincipal = callePrincipal;
        this.calleSegundaria = calleSegundaria;
        this.numeracion = numeracion;
        this.ciudad = ciudad;
        this.provincia = provincia;
        this.pais = pais;
    }


    @Override
    public String toString() {
        return  "\n\t\t◦ Calle Principal  : " + callePrincipal  +
                "\n\t\t◦ Calle Segundaria : " + calleSegundaria  +
                "\n\t\t◦ Numeracion       : " + numeracion  +
                "\n\t\t◦ Ciudad           : " + ciudad  +
                "\n\t\t◦ Provincia        : " + provincia  +
                "\n\t\t◦ Pais             : " + pais;
    }
}
