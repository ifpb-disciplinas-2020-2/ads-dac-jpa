package br.edu.ifpb.main;

import br.edu.ifpb.domain.Departamento;
import br.edu.ifpb.domain.Dependente;
import br.edu.ifpb.domain.Endereco;
import br.edu.ifpb.domain.Funcionario;
import br.edu.ifpb.domain.Gerente;
import br.edu.ifpb.domain.Projeto;
import javax.persistence.EntityManager;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 18/04/2021, 22:12:03
 */
public class IniciadorBancoDeDados {

    private final EntityManager em;

    public IniciadorBancoDeDados(EntityManager em) {
        this.em = em;
    }

    public void dadosIniciais() {
        Endereco meuEndereco = new Endereco(
            "Minha rua","Meu bairro","Minha cidade"
        );
        Endereco primeiro = new Endereco(
            "rua","bairro","cidade"
        );
        Endereco segundo = new Endereco(
            "rua 1","bairro","cidade"
        );
        Funcionario chaves = new Funcionario(
            "Chaves","134",2300.0,primeiro
        );
        Funcionario kiko = new Funcionario(
            "Kiko","1354",1200.0,segundo
        );
        Funcionario madruga = new Funcionario(
            "Madruga","123",800.0,meuEndereco
        );
        Funcionario florinda = new Funcionario(
            "Florinda","124",3000.0,meuEndereco
        );
        Dependente chiquinha = new Dependente(
            "Chiquinha", 18
        );
        Dependente godiles = new Dependente(
            "Godiles", 22
        );
        Dependente mariana = new Dependente(
            "Mariana", 21
        );
        Dependente jose = new Dependente(
            "jose", 12
        );
        Dependente tulio = new Dependente(
            "Tulio", 10
        );
        Projeto dac = new Projeto(
            "DAC"
        );
        Projeto pwi = new Projeto(
            "PWI"
        );
        Gerente gerente = new Gerente(
            "Jo","123"
        );
        Gerente segundoGerente = new Gerente(
            "Kiko","124"
        );
        Departamento uninfo = new Departamento(
            "UNINFO"
        );
        Departamento unind = new Departamento(
            "UNIND"
        );
        Projeto sd = new Projeto(
            "SD"
        );

        //bidirecional
        chaves.adicionar(dac);
        chaves.adicionar(sd);
        dac.adicinar(chaves);
        sd.adicinar(chaves);

        kiko.adicionar(dac);
        dac.adicinar(kiko);

        // bidirecional
        gerente.adicionar(sd);
        gerente.adicionar(dac);
        dac.setGerente(gerente);
        sd.setGerente(gerente);

        // bidirecional
        gerente.setDep(uninfo);
        uninfo.setGerente(gerente);

        madruga.adicionar(godiles);
        madruga.adicionar(chiquinha);
        chaves.adicionar(mariana);
//        chaves.adicionar(jose);
        madruga.adicionar(pwi);
        madruga.adicionar(dac);
        madruga.setDepartamento(uninfo);
        florinda.setDepartamento(uninfo);

        em.getTransaction().begin();
        em.persist(meuEndereco);
        em.persist(chiquinha);
        em.persist(mariana);
        em.persist(chaves);
        em.persist(dac);
        em.persist(pwi);
        em.persist(uninfo);
        em.persist(madruga);
        em.persist(florinda);
        em.persist(primeiro);
        em.persist(segundo);
        em.persist(chaves);
        em.persist(kiko);
        em.persist(dac);
        em.persist(sd);
        em.persist(uninfo);
        em.persist(unind);
        em.persist(gerente);
        em.persist(godiles);
        em.persist(jose);
        em.persist(tulio);
        em.persist(segundoGerente);

//        for (int i = 0; i < 1_000_000; i++) {
//            em.persist(
//                    new Dependente(String.valueOf(i))
//            );
//        }
        em.getTransaction().commit();
    }
}
