package org.example;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        //EJERCICIO 1
        System.out.println("EJERCICIO 1 ====================");
        emiteMensaje()
                .map(transforma->transforma+" desde Project Reactor")
                .subscribe(mensajeTransformado-> System.out.println(mensajeTransformado)
                );

        //EJERCICIO 2
        System.out.println("EJERCICIO 2 ====================");
        emiteNumeros()
                .filter(pares->pares%2==0)
                .map(producto->producto*10)
                .subscribe(
                       numero->System.out.println(numero)
                );

        //EJERCICIO 3
        System.out.println("EJERCICIO 3 ====================");
        emiteLetras()
                .zipWith(emiteNumeros(),(letra, numero)->letra+" - "+numero)
                .subscribe(combinacion->System.out.println(combinacion));
        emiteLetras()
                .concatWith(emiteNumeros().map(Object::toString))
                .subscribe(item -> System.out.println("Emite: " + item)
                );
    }

    public static Mono<String> emiteMensaje(){
        return Mono.just("Hola, mundo reactivo");
    }

    public static Flux<Integer> emiteNumeros(){
        return Flux.just(1,2,3,4,5);
    }

    public static Flux<String> emiteLetras(){
        return Flux.just("A","B","C","D","E");
    }

}