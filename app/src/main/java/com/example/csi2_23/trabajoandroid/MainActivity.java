package com.example.csi2_23.trabajoandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.victor.loading.rotate.RotateLoading;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    private static final long TIEMPO_SPLAH = 6000;
    private static final int TIEMPO_RECARGA_BARRA = 100;
    private ImageView imgBackground;
    private ProgressBar progressBarBoot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgBackground = (ImageView)findViewById(R.id.imgBackground);

        Timer timer = new Timer();
        Timer timer2 = new Timer();

        progressBarBoot = (ProgressBar)findViewById(R.id.progressBarBoot);

        // Vamos a crear una tarea de x segundos
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                Intent i = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(i);
                finish();
            }
        };

        // Vamos a crear una tarea para recargar la barra
        TimerTask task2 = new TimerTask() {
            @Override
            public void run() {
                progressBarBoot.setProgress(progressBarBoot.getProgress()+TIEMPO_RECARGA_BARRA);
            }
        };

        timer.schedule(task, TIEMPO_SPLAH);
        timer2.schedule(task2, TIEMPO_RECARGA_BARRA, TIEMPO_SPLAH/TIEMPO_RECARGA_BARRA);

        ((RotateLoading)findViewById(R.id.rotateloading)).start();
    }
}
