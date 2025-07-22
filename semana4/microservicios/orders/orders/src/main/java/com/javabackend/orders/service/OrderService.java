package com.javabackend.orders.service;

import com.javabackend.orders.dto.ClientResponseDto;
import com.javabackend.orders.dto.CreateNewOrderCreatingNewClientDto;
import com.javabackend.orders.dto.GenerateNewOrderDto;
import com.javabackend.orders.model.Order;
import com.javabackend.orders.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@Setter
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final RestTemplate restTemplate;

    @Value("${app.envs.client.host}")
    private String host;//esto quiero que lo inyecte como variable de entorno

    public Order createNewOrder(GenerateNewOrderDto dto){
        //genero url
        String url="localhot:8081/api/v1/client/"+dto.getClientEmail();

        //llamar microservicio clientes
        ResponseEntity<ClientResponseDto> responseEntityDto=restTemplate.exchange(
                url, HttpMethod.GET, null, ClientResponseDto.class);

        if(responseEntityDto.getStatusCode().is2xxSuccessful()){
            ClientResponseDto bodyResponse=responseEntityDto.getBody();
            Order order=new Order();
            order.setClientId(bodyResponse.getId());
            return orderRepository.save(order);
        }
        throw  new RuntimeException("ERROR");
        //obtener cliente
        //si el cliente existe guardo la orden sino gener excepción
        /*resttemplate.exchange()
        cual es su url
        cual es el verbo
        que contenido envio ->null
        cuales header vas a enviar ->> null
        cual es la respuesta esperada

        * */

       // return null;
    }

    public Order createNewOrderCreatingNewClient(CreateNewOrderCreatingNewClientDto dto){
        //llamar micro clientes para guardar nuevo cliente
        //crear nueva orden
        String url="localhot:8081/api/v1/client";
        HttpEntity<CreateNewOrderCreatingNewClientDto> request=new HttpEntity<>(dto);
        ResponseEntity<ClientResponseDto> responseEntity =restTemplate.exchange(
                url,HttpMethod.POST,request, ClientResponseDto.class);
       ClientResponseDto bodyResponse= responseEntity.getBody();
       Order order=new Order();
       order.setClientId(bodyResponse.getId());
       return orderRepository.save(order);


        /*restemplate.exchange()
        cual es su url

        * */

    }
}
