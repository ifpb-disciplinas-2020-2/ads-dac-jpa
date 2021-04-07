package br.edu.ifpb.main;

import br.edu.ifpb.domain.*;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 05/04/2021, 09:33:24
 */
public class Main {

    public static void main(String[] args) {
        EntityManager entityManager = Persistence
            .createEntityManagerFactory("ExemploPU2")
            .createEntityManager();
        persistirPessoa(entityManager);
    }

    private static void persistirPessoa(EntityManager entityManager) {
        Pessoa pessoa = new Pessoa("Job", Sexo.MASCULINO);
        EntityTransaction transaction = entityManager.getTransaction();
        //iniciar uma transação
        transaction.begin();
        entityManager.persist(pessoa);
        //comitar uma transação
        transaction.commit();
    }




    private static void persistirAluno(EntityManager entityManager) {
        Aluno aluno = new Aluno("Job", "1234567890");
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(aluno);
        transaction.commit();
    }

    private static void persistirPerfil(EntityManager entityManager) {
        Perfil  perfil = new Perfil("ricardojob");
        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();
        entityManager.persist(perfil);
        transaction.commit();
    }

    private static void persistirProfessor(EntityManager entityManager) {
        Professor professor = new Professor("R. Job");
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(professor);
        transaction.commit();
    }


    private static void listarPessoas(EntityManager entityManager) {
        List<Pessoa> resultList = entityManager.createQuery("SELECT p FROM Pessoa p")
            .getResultList();
        resultList.forEach(p -> {
            System.out.print("Nome: " + p.getNome());
            System.out.println("\tId: " + p.getId());
        });
    }
}
