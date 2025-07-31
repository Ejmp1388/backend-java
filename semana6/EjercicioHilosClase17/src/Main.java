import model.Inventario;


public class Main {
    public static void main(String[] args) {

        Inventario inventario=new Inventario(10);

        Thread compra1= new Thread(()->{
            inventario.comprar(5);
        });
        Thread abastecer1= new Thread(()->{
            inventario.abastecer(15);
        });
        Thread compra2= new Thread(()->{
            inventario.comprar(4);
        });
        Thread abastecer2= new Thread(()->{
            inventario.abastecer(10);
        });



        compra1.start();
        abastecer1.start();
        compra2.start();
        abastecer2.start();

    }
}