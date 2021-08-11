package com.example.counterapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
private int counter=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView textCounter=(TextView) findViewById(R.id.textView3);

        Button startButton=(Button)findViewById(R.id.button5);
        Button stopButton=(Button)findViewById(R.id.button4);

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter=0;
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        while(!stopButton.isPressed()){
                            try {
                                Thread.sleep(500);
                            }catch (InterruptedException e){
                                e.printStackTrace();
                            }
                            textCounter.post(new Runnable() {
                                @Override
                                public void run() {
                                    counter++;
                                    textCounter.setText(" "+counter);
                                }
                            });
                        }
                    }
                }).start();

            }
        });

        stopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Thread.sleep(500);
                    textCounter.setText(" "+counter);
                }catch (Exception e) {
                    e.printStackTrace();
                }
                }

        });
    }
}