package co.quindio.sena.navigationdrawerejemplo.clases;

import com.google.gson.annotations.SerializedName;

public class Mascota {
    //@SerializedName("nombre")
    public String nombre;

    //@SerializedName("raza")
    public String raza;

    public String propietario;

    //@SerializedName("descripcion")
    public String descripcion;

    //@SerializedName("propietario")
    public Integer duenio;

    //@SerializedName("id_mascota")
    public String id;

  //  @SerializedName("en_adopcion")
    public boolean enAdopcion;

//    @SerializedName("esta_perdida")
    public boolean estaPerdida;
    private int imagenId;
    public Mascota(String id, String nombre,String raza,String descripcion,boolean esAdopcion,boolean estaPerdida,Integer duenio) {
        this.id=id;
        this.nombre = nombre;
        this.raza=raza;
        this.descripcion = descripcion;
        this.duenio=duenio;
        this.estaPerdida=estaPerdida;
        this.enAdopcion=esAdopcion;
    }
    public Mascota(String nombre,String descripcion,int imagenId) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.imagenId = imagenId;
    }


    public String getNombre() {
        return nombre;
    }

    public boolean isEnAdopcion() {
        return enAdopcion;
    }

    public void setEnAdopcion(boolean enAdopcion) {
        this.enAdopcion = enAdopcion;
    }

    public boolean isEstaPerdida() {
        return estaPerdida;
    }

    public void setEstaPerdida(boolean estaPerdida) {
        this.estaPerdida = estaPerdida;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getImagenId() {
        return imagenId;
    }

    public void setImagenId(int imagenId) {
        this.imagenId = imagenId;
    }

    public void setNombe(String nombe) {
        this.nombre = nombe;
    }

    public String getPropietario() {
        return propietario;
    }

    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    @Override
    public String toString() {
        return "Mascota{" +
                "nombre='" + nombre + '\'' +
                ", raza='" + raza + '\'' +
                ", propietario='" + propietario + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", enAdopcion=" + enAdopcion +
                ", estaPerdida=" + estaPerdida +
                ", imagenId=" + imagenId +
                '}';
    }
}
