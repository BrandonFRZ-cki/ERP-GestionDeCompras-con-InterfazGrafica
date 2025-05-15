package ec.edu.ups.models;

import java.util.Objects;

public class Direccion {
    private String callePrincipal;
    private String calleSegundaria;
    private String numeracion;
    private String ciudad;
    private String provincia;
    private String pais;

    public Direccion(){

    }

    public Direccion(String callePrincipal, String calleSegundaria, String numeracion, String ciudad, String provincia, String pais) {
        this.callePrincipal = callePrincipal;
        this.calleSegundaria = calleSegundaria;
        this.numeracion = numeracion;
        this.ciudad = ciudad;
        this.provincia = provincia;
        this.pais = pais;
    }

    public String getCallePrincipal() {
        return callePrincipal;
    }

    public void setCallePrincipal(String callePrincipal) {
        this.callePrincipal = callePrincipal;
    }

    public String getCalleSegundaria() {
        return calleSegundaria;
    }

    public void setCalleSegundaria(String calleSegundaria) {
        this.calleSegundaria = calleSegundaria;
    }

    public String getNumeracion() {
        return numeracion;
    }

    public void setNumeracion(String numeracion) {
        this.numeracion = numeracion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }


    @Override
    public String toString() {
        return  "\n\t\t\t\t◦ Calle Principal  : " + callePrincipal  +
                "\n\t\t\t\t◦ Calle Segundaria : " + calleSegundaria  +
                "\n\t\t\t\t◦ Numeracion       : " + numeracion  +
                "\n\t\t\t\t◦ Ciudad           : " + ciudad  +
                "\n\t\t\t\t◦ Provincia        : " + provincia  +
                "\n\t\t\t\t◦ Pais             : " + pais;
    }
}
