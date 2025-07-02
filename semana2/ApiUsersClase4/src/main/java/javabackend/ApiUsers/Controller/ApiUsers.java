package javabackend.ApiUsers.Controller;

import javabackend.ApiUsers.model.Usuarios;
import javabackend.ApiUsers.model.UsuariosDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/apiuser/v1")
public class ApiUsers {

    private final Map<String, Usuarios> usuarios = new HashMap<>();

    @PostMapping("/save")
    public ResponseEntity<?> saveUser(@Valid @RequestBody Usuarios user){
        if(user.getEmail()==null || user.getEmail().isEmpty()){
            return ResponseEntity.status(HttpStatus.CREATED).body("No Guardado");
        }

        usuarios.put(user.getEmail(),user);
        return ResponseEntity.status(HttpStatus.CREATED).body("Guardado");
    }

    @GetMapping("/allUsers")
    public ResponseEntity<?> allUsers(){
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarios);
    }

    @PostMapping("/alluserandemail")
    public ResponseEntity<?> userAndEmail(){
        List<UsuariosDTO> usuariosdto = new ArrayList<>();
        for(Usuarios user: usuarios.values()){
            usuariosdto.add(new UsuariosDTO(user.getEmail(),user.getNombre()));
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(usuariosdto);
    }

    @PostMapping("/update/{email}")
    public ResponseEntity<?> update(@PathVariable String email, @RequestBody Usuarios user){
        Usuarios existentes = usuarios.get(email);
        if (existentes == null) {
            return ResponseEntity.notFound().build();
        }
        existentes.setNombre(user.getNombre());
        existentes.setEdad(user.getEdad());
        existentes.setOcupacion(user.getOcupacion());
        return ResponseEntity.ok(usuarios);
    }

    @DeleteMapping("/delete/{email}")
    public ResponseEntity<?> delete(@PathVariable String email){
        usuarios.remove(email);
        return ResponseEntity.ok(usuarios);
    }



}
