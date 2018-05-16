package com.example.uca.labo7;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.uca.labo7.datos.Persona;
import com.example.uca.labo7.entidades.DBHelper;

/**
 * Created by UCA on 16/05/2018.
 */

public class ModificarActivity extends AppCompatActivity{
    private EditText id, nombre;
    private Button btnBuscar,btnEliminar,btnActualizar,btnLimpiar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modificar);
        
        inicializarControles();

        btnBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Persona p = DBHelper.myDB.findUser(id.getText().toString());
                if(p==null){
                    Toast.makeText(getApplicationContext(),"El usuario no fue encontrado",Toast.LENGTH_SHORT).show();
                    limpiar();
                }else {
                    nombre.setText(p.getNombre());
                }
            }
        });

        btnActualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper.myDB.editUser(new Persona(id.getText().toString(),nombre.getText().toString()));
            }
        });

        btnEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper.myDB.deleteUser(id.getText().toString());
                limpiar();
            }
        });

        btnLimpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                limpiar();
            }
        });
    }

    private void inicializarControles() {
        id = findViewById(R.id.txtIdM);
        nombre= findViewById(R.id.txtNombreM);
        btnEliminar=findViewById(R.id.btnEliminar);
        btnActualizar=findViewById(R.id.bntActualizar);
        btnLimpiar=findViewById(R.id.btnLimpiar);
        btnBuscar=findViewById(R.id.btnBuscar);
    }

    public void limpiar(){
        nombre.setText("");
        id.setText("");
    }
}
