package br.edu.ifpb.domain;

import br.edu.ifpb.infra.jpa.convert.ConvertLocalDate;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
public class Aluno implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "nome_do_aluno", nullable = false, updatable = false)
    private String nome;
    @Column(length = 15, unique = true)
    private String matricula; // 15 caracteres
    @Embedded
//    @AttributeOverride(name = "valor",column = @Column(name = "cpf_aluno"))
    private CPF cpf;
    @Convert(converter = ConvertLocalDate.class)
    private LocalDate dataDaMatricula;


    public Aluno(String nome, String matricula, CPF cpf) {
        this.nome = nome;
        this.matricula = matricula;
        this.cpf = cpf;
        this.dataDaMatricula = LocalDate.now();
    }
    public Aluno(String nome, String matricula) {
        this(nome, matricula, new CPF("11122233300"));
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
    public CPF getCpf() {
        return cpf;
    }
    public void setCpf(CPF cpf) {
        this.cpf = cpf;
    }
    public LocalDate getDataDaMatricula() {
        return dataDaMatricula;
    }
    public void setDataDaMatricula(LocalDate dataDaMatricula) {
        this.dataDaMatricula = dataDaMatricula;
    }
}

