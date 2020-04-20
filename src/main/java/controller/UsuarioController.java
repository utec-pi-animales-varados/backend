package controller;


import business.UsuarioService;
import data.entities.Usuario;
import data.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

//    @Autowired
//    private UsuarioService service;

    private final UsuarioRepository repository;

    UsuarioController(UsuarioRepository repository) {
        this.repository = repository;
    }

    //CRUD  CREATE (POST) , READ (GET), UPDATE (PUT), DELETE (DELETE)
    @GetMapping
    public List<Usuario> readAll(){
        return repository.findAll();
    }

    @PostMapping
    Usuario newUsuario(@RequestBody Usuario newUsuario) {
        return repository.save(newUsuario);
    }

    // Single item

    @GetMapping("/{id}")
    public Usuario one(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new UsuarioNotFoundException(id));
    }

    @PutMapping("/{id}")
    public Usuario replaceUsuario(@RequestBody Usuario newUsuario, @PathVariable Long id){
        return repository.findById(id).map(usuario -> {
            usuario.setName(newUsuario.getName());
            usuario.setLastName(newUsuario.getLastName());
            usuario.setEmail(newUsuario.getEmail());
            usuario.setPassword(newUsuario.getPassword());
            usuario.setReports(newUsuario.getReports());
            usuario.setTelephone(newUsuario.getTelephone());
            usuario.setMobilePhone(newUsuario.getMobilePhone());
            return repository.save(usuario);
        }).orElseGet(()->{
            newUsuario.setId(id);
            return repository.save(newUsuario);
        });
    }

    @DeleteMapping("/{id}")
    void deleteUsuario(@PathVariable Long id){
        repository.deleteById(id);
    }

}
