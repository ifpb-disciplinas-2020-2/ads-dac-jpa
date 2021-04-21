package br.edu.ifpb.domain.mapped;

import br.edu.ifpb.domain.Endereco;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;
import java.io.Serializable;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 21/04/2021, 11:15:56
 */
@MappedSuperclass
public class FuncionarioExecutivo implements Serializable {

    @Id
    @GeneratedValue
    private int id;
    private String nome;
    private String cpf;

    // apenas unidirecional !!
    @OneToOne//(cascade = {CascadeType.MERGE,CascadeType.PERSIST})
    private Endereco endereco;

    public FuncionarioExecutivo() {
    }

    public FuncionarioExecutivo(String nome,String cpf) {
        this.nome = nome;
        this.cpf = cpf;
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

}
