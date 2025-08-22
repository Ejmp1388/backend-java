CREATE TABLE PERSONAS (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(255),
    edad INT
);

INSERT INTO PERSONAS (nombre, edad) VALUES ('Carlos', 30);
INSERT INTO PERSONAS (nombre, edad) VALUES ('Ana', 25);

CREATE TABLE CARROS (
    id INT PRIMARY KEY AUTO_INCREMENT,
    marca VARCHAR(255) NOT NULL,
    persona_id INT NOT NULL,
    CONSTRAINT fk_carros_personas
        FOREIGN KEY (persona_id) REFERENCES PERSONAS(id)
        ON DELETE CASCADE
);

CREATE INDEX idx_carros_persona ON CARROS(persona_id);

INSERT INTO CARROS(marca, persona_id) VALUES ('Toyota', 1);
INSERT INTO CARROS(marca, persona_id) VALUES ('Mazda', 1);
INSERT INTO CARROS(marca, persona_id) VALUES ('Renault', 2);
