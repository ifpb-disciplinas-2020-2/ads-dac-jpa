package br.edu.ifpb.main;

import br.edu.ifpb.domain.Aluno;
import br.edu.ifpb.domain.Perfil;
import br.edu.ifpb.domain.Pessoa;
import br.edu.ifpb.domain.Professor;
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
        persistirAluno(entityManager);
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






    private static void persistirPessoa(EntityManager entityManager) {
        Pessoa pessoa = new Pessoa("Job");
        EntityTransaction transaction = entityManager.getTransaction();
        //iniciar uma transação
        transaction.begin();
        entityManager.persist(pessoa);
        //comitar uma transação
        transaction.commit();
    }





//    public static void main(String[] args) {
//        EntityManager entityManager = Persistence
//                .createEntityManagerFactory("ExemploPU2")
//                .createEntityManager();
//        salvarAluno(entityManager);
//        salvarPerfil(entityManager);
//        salvarProfessor(entityManager);
//        salvarPessoa(entityManager);
//        listarPessoas(entityManager);

//    }



//    private static void salvarPessoa(EntityManager entityManager) {
////        Pessoa pessoa = new Pessoa(590,"Chiquinha");
//        Pessoa pessoa = new Pessoa("Nhonho");
//        EntityTransaction transaction = entityManager.getTransaction();
//
//        //iniciar uma transação
//        transaction.begin();
//        entityManager.persist(pessoa);
//        //finalizar uma transação
//        transaction.commit();
//    }

    private static void listarPessoas(EntityManager entityManager) {
        List<Pessoa> resultList = entityManager.createQuery("FROM Pessoa p")
            .getResultList();
        resultList.forEach(p -> {
            System.out.print("Nome: " + p.getNome());
            System.out.println("\tId: " + p.getId());
        });
    }

    private static void salvarPerfil(EntityManager entityManager) {
        Perfil  perfil = new Perfil();
        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();
        entityManager.persist(perfil);
        transaction.commit();
    }

}
