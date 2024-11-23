package com.bemestar.BemEstar;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "pacientes")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Paciente {
    @Id
    private ObjectId id;
    private String nome;

    private String email;
    private String password;
    private String weight;
    private String height;
    private String comorbidade;
    
    public Paciente(String nome) {
        this.nome = nome;
    }
    public Paciente(CreatePacienteRequest pacienteRequest){
        this.nome = pacienteRequest.nome;
        this.email = pacienteRequest.email;
        this.password = pacienteRequest.password;
        this.weight = pacienteRequest.weight;
        this.height = pacienteRequest.height;
        this.comorbidade = pacienteRequest.comorbidade;
    }
}
