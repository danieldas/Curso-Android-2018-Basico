package com.android.curso.librerias;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.tvTexto)TextView _tvTexto;
    @BindView(R.id.btnMostrar)Button _btnMostrar;

    @OnClick(R.id.btnMostrar)
    public void Enviar(View view){
        _tvTexto.setText("Hola mundo");
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

    }
}
