package controller;

import business.PreguntaYRespuestaService;
import data.entities.PreguntaYRespuesta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pyq")
public class PreguntaYRespuestaController {

    @Autowired
    private PreguntaYRespuestaService service;

    @GetMapping
    public List<PreguntaYRespuesta> readAll() {
        return service.findAll();
    }

    @PostMapping
    PreguntaYRespuesta newUsuario(@RequestBody PreguntaYRespuesta preguntaYRespuesta) {
        return service.save(preguntaYRespuesta);
    }

    @GetMapping("/{id}")
    public PreguntaYRespuesta one(@PathVariable Long id) {
        return service.findById(id);
    }

    @PutMapping("/{id}")
    public PreguntaYRespuesta replacePreguntaYRespuesta(@RequestBody PreguntaYRespuesta preguntaYRespuesta,
                                                        @PathVariable Long id) {
        return service.update(preguntaYRespuesta, id);
    }

    @DeleteMapping("/{id}")
    void deletePreguntaYRespuesta(@PathVariable Long id) {
        service.deleteById(id);
    }
}
