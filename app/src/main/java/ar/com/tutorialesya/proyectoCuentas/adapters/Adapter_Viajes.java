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
import ar.com.tutorialesya.proyectoCuentas.model.Viaje;

/**
 * Created by Joseba on 23/05/2017.
 */

public class Adapter_Viajes extends ArrayAdapter<Viaje> {

    private final Activity context;

    Viaje vj;

    private TextView nombreViaje;
    private TextView txtCosteTotal;
    private float costeTotal;
    private TextView personas;

    private ArrayList<Viaje> listaViajes;

    public Adapter_Viajes(Activity context, ArrayList<Viaje> lista) {
        super(context, R.layout.item_viaje,lista);

        this.context = context;
        this.listaViajes = lista;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.item_viaje, null);

        nombreViaje = (TextView)item.findViewById(R.id.txtNombre);
        nombreViaje.setText(listaViajes.get(position).getNombreViaje());

        txtCosteTotal = (TextView)item.findViewById(R.id.txtCosteTotal);
        txtCosteTotal.setText("COSTE TOTAL: " + listaViajes.get(position).getGastoTotal() + " €");

        personas = (TextView)item.findViewById(R.id.txtPersonas);
        personas.setText("Personas: " + listaViajes.get(position).getGastoPersona() + " (prueba)");

        return(item);
    }

    @Override
    public int getCount() {
        return super.getCount();
    }

    @Nullable
    @Override
    public Viaje getItem(int position) {
        return super.getItem(position);
    }
}
