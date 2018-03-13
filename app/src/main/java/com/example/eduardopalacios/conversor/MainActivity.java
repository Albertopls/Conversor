package com.example.eduardopalacios.conversor;

import android.content.Context;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.eduardopalacios.conversor.Adapters.Adapter;
import com.example.eduardopalacios.conversor.Clases.Item;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Spinner spinner,spinner2,spinner3;
    EditText cantidad;
    Button aceptar;
    Context context=this;
    List<Item> items=new ArrayList<Item>();
    Adapter adapter;
    Double cantidadEditText,resultado;
    String item1;
    String item2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        spinner=(Spinner)findViewById(R.id.spiner);
        spinner2=(Spinner)findViewById(R.id.spiner2);
        cantidad=(EditText) findViewById(R.id.cantidad);
        aceptar=(Button)findViewById(R.id.aceptar);


        items.add(new Item("MXN",R.drawable.peso));
        items.add(new Item("USD",R.drawable.dolar));
        items.add(new Item("EUR",R.drawable.euro));
        items.add(new Item("JPY",R.drawable.yen));
        

        adapter=new Adapter(this,R.layout.spinnerdesign,items);



        spinner.setAdapter(adapter);

        spinner2.setAdapter(adapter);

        OnItemSelected(spinner);
        OnItemSelected(spinner2);






    }

    public  void OnItemSelected(final Spinner spinner)
    {
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                if (spinner.getId()==R.id.spiner)
                {

                    item1=items.get(i).getTitulo();

                }

                if (spinner.getId()==R.id.spiner2)
                {

                    item2=items.get(i).getTitulo();

                }



            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    public void OnButtonclickListener(View view)
    {
        if (view.getId()==R.id.aceptar)
        {
            conversion(item1,item2);
        }

    }


    public void conversion(String item1,String item2)
    {

        //CONVERSIO NDOLARES
        if(item1.equalsIgnoreCase("USD") && item2.equalsIgnoreCase("MXN"))
        {

            Operacion(18.7076);
        }

        if(item1=="USD" && item2=="EUR")
        {

            Operacion(0.805781);
        }

        if(item1=="USD" && item2=="JPY")
        {

            Operacion( 106.118);

        }

        //CONVERSION EUROS

        if(item1.equalsIgnoreCase("EUR") && item2.equalsIgnoreCase("MXN"))
        {

            Operacion(23.2187);
        }

        if(item1=="EUR" && item2=="USD")
        {

            Operacion(1.24109 );
        }

        if(item1=="EUR" && item2=="JPY")
        {

            Operacion( 131.677);

        }


        //CONVERSION YEN

        if(item1.equalsIgnoreCase("JPY") && item2.equalsIgnoreCase("MXN"))
        {

            Operacion( 0.176360);
        }

        if(item1=="JPY" && item2=="EUR")
        {

            Operacion(0.007596310 );
        }

        if(item1=="JPY" && item2=="USD")
        {

            Operacion( 0.00942775);

        }

        //CONVERSION PESO MEXICANO

        if(item1.equalsIgnoreCase("MXN") && item2.equalsIgnoreCase("USD"))
        {

            Operacion( 0.0534443 );
        }

        if(item1=="MXN" && item2=="EUR")
        {

            Operacion(0.0430641 );
        }

        if(item1=="MXN" && item2=="JPY")
        {

            Operacion( 5.66797);

        }

    }

    public void Operacion(Double valorMoneda)
    {
        boolean comprobandoParsing=false;
        if (cantidad.length()>0)
        {

            //Comprobando si la cantidad es numerica.
            try {
                //Ejecuta el try cuando se realizo correctamente la conversion
                cantidadEditText=Double.parseDouble(cantidad.getText().toString());
                comprobandoParsing=true;

            }catch (Exception e)
            {
                //Ejecuta el catch cuando no se realizo correctamente la conversion
                e.printStackTrace();
                comprobandoParsing=false;
            }

            if (comprobandoParsing)
            {
                resultado=valorMoneda*cantidadEditText;
                Toast.makeText(getApplicationContext(),String.valueOf(resultado),Toast.LENGTH_SHORT).show();
            }
            else {
                Toast.makeText(getApplicationContext(),"Conversion fallida",Toast.LENGTH_SHORT).show();
            }

        }
        else {
            Toast.makeText(getApplicationContext(),"campo vacio",Toast.LENGTH_SHORT).show();
        }

    }


}
