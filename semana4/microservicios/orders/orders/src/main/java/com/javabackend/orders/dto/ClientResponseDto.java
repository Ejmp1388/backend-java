package com.javabackend.orders.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true) // cualquier campo que no conozca ignoralo
public class ClientResponseDto {

    private String id;
    @JsonProperty("email")//en json el campo es email
    private String mail;
}
