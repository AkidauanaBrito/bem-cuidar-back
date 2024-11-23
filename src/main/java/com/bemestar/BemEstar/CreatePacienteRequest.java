package com.bemestar.BemEstar;

import org.bson.types.ObjectId;

public class CreatePacienteRequest {
    public String nome;
    public String email;
    public String password;
    public String weight;
    public String height;
    public String comorbidade;
    public ObjectId idCuidador;
}
