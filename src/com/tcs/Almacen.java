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

    public Almacen() {
        for (int i = 0; i < estanterias.length; i++) {
            Estanteria estanteria = new Estanteria();
            estanterias[i] = estanteria;

        }
    }

    public void calcularPrecioTodasBebidas() {
        System.out.println("Calculando precio de todas las bebidas...");
        double precioTotal = 0;
        int productos = 0;
        for (int i = 0; i < estanterias.length; i++) {
            productos = estanterias[i].getProductos().length;
            for (int j = 0; j < productos; j++) {
                if (!Objects.isNull(estanterias[i].getProductos()[j])) {
                    Producto producto = estanterias[i].getProductos()[j];
                    Bebida bebida = (Bebida) producto;
                    precioTotal = precioTotal + bebida.getPrecio();

                }
            }
        }
        System.out.println("Precio total es: " + precioTotal);
    }

    public void calcularPrecioTotalMarcaBebida() {
        String marca = LectorUtil.leerString("Ingrese la marca a calcular precio: \n");
        double precioTotalMarca = 0;

        for (int i = 0; i < estanterias.length; i++) {
            int productos = estanterias[i].getProductos().length;
            for (int j = 0; j < productos; j++) {
                if (!Objects.isNull(estanterias[i].getProductos()[j])) {
                    Producto producto = estanterias[i].getProductos()[j];
                    Bebida bebida = (Bebida) producto;

                    if (bebida.getMarca().equals(marca)) {
                        precioTotalMarca = precioTotalMarca + bebida.getPrecio();
                    }
                }
            }
        }

        System.out.println("El precio total de bebidas de la marca: " + marca + " es: " + precioTotalMarca);

    }

    public void calcularPrecioTotalEstanteria() {
        do {
            opcion = LectorUtil.leerInteger("Ingrese la estantería: \n");
        } while (opcion < 1 || opcion > estanterias.length);

        int estanteria = opcion - 1;
        int productos = 0;
        double precioTotalEstanteria = 0;
        productos = estanterias[estanteria].getProductos().length;

        for (int j = 0; j < productos; j++) {
            if (!Objects.isNull(estanterias[estanteria].getProductos()[j])) {
                Producto producto = estanterias[estanteria].getProductos()[j];
                Bebida bebida = (Bebida) producto;
                precioTotalEstanteria = precioTotalEstanteria + bebida.getPrecio();

            }
        }

        System.out.println("Precio total estantería número: " + opcion + " es: " + precioTotalEstanteria);
    }

    public void agregarProducto() {
        System.out.println("Agregando producto");
        Producto producto;
        do {
            try {
                System.out.println("Es bebida azucarada?\n1. Sí\n2. No ");
                opcion = Integer.parseInt(lector.nextLine());
            } catch (Exception e) {
                Logger.getGlobal().log(Level.SEVERE, "La opción debe ser un número");
            }
        } while (opcion < 1 || opcion > 2);
        Bebida bebida = solicitarDatosBebida();

        if (opcion == 1) {
            producto = solicitarBebidaAzucarada(bebida);

        } else {
            producto = solicitarBebidaAguaMineral(bebida);
        }


        ingresarEnEstantería(producto);

    }

    private Bebida solicitarDatosBebida() {
        incrementarIdentificadorGlobal();
        Bebida bebida = new Bebida();

        bebida.setIdentificador(identificadorGlobal);
        bebida.setLitros(LectorUtil.leerDouble("Ingrese la cantidad de litros: "));
        bebida.setPrecio(LectorUtil.leerDouble("Ingrese precio: "));
        bebida.setMarca(LectorUtil.leerString("Ingrese marca: "));

        return bebida;
    }

    private void ingresarEnEstantería(Producto producto) {
        boolean ingresado = false;
        for (int i = 0; i < estanterias.length; i++) {
            int productos = estanterias[i].getProductos().length;

            for (int j = 0; j < productos; j++) {
                if (Objects.isNull(estanterias[i].getProductos()[j])) {
                    estanterias[i].getProductos()[j] = producto;
                    ingresado=true;
                    return;
                }
            }
        }
        if(ingresado){
            System.out.println("Producto agregado correctamente.");
        }else{
            System.out.println("No se pudo agregar el producto");
        }

    }

    private Producto solicitarBebidaAzucarada(Bebida bebida) {
        Azucarada azucarada = new Azucarada(bebida.getIdentificador(), bebida.getLitros(), bebida.getPrecio(), bebida.getMarca());

        azucarada.setPorcentajeAzucar(LectorUtil.leerDouble("Porcentaje de azucar: "));
        do {
            opcion = LectorUtil.leerInteger("Tiene promocion?\n1. Sí\n2. No");

        } while (opcion < 1 || opcion > 2);

        if (opcion == 1) {
            azucarada.setPrecio(azucarada.getPrecio() - (azucarada.getPrecio() * (0.1)));
        }
        azucarada.setTienePromocion(opcion == 1);
        System.out.println(azucarada.toString());

        return azucarada;

    }

    private Producto solicitarBebidaAguaMineral(Bebida bebida) {

        AguaMineral aguaMineral = new AguaMineral(bebida.getIdentificador(), bebida.getLitros(), bebida.getPrecio(), bebida.getMarca());
        do {
            opcion = LectorUtil.leerInteger("Origen de agua mineral?\n1. Manantial\n2. Oasis\n3. Reserva");

        } while (opcion < 1 || opcion > 3);
        aguaMineral.setOrigen(getOrigenAguaMineral(opcion));

        System.out.println(aguaMineral.toString());

        return aguaMineral;
    }

    private String getOrigenAguaMineral(int opcion) {
        if (opcion == 1) {
            return "Manantial";
        } else if (opcion == 2) {
            return "Oasis";
        } else {
            return "Reserva";
        }
    }

    public void eliminarProducto() {
        opcion = LectorUtil.leerInteger("Ingrese identificador del producto a eliminar: \n");
        int identificador = opcion;
        boolean eliminado = false;

        for (int i = 0; i < estanterias.length; i++) {
            int productos = estanterias[i].getProductos().length;
            for (int j = 0; j < productos; j++) {
                if (!Objects.isNull(estanterias[i].getProductos()[j])) {
                    Producto producto = estanterias[i].getProductos()[j];
                    Bebida bebida = (Bebida) producto;
                    if (bebida.getIdentificador().equals(identificador)) {
                        eliminado = true;
                        estanterias[i].getProductos()[j] = null;
                    }
                }
            }
        }
        if(eliminado){
            System.out.println("Se eliminó el producto con id "+identificador);
        }else {
            System.out.println("No se encontró el producto con id "+identificador);
        }
    }

    public void mostrarInformacion() {
        System.out.println("Mostramos toda la info del almacen");

        escribirArchivo();
    }

    private void escribirArchivo() {
        boolean vacio = true;
        try (FileWriter fichero = new FileWriter("almacen.txt", false);
             PrintWriter pw = new PrintWriter(fichero);) {
            for (int i = 0; i < estanterias.length; i++) {
                for (int j = 0; j < estanterias[i].getProductos().length; j++) {

                    if (!Objects.isNull(estanterias[i].getProductos()[j])) {
                        vacio=false;
                        System.out.println("Estantería: " + (i + 1) + " " + estanterias[i].getProductos()[j].toString());
                        pw.println(estanterias[i].getProductos()[j].toString());
                    }
                }
            }
        } catch (Exception e) {
            Logger.getGlobal().log(Level.SEVERE, "Error escribiendo en archivo", e);
        }
        if (vacio){
            System.out.println("No hay productos que imprimir.");
        }else{
            System.out.println("Productos impresos con exito.");
        }
    }

    private void incrementarIdentificadorGlobal() {
        identificadorGlobal++;
    }


}
