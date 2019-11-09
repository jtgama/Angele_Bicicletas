package angelbike.proyectointe.angelbikes11.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ModeloUsuario {

    @Expose
    @SerializedName("id_angel") private int id;
    @SerializedName("nombre") private String angel;
    @SerializedName("correo") private  String correo;
    @SerializedName("telefono") private  String tele;
    @SerializedName("password") private  String contra;
    @SerializedName("color") private int color;
    @SerializedName("fecha") private  String fecha;
    @SerializedName("success") private  Boolean aceptar;
    @SerializedName("message") private  String mensaje;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAngel() {
        return angel;
    }

    public void setAngel(String angel) {
        this.angel = angel;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTele() {
        return tele;
    }

    public void setTele(String tele) {
        this.tele = tele;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Boolean getAceptar() {
        return aceptar;
    }

    public void setAceptar(Boolean aceptar) {
        this.aceptar = aceptar;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    public String getContra() { return contra; }

    public void setContra(String contra) { this.contra = contra; }
}
