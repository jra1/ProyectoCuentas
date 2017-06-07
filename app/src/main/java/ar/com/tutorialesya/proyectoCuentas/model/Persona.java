package ar.com.tutorialesya.proyectoCuentas.model;

/**
 * Created by Joseba on 31/05/2017.
 */

public class Persona {
    private int idPersona;
    private String nombrePersona;
    private int viajeID;
    private float pagado;

    public Persona(int idPersona, String nombrePersona, int viajeID, float pagado) {
        this.idPersona = idPersona;
        this.nombrePersona = nombrePersona;
        this.viajeID = viajeID;
        this.pagado = pagado;
    }

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public String getNombrePersona() {
        return nombrePersona;
    }

    public void setNombrePersona(String nombrePersona) {
        this.nombrePersona = nombrePersona;
    }

    public int getViajeID() {
        return viajeID;
    }

    public void setViajeID(int viajeID) {
        this.viajeID = viajeID;
    }

    public float getPagado() {
        return pagado;
    }

    public void setPagado(float pagado) {
        this.pagado = pagado;
    }
}
