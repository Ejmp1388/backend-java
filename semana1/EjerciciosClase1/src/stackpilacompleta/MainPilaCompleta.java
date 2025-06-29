package stackpilacompleta;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class MainPilaCompleta<E> {
    public static <E> void main(String[] args){
        PilaCompleta pcompleta = new PilaCompleta();
        List<String> fruits = new ArrayList<>();
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Orange");

        pcompleta.pushAll(fruits);

        List<String> listavaciado=pcompleta.popAll();


        System.out.println("Pila extraída: "+listavaciado);
        System.out.println("Pila vacía: "+pcompleta);



    }
}
