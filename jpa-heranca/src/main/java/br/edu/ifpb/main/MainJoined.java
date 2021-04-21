package br.edu.ifpb.main;

import br.edu.ifpb.domain.Endereco;
import br.edu.ifpb.domain.joined.Aluno;
import br.edu.ifpb.domain.joined.Pessoa;
import br.edu.ifpb.domain.joined.Professor;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 12/04/2021, 08:45:10
 */
public class MainJoined {

    public static void main(String[] args) {
        EntityManager entityManager = Persistence
            .createEntityManagerFactory("ExemploPU")
            .createEntityManager();

        Pessoa pessoa =new Pessoa(
                "Mariana",
                "123.123.123-12"
        );
        Aluno aluno = Aluno.create(
                "Ricardo",
                "111.222.333-44",
                "13232",
                "ADS"
        );
        Professor professor = Professor.create(
                "Job",
                "999.999.999-99",
                "313122",
                40
        );

        Endereco endereco =new Endereco(
                "Minha rua",
                "Meu bairro",
                "Minha cidade"
        );
        Endereco segundoEndereco =new Endereco(
                "tu rua",
                "teu bairro",
                "tua cidade"
        );

        //atribuições
        aluno.setEndereco(endereco);
        professor.setEndereco(segundoEndereco);

        entityManager.getTransaction().begin();
        entityManager.persist(endereco);
        entityManager.persist(segundoEndereco);
        entityManager.persist(aluno);
        entityManager.persist(professor);
        entityManager.getTransaction().commit();

//        entityManager.createQuery(
//                "FROM Professor p", Professor.class
//        ).getResultList()
//         .forEach(p ->
//             System.out.println(
//                  String.format("Nome: %s",p.getNome())
//             )
//         );
    }
    

}
