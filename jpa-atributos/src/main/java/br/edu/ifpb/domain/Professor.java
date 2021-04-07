package br.edu.ifpb.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 05/04/2021, 10:09:51
 */
@Entity
@TableGenerator(
    name = "generator_table",
    table = "tabela_com_as_chaves",
    pkColumnName = "coluna_chave",
    valueColumnName = "coluna_valor",
    pkColumnValue = "prof_seq",
    allocationSize = 1
)
public class Professor implements Serializable {

    @Id
    @GeneratedValue(
            strategy = GenerationType.TABLE,
            generator = "generator_table"
    )
    private int id;
    private String nome;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataDeNascimento;

    public Professor() {
    }

    public Professor(String nome) {
        this(nome, new Date());
    }

    public Professor(String nome, Date dataDeNascimento) {
        this.nome = nome;
        this.dataDeNascimento = dataDeNascimento;
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
