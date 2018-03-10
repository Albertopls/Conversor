package com.example.eduardopalacios.conversor.Adapters;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.eduardopalacios.conversor.Clases.Item;
import com.example.eduardopalacios.conversor.Holders.HolderItem;
import com.example.eduardopalacios.conversor.R;

import java.util.List;

/**
 * Created by eduardopalacios on 05/03/18.
 */

public class Adapter extends ArrayAdapter<Item> {

    Context context;
    int resource;
    List<Item> datos;
    public Adapter( Context context, int resource,  List<Item> datos) {

        super(context, resource, datos);

        this.context=context;
        this.resource=resource;
        this.datos=datos;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return ConstruirVista(position,convertView,parent);
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {

        return ConstruirVista(position,convertView,parent);
    }

    public View ConstruirVista(int position,View convertView,ViewGroup parent)
    {
        View row=convertView;
        HolderItem holderItem=null;
        if (row==null)
        {
            LayoutInflater inflater =LayoutInflater.from(context);
            row=inflater.inflate(resource,parent,false);

            holderItem=new HolderItem();

            holderItem.texto=(TextView)row.findViewById(R.id.moneda);
            holderItem.imagen=(ImageView)row.findViewById(R.id.bandera);
            row.setTag(holderItem);


        }
        else {
            holderItem=(HolderItem)row.getTag();
        }

        holderItem.texto.setText(datos.get(position).getTitulo());
        holderItem.imagen.setImageResource(datos.get(position).getImagen());

        return row;

    }
}
