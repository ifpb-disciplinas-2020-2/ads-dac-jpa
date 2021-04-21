package br.edu.ifpb.domain.single;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 21/04/2021, 10:35:06
 */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorValue("animal")
@DiscriminatorColumn(name = "tipo", length = 15)
public class Animal implements Serializable{

    @Id
    @GeneratedValue
    private int id;
    private String nome;
    private String raca;

    public Animal() {
    }

    public Animal(String nome,String raca) {
        this.nome = nome;
        this.raca = raca;
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

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }
    
}
