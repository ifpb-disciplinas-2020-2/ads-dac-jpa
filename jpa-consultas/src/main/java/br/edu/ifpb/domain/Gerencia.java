package br.edu.ifpb.domain;

import java.io.Serializable;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 18/04/2021, 19:48:19
 */
// DDD -> ValueObject
public class Gerencia implements Serializable{

    private final String abreviacao;
    private final Gerente gerente;

    public Gerencia(String abreviacao, Gerente gerente) {
        this.abreviacao = abreviacao;
        this.gerente = gerente;
    }

    public String getAbreviacao() {
        return abreviacao;
    }

    public Gerente getGerente() {
        return gerente;
    }
    
}
