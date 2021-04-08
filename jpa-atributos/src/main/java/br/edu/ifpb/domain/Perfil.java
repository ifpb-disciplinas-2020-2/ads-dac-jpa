package br.edu.ifpb.domain;

import br.edu.ifpb.infra.io.ImageFromFile;

import java.io.Serializable;
import javax.persistence.*;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 05/04/2021, 10:29:17
 */
@Entity
@SequenceGenerator(
    name = "generator_seq",
    sequenceName = "seq_name",
    initialValue = 25,
    allocationSize = 1
)
public class Perfil implements Serializable {

    @Id
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "generator_seq"
    )
    private int id;
    private String nomeUsuario;
    @Basic(fetch = FetchType.LAZY)
    @Lob
    private String descricao; // C-LOB
    @Basic(fetch = FetchType.EAGER)
    @Lob
    private byte[] foto; // B-LOB
    @Transient
    private ImageFromFile image;

    public Perfil() {
    }
    public Perfil(String nomeUsuario, String path) {
        this.nomeUsuario = nomeUsuario;
        this.image =  new ImageFromFile(path);
        this.foto = image.toBytes();
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }
    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public byte[] getFoto() {
        return foto;
    }
    public void setFoto(byte[] foto) {
        this.foto = foto;
    }
}
