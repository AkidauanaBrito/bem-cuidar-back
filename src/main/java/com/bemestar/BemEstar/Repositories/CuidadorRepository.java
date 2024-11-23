package com.bemestar.BemEstar.Repositories;

import com.bemestar.BemEstar.Cuidador;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CuidadorRepository extends MongoRepository<Cuidador, ObjectId> {
    Optional<Cuidador> findByEmailAndPassword(String login, String password);
}
