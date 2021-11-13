package com.tcs;

public abstract class Bebida{

    private Integer identificador;
    private Double litros;
    private Double precio;
    private String marca;

    public Integer getIdentificador() {
        return identificador;
    }

    public void setIdentificador(Integer identificador) {
        this.identificador = identificador;
    }

    public Double getLitros() {
        return litros;
    }

    public void setLitros(Double litros) {
        this.litros = litros;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    @Override
    public String toString() {
        return "Bebida{" +
                "identificador=" + identificador +
                ", litros=" + litros +
                ", precio=" + precio +
                ", marca='" + marca + '\'' +
                '}';
    }
}
