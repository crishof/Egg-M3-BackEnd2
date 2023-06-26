package entidad;

import java.util.Date;

public class Poliza {

    int numeroPoliza;
    Date fechaInicio;
    Date fechaVencimiento;
    int cuotasCantidad;
    String formaPago;
    double montoAsegurado;
    boolean incluyeGranizo;
    double MontoGranizo;
    String coberturaTipo;

    Cliente cliente;

    Vehiculo vehiculo;

    public Poliza() {
    }

    public Poliza(int numeroPoliza, Date fechaInicio, Date fechaVencimiento, int cuotasCantidad, String formaPago, double montoAsegurado, boolean incluyeGranizo, double montoGranizo, String coberturaTipo, Cliente cliente, Vehiculo vehiculo) {
        this.numeroPoliza = numeroPoliza;
        this.fechaInicio = fechaInicio;
        this.fechaVencimiento = fechaVencimiento;
        this.cuotasCantidad = cuotasCantidad;
        this.formaPago = formaPago;
        this.montoAsegurado = montoAsegurado;
        this.incluyeGranizo = incluyeGranizo;
        MontoGranizo = montoGranizo;
        this.coberturaTipo = coberturaTipo;
        this.cliente = cliente;
        this.vehiculo = vehiculo;
    }

    public int getNumeroPoliza() {
        return numeroPoliza;
    }

    public void setNumeroPoliza(int numeroPoliza) {
        this.numeroPoliza = numeroPoliza;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public int getCuotasCantidad() {
        return cuotasCantidad;
    }

    public void setCuotasCantidad(int cuotasCantidad) {
        this.cuotasCantidad = cuotasCantidad;
    }

    public String getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(String formaPago) {
        this.formaPago = formaPago;
    }

    public double getMontoAsegurado() {
        return montoAsegurado;
    }

    public void setMontoAsegurado(double montoAsegurado) {
        this.montoAsegurado = montoAsegurado;
    }

    public boolean isIncluyeGranizo() {
        return incluyeGranizo;
    }

    public void setIncluyeGranizo(boolean incluyeGranizo) {
        this.incluyeGranizo = incluyeGranizo;
    }

    public double getMontoGranizo() {
        return MontoGranizo;
    }

    public void setMontoGranizo(double montoGranizo) {
        MontoGranizo = montoGranizo;
    }

    public String getCoberturaTipo() {
        return coberturaTipo;
    }

    public void setCoberturaTipo(String coberturaTipo) {
        this.coberturaTipo = coberturaTipo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }
}
