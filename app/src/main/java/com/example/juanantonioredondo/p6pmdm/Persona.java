package com.example.juanantonioredondo.p6pmdm;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

public class Persona extends AppCompatActivity {

    ImageView foto1;
    ImageView foto2;
    ImageView foto3;
    ImageView foto4;
    ImageView foto5;
    ImageView foto6;
    String correo;
    String telefono;
    SharedPreferences prefs;
    SharedPreferences.Editor editor;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_persona);
        foto1 = findViewById(R.id.imageView3);
        foto2 = findViewById(R.id.imageView4);
        foto3 = findViewById(R.id.imageView5);
        foto4 = findViewById(R.id.imageView6);
        foto5 = findViewById(R.id.imageView7);
        foto6 = findViewById(R.id.imageView8);

        prefs = getSharedPreferences("ficheroConfigUsuario", Context.MODE_PRIVATE);
        editor = prefs.edit();






        editor.putString("telefono1", "23456234");
        editor.putString("telefono2", "34653234");
        editor.putString("telefono3", "54477635");
        editor.putString("telefono4", "8765432");
        editor.putString("telefono5", "246576543");
        editor.putString("telefono6", "234363441");
        editor.putString("correo1", "correofalso@123.com");
        editor.putString("correo2", "correofalso@456.com");
        editor.putString("correo3", "correofalso@789.com");
        editor.putString("correo4", "correofalso@101.com");
        editor.putString("correo5", "correofalso@111.com");
        editor.putString("correo6", "correofalso@112.com");

            editor.commit();




        foto1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                correo="correo1";
                telefono="telefono1";
                registerForContextMenu(foto1);
                return false;
            }
        });

        foto2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                correo="correo2";
                telefono="telefono2";
                registerForContextMenu(foto2);
                return false;
            }
        });

        foto3.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                correo="correo3";
                telefono="telefono3";
                registerForContextMenu(foto3);
                return false;
            }
        });

        foto4.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                correo="correo4";
                telefono="telefono4";
                registerForContextMenu(foto4);
                return false;
            }
        });

        foto5.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                correo="correo5";
                telefono="telefono5";
                registerForContextMenu(foto5);
                return false;
            }
        });

        foto6.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                correo="correo6";
                telefono="telefono6";
                registerForContextMenu(foto6);
                return false;
            }
        });


    }


    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo)
    {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_contextual, menu);
    }

    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item3:


                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:" + prefs.getString(telefono, " ")));
                startActivity(intent);

                break;
            case R.id.item4:

                Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
                emailIntent.setData(Uri.parse("mailto:" + prefs.getString(correo, " ")));
                startActivity(emailIntent);

                break;
        }
        return true;
    }

}
