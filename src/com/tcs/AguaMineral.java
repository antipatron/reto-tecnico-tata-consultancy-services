package com.tcs;

public class AguaMineral extends Bebida implements Producto{

    private String origen;

    public AguaMineral() {
    }

    public AguaMineral(Integer identificador, Double litros, Double precio, String marca) {
        super(identificador, litros, precio, marca);
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    @Override
    public String toString() {
        return "AguaMineral{" +
                "Bebida="+super.toString()+
                "origen='" + origen + '\'' +
                '}';
    }
}
