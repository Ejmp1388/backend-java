package extenderhashmap;

import java.util.HashMap;

public class ExtiendHashMap<E,V> extends HashMap<E,V> {

    public void insertar(E e, V v){
        if (e!=null && v!=null){
            this.put(e,v);
        }else{
            System.out.println("Valores no insertados porque posee un null: "+e+" y "+v);
        }

    }

}
