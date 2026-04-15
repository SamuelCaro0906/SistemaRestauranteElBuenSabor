package com.mycompany.restauranteelbuensabor;

public class Proceso {

    public static double CalcularTotalPedido() {
        double Subtotal = 0;
        double iva = 0;
        double tot = 0;
        double aux = 0;
        int cont = 0;
        int i = 0;
        while (i < Datos.nombreProductos.length) {
            if (Datos.cantidadPedida[i] > 0) {
                Subtotal = Subtotal + Datos.precioProductos[i] * Datos.cantidadPedida[i];
                cont = cont + 1;
            }
            i++;
        }
        if (cont > 3) {
            if (Subtotal > 0) {
                aux = Subtotal - (Subtotal * 0.05);
                if (aux > 50000) {
                    iva = aux * 0.19;
                    tot = aux + iva;
                    tot = tot + (tot * 0.10);
                } else {
                    iva = aux * 0.19;
                    tot = aux + iva;
                }
            }
        } else {
            if (Subtotal > 50000) {
                iva = Subtotal * 0.19;
                tot = Subtotal + iva;
                tot = tot + (tot * 0.10);
            } else {
                iva = Subtotal * 0.19;
                tot = Subtotal + iva;
            }
        }
        Datos.estadoMesa = 1;
        Datos.totalFactura = tot;
        return tot;
    }

    public static double procesar(double a, double b, double c, double d, double e, int f, boolean g) {
        double res = 0;
        double iva = 0;
        double prop = 0;
        double tmp = 0;
        res = a * b;
        if (c > 0) {

            res = res - (res * c);
        }
        iva = res * d;
        tmp = iva;
        res = res + tmp;
        if (g) {
            prop = res * e;
            res = res + prop;
        }
        if (f > 3) {
            res = res - (res * 0.01);
        }
        return res;
    }
}
