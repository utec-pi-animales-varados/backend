package controller;


import business.ReporteService;
import business.UploadImagenService;
import data.entities.Reporte;
import data.entities.Respuesta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Path;
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

        for (Respuesta respuesta: respuestas)
            respuesta.setReporte(newReporte);

        newReporte.setRespuestas(respuestas);

        service.update(newReporte, newReporte.getId());

        return newReporte;
    }

    @GetMapping("/usuario/{id}")
    public List<Reporte> reportsByUser(@PathVariable Long id) {
        return service.findReportsByUserID(id);
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
