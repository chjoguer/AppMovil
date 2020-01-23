package co.quindio.sena.navigationdrawerejemplo.clases;

public class Mascota {
    public String nombre;
    public String raza;
    public String propietario;
    public String descripcion;
    public boolean enAdopcion;
    public boolean estaPerdida;
    private int imagenId;
    public Mascota(String nombre,String descripcion,boolean esAdopcion,boolean estaPerdida,int imagenId) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.imagenId = imagenId;
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
