package com.javabackend.gestioncolegio.repository;

import com.javabackend.gestioncolegio.model.Tareas;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TareasRepository extends JpaRepository<Tareas, Integer> {
}
