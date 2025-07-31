import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //Predicate<Integer> esPar=(num)->num%2==0;
        Consumer<Integer> imprimirNumero=(num)->System.out.println(num);

        Stream<Integer> integerStream =Stream.of(1,2,3,4,5,6,7,8);
        long cantidadFinal =integerStream
                .filter(num->num%2==0) //operación intermedia
                .peek(imprimirNumero) //operación intermedia
                .count(); //cierre --> contar los elementos de la colección

        System.out.println("Cantidad final: "+cantidadFinal);


        //Ejemplo 2


        List<Integer> miLista= Arrays.asList(1,2,3,4,5);
        Function<Integer,Integer> multiplicarPorDos=(num)->num*2;
        Consumer<Integer> impresoraDeNumeros=(num)->System.out.println(num);
        //Multiplica cada número por 2
        //devolverlo como lista
        List<Integer> listaTransformada=
                miLista.stream() //operación creación
                .map(multiplicarPorDos) //operación intermedia
                .toList(); //operación cierre

        System.out.println("Lista trasnformada: "+listaTransformada.toString());



                miLista.stream() //operación creación
                        .map(num->num*2) //operación intermedia
                        .filter(num->num>5)
                        .forEach(impresoraDeNumeros);


    }
}