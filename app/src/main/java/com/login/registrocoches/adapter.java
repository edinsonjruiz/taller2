package com.login.registrocoches;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import java.util.ArrayList;

public class adapter extends ArrayAdapter<Datos> implements Filterable {

    Context context;
    int layaoutResourceID;

    ArrayList<Datos> data;


    static class Holder {
        TextView placa;
        TextView marca;
        TextView modelo;
        TextView radio1;


    }

    public  adapter(Context context, int layaoutResourceID, ArrayList<Datos> data) {
        super(context,layaoutResourceID,data);

        this.context = context;
        this.layaoutResourceID = layaoutResourceID;
        this.data = data;
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        View row = convertView;

        Holder holder = null;

        if(row == null) {
            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            row = inflater.inflate(layaoutResourceID, parent,false);
            holder = new Holder();
            holder.placa = (TextView) row.findViewById(R.id.one);
            holder.marca = (TextView) row.findViewById(R.id.two);
            holder.modelo = (TextView) row.findViewById(R.id.three);
            holder.radio1 = (TextView) row.findViewById(R.id.four);

            row.setTag(holder);


        }else {
            holder = (Holder)row.getTag();
        }

        Datos contacto = data.get(position);
        holder.placa.setText("Placa: "+contacto.getPlaca());
        holder.marca.setText("Marca: "+contacto.getMarca());
        holder.modelo.setText("Modelo: "+contacto.getModelo());
        holder.radio1.setText("Tipo: "+contacto.getRadio1());



        return row;
    }



}