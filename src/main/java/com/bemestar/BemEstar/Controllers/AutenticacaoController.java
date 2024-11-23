package com.bemestar.BemEstar.Controllers;

import com.bemestar.BemEstar.Cuidador;
import com.bemestar.BemEstar.Services.CuidadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/autenticacao")
public class AutenticacaoController {
    @Autowired
    private CuidadorService cuidadorService;

    @GetMapping
    public ResponseEntity<Optional<Cuidador>> autoriza(String email, String senha){
        return new ResponseEntity<>(cuidadorService.getUsuario(email,  senha), HttpStatus.OK);
    }
}
