package ar.com.tutorialesya.proyectoCuentas;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.TextView;
import android.widget.Toast;

import ar.com.tutorialesya.proyectoCuentas.R;

public class CuentaDetail extends ActionBarActivity {

    private TextView costeTotal;
    private TextView importeUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cuenta_detail);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        costeTotal=(TextView)findViewById(R.id.txtCosteTotal);

        Bundle bundle = getIntent().getExtras();
        costeTotal.setText(bundle.getString("cuenta"));

        /*


        costeTotal=sum(coste[i])

        importeDivision=costeTotal/i

        importeReal=coste(i) - importeDivision
        if (importeReal < 0)
        costeTotal.setText("Debe " + (-importeReal));
        else
        costeTotal.setText("Le deben " + importeReal);

         */
    }

    @Override
    public void onBackPressed() {
        //Toast.makeText(getApplicationContext(), " ATRAS ", Toast.LENGTH_SHORT).show();
        this.finish();
    }

}
