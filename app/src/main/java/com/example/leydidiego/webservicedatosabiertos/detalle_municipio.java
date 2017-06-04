package com.example.leydidiego.webservicedatosabiertos;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import retrofit2.Retrofit;

/**
 * Created by leydidiego on 2/06/17.
 */

public class detalle_municipio extends AppCompatActivity {
    private Retrofit retrofit;
    private TextView txtmunicipio;
    private TextView txtañofun;
    private TextView txtalcalde;
    private TextView txttemperatura;


    String mun, alcal, anio, temp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_municipio);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);


        txtmunicipio = (TextView) findViewById(R.id.txt_mun);
        txtañofun = (TextView) findViewById(R.id.txt_año);
        txtalcalde = (TextView) findViewById(R.id.txt_alcalde);
        txttemperatura = (TextView) findViewById(R.id.txt_tem);

        Bundle bundle = getIntent().getExtras();
        mun = bundle.getString("municipio");
        alcal = bundle.getString("alcalde");
        anio = bundle.getString("anio");
        temp = bundle.getString("temp");


        txtmunicipio.setText(mun);
        txtañofun.setText(anio);
        txtalcalde.setText(alcal);
        txttemperatura.setText(temp);

    }

}