package entidades;

import java.time.LocalDate;

public class Amarre {

    private Cliente cliente;
    private LocalDate fechaAlquiler;
    private LocalDate fechaDevolucion;
    private int posicion;
    private Barco barco;

    public Amarre() {
    }

    public Amarre(Cliente cliente, LocalDate fechaAlquiler, LocalDate fechaDevolucion, int posicion, Barco barco) {
        this.cliente = cliente;
        this.fechaAlquiler = fechaAlquiler;
        this.fechaDevolucion = fechaDevolucion;
        this.posicion = posicion;
        this.barco = barco;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public LocalDate getFechaAlquiler() {
        return fechaAlquiler;
    }

    public void setFechaAlquiler(LocalDate fechaAlquiler) {
        this.fechaAlquiler = fechaAlquiler;
    }

    public LocalDate getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(LocalDate fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    public int getPosicion() {
        return posicion;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }

    public Barco getBarco() {
        return barco;
    }

    public void setBarco(Barco barco) {
        this.barco = barco;
    }

    @Override
    public String toString() {
        return "Ficha alquiler: " +
                "cliente: "
                + cliente +
                "\n fechaAlquiler: " + fechaAlquiler +
                "\n fechaDevolucion: " + fechaDevolucion +
                "\n posicion: " + posicion +
                "\n barco: " + barco;
    }
}
