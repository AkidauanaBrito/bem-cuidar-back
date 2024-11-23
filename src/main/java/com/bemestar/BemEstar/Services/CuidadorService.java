package com.bemestar.BemEstar.Services;

import com.bemestar.BemEstar.Cuidador;
import com.bemestar.BemEstar.Repositories.CuidadorRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CuidadorService {
    @Autowired
    private CuidadorRepository cuidadorRepository;

    public List<Cuidador> getAll(){
        return cuidadorRepository.findAll();
    }

    public Cuidador addCuidador(Cuidador cuidador){

        return cuidadorRepository.insert(cuidador);
    }

    public Optional<Cuidador> getUsuario(String email, String password){
        return cuidadorRepository.findByEmailAndPassword(email, password);

    }
    public Optional<Cuidador> getCuidador(ObjectId id){

        return cuidadorRepository.findById(id);
    }
}
