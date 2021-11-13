package com.tcs;

public class Azucarada extends Bebida implements Producto{

    private Double porcentajeAzucar;
    private boolean tienePromocion;

    public Double getPorcentajeAzucar() {
        return porcentajeAzucar;
    }

    public void setPorcentajeAzucar(Double porcentajeAzucar) {
        this.porcentajeAzucar = porcentajeAzucar;
    }

    public boolean isTienePromocion() {
        return tienePromocion;
    }

    public void setTienePromocion(boolean tienePromocion) {
        this.tienePromocion = tienePromocion;
    }

    @Override
    public String toString() {
        return "Azucarada{" +
                "Bebida="+super.toString()+
                "porcentajeAzucar=" + porcentajeAzucar +
                ", tienePromocion=" + tienePromocion +
                '}';
    }
}
