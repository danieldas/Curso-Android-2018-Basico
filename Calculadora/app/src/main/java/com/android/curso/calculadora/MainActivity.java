package com.android.curso.calculadora;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
Button _btnSumar, _btnRestar, _btnMultiplicar, _btnDividir;
EditText _et1, _et2;
TextView _tvResultado;
Double numero1=0.0;
Double numero2=0.0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        _btnSumar=findViewById(R.id.btnSumar);
        _btnRestar=findViewById(R.id.btnRestar);
        _btnMultiplicar=findViewById(R.id.btnMultiplicar);
        _btnDividir=findViewById(R.id.btnDividir);
        _et1=findViewById(R.id.et1);
        _et2=findViewById(R.id.et2);
        _tvResultado=findViewById(R.id.tvResultado);


//Esta es la 1ra forma de trabajar con los clicks (restar, multiplicar)
        _btnRestar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cargarDatosEditText();
               _tvResultado.setText(restar(numero1, numero2)+"");
            }
        });
        _btnMultiplicar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cargarDatosEditText();
                _tvResultado.setText(multiplicar(numero1, numero2)+"");
            }
        });

        _btnDividir.setOnClickListener(this);
    }
    //Esta es la 3ra forma de trabajar con los clicks (se pone como nombre al mismo nombre que se puso en la propiedad onclick en el xml)
    public void sumar(View view)
    {
        cargarDatosEditText();
        _tvResultado.setText(funcionSumar(numero1, numero2)+"");
    }

    //las siguientes 4 funciones son las que hacen las operaciones
    public Double funcionSumar(Double nro1, Double nro2)
    {
        return nro1+nro2;
    }
    public Double restar(Double nro1, Double nro2)
    {
        return nro1-nro2;
    }
    public Double multiplicar(Double nro1, Double nro2)
    {
        return nro1*nro2;
    }
    public Double dividir(Double nro1, Double nro2)
    {
        return nro1/nro2;
    }
    private void cargarDatosEditText()
    {
        if (TextUtils.isEmpty(_et1.getText().toString())||TextUtils.isEmpty(_et2.getText().toString()))
        {
            Toast.makeText(this, "Ingrese números válidos", Toast.LENGTH_SHORT).show();
        }
        else
        {
            numero1=Double.parseDouble(_et1.getText()+"");
            numero2=Double.parseDouble(_et2.getText()+"");
        }
    }

    //Esta es la 2da forma de trabajar con los clicks
    @Override
    public void onClick(View view) {
        cargarDatosEditText();
        _tvResultado.setText(dividir(numero1, numero2)+"");
    }
}
