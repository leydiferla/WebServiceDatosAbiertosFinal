package com.example.leydidiego.webservicedatosabiertos.models;

/**
 * Created by leydidiego on 2/06/17.
 */

public class Municipio {

    private String nombremunicipio;
    private String nombre;
    private String paginaweb;
    private String email;
    private String fundador;
    private String a_o;
    private String temperatura_media;
    private String veredas_2005;


    public String getNombremunicipio() {
        return nombremunicipio;
    }

    public void setNombremunicipio(String nombremunicipio) {
        this.nombremunicipio = nombremunicipio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPaginaweb() {
        return paginaweb;
    }

    public void setPaginaweb(String paginaweb) {
        this.paginaweb = paginaweb;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFundador() {
        return fundador;
    }

    public void setFundador(String fundador) {
        this.fundador = fundador;
    }

    public String getA_o() {
        return a_o;
    }

    public void setA_o(String a_o) {
        this.a_o = a_o;
    }

    public String getTemperatura_media() {
        return temperatura_media;
    }

    public void setTemperatura_media(String temperatura_media) {
        this.temperatura_media = temperatura_media;
    }

    public String getVeredas_2005() {
        return veredas_2005;
    }

    public void setVeredas_2005(String veredas_2005) {
        this.veredas_2005 = veredas_2005;
    }
}
