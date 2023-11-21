package com.example.semana10taller;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class VistaUsuarios extends RecyclerView.ViewHolder {
    public TextView id, usuario, correo, clave;

    public VistaUsuarios(@NonNull View itemView) {
        super(itemView);
        id = itemView.findViewById(R.id.txtid);
        usuario = itemView.findViewById(R.id.txtusuario);
        correo = itemView.findViewById(R.id.txtcorreo);
        clave = itemView.findViewById(R.id.txtclave);
    }
}
