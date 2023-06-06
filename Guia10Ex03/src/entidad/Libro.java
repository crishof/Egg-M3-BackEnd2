package entidad;

public class Libro {

    private String titulo;
    private String autor;
    private int ejemplaresCant;
    private int prestadosCant;

    public Libro() {
    }

    public Libro(String titulo, String autor, int ejemplaresCant, int prestadosCant) {
        this.titulo = titulo;
        this.autor = autor;
        this.ejemplaresCant = ejemplaresCant;
        this.prestadosCant = prestadosCant;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getEjemplaresCant() {
        return ejemplaresCant;
    }

    public void setEjemplaresCant(int ejemplaresCant) {
        this.ejemplaresCant = ejemplaresCant;
    }

    public int getPrestadosCant() {
        return prestadosCant;
    }

    public void setPrestadosCant(int prestadosCant) {
        this.prestadosCant = prestadosCant;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", ejemplaresCant=" + ejemplaresCant +
                ", prestadosCant=" + prestadosCant +
                '}';
    }
}
