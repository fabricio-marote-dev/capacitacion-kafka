package com.example.demo.model;

public class OrderEvent {
    private String id;
    private String cliente;
    private Double monto;

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getCliente() { return cliente; }
    public void setCliente(String cliente) { this.cliente = cliente; }

    public Double getMonto() { return monto; }
    public void setMonto(Double monto) { this.monto = monto; }
}
