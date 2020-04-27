package controller;

import business.RespuestaService;
import data.entities.Respuesta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/respuestas")
public class RespuestaController {

    @Autowired
    private RespuestaService service;

    @GetMapping
    public List<Respuesta> readAll() {
        return service.findAll();
    }

    @PostMapping
    Respuesta newRespuesta(@RequestBody Respuesta respuesta) {
        return service.save(respuesta);
    }

    @GetMapping("/{id}")
    public Respuesta one(@PathVariable Long id) {
        return service.findById(id);
    }

    @PutMapping("/{id}")
    public Respuesta replaceRespuesta(@RequestBody Respuesta respuesta,
                                               @PathVariable Long id) {
        return service.update(respuesta, id);
    }

    @DeleteMapping("/{id}")
    void deleteRespuesta(@PathVariable Long id) {
        service.deleteById(id);
    }
}
