package br.edu.ifpb.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 12/04/2021, 08:42:46
 */
@Entity
public class Departamento implements Serializable{
    @Id
    @GeneratedValue
    private int id;
    private String abreviacao;

    // UM Departamento tem UM Gerente
    @OneToOne(mappedBy = "departamento")// 1 -> 1 bidirecional (inversa)
    private Gerente gerente;

    public Departamento() {
    }

    public Departamento(String abreviacao) {
        this.abreviacao = abreviacao;
    }

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

    public Gerente getGerente() {
        return gerente;
    }

    public void setGerente(Gerente gerente) {
        this.gerente = gerente;
    }
}
