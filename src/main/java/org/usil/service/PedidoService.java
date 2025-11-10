package org.usil.service;

import org.usil.model.Pedido;
import org.usil.model.Producto;

public class PedidoService {

    public boolean registrarPedido(Pedido pedido) {
        // Actualizar el stock del producto
        Producto producto = pedido.getProducto();
        int stockActual = producto.getStock();
        int cantidadPedida = pedido.getCantidad();
        producto.setStock(stockActual - cantidadPedida);

        return true;
    }
}

