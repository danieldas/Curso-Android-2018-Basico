package com.android.curso.ventacomida;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView _tvCantidad, _tvNombre, _tvPrecio, _tvSubtotal, _tvTotal;
    private ImageView _imgPlato;
    private int indice=0;
    private double total=0, subtotal;

    int imagenes[]={R.drawable.img1, R.drawable.img2, R.drawable.img3, R.drawable.img4, R.drawable.img5};
    String nombres[]={"Charquekan","Chicharron", "Majadito", "Pollo", "Silpancho"};
    double precios[]={20, 30, 15, 17, 25};
    int cantidades[]={0,0,0,0,0};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inicializarComponentes();
    }

    private void inicializarComponentes(){
        _tvNombre= findViewById(R.id.tvNombre);
        _tvCantidad= findViewById(R.id.tvCantidad);
        _tvPrecio=  findViewById(R.id.tvPrecio);
        _tvSubtotal= findViewById(R.id.tvSubtotal);
        _tvTotal= findViewById(R.id.tvTotal);
        _imgPlato= findViewById(R.id.imgPlato);

        //dar valores por defecto
        _tvNombre.setText("Nombre: "+nombres[0]);
        _tvCantidad.setText("Cantidad: "+cantidades[0]);
        _tvPrecio.setText(precios[0]+" Bs");
        subtotal=cantidades[0]*precios[0];
        _tvSubtotal.setText("Subtotal: "+subtotal);
        _tvTotal.setText("Total: "+total);

    }

    public void siguiente (View view){
        indice++;
        if (indice>4)
        {
            indice=0;
        }
        _tvNombre.setText("Nombre: "+nombres[indice]);
        _tvPrecio.setText(precios[indice]+" Bs");
        _tvCantidad.setText("Cantidad: "+cantidades[indice]);
        _imgPlato.setImageResource(imagenes[indice]);
        subtotal=cantidades[indice]*precios[indice];
        _tvSubtotal.setText("Subtotal: "+subtotal+"");
    }

    public void anterior (View view){
        indice--;
        if (indice<0)
        {
            indice=4;
        }
        _tvNombre.setText("Nombre: "+nombres[indice]);
        _tvPrecio.setText(precios[indice]+" Bs");
        _tvCantidad.setText("Cantidad: "+cantidades[indice]);
        _imgPlato.setImageResource(imagenes[indice]);
        subtotal=cantidades[indice]*precios[indice];
        _tvSubtotal.setText("Subtotal: "+subtotal);
    }

    public  void comprar(View view){
        cantidades[indice]=cantidades[indice]+1;
        _tvCantidad.setText("Cantidad: "+cantidades[indice]);
        subtotal=cantidades[indice]*precios[indice];
        _tvSubtotal.setText("Subtotal: "+subtotal);
        total=total+precios[indice];
        _tvTotal.setText("Total: "+total);
    }

    public void cancelar(View view){
        if(cantidades[indice]>0)
        {
           cantidades[indice]=cantidades[indice]-1;
            _tvCantidad.setText("Cantidad: "+cantidades[indice]);
            subtotal=cantidades[indice]*precios[indice];
            _tvSubtotal.setText("Subtotal: "+subtotal);
            total=total-precios[indice];
            _tvTotal.setText("Total: "+total);
        }
        else{
            Toast.makeText(this, "Debe realizar por o menos una compra", Toast.LENGTH_LONG).show();
        }
    }

    public void finalizar(View view) {
        String reporte="";
        double sub=0;
        for(int i=0; i<5; i++)
        {
            sub=cantidades[i]*precios[i];
            reporte=reporte+nombres[i]+" - "+cantidades[i]+" - "+sub+"\n";
        }
        reporte=reporte+" Total a pagar: "+total;
        Intent intent= new Intent(MainActivity.this, ReporteActivity.class);
        intent.putExtra("parametro", reporte);
        startActivity(intent);
    }
}
