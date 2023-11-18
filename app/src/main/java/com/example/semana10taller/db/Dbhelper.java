package com.example.semana10taller.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Dbhelper extends SQLiteOpenHelper {
    private static Dbhelper instancia;
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "db_Taller";
    private Tablausuarios tablausuarios;

    public static synchronized Dbhelper getInstance(Context context) {
        if (instancia == null) {
            instancia = new Dbhelper(context.getApplicationContext());
        }
        return instancia;
    }

    public Dbhelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onConfigure(SQLiteDatabase db) {
        super.onConfigure(db);
        db.setForeignKeyConstraintsEnabled(true);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion != newVersion) {
            this.tablausuarios.dropTable(db);
            onCreate(db);
        }
    }

    public void onCreate(SQLiteDatabase db) {
        this.tablausuarios = new Tablausuarios();
        this.tablausuarios.crearTabla(db);
    }

    public Tablausuarios getTablausuarios() {
        return tablausuarios;
    }
}
