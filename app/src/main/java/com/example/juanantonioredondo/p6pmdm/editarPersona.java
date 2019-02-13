package com.example.juanantonioredondo.p6pmdm;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class editarPersona extends AppCompatActivity {

    TextView call;
    TextView mail;
    Button button;
    SharedPreferences prefs;
    SharedPreferences.Editor editor;

    String correo;
    String telefono;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_persona);


        call = findViewById(R.id.editText5);
        mail = findViewById(R.id.editText6);
        button = findViewById(R.id.button);

        prefs = getSharedPreferences("ficheroConfigUsuarios", Context.MODE_PRIVATE);
        editor = prefs.edit();


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            correo = getIntent().getStringExtra("correo1");
            telefono = getIntent().getStringExtra("telefono1");

            editor.putString("telefono1", call.getText().toString());
            editor.putString("correo1", mail.getText().toString());

            }
        });

    }
}
