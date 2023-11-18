package com.example.semana10taller.db;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

public class Tablausuarios {
    public static final String TABBLA_NAME = "usuarios";

    public void crearTabla(SQLiteDatabase db) {
        try {
            db.execSQL("CREATE TABLE IF NOT EXISTS " + TABBLA_NAME + " (id INTEGER PRIMARY KEY " +
                    "AUTOINCREMENT, usuario TEXT NOT NULL, correo TEXT NOT NULL, clave TEXT NOT " +
                    "NULL)");
            ContentValues usuarioAdmin = new ContentValues();
            usuarioAdmin.put("usuario", "admin");
            usuarioAdmin.put("correo", "admin@gollosolobueno.com");
            usuarioAdmin.put("clave", "admin");
            db.insert(TABBLA_NAME, null, usuarioAdmin);
            this.insertarUsuario(db, usuarioAdmin);
        } catch (Exception e) {
            // Toast.makeText(null, "Error al crear la tabla", Toast.LENGTH_SHORT).show();
        } finally {
            if (db.isOpen()) {
                // db.close();
            }
        }
    }

    public void dropTable(SQLiteDatabase db) {
        try {
            db.execSQL("DROP TABLE IF EXISTS " + TABBLA_NAME);
        } catch (Exception e) {
            // Toast.makeText(null, "Error al eliminar la tabla", Toast.LENGTH_SHORT).show();
        } finally {
            //  db.close();
        }
    }

    public void insertarUsuario(SQLiteDatabase db, ContentValues values) {
        try {
            db.insert(TABBLA_NAME, null, values);
        } catch (Exception e) {
            // Toast.makeText(null, "Error al insertar el usuario", Toast.LENGTH_SHORT).show();
        } finally {
            if (db.isOpen()) {
                // db.close();
            }
        }
    }

    public void deleteUsuario(SQLiteDatabase db, int id) {
        try {
            db.delete(TABBLA_NAME, "id = ?", new String[]{String.valueOf(id)});
        } catch (Exception e) {
            // Toast.makeText(null, "Error al eliminar el usuario", Toast.LENGTH_SHORT).show();
        } finally {
            //   db.close();
        }
    }

    public String validarUsuario(SQLiteDatabase db, ContentValues datos) {
        String idIngreso = "0";
        try {
            String usuario = datos.getAsString("usuario");
            String clave = datos.getAsString("clave");
            Cursor usuarioCursor = db.rawQuery("SELECT id, usuario, clave FROM " + TABBLA_NAME +
                    " WHERE usuario = ? AND clave = ?", new String[]{usuario, clave},null);
            if (usuarioCursor.getCount() > 0) {
                usuarioCursor.moveToFirst();
                idIngreso = usuarioCursor.getString(0);
            }
        } catch (Exception e) {
            Toast.makeText(null, "Error al eliminar el usuario", Toast.LENGTH_SHORT).show();
        } finally {
            db.close();
            return idIngreso;
        }

    }
}
