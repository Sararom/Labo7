package com.example.uca.labo7;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.uca.labo7.datos.Persona;
import com.example.uca.labo7.entidades.DBHelper;

/**
 * Created by UCA on 16/05/2018.
 */

public class RegistrarActivity extends AppCompatActivity {

    private EditText txtId, txtNombre;
    private Button btnEnviar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);

        inicializarControles();

        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean flag = DBHelper.myDB.add(new Persona(
                        txtId.getText().toString(),
                        txtNombre.getText().toString()
                ));
                if (flag) {
                    Log.d("Edit", txtNombre.getText().toString());
                }
            }
        });

    }


    private void inicializarControles() {
        btnEnviar = findViewById(R.id.btnRegistrar);
        txtId = findViewById(R.id.txtId);
        txtNombre=findViewById(R.id.txtNombre);
    }
}
