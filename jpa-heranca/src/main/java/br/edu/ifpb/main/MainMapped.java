package br.edu.ifpb.main;

import br.edu.ifpb.domain.mapped.Analista;
import br.edu.ifpb.domain.mapped.Tecnico;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 21/04/2021, 10:39:29
 */
public class MainMapped {

    public static void main(String[] args) {
        EntityManager em = Persistence
            .createEntityManagerFactory("ExemploPU")
            .createEntityManager();

        Analista aluno = new Analista(
            "123","Chaves","124"
        );

        Tecnico professor = new Tecnico(
            "125","Girafales","126"
        );

        em.getTransaction().begin();
        em.persist(aluno);
        em.persist(professor);
        em.getTransaction().commit();

        em.createQuery("FROM Analista g",Analista.class)
            .getResultList()
            .forEach(
                g -> System.out.println(g.getNome())
            );
    }

}
