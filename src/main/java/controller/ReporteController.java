package controller;


import business.ReporteService;
import data.entities.Reporte;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/reportes")
public class ReporteController {

    @Autowired
    private ReporteService service;


    //CRUD  CREATE (POST) , READ (GET), UPDATE (PUT), DELETE (DELETE)
    @PostMapping(value = "/")
    public ResponseEntity<?> create(@RequestBody Reporte reporte){
        return  new ResponseEntity<Reporte>(service.create(reporte), HttpStatus.OK);
    }

    public List<Reporte> readAll(){
        return service.findAll();
    }



}
