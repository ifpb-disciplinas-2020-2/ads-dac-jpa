package br.edu.ifpb.main;

import br.edu.ifpb.domain.*;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 18/04/2021, 19:51:20
 */
public class MainConsultasJPQL {

    public static void main(String[] args) {
        EntityManager em = Persistence
                .createEntityManagerFactory("ExemploPU")
                .createEntityManager();
//        new IniciadorBancoDeDados(em).dadosIniciais();
//        consultarTodosOsFuncionarios(em);
//        consultarDepartamentoComId(em);
//        consultarDepartamentoComIdParametros(em);
//        consultarDependentesComPaginacao(em);
//        consultarNomeDoDependentes(em);
//        consultarNomeDoDepartamentoEGerente(em);
//        consultarNomeDoDepartamentoEGerenteComTipo(em);
//        consultarNomeDoFuncionarioQuePossuiDependentes(em);
//        consultarNomeDoFuncionarioNomeDoDependente(em);
        consultarNomeDoFuncionarioQuantidadeDeDependentes(em);
//        consultarDependentesComIdEntre(em);
//        consultarDependentesComIdFora(em);
//        consultarDependentesComIdEntreBETWEEN(em);
//        consultarDependentesComIdForaBETWEEN(em);
//        consultarDepartamentoSemGerente(em);
//        consultarDepartamentoComGerente(em);
//        consultarFuncionarioPossuiDependente(em);
//        consultarFuncionarioDependenteIniciandoComLetra(em);
//        consultarPrimeiraLetraNomesDosDependente(em);
//        consultarNumeroDeTodosOsDependentes(em);
//        consultarNomeDoFuncionarioEQuantidadeDependentes(em);
//        consultarFuncionarComSalarioSuperiorAMedia(em);
//        consultarDependenteSeTodosIdSuperiorADez(em);
//        consultarDependenteSeQualquerIdSuperiorADez(em);
//        atualizarNomeTodosDependentes(em);
//        removerDependenteComId(em);
//        consultarTodosOsDependentesNamedQuery(em);
//        consultarOsDependentesComIdNamedQuery(em);
//        consultarTodosOsFuncionariosNativeQuery(em);
//        consultarTodosOsDependentesDoFuncionarioComIdOito(em);
//        consultarNomeIdFuncionariosNativeQuery(em);
//        consultarNomeIdEmpregadosNativeQueryComTipo(em);
//        consultarNomeIdFuncionarioNativeQueryComTipoEntidade(em);
    }

    /* Selecionar todos os Funcionarios */
    private static void consultarTodosOsFuncionarios(EntityManager em) {
        // SELECT * FROM Funcionario AS f -> tabela
        String jpql ="SELECT f FROM Funcionario f"; //entidade
//        Query query = em.createQuery("");
//        List resultList = query.getResultList(); // Object, Funcionario, Departamento
        TypedQuery<Funcionario> query = em.createQuery(jpql, Funcionario.class);
        List<Funcionario> resultList = query.getResultList();
        resultList.forEach( funcionario ->{
                System.out.print("nome: "+funcionario.getNome());
                System.out.println("\tcpf: "+funcionario.getCpf());}
        );

    }

    /* Selecionar o Departamento com id igual 7 */
    private static void consultarDepartamentoComId(EntityManager em) {
        // SELECT * FROM Departamento AS d WHERE d.id=7
        String jpql="SELECT d FROM Departamento d WHERE d.id=7";
        TypedQuery<Departamento> query = em.createQuery(jpql, Departamento.class);
        Departamento departamento = query.getSingleResult();
        System.out.println("Abreviação: "+departamento.getAbreviacao());

    }

    /* Selecionar o Departamento com id igual a um determinado parametro */
    private static void consultarDepartamentoComIdParametros(EntityManager em) {
        // SELECT * FROM Departamento AS d WHERE d.id = ?
//        String abreviacao ="JOB' OR 1=1 OR d.abreviacao ='a";
//        String jpql ="SELECT d FROM Departamento d WHERE d.id = ?1 AND d.abreviacao =?2";
        String jpql ="SELECT d FROM Departamento d WHERE d.id = :id AND d.abreviacao =:abreviacao";
        TypedQuery<Departamento> query = em.createQuery(jpql, Departamento.class);
//        query.setParameter(1, 7); // 1 -> posição, 7-> valor
//        query.setParameter(2, "UNINFO"); // 2 -> posição, UNINFO-> valor
        query.setParameter("id", 7);
        query.setParameter("abreviacao", "UNINFO");

        List<Departamento> resultList = query.getResultList();
        resultList.forEach(departamento ->
            System.out.println("Abreviação: "+departamento.getAbreviacao())
        );

    }

    /* Selecionar os Dependentes por página */
    private static void consultarDependentesComPaginacao(EntityManager em) {
        // A B | C D | E
        // SELECT * FROM Dependente AS d
        String jpql ="SELECT d FROM Dependente d";
        TypedQuery<Dependente> query = em.createQuery(jpql, Dependente.class);
        Long quantidadeDeDependentes = em.createQuery(
                "SELECT COUNT(d) FROM Dependente  d", Long.class
        ).getSingleResult();
        int quantidadePorPagina = 1;
        // quantidadeDeDependentes / quantidadePorPagina 6/4 -> 1 UP 2
        // o usuario não sabe essa informação
        int totalDePaginas = (int) Math.ceil(
                quantidadeDeDependentes/ (double) quantidadePorPagina
        );
        for(int numeroDaPagina =1; numeroDaPagina <=totalDePaginas; numeroDaPagina++) {
            int inicio =quantidadePorPagina*(numeroDaPagina-1);
            List<Dependente> resultList = query
                    .setFirstResult(inicio)
                    .setMaxResults(quantidadePorPagina)
                    .getResultList();
            System.out.println( "------ Página "+numeroDaPagina+" ---------" );
            resultList.forEach(dependente ->
                    System.out.println("Nome: " + dependente.getNome())
            );
        }
    }

    /* Selecionar o nome de todos os Dependentes*/
    private static void consultarNomeDoDependentes(EntityManager em) {
        // SELECT d.nome FROM Dependente AS d
        String jpql = "SELECT d.nome FROM Dependente d";
        TypedQuery<String> query = em.createQuery(jpql, String.class);
        query.getResultList()
                .forEach(System.out::println);

    }

    /* Selecionar a abreviação do Departamento e o seu Gerente */
    private static void consultarNomeDoDepartamentoEGerente(EntityManager em) {
        //SELECT d.abreviacao, d.gerente_id FROM Departamento d
        // [String, Gerente] -> Object[]
        String jpql = "SELECT d.abreviacao, d.gerente FROM Departamento d";
        TypedQuery<Object[]> query = em.createQuery(jpql, Object[].class);
        query.getResultList()
                .forEach( array ->
                    System.out.println(
                            "Abreviação:"+ array[0] + " Gerente: "+ array[1]
                    )
                );

    }

    /* Selecionar a abreviação do Departamento e o seu Gerente usando um Tipo específico*/
    private static void consultarNomeDoDepartamentoEGerenteComTipo(EntityManager em) {
        //SELECT d.abreviacao, d.gerente_id FROM Departamento d
//        new Gerencia("a", null);
        String jpql = "SELECT NEW br.edu.ifpb.domain.Gerencia(d.abreviacao, d.gerente) FROM Departamento d"; // Object[] -> Gerencia
        TypedQuery<Gerencia> query = em.createQuery(jpql, Gerencia.class);
        query.getResultList()
                .forEach(gerencia ->
                         System.out.println(
                            "Abreviação:"+ gerencia.getAbreviacao() + " Gerente: "+ gerencia.getGerente()
                        )
                );

    }

    /* Selecionar o nomes dos Funcionarios que possuem Dependentes */
    private static void consultarNomeDoFuncionarioQuePossuiDependentes(EntityManager em) {
        // SELECT f.nome FROM Funcionario f INNER JOIN Dependente d ON f.id= d.funcionario_id
        String jpql = "SELECT f.nome FROM Funcionario f JOIN f.dependentes d";  // Produto Cartesiano AxB
        TypedQuery<String> query = em.createQuery(jpql, String.class);
        query.getResultList()
                .forEach(System.out::println);
    }

    /* Selecionar o nomes dos Funcionarios e dos respectivos Dependentes */
    private static void consultarNomeDoFuncionarioNomeDoDependente(EntityManager em) {
        // SELECT f.nome, d.nome FROM Funcionario f INNER JOIN Dependente d ON f.id= d.funcionario_id
//        String jpql ="SELECT NEW br.edu.ifpb.domain.Dependentes( f.nome, d.nome) FROM Funcionario f, Dependente d"; // Produto Cartesiano AxB
        String jpql ="SELECT NEW br.edu.ifpb.domain.Dependentes( f.nome, d.nome) FROM Funcionario f, IN(f.dependentes) d";
        TypedQuery<Dependentes> query = em.createQuery(jpql, Dependentes.class);
        query.getResultList()
                .forEach( dependentes -> System.out.println(
                            " Funcionario: "+dependentes.getFuncionario() +
                            " Dependente: "+dependentes.getDependente()
                        )
                );
    }

    /* Selecionar o nomes dos Funcionarios e quantidade de seus Dependentes */
    private static void consultarNomeDoFuncionarioQuantidadeDeDependentes(EntityManager em) {
        //SELECT t0.NOME, COUNT(t1.CODIGO) FROM FUNCIONARIO t0, DEPENDENTE t1 WHERE (t1.funcionario_id = t0.ID) GROUP BY t0.NOME
//        SELECT t0.NOME, COUNT(t1.CODIGO) FROM {oj FUNCIONARIO t0 LEFT OUTER JOIN DEPENDENTE t1 ON (t1.funcionario_id = t0.ID)} GROUP BY t0.NOME
        String jpql = "SELECT f.nome, COUNT(d) FROM Funcionario f LEFT JOIN f.dependentes d GROUP BY f.nome";
        TypedQuery<Object[]> query = em.createQuery(jpql, Object[].class);
        query.getResultList()
                .forEach( array-> System.out.println(
                        "Nome: "+array[0]+ " count: "+array[1]
                ));
    }

    /* Selecionar o nome dos Dependentes que possuem id entre 15 e 17*/
    private static void consultarDependentesComIdEntre(EntityManager em) {


    }

    /* Selecionar o nome dos Dependentes que possuem id fora do intervalo de 15 a 17*/
    private static void consultarDependentesComIdFora(EntityManager em) {

    }

    /* Selecionar o nome dos Dependentes que possuem id entre 15 e 17, usando a clausa BETWEEN*/
    private static void consultarDependentesComIdEntreBETWEEN(EntityManager em) {

    }

    /* Selecionar o nome dos Dependentes que possuem id fora do intervalo de 15 a 17, usando BETWEEN*/
    private static void consultarDependentesComIdForaBETWEEN(EntityManager em) {

    }

    /* Selecionar os Departamentos que não possuem Gerente */
    private static void consultarDepartamentoSemGerente(EntityManager em) {

    }

    /* Selecionar os Departamentos que possuem Gerente */
    private static void consultarDepartamentoComGerente(EntityManager em) {


    }

    /* Selecionar o nome dos Funcionarios que possuem Dependentes */
    private static void consultarFuncionarioPossuiDependente(EntityManager em) {

    }

    /* Selecionar o nome dos Funcionarios que possuem Dependentes e
     * o nome do Dependente começa com letra M */
    private static void consultarFuncionarioDependenteIniciandoComLetra(EntityManager em) {

    }

    /* Selecionar a primeira letra do nome dos Dependentes  */
    private static void consultarPrimeiraLetraNomesDosDependente(EntityManager em) {

    }

    /* Selecionar o total de Dependentes  */
    private static void consultarNumeroDeTodosOsDependentes(EntityManager em) {

    }

    /* Selecionar o nomes dos Funcionarios e quantidade de seus Dependentes,
     * se a quantidade for superior ou igual a 2*/
    private static void consultarNomeDoFuncionarioEQuantidadeDependentes(EntityManager em) {
//
    }

    /* Selecionar o nome do Funcionario que possui o salário superior a média */
    private static void consultarFuncionarComSalarioSuperiorAMedia(EntityManager em) {
        //avg=1825.0

    }

    /* Selecionar o nome dos Dependentes SE TODOS os códigos forem superior a dez */
    private static void consultarDependenteSeTodosIdSuperiorADez(EntityManager em) {

    }

    /* Selecionar o nome dos Dependentes SE ALGUM dos códigos for superior a dez */
    private static void consultarDependenteSeQualquerIdSuperiorADez(EntityManager em) {
    }

    /* Atualizar o nome de todos os Dependentes para Maisculo*/
    private static void atualizarNomeTodosDependentes(EntityManager em) {
    }

    /* Remover o Dependente com código igual a 2 */
    private static void removerDependenteComId(EntityManager em) {
    }

    /* Selecionar todos os Dependentes  */
    private static void consultarTodosOsDependentesNamedQuery(EntityManager em) {
    }

    /* Selecionar todos os Dependentes com id superior a 5 */
    private static void consultarOsDependentesComIdNamedQuery(EntityManager em) {
    }

    private static void consultarTodosOsFuncionariosNativeQuery(EntityManager em) {
    }

    private static void consultarTodosOsDependentesDoFuncionarioComIdOito(EntityManager em) {
    }

    private static void consultarNomeIdFuncionariosNativeQuery(EntityManager em) {
    }

    private static void consultarNomeIdEmpregadosNativeQueryComTipo(EntityManager em) {
    }

    private static void consultarNomeIdFuncionarioNativeQueryComTipoEntidade(EntityManager em) {

    }
}
