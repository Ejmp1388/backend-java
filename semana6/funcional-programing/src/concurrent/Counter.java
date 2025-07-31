package concurrent;

import java.util.concurrent.atomic.AtomicInteger;

public class Counter {
    public int cont;

    public static AtomicInteger atomicInteger =new AtomicInteger(0);

    public Counter() {
        this.cont = 0;
    }

    public void incrementar1(){
        cont++;

    }
    //bloqueo optimista
    public void incrementar() {
        atomicInteger.incrementAndGet();
    }

//bloqueo pesimista, sólo un hilo por instancia puede utilizar este método
  //  public synchronized void incrementar(){
 //       cont++;
 //   }

    public int getCont() {
        return this.cont;
    }


}
