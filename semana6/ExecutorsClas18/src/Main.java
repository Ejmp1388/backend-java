import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        ExecutorService pool= Executors.newFixedThreadPool(2);
        //para usar pool por defecto
        ExecutorService pool2= Executors.newCachedThreadPool();


        Runnable miRunnable=()->{
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Nombre H1: "+Thread.currentThread().getName());

        };
        Runnable otroRunnable=()->{
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Nombre H2:  "+Thread.currentThread().getName());
        };

        pool2.submit(miRunnable);
        pool2.submit(otroRunnable);

       // pool2.shutdown();

        pool2.submit(()->{
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Nombre H3:  "+Thread.currentThread().getName());
        });


    }
}