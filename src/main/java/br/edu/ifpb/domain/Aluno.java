package br.edu.ifpb.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Aluno implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "nome_do_aluno",nullable = false,updatable = false)
    private String nome;
    @Column(length = 15, unique = true)
    private String matricula; // 15 caracteres

    public Aluno(String nome, String matricula) {
        this.nome=nome;
        this.matricula=matricula;
    }
    public Aluno(String nome) {
        this.nome = nome;
    }
    public Aluno() {
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getMatricula() {
        return matricula;
    }
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
}

