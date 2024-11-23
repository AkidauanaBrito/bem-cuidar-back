package com.bemestar.BemEstar.Controllers;

import com.bemestar.BemEstar.Cuidador;
import com.bemestar.BemEstar.Services.CuidadorService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/cuidadores")
public class CuidadorController {
    @Autowired
    private CuidadorService cuidadorService;

    @CrossOrigin
    @GetMapping
    public ResponseEntity<List<Cuidador>> getAll(){
        return new ResponseEntity<>(cuidadorService.getAll(), HttpStatus.OK);
    }
    @CrossOrigin
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Cuidador>> getCuidador(@PathVariable("id") ObjectId id){
        return new ResponseEntity<>(cuidadorService.getCuidador(id), HttpStatus.OK);
    }

    @CrossOrigin
    @PostMapping
    public ResponseEntity<Cuidador> createCuidador(@RequestBody Cuidador cuidador){
        return new ResponseEntity<Cuidador>(cuidadorService.addCuidador(cuidador),HttpStatus.CREATED);
    }
}
