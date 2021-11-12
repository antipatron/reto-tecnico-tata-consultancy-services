package com.tcs;

public class Azucarada extends Bebida{

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
}
