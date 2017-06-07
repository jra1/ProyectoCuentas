package ar.com.tutorialesya.proyectoCuentas.model;

/**
 * Created by Joseba on 17/05/2017.
 */

public class Viaje {
    private int id;
    private String nombreViaje;
    private float gastoTotal;
    private float gastoPersona;

    public Viaje(int id, String nombreViaje, float gastoTotal, float gastoPersona) {
        this.id = id;
        this.nombreViaje = nombreViaje;
        this.gastoTotal = gastoTotal;
        this.gastoPersona = gastoPersona;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreViaje() {
        return nombreViaje;
    }

    public void setNombreViaje(String nombreViaje) {
        this.nombreViaje = nombreViaje;
    }

    public float getGastoTotal() {
        return gastoTotal;
    }

    public void setGastoTotal(float gastoTotal) {
        this.gastoTotal = gastoTotal;
    }

    public float getGastoPersona() {
        return gastoPersona;
    }

    public void setGastoPersona(float gastoPersona) {
        this.gastoPersona = gastoPersona;
    }
}
