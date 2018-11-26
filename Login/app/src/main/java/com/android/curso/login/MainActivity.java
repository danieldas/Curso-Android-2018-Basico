package com.android.curso.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
EditText _etCuenta, _etPassword;
Button _btnIngresar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        _etCuenta=findViewById(R.id.etCuenta);
        _etPassword=findViewById(R.id.etPassword);
        _btnIngresar=findViewById(R.id.btnIngresar);

        _btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(_etCuenta.getText().toString().equals("admin")
                     && _etPassword.getText().toString().equals("123456"))
                {
                    Intent intent=new Intent(MainActivity.this, Main2Activity.class);
                    startActivity(intent);
                }

                else {
                    Toast.makeText(MainActivity.this, "Credenciales incorrectas", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
