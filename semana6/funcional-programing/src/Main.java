import concurrent.Counter;
import concurrent.TransactionService;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        //EJEMPLO 1
       // TransactionService transactionService = new TransactionService();
       // transactionService.doTransaction();

        //EJEMPLO2
      //  Runnable myRunnable =()->System.out.println("hola desde un hilo");

      //  Thread t=new Thread(myRunnable); // los hilos clásicos no retornan nada
      //  t.start(); // siempre start nunca directamente run


        //EJEJMPLO 3

        Counter counter=new Counter();

        System.out.println(counter.getCont());
        Thread t1= new Thread(()->{
            for (int i=0; i<1000; i++){
                counter.incrementar();
            }
        });

        Thread t2= new Thread(()->{
            for (int i=0; i<1000; i++){
                counter.incrementar();
            }
        });

        t1.start();
        t2.start();
        try {Thread.sleep(2000);}catch (InterruptedException ex){}

       // try {t1.join();} catch (InterruptedException e) { }
       // try {t2.join();} catch (InterruptedException e) { }
        //System.out.println("aquí " + counter.getCont());
        System.out.println("aquí " + Counter.atomicInteger);



    }
}