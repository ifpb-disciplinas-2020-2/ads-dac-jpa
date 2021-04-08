package br.edu.ifpb.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 05/04/2021, 11:05:41
 */
@Embeddable
public class CPF implements Serializable {

//    @Column(name = "cpf")
    private final String valor;
    public CPF(String valor) {
        this.valor = valor;
    }
    public CPF(){
        this("11122233300");
    }

    public String valor() {
        return valor; //12345678910
    }
    public String formatado() {
        return valor; //123.456.789-10
    }
    public boolean valido() {
        if (valor == null) {
            return false;
        }
        return this.valor.trim().length() <= 11;
    }
}
