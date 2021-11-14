package com.tcs;

public class Bebida {

    private Integer identificador;
    private Double litros;
    private Double precio;
    private String marca;

    public Bebida() {
    }

    public Bebida(Integer identificador, Double litros, Double precio, String marca) {
        this.identificador = identificador;
        this.litros = litros;
        this.precio = precio;
        this.marca = marca;
    }

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
