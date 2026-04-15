package com.mycompany.restauranteelbuensabor;

public class Utilidades {

    public static double calcular(double pr, double cn, double dc, double iv, double pp, int ni, boolean ap) {
        double res = 0;
        double tmp = 0;
        double aux2 = 0;
// calcula el resultado
        res = pr * cn;
        if (dc > 0) {
            res = res - (res * dc);
        }
        tmp = res * iv;
        res = res + tmp;
        if (ap) {
            res = res + (res * pp);
        }
// imprime restaurante
        System.out.println("RESTAURANTE EL BUEN SABOR - calculo aplicado");
        aux2 = res;
        return aux2;
    }

    public static boolean validar() {
        int cont = 0;
        int i = 0;
        while (i < Datos.cantidadPedida.length) {
            if (Datos.cantidadPedida[i] > 0) {
                cont = cont + 1;
            }
            i++;
        }// fin while
// reinicia si no hay nada - efecto secundario no documentado
        if (cont == 0) {
            Datos.totalFactura = 0;
            Datos.textoTemporal = "";
        }
        return cont > 0;
    }

    public static void reiniciar() {
        int i = 0;
        while (i < Datos.cantidadPedida.length) {
            Datos.cantidadPedida[i] = 0;
            i++;
        }
        Datos.totalFactura = 0;
        Datos.estadoMesa = 0;
        Datos.numeroMesa = 0;
        Datos.textoTemporal = "";
    }
}
