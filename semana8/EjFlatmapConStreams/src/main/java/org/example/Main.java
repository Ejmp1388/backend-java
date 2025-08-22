package org.example;

import java.util.stream.Stream;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
       // streamNombre().forEach(nombre->System.out.println("Hola: "+nombre));
        saludadorNombreEdad().forEach(System.out::println);

    }

    public static Stream<String> saludador(){
        return streamNombre().map(
                nombre->"hola "+nombre+" de " + getEdadByName(nombre) +" años de edad"

        );
    }

    public static Stream<String> saludadorNombreEdad(){
        //se puede usar flatMap en lugar de map y luego tengo que quitar
        //.findFirst() y .orElse
        return streamNombre().map(
                nombreImput->{
                    Stream<Integer> edadStream = getEdadByNameStream(nombreImput);
                    return edadStream
                            .map(edad->nombreImput +" tiene "+edad+" años")
                            .findFirst()
                            .orElse(nombreImput+" sin edad");
                }
        );
    }

    public static Stream<String> streamNombre(){
        return Stream.of("Ana","Daniel","María","Juan");
    }

    public static Integer getEdadByName(String nombre){
        if(nombre.equals("Ana")){
            return 18;
        }
        if(nombre.equals("Daniel")){
            return 20;
        }
        if(nombre.equals("María")){
            return 25;
        }
        else {return 30;}
    }

    public static Stream<Integer> getEdadByNameStream(String nombre){
        if(nombre.equals("Ana")){
            return Stream.of(18);
        }
        if(nombre.equals("Daniel")){
            return Stream.of(20);
        }
        if(nombre.equals("María")){
            return Stream.of(25);
        }
        else {return Stream.of(30);}
    }
}