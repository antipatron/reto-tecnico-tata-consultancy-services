package com.tcs;

public class ProcesarComando {
    private Almacen almacen = new Almacen();

    public void comando(int comando){

        int comandoProcesar = comando;
        switch (comandoProcesar){
            case 1:
                almacen.calcularPrecioTodasBebidas();
                break;
            case 2:
                almacen.calcularPrecioTotalMarcaBebida();
                break;
            case 3:
                almacen.calcularPrecioTotalEstanteria();
                break;
            case 4:
                almacen.agregarProducto();
                break;
            case 5:
                almacen.eliminarProducto();
                break;
            case 6:
                almacen.mostrarInformacion();
                break;
            case 7:
                System.out.println("Nos vemos luego");
                break;
            default:
                System.out.println("Comando no encontrado.");
        }

    }





}
