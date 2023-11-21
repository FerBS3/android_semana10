package com.example.semana10taller;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class VistaUsuarios extends RecyclerView.ViewHolder {
    public TextView id, usuario, correo, clave;

    public VistaUsuarios(@NonNull View itemView) {
        super(itemView);
        id = itemView.findViewById(R.id.tablaid);
        usuario = itemView.findViewById(R.id.tablaUsuario);
        correo = itemView.findViewById(R.id.tablaCorreo);
        clave = itemView.findViewById(R.id.tablaClave);
    }
}
