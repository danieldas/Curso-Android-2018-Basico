package com.android.curso.animacionestransiciones;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this, Main2Activity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.fadein, R.anim.fadeout);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        TextView _tvTexto=findViewById(R.id.tvTexto);
        Animation animation;
        //noinspection SimplifiableIfStatement
        if (id == R.id.alpha) {
            animation= AnimationUtils.loadAnimation(getApplicationContext(), R.anim.alpha);
            _tvTexto.startAnimation(animation);
        }
        else if (id == R.id.rotate) {
            animation= AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate);
            _tvTexto.startAnimation(animation);
        }
        else if (id == R.id.translate) {
            animation= AnimationUtils.loadAnimation(getApplicationContext(), R.anim.translate);
            _tvTexto.startAnimation(animation);
        }
        else if (id == R.id.scale) {
            animation= AnimationUtils.loadAnimation(getApplicationContext(), R.anim.scale);
            _tvTexto.startAnimation(animation);
        }

        return super.onOptionsItemSelected(item);
    }
}
