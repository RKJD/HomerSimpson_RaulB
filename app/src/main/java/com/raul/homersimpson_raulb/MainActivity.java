package com.raul.homersimpson_raulb;

import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    AnimationDrawable titulo_simpson;
    boolean bol = false;
     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView titulo = findViewById(R.id.tituloSimpsons);
        titulo.setBackgroundResource(R.drawable.titulo);
        titulo_simpson = (AnimationDrawable) titulo.getBackground();


        final ImageView ejeAzul =findViewById(R.id.ejeAzul);
        final ImageView ejeRojo =findViewById(R.id.ejeRojo);
        final ImageView ejeVerde =findViewById(R.id.ejeVerde);
        final ImageView ojo =findViewById(R.id.ojo);
        final ImageView donut =findViewById(R.id.donut);
         ejeAzul.setVisibility(View.INVISIBLE);
         ejeRojo.setVisibility(View.INVISIBLE);
         ejeVerde.setVisibility(View.INVISIBLE);
         ojo.setVisibility(View.INVISIBLE);
         donut.setVisibility(View.INVISIBLE);

        titulo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(bol==true){
                    //cambiar bool
                    bol=false;
                    // quitar fotos
                    ejeAzul.setVisibility(View.INVISIBLE);
                    ejeVerde.setVisibility(View.INVISIBLE);
                    ojo.setVisibility(View.INVISIBLE);
                    donut.setVisibility(View.INVISIBLE);
                    ejeRojo.setVisibility(View.INVISIBLE);

                    }
                else{
                    bol=true;
                    // cambiar bool
                    // poner ftos
                    ejeRojo.setVisibility(View.VISIBLE);
                    ojo.setVisibility(View.VISIBLE);
                    ejeAzul.setVisibility(View.VISIBLE);
                    ejeVerde.setVisibility(View.VISIBLE);
                    donut.setVisibility(View.VISIBLE);
                 }
            }
        });
    }
    @Override
    public void onWindowFocusChanged(boolean bol) {
        super.onWindowFocusChanged(bol);
        titulo_simpson.start();
    }
}