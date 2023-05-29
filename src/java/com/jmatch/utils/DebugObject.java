
package com.jmatch.utils;
import java.lang.reflect.Field;

public class DebugObject {
    
    public static <T> void printObject(T objeto) {
        Class<?> clase = objeto.getClass();
        Field[] campos = clase.getDeclaredFields();
        String response = "\n\n"
                + "-------------------------\n"
                + "Debug Object by JC\n"
                + "Atributos:\n";
        for (Field campo: campos) {
            campo.setAccessible(true);
            String nombreCampo = campo.getName();
            Object valorCampo;
            try {
                valorCampo = campo.get(objeto);
            } catch (IllegalAccessException e) {
                valorCampo = null;
                System.out.println(e);
            }
            response += nombreCampo + " = " + valorCampo + "\n";
        }
        response += "-------------------------";
        System.out.println(response);
    }
}
