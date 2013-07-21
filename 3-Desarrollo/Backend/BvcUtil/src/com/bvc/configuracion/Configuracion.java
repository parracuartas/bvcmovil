/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bvc.configuracion;

/**
 *
 * @author xHANSx
 */
public class Configuracion {

    public static String CODIFICACION;
    private static Configuracion configuracion;

    private Configuracion() {
        if (sistemaOperativoLinux()) {
            CODIFICACION = "UTF-8";
        } else {
            CODIFICACION = "ISO-8859-15";
        }
    }

    private boolean sistemaOperativoLinux() {
        String soActual = System.getProperty("os.name");
        soActual = soActual.toUpperCase();
        if (soActual.indexOf("WINDOWS", 0) != -1) {
            return false;
        }
        return true;
    }

    public static Configuracion getInstancia() throws Exception {
        if (configuracion == null) {
            try {
                configuracion = new Configuracion();
            } catch (Exception e) {
                throw new Exception();
            }
        }
        return configuracion;
    }
}
