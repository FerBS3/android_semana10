package com.example.semana10taller.db;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.semana10taller.R;
import com.example.semana10taller.VistaUsuarios;

import java.util.ArrayList;

public class UsuarioHelper extends RecyclerView.Adapter<VistaUsuarios> {
    private Context contexto;
    private Cursor datos;

    public UsuarioHelper(Context contexto, Cursor datos) {
        this.contexto = contexto;
        this.datos = datos;
    }
    @NonNull
    @Override
    public VistaUsuarios onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vista=LayoutInflater.from(contexto).inflate(R.layout.activity_filas,parent,false);
        return new VistaUsuarios(vista);
    }

    @Override
    public void onBindViewHolder(@NonNull VistaUsuarios holder, int position) {
        datos.moveToPosition(position);
        holder.id.setText(datos.getString(0));
        holder.usuario.setText(datos.getString(1));
        holder.correo.setText(datos.getString(2));
        holder.clave.setText(datos.getString(3));
    }
    

    @Override
    public int getItemCount() {
        return datos.getCount();
    }
}
