package controller;

import business.PreguntaService;
import data.entities.Pregunta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/preguntas")
public class PreguntaController {

    @Autowired
    private PreguntaService service;

    @GetMapping
    public List<Pregunta> readAll() {
        return service.findAll();
    }

    @PostMapping
    Pregunta newUsuario(@RequestBody Pregunta pregunta) {
        return service.save(pregunta);
    }

    @GetMapping("/{id}")
    public Pregunta one(@PathVariable Long id) {
        return service.findById(id);
    }

    @PutMapping("/{id}")
    public Pregunta replacePregunta(@RequestBody Pregunta pregunta, @PathVariable Long id) {
        return service.update(pregunta, id);
    }

    @DeleteMapping("/{id}")
    void deletePregunta(@PathVariable Long id) {
        service.deleteById(id);
    }
}
