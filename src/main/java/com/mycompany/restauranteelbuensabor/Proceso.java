package com.mycompany.restauranteelbuensabor;

public class Proceso {

    public static double CalcularTotalPedido() {
        double Subtotal = 0;
        double iva = 0;
        double totalFactura = 0;
        double SubtotalConDescuento = 0;
        int CantidadITems = 0;
        int i = 0;
        while (i < Datos.nombreProductos.length) {
            if (Datos.cantidadPedida[i] > 0) {
                Subtotal = Subtotal + Datos.precioProductos[i] * Datos.cantidadPedida[i];
                CantidadITems = CantidadITems + 1;
            }
            i++;
        }
        if (CantidadITems > 3) {
            if (Subtotal > 0) {
                SubtotalConDescuento = Subtotal - (Subtotal * 0.05);
                if (SubtotalConDescuento > 50000) {
                    iva = SubtotalConDescuento * 0.19;
                    totalFactura = SubtotalConDescuento + iva;
                    totalFactura = totalFactura + (totalFactura * 0.10);
                } else {
                    iva = SubtotalConDescuento * 0.19;
                    totalFactura = SubtotalConDescuento + iva;
                }
            }
        } else {
            if (Subtotal > 50000) {
                iva = Subtotal * 0.19;
                totalFactura = Subtotal + iva;
                totalFactura = totalFactura + (totalFactura * 0.10);
            } else {
                iva = Subtotal * 0.19;
                totalFactura = Subtotal + iva;
            }
        }
        Datos.estadoMesa = 1;
        Datos.totalFactura = totalFactura;
        return totalFactura;
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
