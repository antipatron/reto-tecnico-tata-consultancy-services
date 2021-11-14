package com.tcs;

import java.util.List;

public class Estanteria {

    private Producto[] productos = new Producto[2];

    public Estanteria(){
        for (int i = 0; i < productos.length; i++) {
            Producto producto =  null;
            productos[i] =producto;
        }
    }

    public Producto[] getProductos() {
        return productos;
    }

    public void setProductos(Producto[] productos) {
        this.productos = productos;
    }
}
