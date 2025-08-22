package com.example.projectwebflux.controller;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

public class TestControllerTest {

    TestController testController=new TestController();

    @Test
    void testEmisorDeNumeros(){
        //TOMAR EL PUBLISHER QUE DESEEMOS PROBAR
        Flux<Integer> emisorNumeros = testController.test(); //publicador

        StepVerifier.create(emisorNumeros)
                .expectNext(1)
                .expectNext(2)
                .expectNext(3)
                .expectNext(4)
                .expectNext(5)
                .expectComplete()
                .verify();//subscripcion
    }
}
