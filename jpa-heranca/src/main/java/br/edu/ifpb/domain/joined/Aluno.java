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
@DiscriminatorValue("al")
public class Aluno extends Pessoa{

    private String matricula;
    private String curso;

    public Aluno() {
    }

    protected Aluno(String nome,String cpf, String matricula, String curso) {
        super(nome,cpf);
        this.matricula = matricula;
        this.curso =curso;
    }
    public static Aluno create(String nome,String cpf, String matricula, String curso) {
        Objects.requireNonNull(nome, "O nome não pode ser nulo");
        Objects.requireNonNull(cpf, "O cpf não pode ser nulo");
        Objects.requireNonNull(curso, "O curso não pode ser nulo");
        Objects.requireNonNull(matricula, "A matrícula não pode ser nula");
        return new Aluno(nome, cpf, matricula, curso);
    }

    public String getMatricula() {
        return matricula;
    }
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
    public String getCurso() {
        return curso;
    }
    public void setCurso(String curso) {
        this.curso = curso;
    }
}
