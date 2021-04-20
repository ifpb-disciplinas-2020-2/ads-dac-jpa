package br.edu.ifpb.domain;

import java.io.Serializable;


/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 18/04/2021, 18:54:14
 */
public class FuncionarioNativo {

    private int id;
    private String nome;

//    public FuncionarioNativo() {
//    }

    public FuncionarioNativo(int id,String nome) {
        this.id = id;
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
        return "FuncionarioNativo{" + "id=" + id + ", nome=" + nome + '}';
    }
    

}
