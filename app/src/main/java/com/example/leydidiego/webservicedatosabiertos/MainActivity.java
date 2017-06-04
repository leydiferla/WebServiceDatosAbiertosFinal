package com.example.leydidiego.webservicedatosabiertos;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.leydidiego.webservicedatosabiertos.DatosapiService.DatosapiService;
import com.example.leydidiego.webservicedatosabiertos.models.ListaMunicipioAdapter;
import com.example.leydidiego.webservicedatosabiertos.models.MunicipioRespuesta;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "Putumayo";

    private Retrofit retrofit;

    private RecyclerView recyclerView;
    private ListaMunicipioAdapter listaMunicipioAdapter;
    private TextView nombreTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        listaMunicipioAdapter = new ListaMunicipioAdapter(this);
        recyclerView.setAdapter(listaMunicipioAdapter);
        GridLayoutManager layoutManager = new GridLayoutManager(this,1);
        recyclerView.setLayoutManager(layoutManager);

        retrofit = new Retrofit.Builder()
                .baseUrl("https://www.datos.gov.co/resource/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        obtenerDatos();
    }

    private void obtenerDatos() {


        DatosapiService service = retrofit.create(DatosapiService.class);
        Call<List<MunicipioRespuesta>> municipioRespuestaCall = service.obtenerListaMunicipio();

        municipioRespuestaCall.enqueue(new Callback<List<MunicipioRespuesta>>() {
            @Override
            public void onResponse(Call<List<MunicipioRespuesta>> call, Response<List<MunicipioRespuesta>> response) {

                if (response.isSuccessful()) {

                    List<MunicipioRespuesta> municipioRespuesta =  response.body();
                    // ArrayList<Municipio> listaMunicipio = municipioRespuesta.getResults();


                    listaMunicipioAdapter.adicionarListaMunicipio(municipioRespuesta);

                  /*  for (int i=0;i<municipioRespuesta.size();i++){
                        Municipio m = municipioRespuesta.get(i);
                        Log.i(TAG, "Muni:  "+m.getNombremunicipio());
                    }*/


                } else {
                    Log.e(TAG, " onResponse: "+ response.errorBody());

                }
            }

            @Override
            public void onFailure(Call<List<MunicipioRespuesta>> call, Throwable t) {
                Log.e(TAG, " onResponse: "+ t.getMessage());
            }
        });


    }

    public void detalle(View view)
    {
        nombreTxt = (TextView) findViewById(R.id.nombreTextView);
        Intent i = new Intent(this, detalle_municipio.class);
        i.putExtra("municipio", nombreTxt.getText().toString());
        startActivity(i);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent i = new Intent(this, AcercaDe.class);
            startActivity(i);
        }

        return super.onOptionsItemSelected(item);
    }
}
