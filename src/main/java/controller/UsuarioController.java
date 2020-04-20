package controller;

import business.UsuarioService;
import data.entities.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    //CRUD  CREATE (POST) , READ (GET), UPDATE (PUT), DELETE (DELETE)
    @GetMapping
    public List<Usuario> readAll(){
        return service.findAll();
    }

    @PostMapping
    Usuario newUsuario(@RequestBody Usuario newUsuario) {
        return service.save(newUsuario);
    }

    // Single item
    @GetMapping("/{id}")
    public Usuario one(@PathVariable Long id) {
        return service.findById(id);
    }

    @PutMapping("/{id}")
    public Usuario replaceUsuario(@RequestBody Usuario newUsuario, @PathVariable Long id){
        return service.update(newUsuario, id);
    }

    @DeleteMapping("/{id}")
    void deleteUsuario(@PathVariable Long id){
        service.deleteById(id);
    }

}
