package br.edu.ifpb.main;

import br.edu.ifpb.domain.*;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 12/04/2021, 08:45:10
 */
public class Main {

    public static void main(String[] args) {
        EntityManager entityManager = Persistence
            .createEntityManagerFactory("ExemploPU")
            .createEntityManager();
        Endereco endereco = new Endereco(
          "Minha rua",
          "Meu bairro",
          "CzCity"
        );
        Funcionario funcionario = new Funcionario(
             "João Gabriel",
             "123.123.123-12",
             endereco // atribuição
        );
        Dependente ana = new Dependente(
                "Ana Maria"
        );
        Dependente jose = new Dependente(
                "José"
        );
        Fornecedor job = new Fornecedor(
                "Job",
                "Informática"
        );
        Fornecedor diogo = new Fornecedor(
                "Diogo",
                "Informática"
        );
        Projeto dac= new Projeto(
                "DAC, a volta"
        );
        Departamento uninfo = new Departamento(
                "UNINFO"
        );
        Gerente paulo = new Gerente(
                "Paulo",
                "123.123.123.23"
        );

        //atribuição bidirecionais
        uninfo.setGerente(paulo); //atribuição
        paulo.setDepartamento(uninfo); //atribuição

        //atribuição bidirecionais
        dac.setGerente(paulo);
        paulo.novo(dac);

        //atribuição bidirecionais
        dac.novo(funcionario);
        funcionario.novo(dac);

        funcionario.novo(ana); // atribuição
        funcionario.novo(jose); // atribuição
        funcionario.setDepartamento(uninfo); // atribuição
        dac.novo(job); //atribuição
        dac.novo(diogo); //atribuição

        entityManager.getTransaction().begin();
        entityManager.persist(funcionario);
        entityManager.persist(jose);
        entityManager.persist(ana);
        entityManager.persist(endereco);
        entityManager.persist(uninfo);
        entityManager.persist(paulo);
        entityManager.persist(job);
        entityManager.persist(diogo);
        entityManager.persist(dac);
        entityManager.getTransaction().commit();

//        Funcionario joaoGabriel = entityManager.find(Funcionario.class, 1);
//        System.out.println(joaoGabriel.getNome());
//        System.out.println(joaoGabriel.getEndereco().getRua()); //JOIN
//        System.out.println(joaoGabriel.getDependentes().size());
//        System.out.println(joaoGabriel.getDependentes().get(0).getNome());
//        joaoGabriel.getDependentes().forEach(d-> System.out.println(d.getNome()));

//        Gerente gerente = entityManager.find(Gerente.class, 6);
//        System.out.println(gerente.getDepartamento().getAbreviacao()); //JOIN
    }
    

}
