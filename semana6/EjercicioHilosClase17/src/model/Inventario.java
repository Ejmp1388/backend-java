package model;

import java.util.concurrent.atomic.AtomicInteger;

public class Inventario {

    private AtomicInteger stock;

    public Inventario(int cantidad) {
        this.stock = new AtomicInteger(cantidad);
    }

    public void comprar(int cantidad){
        int stockActual=stock.get();
        if(stockActual>=cantidad){
            stock.compareAndSet(stockActual,stockActual-cantidad);
            System.out.println("Se ha comprado "+cantidad +" unidades");
        }
        else{
            System.out.println("No es posible realizar la compra");
        }

    }

    public void abastecer(int cantidad){
        int nuevoStock=stock.addAndGet(cantidad);
        System.out.println("Se ha abastecido "+cantidad+" unidades. Nuevo Stock: "+nuevoStock);

    }


}
