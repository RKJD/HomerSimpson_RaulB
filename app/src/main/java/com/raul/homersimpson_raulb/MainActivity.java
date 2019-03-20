package com.raul.homersimpson_raulb;

import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    AnimationDrawable titulo_simpson;
    boolean bol = false;
    boolean bolMusica = false;
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
                    paradeRotar(ojo);
                    paradeRotar(ejeAzul);
                    paradeRotar(ejeRojo);
                    paradeRotar(ejeVerde);
                    paradeRotar(donut);

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
                    rotarImagen(ojo);
                    ejeAzul.setVisibility(View.VISIBLE);
                    ejeVerde.setVisibility(View.VISIBLE);
                    donut.setVisibility(View.VISIBLE);
                    rotarDonut(donut);

                    rotarEngranaje1(ejeVerde);
                    rotarEngranaje2(ejeAzul);
                    rotarEngranaje2(ejeRojo);

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
    private void rotarEngranaje1(View view) {
        RotateAnimation animation = new RotateAnimation(0, 360,
                RotateAnimation.RELATIVE_TO_SELF, 0.5f,
                RotateAnimation.RELATIVE_TO_SELF, 0.5f);

        animation.setDuration(2000);
        animation.setRepeatCount(Animation.INFINITE);
        animation.setRepeatMode(Animation.INFINITE);
        view.startAnimation(animation);
    }
    private void rotarEngranaje2(View view) {
        RotateAnimation animation = new RotateAnimation(360, 0,
                RotateAnimation.RELATIVE_TO_SELF, 0.5f,
                RotateAnimation.RELATIVE_TO_SELF, 0.5f);

        animation.setDuration(2000);
        animation.setRepeatCount(Animation.INFINITE);
        animation.setRepeatMode(Animation.INFINITE);
        view.startAnimation(animation);
    }
    private void rotarDonut(View view) {
        AnimationSet animationSet = new AnimationSet(true);
        TranslateAnimation animation = new TranslateAnimation(
                TranslateAnimation.RELATIVE_TO_PARENT,0.0f,
                TranslateAnimation.RELATIVE_TO_PARENT,0.0f,
                TranslateAnimation.RELATIVE_TO_PARENT,0.0f,
                TranslateAnimation.RELATIVE_TO_PARENT,0.2f);

        animation.setDuration(2000);
        animation.setRepeatCount(Animation.INFINITE);
        animation.setRepeatMode(Animation.REVERSE);


        RotateAnimation animation2 = new RotateAnimation(0, 360,
                RotateAnimation.RELATIVE_TO_SELF, 0.5f,
                RotateAnimation.RELATIVE_TO_SELF, 0.5f);

        animation2.setDuration(2000);
        animation2.setRepeatCount(Animation.INFINITE);
        animation2.setRepeatMode(Animation.INFINITE);

        animationSet.addAnimation(animation);
        animationSet.addAnimation(animation2);
        view.startAnimation(animationSet);
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
