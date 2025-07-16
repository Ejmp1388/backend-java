package com.javabackend.gestioncolegio.controller;

import com.javabackend.gestioncolegio.dto.CursosResponseDto;
import com.javabackend.gestioncolegio.model.Cursos;
import com.javabackend.gestioncolegio.repository.CursosRepository;
import com.javabackend.gestioncolegio.service.CursosService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/cursos")
public class CursosController {

    private final CursosService cursosService;

    @GetMapping
    public ResponseEntity<List<CursosResponseDto>> getAllCursos(){
        List<CursosResponseDto> cursosList=cursosService.getCursos();
        return new ResponseEntity<>(cursosList, HttpStatus.OK);
    }


}
