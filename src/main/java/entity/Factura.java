package entity;

import java.time.LocalDate;

public class Factura {
    private Long id;
    private Long clienteId;
    private double monto;
    private LocalDate fecha;

 
    public Factura() {}

   
    public Factura(Long id, Long clienteId, double monto, LocalDate fecha) {
        this.id = id;
        this.clienteId = clienteId;
        this.monto = monto;
        this.fecha = fecha;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
}
