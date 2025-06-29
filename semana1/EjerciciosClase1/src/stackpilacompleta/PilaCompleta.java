package stackpilacompleta;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PilaCompleta<E> extends Stack<E> {

    public void pushAll(List<E> lista){
        //Stack<E> stack = new Stack<>();
        for(E l:lista){
            this.push(l);
            System.out.println("Insertado: " + l);
        }

    }

    public List<E> popAll(){
        List<E> lista=new ArrayList<>();
        while (!this.isEmpty()) {
            lista.add(this.pop());
            System.out.println("Elemento extraído: " + lista);
        }
        return lista;
    }
}
