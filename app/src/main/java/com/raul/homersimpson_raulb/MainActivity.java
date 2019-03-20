package com.raul.homersimpson_raulb;

import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    AnimationDrawable titulo_simpson;
    boolean bol = false;
    boolean bolMusica = false;
    boolean bolAnime = false;
    MediaPlayer player;

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
                if(bol){
                    //cambiar bool
                    bol=false;
                    // quitar fotos
                    ejeAzul.setVisibility(View.INVISIBLE);
                    ejeVerde.setVisibility(View.INVISIBLE);
                    paradeRotar(ojo);
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
                    rotarImagen(ojo);
                    ejeAzul.setVisibility(View.VISIBLE);
                    ejeVerde.setVisibility(View.VISIBLE);
                    donut.setVisibility(View.VISIBLE);

                 }
            }

        });
         donut.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 if(bolMusica){
                     //cambiar bool
                     bolMusica=false;
                     pause(v);
                 }
                 else{
                     bolMusica=true;
                     // cambiar bool
                     play(v);
                 }
             }
         });
    }
    @Override
    public void onWindowFocusChanged(boolean bol) {
        super.onWindowFocusChanged(bol);
        titulo_simpson.start();
    }

    public void play(View v) {
        if (player == null) {

            player = MediaPlayer.create(this, R.raw.the_simpsons);
            player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    stopPlayer();
                }
            });

        }

        player.start();
        Toast.makeText(this, "Reproductor iniciado", Toast.LENGTH_SHORT).show();
    }

    public void pause(View v) {
        if (player != null) {
            player.pause();
            Toast.makeText(this, "Reproductor pausado", Toast.LENGTH_SHORT).show();
        }
    }

    public void stop(View v) {
        stopPlayer();
    }

    private void stopPlayer() {
        if (player != null) {
            player.release();
            player = null;
            Toast.makeText(this, "Reproductor parado", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        stopPlayer();
    }


    private void rotarImagen(View view) {
        RotateAnimation animation = new RotateAnimation(50, -50,
                RotateAnimation.RELATIVE_TO_SELF, 0.5f,
                RotateAnimation.RELATIVE_TO_SELF, 0.5f);

        animation.setDuration(2000);
        animation.setRepeatCount(Animation.INFINITE);
        animation.setRepeatMode(Animation.REVERSE);
        view.startAnimation(animation);
    }
    private void paradeRotar(View view) {
        RotateAnimation animation = new RotateAnimation(0, 1,
                RotateAnimation.RELATIVE_TO_SELF, 0.5f,
                RotateAnimation.RELATIVE_TO_SELF, 0.5f);

        animation.setDuration(1);
        animation.setRepeatCount(0);
        animation.setRepeatMode(Animation.REVERSE);
        view.startAnimation(animation);

    }
}
