package com.tcs;


import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    private static int opcion;
    private static Scanner lector = new Scanner(System.in);
    private static ProcesarComando procesarComando = new ProcesarComando();
    private static boolean salir = false;


    public static void main(String[] args) {

        while (!salir) {
            operacion();
            procesarComando.comando(opcion);
        }

    }

    public static void operacion() {
        boolean operacionIncorrecta = false;

        do {
            try {
                menu();
                System.out.println("Elija una operación entre 1 y 6: \n");
                opcion = Integer.parseInt(lector.nextLine());

            } catch (Exception e) {
                Logger.getGlobal().log(Level.SEVERE, "La opción debe ser un número");
                opcion = 0;
            }

            operacionIncorrecta = (opcion < 1 || opcion > 7);
            if (operacionIncorrecta) {
                System.out.println("OPERACIÓN INCORRECTA, VUELVE A INTENTARLO");
            }

            if (opcion == 7) {
                salir = true;
            }

        } while (operacionIncorrecta);


    }

    public static void menu() {
        System.out.println("\n" +
                "Operaciones del almacén: \n" +
                "1. Calcular precio de todas las bebidas\n" +
                "2. Calcular el precio total de una marca de bebida\n" +
                "3. Calcular el precio total de una estantería\n" +
                "4. Agregar producto\n" +
                "5. Eliminar producto\n" +
                "6. Mostrar información\n" +
                "7. Salir");

    }


}
