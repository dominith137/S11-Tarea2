package org.usil.service;

import org.usil.model.Pedido;

public class ImpuestoService {
    
    private static final double IGV_PORCENTAJE = 0.18;

    public void calcularImpuestos(Pedido pedido) {
        double precioUnitario = pedido.getProducto().getPrecio();
        int cantidad = pedido.getCantidad();
        
        double subtotal = precioUnitario * cantidad;
        double igv = subtotal * IGV_PORCENTAJE;
        double total = subtotal + igv;
        
        pedido.setSubtotal(subtotal);
        pedido.setIgv(igv);
        pedido.setTotal(total);
    }
}

