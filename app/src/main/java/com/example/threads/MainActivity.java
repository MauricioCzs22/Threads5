package com.example.threads;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity {

    private Button button1;
    private TextView textView;
    private Handler handler;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(this, "OnCreate", Toast.LENGTH_SHORT).show();
        Toast.makeText(this, "OnPause", Toast.LENGTH_SHORT).show();
        Toast.makeText(this, "OnStop", Toast.LENGTH_SHORT).show();


        button1 = findViewById(R.id.button1);
        textView = findViewById(R.id.textView);

        handler = new Handler(Looper.getMainLooper()) {
            @Override
            public void handleMessage(Message msg) {
                switch (msg.what) {
                    case 0:
                        textView.setText("Estado: Nuevo");
                        break;
                    case 1:
                        textView.setText("Estado: Ejecutable");
                        break;
                    case 2:
                        textView.setText("Estado: Parado");

                        break;
                    case 3:
                        textView.setText("Estado: Muerto");
                        break;
                }
            }
        };

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new MyThread(handler)).start();
            }
        });
    }

    private class MyThread implements Runnable {

        private Handler handler;

        public MyThread(Handler handler) {
            this.handler = handler;
        }

        @Override
        public void run() {
            // Estado nuevo
            Message msg = new Message();
            msg.what = 0;
            handler.sendMessage(msg);

            // Estado ejecutable
            Looper.prepare();

            // Estado parado

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


            // Estado muerto

            msg = new Message();
            msg.what = 3;
            handler.sendMessage(msg);
        }
    }
}

