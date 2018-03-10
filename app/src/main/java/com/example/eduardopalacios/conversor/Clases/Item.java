package com.example.eduardopalacios.conversor.Clases;

/**
 * Created by eduardopalacios on 05/03/18.
 */

public class Item {

    String titulo;
    int imagen;

    public Item(String titulo,int imagen)
    {
        this.titulo=titulo;
        this.imagen=imagen;
    }

    public String getTitulo()
    {
        return titulo;
    }

        public int getImagen()
    {
        return imagen;
    }
}
