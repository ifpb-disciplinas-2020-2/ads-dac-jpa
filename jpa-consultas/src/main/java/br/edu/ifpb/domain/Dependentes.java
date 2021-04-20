package br.edu.ifpb.domain;

import java.io.Serializable;


/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 18/04/2021, 18:42:24
 */
public class Dependentes implements Serializable{

    private String funcionario;
    private String dependente;

    public Dependentes(String funcionario,String dependente) {
        this.funcionario = funcionario;
        this.dependente = dependente;
    }

    public String getFuncionario() {
        return funcionario;
    }

    public String getDependente() {
        return dependente;
    }
    
}
