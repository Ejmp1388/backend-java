package org.example;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.function.Consumer;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //ejemplo 1
        //Mono<String> publicador=emitirSaludo();
        //System.out.println("aquí"+pulicador);

        //ejemplo2
       // Consumer<String> impresor=str-> System.out.println(str);
       // publicador.subscribe(impresor);

        // ejemplo 3
       // emitirNumeros().subscribe(n->System.out.println(n));

        //ejemplo 4
/*
        Consumer<Integer> onNext=n->System.out.println("on next-> "+n);
        Consumer<Throwable> onError=err->System.out.println("Error-> "+err);
        Runnable onComplete=()->System.out.println("completado");
        emitirNumeros().subscribe(
                onNext,
                onError,
                onComplete
        );
*/
        // ejemplo 5
       /* emitirSaludo().subscribe(
                str->System.out.println("on next-> "+str),
                null,
                ()->System.out.println("termino")
        );*/

        //ejemplo 6
     /*   emitirSaludo().subscribe(str->System.out.println("terminox"));


        System.out.println("llegamos aquí");*/


        //ejemplo 7 tipos operadores
        publicadorNombres()
                .map(String::toUpperCase)
                .filter(nombre->nombre.length()<=4)
                .subscribe(
                        nombre->System.out.println(nombre)
                );

        //ejemplo 8 - no devuelve nada
        nada().subscribe(
                null,
                err->System.out.println(err.getMessage()),
                null
        );

        //ejemplo 9
     //   publicarSaludar().subscribe();

        //ejemplo 10 flatmap (obtener lo que tenga adentro del publicador)
        saludador("Carlos").subscribe(
                nombre->System.out.println(nombre)
        );


    }

    public static Mono<String> emitirSaludo(){

        return Mono.just("hola mundo");
    }

    public static Mono<String> saludador(String nombre){
        return emitirSaludo().flatMap(str->Mono.just(str+" "+nombre));//emitirSaludo es un Mono<Strin> deje acceder al dato interno
    }

    public static Flux<Integer> emitirNumeros(){
        return Flux.just(1,2,3,4,5);
    }

    public static Flux<String> publicadorNombres(){
        return Flux.just("Carlos","Oman","Yisel","Javier","Guadalupe","ana");
    }

    public static Mono<Void> nada(){
        return Mono.error(new RuntimeException("ocurrico un erro"));
    }

    public static String saludar(){
        System.out.println("voy a saludar Ejemplo 9");
        return "hola mundo";
    }

    public static Mono<String> publicarSaludar(){
        return Mono.fromSupplier(()->saludar()); //no es lazy pero fromSupplier y fronCallable y fromFuture si son lazy no se ejecuta a menos que se subscriba
    }

}