package br.edu.ifpb.domain.hotel;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 21/04/2021, 09:51:22
 */
@Entity
public class Hotel implements Serializable {

    @Id
    @GeneratedValue
    private int id;
    private String abreviacao;
//    @ManyToMany
//    @JoinTable(name = "Hospedagem")
//    private List<Hospede> hospedes = new ArrayList<>();
    @OneToMany(mappedBy = "hotel")
    private List<Hospedagem> hospedagens = new ArrayList<>();

    public Hotel() {
    }
    public Hotel(String abreviacao) {
        this.abreviacao = abreviacao;
    }

    public void novo(Hospedagem hospedagem){
        hospedagem.setHotel(this);
        this.hospedagens.add(hospedagem);
    }
//    public void novo(Hospede hospede){
//        hospede.novo(this);
//        this.hospedes.add(hospede);
//    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getAbreviacao() {
        return abreviacao;
    }
    public void setAbreviacao(String abreviacao) {
        this.abreviacao = abreviacao;
    }
    public List<Hospedagem> getHospedagens() {
        return hospedagens;
    }
    public void setHospedagens(List<Hospedagem> hospedagens) {
        this.hospedagens = hospedagens;
    }
//    Hotel n    -    n Hospede
//              data

}
