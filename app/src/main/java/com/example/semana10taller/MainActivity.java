package com.example.semana10taller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Toast;

import com.example.semana10taller.db.Dbhelper;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {
            SQLiteDatabase db = Dbhelper.getInstance(MainActivity.this).getWritableDatabase();
            if (db != null) {
                Toast.makeText(this, "Base de datos creada", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainActivity.this, LoginActivity.class));
                this.finish();
            }
        } catch (Exception e) {
            Toast.makeText(this, "Error al crear la base de datos", Toast.LENGTH_SHORT).show();
        }

    }
}