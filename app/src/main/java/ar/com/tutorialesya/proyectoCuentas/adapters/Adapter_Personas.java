package ar.com.tutorialesya.proyectoCuentas.adapters;

import android.app.Activity;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import ar.com.tutorialesya.proyectoCuentas.R;
import ar.com.tutorialesya.proyectoCuentas.model.Persona;
import ar.com.tutorialesya.proyectoCuentas.model.Viaje;

/**
 * Created by Joseba on 23/05/2017.
 */

public class Adapter_Personas extends ArrayAdapter<Persona> {

    private final Activity context;

    Persona p;

    private TextView nombrePersona;
    private TextView lblCantidad;
    private float importeCantidad;

    private ArrayList<Persona> listaPersonas;

    public Adapter_Personas(Activity context, ArrayList<Persona> lista) {
        super(context, R.layout.item_persona,lista);

        this.context = context;
        this.listaPersonas = lista;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.item_persona, null);

        nombrePersona = (TextView)item.findViewById(R.id.lblNombrePersona);
        nombrePersona.setText(listaPersonas.get(position).getNombrePersona());

        lblCantidad = (TextView)item.findViewById(R.id.lblCantidad);
        lblCantidad.setText("Ha pagado: " + listaPersonas.get(position).getPagado() + " €");

        return(item);
    }

    @Override
    public int getCount() {
        return super.getCount();
    }

    @Nullable
    @Override
    public Persona getItem(int position) {
        return super.getItem(position);
    }
}
