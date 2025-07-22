package com.javabackend.orders.service;

import com.javabackend.orders.config.EnvsFacade;
import com.javabackend.orders.repository.OrderRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.client.RestTemplate;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class OrderServiceTest {
    @Mock
    OrderRepository orderRepository;

    @Mock
    RestTemplate restTemplate;

    @Mock
    EnvsFacade envsFacade;

    @InjectMocks
    OrderService orderService;

    @Test
    void shouldCreateNewOrder(){
        //arrange
        when(envsFacade.getClientHostEnv()).thenReturn("localhost:8081");
        //when(restTemplate.exchange())
    }

}
