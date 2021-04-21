package br.edu.ifpb.domain.joined;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.Objects;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 21/04/2021, 11:16:47
 */
@Entity
@DiscriminatorValue("pr")
public class Professor extends Pessoa {

    private String siape;
    private int cargaHoraria;

    public Professor() {
    }

    protected Professor(String nome,String cpf,String siape, int cargaHoraria) {
        super(nome,cpf);
        this.siape = siape;
        this.cargaHoraria=cargaHoraria;
    }
    public static Professor create(String nome,String cpf, String siape,int cargaHoraria) {
        Objects.requireNonNull(nome, "O nome não pode ser nulo");
        Objects.requireNonNull(cpf, "O cpf não pode ser nulo");
        Objects.requireNonNull(siape, "A matrícula siape não pode ser nula");
        Objects.requireNonNull(cargaHoraria, "A carga horária não pode ser nula");
        Objects.requireNonNull(cargaHoraria, "A carga horária não pode ser nula");
        return new Professor(nome, cpf, siape, cargaHoraria);
    }

    public String getSiape() {
        return siape;
    }
    public void setSiape(String siape) {
        this.siape = siape;
    }
    public int getCargaHoraria() {
        return cargaHoraria;
    }
    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }
}
