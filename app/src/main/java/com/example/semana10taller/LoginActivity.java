package com.example.semana10taller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.semana10taller.R;
import com.example.semana10taller.db.Dbhelper;
import com.example.semana10taller.db.Tablausuarios;

public class LoginActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void onClickIngresar(View view) {
        SQLiteDatabase db = Dbhelper.getInstance(LoginActivity.this).getReadableDatabase();

        String txtusuario = ((EditText) findViewById(R.id.txtusuario)).getText().toString();
        String txtcontrasena = ((EditText) findViewById(R.id.txtcontrasenia)).getText().toString();
        if (txtusuario.isEmpty() || txtcontrasena.isEmpty()) {
            Toast.makeText(this, "Ingrese los datos", Toast.LENGTH_SHORT).show();
        } else {
            ContentValues datos = new ContentValues();
            datos.put("usuario", txtusuario);
            datos.put("clave", txtcontrasena);
            String valido = new Tablausuarios().validarUsuario(db, datos);
            if (valido.equals("0")) {
                Toast.makeText(this, "Usuario no existe", Toast.LENGTH_SHORT).show();

            } else {
                Toast.makeText(this, "Bienvenido", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(LoginActivity.this, MenuActivity.class));
                this.finish();
            }
        }
    }
    public void registrarCookiesUsuario(String id){
        SharedPreferences preferences = getSharedPreferences("taller", MODE_PRIVATE);
        SharedPreferences.Editor cookie = preferences.edit();
        cookie.putString("idUsuario", id);
    }
}