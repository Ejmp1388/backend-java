package com.microservicio.userservice.infrastructure.mongo.document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
@Getter
@Setter
@AllArgsConstructor
public class UserDocument {
    @Id
    private Integer id;
    private String nombre;
    private Integer edad;
}
