package controller;


import business.AnimalService;
import data.entities.Animal;
import data.repositories.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/animales")
public class AnimalController {

    @Autowired
    private AnimalService service;

    //CRUD  CREATE (POST) , READ (GET), UPDATE (PUT), DELETE (DELETE)
    @GetMapping
    public List<Animal> readAll(){
        return service.findAll();
    }

    @PostMapping
    Animal newAnimal(@RequestBody Animal newAnimal) {
        return service.create(newAnimal);
    }

    //Single animal

    @GetMapping("/{id}")
    public  Animal one(@PathVariable Long id) {
        return service.findOne(id);
    }

    @PutMapping("/{id}")
    public  Animal replaceAnimal(@RequestBody Animal newAnimal, @PathVariable Long id) {
        return service.update(newAnimal, id);
    }

    @DeleteMapping("/{id}")
    void deleteAnimal(@PathVariable Long id) {
        service.delete(id);
    }
}
