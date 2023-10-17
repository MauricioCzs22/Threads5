package com.example.threads;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;


public class SegundaActivity2 extends AppCompatActivity {
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda2);

        textView = findViewById(R.id.textView);

        // Actualiza el estado del thread
        Thread.State state = Thread.currentThread().getState();
        textView.setText("Estado actual: ");
    }
}
