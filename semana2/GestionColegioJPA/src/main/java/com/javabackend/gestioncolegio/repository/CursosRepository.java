package com.javabackend.gestioncolegio.repository;

import com.javabackend.gestioncolegio.model.Cursos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursosRepository extends JpaRepository<Cursos, Integer> {
}
