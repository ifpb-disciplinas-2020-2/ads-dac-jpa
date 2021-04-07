package br.edu.ifpb.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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

    public Pessoa() {
    }

    public Pessoa(int id,String nome) {
        this.id = id;
        this.nome = nome;
    }
    public Pessoa(String nome) {
        this.nome = nome;
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

    @Override
    public String toString() {
        return "Pessoa{ " + "id=" + id + ", nome=" + nome + '}';
    }    
}


