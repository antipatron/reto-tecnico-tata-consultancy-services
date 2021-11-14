package com.tcs;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LectorUtil {
    private static Scanner lector = new Scanner(System.in);

    public static int leerInteger(String mensaje){
        boolean incorrecto =  true;
        int opcion = 0;
        do{
            try{
                System.out.println(mensaje);
                opcion = Integer.parseInt(lector.nextLine());
                //lector.nextLine();

                incorrecto=false;
            }catch (Exception e){
                Logger.getGlobal().log(Level.SEVERE, "La opción debe ser un número");
            }
        }while (incorrecto);


        return opcion;
    }

    public static String leerString(String mensaje){
        boolean incorrecto =  true;
        String opcion = "";
        do{
            try{
                System.out.println(mensaje);
                opcion = lector.nextLine();

                if(!opcion.isEmpty()){
                    incorrecto=false;
                }else{
                    System.out.println("Este campo no puede ser vacío");
                }

            }catch (Exception e){
                Logger.getGlobal().log(Level.SEVERE, "Error leyendo cadena por teclado");
            }
        }while (incorrecto);


        return opcion;
    }

    public static double leerDouble(String mensaje){
        boolean incorrecto =  true;
        double opcion = 0;
        do{
            try{
                System.out.println(mensaje);
                opcion = Double.parseDouble(lector.nextLine());

                incorrecto=false;
            }catch (Exception e){
                Logger.getGlobal().log(Level.SEVERE, "La opción debe ser un número");
            }
        }while (incorrecto);


        return opcion;
    }

}
