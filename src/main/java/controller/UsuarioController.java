package controller;

import business.UsuarioService;
import data.dto.ChangePasswordDTO;
import data.entities.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @PutMapping("/changePassword/{id}")
    public Boolean changePassword(@PathVariable Long id, @RequestBody ChangePasswordDTO changePasswordDTO) {
        Usuario usuario = service.findById(id);
        Boolean passwordIsCorrect = service.findByUsernameAndPassword(usuario.getEmail(), changePasswordDTO.getOldPassword());
        if (passwordIsCorrect) {
            service.changePassword(changePasswordDTO.getNewPassword(), id);
            return true;
        } else {
            return false;
        }
    }
}
