package com.example.semana10taller;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import com.example.semana10taller.db.Dbhelper;
import com.example.semana10taller.db.Tablausuarios;
import com.example.semana10taller.db.UsuarioHelper;
import androidx.recyclerview.widget.LinearLayoutManager;

public class UsuariosActivity2 extends AppCompatActivity {
    private SQLiteDatabase db;
    private Tablausuarios tablausuarios;
    private RecyclerView vistaReciclado;
    private UsuarioHelper usuariosHelper;
    private Cursor datos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuarios2);
        db = Dbhelper.getInstance(UsuariosActivity2.this).getReadableDatabase();
        tablausuarios = new Tablausuarios();
        datos = tablausuarios.getUsuarios(db);
        this.vistaReciclado = findViewById(R.id.txtabla);
        this.vistaReciclado.setHasFixedSize(true);
        this.vistaReciclado.setLayoutManager( new LinearLayoutManager(this));
        this.usuariosHelper = new UsuarioHelper(this, datos);
        if(this.usuariosHelper.getItemCount() > 0) {
            this.vistaReciclado.setAdapter(this.usuariosHelper);
        }
    }
}