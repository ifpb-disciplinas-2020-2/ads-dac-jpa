package br.edu.ifpb.infra;

import br.edu.ifpb.domain.Cliente;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Stateless
public class Clientes {

    @PersistenceContext(unitName = "ExemploPostgres")
    private EntityManager em;

    public void novo(Cliente cliente) {
        em.persist(cliente);
    }

    public List<Cliente> todos() {
        return em.createQuery(
            "SELECT c FROM Cliente c",Cliente.class //jpql
        ).getResultList();
    }
}
