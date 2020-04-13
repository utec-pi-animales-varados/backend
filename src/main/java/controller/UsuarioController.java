package controller;


import business.UsuarioService;
import data.entities.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
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
    @PostMapping(value = "/")
    public ResponseEntity<?> create(@RequestBody Usuario usuario){
        return  new ResponseEntity<Usuario>(service.create(usuario), HttpStatus.OK);
    }

    @GetMapping(value = "/")
    public List<Usuario> readAll(){
        return service.findAll();
    }



}
