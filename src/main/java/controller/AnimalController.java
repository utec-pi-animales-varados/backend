package controller;


import business.AnimalService;
import data.entities.Animal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/animales")
public class AnimalController {

    @Autowired
    private AnimalService service;


    //CRUD  CREATE (POST) , READ (GET), UPDATE (PUT), DELETE (DELETE)
    @PostMapping(value = "/")
    public ResponseEntity<?> create(@RequestBody Animal animal){
        return  new ResponseEntity<Animal>(service.create(animal), HttpStatus.OK);
    }

    public List<Animal> readAll(){
        return service.findAll();
    }



}
