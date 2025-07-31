package com.javabackend.gestioncolegio.repository;

import com.javabackend.gestioncolegio.model.Cursos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CursosRepository extends JpaRepository<Cursos, Integer> {
    @Query("SELECT c FROM CURSOS c LEFT JOIN FETCH c.TAREAS")
    List<Cursos> findAllWithTareas();
}
