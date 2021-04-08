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
        persistirAluno(entityManager);
    }

    private static void persistirAluno(EntityManager entityManager) {
        CPF cpf = new CPF("12312312312");
        Aluno aluno = new Aluno("Job", "1234567890", cpf);
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(aluno);
        transaction.commit();
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
    private static void persistirProfessor(EntityManager entityManager) {
        Professor professor = new Professor("R. Job");
        professor.novoEmail("ricardo.job@ifpb.edu.br");
        professor.novoEmail("ricardo@ifpb.edu.br");
        professor.novoEmail("job@ifpb.edu.br");
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(professor);
        transaction.commit();
    }
    private static void persistirPerfil(EntityManager entityManager) {
        String descricao = "s entidades são convertidas para tabelas no banco..\n"
                + "Os atributos simples desta entidade são convertidos às colunas da respectiva tabela \n."
                + " Nesta seção vamos estudar como configura e utilizar as anotações nos atributos simples. \n"
                + " Nesta seção vamos estudar como configura e utilizar as anotações nos atributos simples. \n"
                + " Nesta seção vamos estudar como configura e utilizar as anotações nos atributos simples. \n"
                + " Nesta seção vamos estudar como configura e utilizar as anotações nos atributos simples. \n"
                + " Nesta seção vamos estudar como configura e utilizar as anotações nos atributos simples. \n"
                + " Nesta seção vamos estudar como configura e utilizar as anotações nos atributos simples. \n"
                + " Nesta seção vamos estudar como configura e utilizar as anotações nos atributos simples. \n"
                + " Nesta seção vamos estudar como configura e utilizar as anotações nos atributos simples. \n"
                + " Nesta seção vamos estudar como configura e utilizar as anotações nos atributos simples. \n"
                + " Nesta seção vamos estudar como configura e utilizar as anotações nos atributos simples. \n"
                + " Nesta seção vamos estudar como configura e utilizar as anotações nos atributos simples. \n"
                + " Nesta seção vamos estudar como configura e utilizar as anotações nos atributos simples. \n"
                + "-Todas as anotações estão presentes no pacote javax.persistence.*";

        Perfil  perfil = new Perfil(
                "ricardojob",
                "src/main/resources/imagens/job.jpg"
        );
        perfil.setDescricao(descricao);
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(perfil);
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
