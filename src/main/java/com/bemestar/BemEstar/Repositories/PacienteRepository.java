package com.bemestar.BemEstar.Repositories;

import com.bemestar.BemEstar.Paciente;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PacienteRepository extends MongoRepository<Paciente, ObjectId> {
    Optional<Paciente> findPacienteByNome(String nome);
}
