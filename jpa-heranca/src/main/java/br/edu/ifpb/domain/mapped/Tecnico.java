package br.edu.ifpb.domain.mapped;

import javax.persistence.Entity;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 21/04/2021, 11:16:47
 */
@Entity
public class Tecnico extends FuncionarioExecutivo {

    private String siape;

    public Tecnico() {
    }

    public Tecnico(String siape,String nome,String cpf) {
        super(nome,cpf);
        this.siape = siape;
    }

    public String getSiape() {
        return siape;
    }

    public void setSiape(String siape) {
        this.siape = siape;
    }

}
