package com.tcs;


import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Objects;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Almacen {
    private static Scanner lector = new Scanner(System.in);
    private static int opcion;

    private static Estanteria[] estanterias = new Estanteria[4];
    private static Integer identificadorGlobal = 0;

    public Almacen(){
        for (int i = 0; i < estanterias.length; i++) {
            Estanteria estanteria = new Estanteria();
            estanterias[i]=estanteria;

        }
    }

    public void calcularPrecioTodasBebidas(){
        System.out.println("Calculando precio de todas las bebidas...");
        int precioTotal = 0;
        int productos = 0;
        for (int i = 0; i < estanterias.length; i++) {
            productos= estanterias[i].getProductos().length;
            for (int j = 0; j < productos; j++) {
                if(!Objects.isNull(estanterias[i].getProductos()[j])) {

                    Producto producto = estanterias[i].getProductos()[j];
                    Bebida bebida = (Bebida) producto;
                    precioTotal = (int) (precioTotal + bebida.getPrecio());


                }
            }
        }
        System.out.println("Precio total es: "+precioTotal);

    }

    public void calcularPrecioTotalMarcaBebida(){
        System.out.println("Ingrese la marca a calcular precio: \n");
        String marca = lector.nextLine();
        int precioTotalMarca = 0;

        for (int i = 0; i < estanterias.length; i++) {
            int productos = estanterias[i].getProductos().length;

            for (int j = 0; j < productos; j++) {

                if(!Objects.isNull(estanterias[i].getProductos()[j])){
                    Producto producto = estanterias[i].getProductos()[j];
                    Bebida bebida = (Bebida) producto;

                    if(bebida.getMarca().equals(marca)){
                        precioTotalMarca = (int) (precioTotalMarca + bebida.getPrecio());
                    }

                }
            }

        }

        System.out.println("El precio total de bebidas de la marca: "+marca+" es: "+precioTotalMarca);


    }

    public void calcularPrecioTotalEstanteria(){
        System.out.println("Ingrese la estantería: \n");
        do{
            System.out.println("Ingrese la estantería: \n");
            opcion = lector.nextInt();
            lector.nextLine();

        }while (opcion<1 || opcion>10);

        int estanteria = opcion-1;
        int productos = 0;
        int precioTotalEstanteria = 0;

        productos= estanterias[estanteria].getProductos().length;
        for (int j = 0; j < productos; j++) {
            if(!Objects.isNull(estanterias[estanteria].getProductos()[j])) {

                Producto producto = estanterias[estanteria].getProductos()[j];
                Bebida bebida = (Bebida) producto;
                precioTotalEstanteria = (int) (precioTotalEstanteria + bebida.getPrecio());

            }
        }

        System.out.println("Precio total estantería número: "+opcion+" es: "+precioTotalEstanteria);
    }

    public void agregarProducto(){
        System.out.println("Agregando producto");
        incrementarIdentificadorGlobal();
        Producto producto;
        do{
            try{
                System.out.println("Es bebida azucarada?\n1. Sí\n2. No ");
                opcion = Integer.parseInt(lector.nextLine());
            }catch (Exception e){
                Logger.getGlobal().log(Level.SEVERE, "La opción debe ser un número");
            }
        }while (opcion<1 || opcion>2);


        if(opcion==1){
            producto = solicitarBebidaAzucarada();

        }else{
            producto = solicitarBebidaAguaMineral();
        }

        ingresarEnEstantería(producto);

    }

    private void ingresarEnEstantería(Producto producto){

        for (int i = 0; i < estanterias.length; i++) {
            int productos = estanterias[i].getProductos().length;

            for (int j = 0; j < productos; j++) {

                if(Objects.isNull(estanterias[i].getProductos()[j])){
                    estanterias[i].getProductos()[j]=producto;
                    return;
                }
            }

        }

    }

    private Producto solicitarBebidaAzucarada(){
        Azucarada azucarada = new Azucarada();
        azucarada.setIdentificador(identificadorGlobal);

        System.out.println("Ingrese la cantidad de litros: ");
        azucarada.setLitros(lector.nextDouble());
        lector.nextLine();

        System.out.println("Ingrese precio: ");
        azucarada.setPrecio(lector.nextDouble());
        lector.nextLine();

        System.out.println("Ingrese marca: ");
        azucarada.setMarca(lector.nextLine());

        System.out.println("Porcentaje de azucar: ");
        azucarada.setPorcentajeAzucar(lector.nextDouble());

        do{
            System.out.println("Tiene promocion?\n1. Sí\n2. No");
            opcion = lector.nextInt();
            lector.nextLine();

        }while (opcion<1 || opcion>2);

        if(opcion == 1){
            azucarada.setPrecio(azucarada.getPrecio() - (azucarada.getPrecio()*(0.1)));
        }

        azucarada.setTienePromocion(opcion == 1);


        System.out.println(azucarada.toString());

        return azucarada;

    }

    private Producto solicitarBebidaAguaMineral(){

        AguaMineral aguaMineral = new AguaMineral();
        aguaMineral.setIdentificador(identificadorGlobal);

        System.out.println("Ingrese la cantidad de litros: ");
        aguaMineral.setLitros(lector.nextDouble());
        lector.nextLine();

        System.out.println("Ingrese precio: ");
        aguaMineral.setPrecio(lector.nextDouble());
        lector.nextLine();

        System.out.println("Ingrese marca: ");
        aguaMineral.setMarca(lector.nextLine());

        System.out.println("Origen: ");
        aguaMineral.setOrigen(lector.nextLine());


        System.out.println(aguaMineral.toString());

        return aguaMineral;
    }

    public void eliminarProducto(){
        System.out.println("Ingrese identificador del producto a eliminar: \n");
        opcion = lector.nextInt();
        lector.nextLine();
        int identificador = opcion;


        for (int i = 0; i < estanterias.length; i++) {
            int productos = estanterias[i].getProductos().length;

            for (int j = 0; j < productos; j++) {

                if(!Objects.isNull(estanterias[i].getProductos()[j])){
                    if(estanterias[i].getProductos()[j] instanceof AguaMineral){
                        AguaMineral aguaMineral = (AguaMineral) estanterias[i].getProductos()[j];
                        if(aguaMineral.getIdentificador().equals(identificador)){
                            estanterias[i].getProductos()[j] = null;

                        }
                    }else{
                        Azucarada azucarada = (Azucarada) estanterias[i].getProductos()[j];
                        if(azucarada.getIdentificador().equals(identificador)){
                            estanterias[i].getProductos()[j] = null;

                        }
                    }
                }
            }

        }

    }

    public void mostrarInformacion(){
        System.out.println("Mostramos toda la info del almacen");

        escribirArchivo();
    }

    private void escribirArchivo(){
        try (FileWriter fichero = new FileWriter("almacen.txt", false);
             PrintWriter pw = new PrintWriter(fichero);){

            for (int i = 0; i < estanterias.length; i++) {
                for (int j = 0; j < estanterias[i].getProductos().length; j++) {

                    if(!Objects.isNull(estanterias[i].getProductos()[j])){
                        System.out.println("Estantería: "+(i+1)+" "+estanterias[i].getProductos()[j].toString());
                        pw.println(estanterias[i].getProductos()[j].toString());
                    }

                }

            }

        }catch (Exception e){
            Logger.getGlobal().log(Level.SEVERE, "Error escribiendo en archivo", e);
        }
    }


    private void incrementarIdentificadorGlobal(){
        identificadorGlobal++;
    }



}
