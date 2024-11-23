package com.bemestar.BemEstar.Controllers;

import com.bemestar.BemEstar.CreatePacienteRequest;
import com.bemestar.BemEstar.Paciente;
import com.bemestar.BemEstar.Services.PacienteService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/pacientes")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @CrossOrigin
    @GetMapping
    public ResponseEntity<List<Paciente>> GetAllPacientes(){
        return new ResponseEntity<List<Paciente>>(pacienteService.todosPacientes(), HttpStatus.OK) ;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Paciente>> GetPaciente(@PathVariable ObjectId id){
        return new ResponseEntity<Optional<Paciente>>(pacienteService.obtemPaciente(id), HttpStatus.OK);
    }

    @CrossOrigin
    @PostMapping
    public ResponseEntity<Paciente> createPaciente(@RequestBody CreatePacienteRequest pacienteRequest){

        return new ResponseEntity<Paciente>(pacienteService.addPaciente(pacienteRequest),HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletePaciente(@PathVariable("id") ObjectId id){
        pacienteService.deletePaciente(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
