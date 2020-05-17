package controller;


import business.ReporteService;
import data.entities.Reporte;
import data.entities.Respuesta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/reportes")
public class ReporteController {

    @Autowired
    private ReporteService service;

    //CRUD  CREATE (POST) , READ (GET), UPDATE (PUT), DELETE (DELETE)
    @GetMapping
    public List<Reporte> readAll(){
        return service.findAll();
    }

    @PostMapping
    Reporte newReporte(@RequestBody Reporte newReporte) {
        service.create(newReporte);
        Set<Respuesta> respuestas = newReporte.getRespuestas();

        for (Respuesta respuesta: respuestas) {
            respuesta.setReporte(newReporte);
        }

        newReporte.setRespuestas(respuestas);

        service.update(newReporte, newReporte.getId());

        return newReporte;
    }

    @GetMapping("/{id}")
    public  Reporte one(@PathVariable Long id) {
        return service.findOne(id);
    }

    @PutMapping("/{id}")
    public  Reporte replaceAnimal(@RequestBody Reporte newReporte, @PathVariable Long id) {
        return service.update(newReporte, id);
    }
    @DeleteMapping("/{id}")
    void deleteReporte(@PathVariable Long id) {
        service.delete(id);
    }

}
