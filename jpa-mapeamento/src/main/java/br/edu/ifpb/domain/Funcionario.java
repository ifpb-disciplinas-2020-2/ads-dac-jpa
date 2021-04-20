package br.edu.ifpb.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 12/04/2021, 08:41:45
 */
@Entity
public class Funcionario implements Serializable {

    @Id
    @GeneratedValue
    private int id;
    @Column(name = "nomeDoFuncionario")
    private String nome;
    private String cpf;
    // UM Funcionario possui UM Endereço
    @OneToOne // 1 -> 1 unidirecional
    private Endereco endereco;

    // UM Funcionario possui MUITOS Dependentes
    @OneToMany(fetch = FetchType.EAGER) // 1 -> N unidirecional
    @JoinColumn(name = "funcionario_id")
    private List<Dependente> dependentes = new ArrayList<>();

    // MUITOS Funcionarios fazem parte de UM Departamento
    @ManyToOne // N -> 1 unidirecional
    private Departamento departamento;

    // MUITOS Funcionarios trabalham em MUITOS Projetos
    @ManyToMany(mappedBy = "funcionarios") // N -> N bidirecional (inverso)
    private List<Projeto> projetos = new ArrayList<>();

    public Funcionario() {
    }
    public Funcionario(String nome, String cpf, Endereco endereco) {
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
    }
    public void novo(Dependente dependente){
        this.dependentes.add(dependente);
    }
    public void novo(Projeto projeto){this.projetos.add(projeto);}

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public Endereco getEndereco() {
        return endereco;
    }
    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
    public List<Dependente> getDependentes() {
        return Collections.unmodifiableList(
                dependentes
        );
    }
    public void setDependentes(List<Dependente> dependentes) {
        this.dependentes = dependentes;
    }
    public Departamento getDepartamento() {
        return departamento;
    }
    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }
}
