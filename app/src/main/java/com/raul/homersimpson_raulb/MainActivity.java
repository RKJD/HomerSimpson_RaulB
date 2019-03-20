package com.raul.homersimpson_raulb;

import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    AnimationDrawable titulo_simpson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView titulo=findViewById(R.id.titulo_simpson);
        titulo.setBackgroundResource(R.drawable.titulo);
        titulo_simpson = (AnimationDrawable) titulo.getBackground();
    }
    @Override
    public void onWindowFocusChanged(boolean bol) {
        super.onWindowFocusChanged(bol);
        titulo_simpson.start();
    }
}