package br.edu.ifpb.domain.chaves;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 08/04/2021, 09:46:48
 */
@Entity
@IdClass(TelefoneChaveComposta.class)
public class Telefone implements Serializable {
    @Id
    private String ddd;
    @Id
    private String numero;
    private String pais; // +55

    public Telefone() {
    }
    public Telefone(String ddd, String numero) {
        this("+55", ddd, numero);
    }
    public Telefone(String pais, String ddd, String numero) {
        this.pais = pais;
        this.ddd = ddd;
        this.numero = numero;
    }
    public String formatado(){
        return new StringBuilder(this.pais)
                .append(" (")
                .append(this.ddd)
                .append(") ")
                .append(this.numero)
                .toString();
    }
    public String getPais() {
        return pais;
    }
    public void setPais(String pais) {
        this.pais = pais;
    }
    public String getDdd() {
        return ddd;
    }
    public void setDdd(String ddd) {
        this.ddd = ddd;
    }
    public String getNumero() {
        return numero;
    }
    public void setNumero(String numero) {
        this.numero = numero;
    }
}