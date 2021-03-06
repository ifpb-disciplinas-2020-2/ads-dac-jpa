package br.edu.ifpb.domain.table;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 21/04/2021, 11:00:32
 */
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Carro implements  Serializable{

    @Id
    @GeneratedValue
    private int id;
    private String nome;
    private String modelo;

    public Carro() {
    }

    public Carro(String nome,String modelo) {
        this.nome = nome;
        this.modelo = modelo;
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

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    
}
