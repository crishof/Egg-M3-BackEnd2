package estancias.entidades;

public class Familia {

    private int idFamilia;
    private String nombre;
    private int edadMin;
    private int edadMax;
    private int numHijos;
    private String email;
    private int idCasaFamilia;

    public Familia() {
    }

    public Familia(int idFamilia, String nombre, int edadMin, int edadMax, int numHijos, String email, int idCasaFamilia) {
        this.idFamilia = idFamilia;
        this.nombre = nombre;
        this.edadMin = edadMin;
        this.edadMax = edadMax;
        this.numHijos = numHijos;
        this.email = email;
        this.idCasaFamilia = idCasaFamilia;
    }

    public int getIdFamilia() {
        return idFamilia;
    }

    public void setIdFamilia(int idFamilia) {
        this.idFamilia = idFamilia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdadMin() {
        return edadMin;
    }

    public void setEdadMin(int edadMin) {
        this.edadMin = edadMin;
    }

    public int getEdadMax() {
        return edadMax;
    }

    public void setEdadMax(int edadMax) {
        this.edadMax = edadMax;
    }

    public int getNumHijos() {
        return numHijos;
    }

    public void setNumHijos(int numHijos) {
        this.numHijos = numHijos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getIdCasaFamilia() {
        return idCasaFamilia;
    }

    public void setIdCasaFamilia(int idCasaFamilia) {
        this.idCasaFamilia = idCasaFamilia;
    }

    @Override
    public String toString() {
        return "Familia{" +
                "idFamilia=" + idFamilia +
                ", nombre='" + nombre + '\'' +
                ", edadMin=" + edadMin +
                ", edadMax=" + edadMax +
                ", numHijos=" + numHijos +
                ", email='" + email + '\'' +
                ", idCasaFamilia=" + idCasaFamilia +
                '}';
    }
}
