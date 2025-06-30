package extenderhashmap;

import java.util.HashMap;

public class MainExtiendHashMap {
    public static void main(String[] args) {
        ExtiendHashMap<String,String> hashmapextendido=new ExtiendHashMap<String,String>();

        hashmapextendido.insertar(null,"London");
        hashmapextendido.insertar("India", "New Dehli");
        hashmapextendido.insertar("Austria", "Wien");
        hashmapextendido.insertar("Norway", "Oslo");
        hashmapextendido.insertar("Norway", "Oslo"); // Duplicate
        hashmapextendido.insertar("USA", "Washington DC");

        System.out.println("Valores insertados: "+hashmapextendido);
    }
}
