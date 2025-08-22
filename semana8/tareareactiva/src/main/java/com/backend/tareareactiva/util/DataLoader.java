package com.backend.tareareactiva.util;

import com.backend.tareareactiva.model.Auto;
import com.backend.tareareactiva.repository.AutoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Flux;

@Configuration
public class DataLoader implements CommandLineRunner {

    private final AutoRepository autoRepository;

    public DataLoader(AutoRepository autoRepository) {
        this.autoRepository = autoRepository;
    }

    @Override
    public void run(String... args) {
        autoRepository.deleteAll()
                .thenMany(
                        Flux.just(
                                new Auto(1,"Toyota", "Corolla", 2020),
                                new Auto(2,"Honda", "Civic", 2021),
                                new Auto(3,"Ford", "Focus", 2019)
                        ).flatMap(autoRepository::save)
                ).subscribe();
    }
}