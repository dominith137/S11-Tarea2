package org.usil.view;

import org.usil.controller.PedidoController;
import org.usil.facade.PedidoFacade;
import org.usil.model.Comprobante;
import org.usil.model.Producto;

/**
 * Vista del patrón MVC
 * Responsable de la presentación y entrada de datos
 */
public class PedidoView {
    
    private PedidoController controller;
    private PedidoFacade pedidoFacade;
    
    public PedidoView(PedidoController controller, PedidoFacade pedidoFacade) {
        this.controller = controller;
        this.pedidoFacade = pedidoFacade;
    }
    
    public void mostrarBienvenida() {
        System.out.println("=========================================");
        System.out.println("  SISTEMA DE PROCESAMIENTO DE PEDIDOS  ");
        System.out.println("=========================================\n");
    }
    
    public void procesarPedido(String nombreCliente, Producto producto, int cantidad) {
        System.out.println("--- Procesando pedido ---");
        System.out.println("Cliente: " + nombreCliente);
        System.out.println("Producto: " + producto.getNombre());
        System.out.println("Cantidad: " + cantidad);
        System.out.println();
        
        Comprobante comprobante = controller.registrarPedido(nombreCliente, producto, cantidad);
        
        if (comprobante != null) {
            pedidoFacade.mostrarComprobante(comprobante);
        } else {
            System.out.println("Error: No hay stock suficiente o la cantidad es inválida\n");
        }
    }
    
    public void mostrarEjemplos() {
        System.out.println("--- EJEMPLO 1: Pedido Exitoso ---\n");
        Producto producto1 = new Producto("Laptop", 2500.00, 10);
        procesarPedido("Juan Pérez", producto1, 2);
        
        System.out.println("\n");
        
        System.out.println("--- EJEMPLO 2: Stock Insuficiente ---\n");
        Producto producto2 = new Producto("Mouse", 50.00, 5);
        procesarPedido("María García", producto2, 10);
        
        System.out.println("\n");
        
        System.out.println("--- EJEMPLO 3: Segundo Pedido Exitoso ---\n");
        Producto producto3 = new Producto("Teclado", 120.00, 15);
        procesarPedido("Carlos López", producto3, 3);
        
        System.out.println("\n=========================================");
        System.out.println("       PROCESO FINALIZADO");
        System.out.println("=========================================");
    }
}

