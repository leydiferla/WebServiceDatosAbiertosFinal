package com.example.leydidiego.webservicedatosabiertos.models;

import java.util.ArrayList;

/**
 * Created by leydidiego on 2/06/17.
 */

public class MunicipioRespuesta extends Municipio {

    //@SerializedName("data")
    private ArrayList<Municipio> results;

    public ArrayList<Municipio> getResults() {
        return results;
    }

    public void setResults(ArrayList<Municipio> results) {
        this.results = results;
    }
}
