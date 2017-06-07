package ar.com.tutorialesya.proyectoCuentas;

import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import ar.com.tutorialesya.proyectoCuentas.R;
import ar.com.tutorialesya.proyectoCuentas.adapters.Adapter_Personas;
import ar.com.tutorialesya.proyectoCuentas.adapters.Adapter_Viajes;
import ar.com.tutorialesya.proyectoCuentas.model.Persona;
import ar.com.tutorialesya.proyectoCuentas.model.Viaje;

public class NuevaCuenta extends AppCompatActivity {

    private EditText nombrePersona;
    private EditText cantidadPersona;
    private ListView lista;

    private ArrayList<Persona> personas = new ArrayList<>();
    Adapter_Personas adapter;

    String msg = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nueva_cuenta);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        lista = (ListView)findViewById(R.id.listaPersonas);
        adapter = new Adapter_Personas(this, personas);
        lista.setAdapter(adapter);
    }

    @Override
    public void onBackPressed() {
        //Toast.makeText(getApplicationContext(), " ATRAS ", Toast.LENGTH_SHORT).show();
        this.finish();
    }

    public void addPersona(View v){
        Dialog dialog = new Dialog(getApplicationContext(),
                android.R.style.Theme_Translucent_NoTitleBar);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.alert_dialog, null);

        builder.setView(dialogView);

        nombrePersona=(EditText)dialogView.findViewById(R.id.txtPideNombre);
        cantidadPersona=(EditText)dialogView.findViewById(R.id.txtPideCantidad);

        builder.setPositiveButton("Aceptar",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,
                                        int whichButton) {
                        String txtCantidad = cantidadPersona.getText().toString();
                        txtCantidad = txtCantidad.replaceAll(",", ".");
                        try{
                            float cantidad = Float.valueOf(txtCantidad);
                            Persona p = new Persona(1,nombrePersona.getText().toString(),1,cantidad);
                            personas.add(p);
                            adapter.notifyDataSetChanged();
                        }catch(NumberFormatException nfe){
                            msg = "Cantidad no válida";
                        }
                    }
                });
        if(!"".equalsIgnoreCase(msg)){
            Toast.makeText(this,msg, Toast.LENGTH_SHORT).show();
        }

        builder.setNegativeButton("Cancelar",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,
                                        int whichButton) {
                    }
                });
        dialog = builder.create();
        dialog.show();



        /*
        final AlertDialog.Builder alert = new AlertDialog.Builder(this);

        final EditText edittext = new EditText(this);
        alert.setMessage("Nombre");
        alert.setTitle("Añadir persona");
        alert.setView(edittext);

        alert.setPositiveButton("Añadir", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                //What ever you want to do with the value
                Editable YouEditTextValue = edittext.getText();
                //OR
                String str = edittext.getText().toString();
            }
        });

        alert.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {

            }
        });

        alert.show();
        */
    }

    public void guardar(View v){
        Toast.makeText(this, "Guardando cuenta...", Toast.LENGTH_SHORT).show();
    }
}
