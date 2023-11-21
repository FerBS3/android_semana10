package com.example.semana10taller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.semana10taller.R;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        SharedPreferences preferences = getSharedPreferences("taller", MODE_PRIVATE);
        String idUsuario = preferences.getString("idUsuario", "0");
        Toast.makeText(this, idUsuario, Toast.LENGTH_SHORT).show();
    }

    public void onClickIrUsuarios(View view) {
        startActivity(new Intent(MenuActivity.this, UsuariosActivity2.class));
    }
}