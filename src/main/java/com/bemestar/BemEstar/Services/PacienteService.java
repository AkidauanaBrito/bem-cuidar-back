package com.bemestar.BemEstar.Services;

import com.bemestar.BemEstar.CreatePacienteRequest;
import com.bemestar.BemEstar.Cuidador;
import com.bemestar.BemEstar.Paciente;
import com.bemestar.BemEstar.Repositories.PacienteRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;
    @Autowired
    private MongoTemplate mongoTemplate;

    public List<Paciente> todosPacientes(){
        return pacienteRepository.findAll();
    }

    public Optional<Paciente> obtemPaciente(ObjectId id){
        return pacienteRepository.findById(id);
    }
    public Optional<Paciente> obtemPacienteByName(String nome){
        return pacienteRepository.findPacienteByNome(nome);
    }

    public Paciente addPaciente(CreatePacienteRequest pacienteRequest){

        Paciente paciente = new Paciente(pacienteRequest);

        Paciente recordedPaciente =  pacienteRepository.insert(paciente);

        mongoTemplate.update(Cuidador.class)
                .matching(Criteria.where("_id").is(pacienteRequest.idCuidador))
                .apply(new Update().push("pacientesIds").value(recordedPaciente))
                .first();
        return recordedPaciente;
    }

    public void deletePaciente(ObjectId id){
        pacienteRepository.deleteById(id);
    }
}
