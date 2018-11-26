package com.android.curso.ventacomida;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ReporteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reporte);

        TextView _tvReporte=findViewById(R.id.tvReporte);
        String rep=getIntent().getExtras().getString("parametro");
        _tvReporte.setText(rep);
    }
}
