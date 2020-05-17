package controller;

import business.UsuarioService;
import data.entities.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/signup")
public class SignUpController {

    @Autowired
    private UsuarioService service;

    //CREATE (POST)
    @PostMapping
    Usuario newUsuario(@RequestBody Usuario newUsuario) {
        return service.save(newUsuario);
    }

}
