package com.bemestar.BemEstar;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "cuidadores")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cuidador {
    @Id
    private ObjectId id;
    private List<Paciente> pacientesIds;

    private String email;
    private String password;

    private String nome;
    private String cpf;
    private String endereco;
    private String telefone;
    private String crt;
}
