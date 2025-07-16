package com.javabackend.gestioncolegio.service;

import com.javabackend.gestioncolegio.dto.CursosResponseDto;
import com.javabackend.gestioncolegio.dto.TareasResponseDto;
import com.javabackend.gestioncolegio.model.Cursos;
import com.javabackend.gestioncolegio.repository.CursosRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CursosService {
    private final CursosRepository cursosRepository;



    public List<CursosResponseDto> getCursos(){
        List<Cursos> cursosList= cursosRepository.findAll();
        return mapCursos(cursosList);
    }

    private List<CursosResponseDto> mapCursos(List<Cursos> cursos){
        List<CursosResponseDto> cursosResponseDtosList =new ArrayList<>();

        for(Cursos curso: cursos){
            CursosResponseDto cursosResponseDto = new CursosResponseDto();
            cursosResponseDto.setId(curso.getId());
            cursosResponseDto.setNombre(curso.getNombre());
            cursosResponseDto.setDescripcion(curso.getDescripcion());
            TareasResponseDto tareasResponseDto= new TareasResponseDto();
            tareasResponseDto.setTitulo("pruebita");
            cursosResponseDto.setTareasResponseDto(tareasResponseDto);
            cursosResponseDtosList.add(cursosResponseDto);

        }
        return cursosResponseDtosList;
    }


}
