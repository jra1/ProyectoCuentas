package ar.com.tutorialesya.proyectoCuentas;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.ListView;

import java.util.ArrayList;

import ar.com.tutorialesya.proyectoCuentas.adapters.Adapter_Viajes;
import ar.com.tutorialesya.proyectoCuentas.model.Viaje;


public class MainActivity extends ActionBarActivity {

    private EditText et1,et2,et3;
    private ListView lista;

    private String[] paises={"Argentina","Chile","Paraguay","Bolivia","Peru",
            "Ecuador","Brasil","Colombia","Venezuela","Uruguay"};

    private ArrayList<Viaje> viajes = new ArrayList<Viaje>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FloatingActionButton FAB = (FloatingActionButton) findViewById(R.id.fab);
        FAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, NuevaCuenta.class);
                startActivity(i);
                //Toast.makeText(MainActivity.this, "NUEVA CUENTA", Toast.LENGTH_SHORT).show();
            }
        });

        //Crear la BD
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,"bd_cuentas", null, 5);
        SQLiteDatabase bd = admin.getWritableDatabase();
        Cursor fila = bd.rawQuery("select * from Viaje", null);
        Viaje v;
        if (fila.moveToFirst()) {
            v = new Viaje(fila.getInt(0), fila.getString(1), fila.getFloat(2), fila.getFloat(3));
            viajes.add(v);
            while(fila.moveToNext()){
                v = new Viaje(fila.getInt(0), fila.getString(1), fila.getFloat(2), fila.getFloat(3));
                viajes.add(v);
            }
        } else
            Toast.makeText(this, "No hay viajes guardados",
                    Toast.LENGTH_SHORT).show();
        bd.close();

        lista=(ListView)findViewById(R.id.listaCuentas);
        Adapter_Viajes adapter = new Adapter_Viajes(this, viajes);
        lista.setAdapter(adapter);
        //ArrayAdapter<Viaje> adapter = new ArrayAdapter<Viaje>(this,android.R.layout.simple_list_item_1, viajes);
        //lista.setAdapter(adapter);
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int posicion, long id) {
                //Intent i = new Intent(MainActivity.this, CuentaDetail.class);
                Intent i2 = new Intent(MainActivity.this, CuentaDetail.class);
                Viaje vj = (Viaje) lista.getAdapter().getItem(posicion);
                i2.putExtra("cuenta", vj.getNombreViaje());
                startActivity(i2);
                //tv1.setText("Población de "+ lista.getItemAtPosition(posicion) + " es "+ habitantes[posicion]);
            }
        });
        //et1=(EditText)findViewById(R.id.editText);
        //et2=(EditText)findViewById(R.id.editText2);
        //et3=(EditText)findViewById(R.id.editText3);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void alta(View v) {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,"administracion", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        String cod = et1.getText().toString();
        String descri = et2.getText().toString();
        String pre = et3.getText().toString();
        ContentValues registro = new ContentValues();
        registro.put("codigo", cod);
        registro.put("descripcion", descri);
        registro.put("precio", pre);
        bd.insert("articulos", null, registro); //"articulos" es el nombre de la tabla
        bd.close();
        et1.setText("");
        et2.setText("");
        et3.setText("");
        Toast.makeText(this, "Se cargaron los datos del artículo",
                Toast.LENGTH_SHORT).show();
    }

    public void consultaporcodigo(View v) {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,"administracion", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        String cod = et1.getText().toString();
        Cursor fila = bd.rawQuery("select descripcion,precio from articulos where codigo=" + cod, null);
        if (fila.moveToFirst()) {
            et2.setText(fila.getString(0));
            et3.setText(fila.getString(1));
        } else
            Toast.makeText(this, "No existe un artículo con dicho código",
                    Toast.LENGTH_SHORT).show();
        bd.close();
    }

    public void consultapordescripcion(View v) {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,"administracion", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        String descri = et2.getText().toString();
        Cursor fila = bd.rawQuery("select codigo,precio from articulos where descripcion='" + descri +"'", null);
        if (fila.moveToFirst()) {
            et1.setText(fila.getString(0));
            et3.setText(fila.getString(1));
        } else
            Toast.makeText(this, "No existe un artículo con dicha descripción",
                    Toast.LENGTH_SHORT).show();
        bd.close();
    }

    public void bajaporcodigo(View v) {
            AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,
                    "administracion", null, 1);
            SQLiteDatabase bd = admin.getWritableDatabase();
            String cod= et1.getText().toString();
            int cant = bd.delete("articulos", "codigo=" + cod, null);
            bd.close();
            et1.setText("");
            et2.setText("");
            et3.setText("");
            if (cant == 1)
                Toast.makeText(this, "Se borró el artículo con dicho código",
                        Toast.LENGTH_SHORT).show();
            else
                Toast.makeText(this, "No existe un artículo con dicho código",
                        Toast.LENGTH_SHORT).show();
    }

    public void modificacion(View v) {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,
                "administracion", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        String cod = et1.getText().toString();
        String descri = et2.getText().toString();
        String pre = et3.getText().toString();
        ContentValues registro = new ContentValues();
        registro.put("codigo", cod);
        registro.put("descripcion", descri);
        registro.put("precio", pre);
        int cant = bd.update("articulos", registro, "codigo=" + cod, null);
        bd.close();
        if (cant == 1)
            Toast.makeText(this, "se modificaron los datos", Toast.LENGTH_SHORT)
                    .show();
        else
            Toast.makeText(this, "no existe un artículo con el código ingresado",
                    Toast.LENGTH_SHORT).show();
    }

}
