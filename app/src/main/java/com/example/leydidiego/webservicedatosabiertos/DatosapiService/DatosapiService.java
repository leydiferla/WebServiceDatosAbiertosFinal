package com.example.leydidiego.webservicedatosabiertos.DatosapiService;

import com.example.leydidiego.webservicedatosabiertos.models.MunicipioRespuesta;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by leydidiego on 2/06/17.
 */

public interface DatosapiService {
    @GET("jne3-w85n.json")
    Call<List<MunicipioRespuesta>> obtenerListaMunicipio();
}
