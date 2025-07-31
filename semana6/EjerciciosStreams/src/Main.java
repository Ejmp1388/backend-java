import model.Personas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        //ejercicio 1
        List<String> listaNombres= Arrays.asList("Ana", "Carlos", "Beatriz", "Luis", "María","jose","Josefina");
        List<String> resultado = listaNombres.stream()
                .filter(nombre -> nombre.length() > 4)
                .map(String::toUpperCase)
                .collect(Collectors.toList());

        System.out.println(resultado);

        //ejercicio2



        //Ejercicio 3

        List<Personas> personasList=new ArrayList<>();
        personasList.add(new Personas("Erick",38));
        personasList.add(new Personas("Osman",17));
        personasList.add(new Personas("Javier",40));

        Double promedio=personasList.stream()
                .filter(persona->persona.getEdad()>17)
                .mapToInt(p->p.getEdad())
                .average().getAsDouble();

        System.out.println(""+promedio);

        //Ejercicio 4
        List<Integer> listEnteros=Arrays.asList(1,2,3,4,5);
        BinaryOperator<Integer> sumaConsecutiva=(a,b)->a+b;

       Integer acumulado= listEnteros.stream().reduce(0,sumaConsecutiva);

       System.out.println(acumulado);

//hola Jose, que tal Jose, hasta luego Jose (que palabra más se repite)

        //Ejercicio 4
        String texto="hola Jose, que tal Jose, hasta luego Jose";

    }
}