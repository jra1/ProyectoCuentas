package ar.com.tutorialesya.proyectoCuentas;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by diegomoisset on 06/01/2015.
 */
public class AdminSQLiteOpenHelper extends SQLiteOpenHelper{
    public AdminSQLiteOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //db.execSQL("create table articulos(codigo int primary key,descripcion text,precio real)");
        db.execSQL("create table Viaje(idViaje int primary key, nombre text, gastoTotal real, gastoPersona real)");
        db.execSQL("create table Persona(idPersona int primary key,nombre text, viajeID int, pagado real)");
        db.execSQL("create table Gasto(idGasto int primary key, concepto text, importe text, personaID int, viajeID int)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
