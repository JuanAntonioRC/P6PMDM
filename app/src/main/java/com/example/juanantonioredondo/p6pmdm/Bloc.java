package com.example.juanantonioredondo.p6pmdm;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

public class Bloc extends AppCompatActivity {

    TextView area;
    SharedPreferences prefs;
    SharedPreferences.Editor editor;
    Button guardar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bloc);

        area = findViewById(R.id.editText);
        guardar = findViewById(R.id.op1);

        prefs = getSharedPreferences("ficheroConfig", Context.MODE_PRIVATE);
        editor = prefs.edit();

        if (prefs.getString("texto", " ").isEmpty()){



        }

        if (prefs.getString("texto", " ") != null){

            area.setText(prefs.getString("texto", " "));

        }


    }

    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.op1:

                editor.putString("texto", area.getText().toString());
                editor.commit();

                break;
        }
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_bloc, menu);
        return true;
    }
}
