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
        //PARA PRUEBAS
        db.execSQL("insert into Viaje values (21, 'Lisboa', 425.1, 215.3)");
        db.execSQL("insert into Viaje values (20, 'Ávila', 120.0, 60.0)");
        db.execSQL("insert into Viaje values (3, 'Ávila', 120.0, 60.0)");
        db.execSQL("insert into Viaje values (4, 'Ávila', 120.0, 60.0)");
        db.execSQL("insert into Viaje values (5, 'Ávila', 120.0, 60.0)");
        db.execSQL("insert into Viaje values (6, 'Ávila', 120.0, 60.0)");
        db.execSQL("insert into Viaje values (7, 'Ávila', 120.0, 60.0)");
        db.execSQL("insert into Viaje values (8, 'Ávila', 120.0, 60.0)");
        db.execSQL("insert into Viaje values (9, 'Ávila', 120.0, 60.0)");
        db.execSQL("insert into Viaje values (10, 'Ávila', 120.0, 60.0)");
        db.execSQL("insert into Viaje values (11, 'Ávila', 120.0, 60.0)");
        db.execSQL("insert into Viaje values (12, 'Ávila', 120.0, 60.0)");
        db.execSQL("insert into Viaje values (13, 'Ávila', 120.0, 60.0)");
        db.execSQL("insert into Viaje values (14, 'Ávila', 120.0, 60.0)");
        db.execSQL("insert into Viaje values (15, 'Ávila', 120.0, 60.0)");
        db.execSQL("insert into Viaje values (16, 'Ávila', 120.0, 60.0)");
        db.execSQL("insert into Viaje values (17, 'Ávila', 120.0, 60.0)");
        db.execSQL("insert into Viaje values (18, 'Ávila', 120.0, 60.0)");
        db.execSQL("insert into Viaje values (19, 'Ávila', 120.0, 60.0)");
    }
}
