package com.example.repaso;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private EditText nombre;
    private EditText id;
    private Button registro;
    private ListView lista;
    private Button consultar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inicializar();

        ArrayList<Usuario> array_usuarios = new ArrayList<>();

        registro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Usuario obj_user = new Usuario();
                obj_user.setNombre(nombre.getText().toString());
                obj_user.setId(Integer.parseInt(id.getText().toString()));
                array_usuarios.add(obj_user);
                Toast.makeText(MainActivity.this, "Usuario registrado", Toast.LENGTH_SHORT).show();
            }
        });

        consultar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usuariosConsulta [] = new String[array_usuarios.size()];
                for (int i=0; i<array_usuarios.size(); i++) {
                    String name = array_usuarios.get(i).getNombre();
                    int ident = array_usuarios.get(i).getId();
                    usuariosConsulta[i] = name + " " + ident;
                }
                ArrayAdapter adapter = new ArrayAdapter<String>(MainActivity.this,
                        com.google.android.material.R.layout.support_simple_spinner_dropdown_item,
                        usuariosConsulta);
                lista.setAdapter(adapter);
            }
        });
    }
    private void inicializar() {
        nombre = (EditText) findViewById(R.id.txtName);
        id = (EditText) findViewById(R.id.txtId);
        registro = (Button) findViewById(R.id.btnNuevoUsuario);
        lista = (ListView) findViewById(R.id.listaUsuarios);
        consultar = (Button) findViewById(R.id.btnCosultar);

    }
}