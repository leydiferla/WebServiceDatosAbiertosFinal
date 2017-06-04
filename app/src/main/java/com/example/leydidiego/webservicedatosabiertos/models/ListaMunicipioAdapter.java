package com.example.leydidiego.webservicedatosabiertos.models;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.leydidiego.webservicedatosabiertos.R;
import com.example.leydidiego.webservicedatosabiertos.detalle_municipio;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by leydidiego on 2/06/17.
 */

public class ListaMunicipioAdapter extends RecyclerView.Adapter<ListaMunicipioAdapter.ViewHolder>{

    private ArrayList<Municipio> dataset;
    private Context context;



    public  ListaMunicipioAdapter(Context context){

        this.context = context;
        dataset = new ArrayList<>();

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_municipio, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        final Municipio m =dataset.get(position);
        holder.nombreTxt.setText(m.getNombremunicipio());


        holder.nombreTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, detalle_municipio.class);
                intent.putExtra("municipio", m.getNombremunicipio());
                intent.putExtra("email", m.getEmail());
                intent.putExtra("alcalde", m.getNombre());
                intent.putExtra("anio", m.getA_o());
                intent.putExtra("funda", m.getFundador());
                intent.putExtra("web", m.getPaginaweb());
                intent.putExtra("temp", m.getTemperatura_media());
                intent.putExtra("vereda", m.getVeredas_2005());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }

    public void adicionarListaMunicipio(List<MunicipioRespuesta> municipioRespuesta) {

        dataset.addAll(municipioRespuesta);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView nombreTxt, nombre ;

        public ViewHolder(View itemView) {
            super(itemView);

            nombreTxt = (TextView) itemView.findViewById(R.id.nombreTextView);
            nombre = (TextView) itemView.findViewById(R.id.txt_mun);

        }

    }

}

