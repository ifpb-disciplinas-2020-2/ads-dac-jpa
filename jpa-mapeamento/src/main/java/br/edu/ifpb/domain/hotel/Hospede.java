package br.edu.ifpb.domain.hotel;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 21/04/2021, 09:50:42
 */
@Entity
public class Hospede implements Serializable {

    @Id
    @GeneratedValue
    private int id;
    private String nome;
    //    @ManyToMany(mappedBy = "hospedes")
//    private List<Hotel> hoteis = new ArrayList<>();
    @OneToMany(mappedBy = "hospede")
    private List<Hospedagem> hospedagens = new ArrayList<>();

    public Hospede() {
    }
    public Hospede(String nome) {
        this.nome = nome;
    }

    public void novo(Hospedagem hospedagem){
        hospedagem.setHospede(this);
        this.hospedagens.add(hospedagem);
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

}
