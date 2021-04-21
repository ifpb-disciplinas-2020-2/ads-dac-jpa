package br.edu.ifpb.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 12/04/2021, 08:43:46
 */
@Entity
public class Gerente implements Serializable {
    @Id
    @GeneratedValue
    private int id;
    private String nome;
    private String cpf;
    @Temporal(TemporalType.DATE)
    private Date inicio;
    @Temporal(TemporalType.DATE)
    private Date fim;

    // UM Gerente gerencia UM Departamento
    // 1 -> 1 bidirecional (possuídora)
    @OneToOne
   private  Departamento departamento;

//    UM Gerente coordena MUITOS Projetos
    // 1 -> N bidirecional (inverso)
    @OneToMany(mappedBy = "gerente")
    private List<Projeto> projetos = new ArrayList<>();

   public Gerente() {
   }

   public Gerente(String nome, String cpf) {
      this.nome = nome;
      this.cpf = cpf;
      this.inicio = new Date();
      this.fim = new Date();
   }
   public void novo(Projeto projeto){
//       projeto.setGerente(this);
       this.projetos.add(projeto);
   }

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

   public Date getInicio() {
      return inicio;
   }

   public void setInicio(Date inicio) {
      this.inicio = inicio;
   }

   public Date getFim() {
      return fim;
   }

   public void setFim(Date fim) {
      this.fim = fim;
   }

   public Departamento getDepartamento() {
      return departamento;
   }

   public void setDepartamento(Departamento departamento) {
      this.departamento = departamento;
   }

    public List<Projeto> getProjetos() {
        return projetos;
    }

    public void setProjetos(List<Projeto> projetos) {
        this.projetos = projetos;
    }
}
