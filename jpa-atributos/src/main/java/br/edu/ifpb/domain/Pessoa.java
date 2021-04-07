package br.edu.ifpb.domain;

import java.io.Serializable;
import javax.persistence.*;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 05/04/2021, 09:22:23
 */
@Entity
@Table(name = "tb_pessoa")
public class Pessoa implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id; // serial
    /* -- H2
        CREATE TABLE TB_PESSOA(
           ID   INTEGER auto_increment primary key,
           NOME VARCHAR
        );
    */
    private String nome;
    @Enumerated(EnumType.ORDINAL)
//    @Enumerated(EnumType.STRING)
    private Sexo sexo;

    public Pessoa() {
    }
    public Pessoa(String nome, Sexo sexo) {
        this.nome=nome;
        this.sexo =sexo;
    }
    public Pessoa(int id,String nome, Sexo sexo) {
        this(nome, sexo);
        this.id = id;
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
    public Sexo getSexo() {
        return sexo;
    }
    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    @Override
    public String toString() {
        return "Pessoa{ " + "id=" + id + ", nome=" + nome + '}';
    }    
}


