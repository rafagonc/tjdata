package br.com.rafagonc.tjdata.models;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by rafagonc on 13/08/17.
 */
@Entity
public class ESAJPesquisaFonetica {

    private Long id;
    private String nome;
    private Set<ESAJPesquisaFoneticaProcesso> processos;

    public ESAJPesquisaFonetica() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    @Column(unique = true, nullable = false)
    public String getNome() {
        return nome;
    }

    @OneToMany(targetEntity = ESAJDocumento.class, cascade = CascadeType.REMOVE)
    @JoinColumn(name="pesquisa_fonetica_processo_id")
    public Set<ESAJPesquisaFoneticaProcesso> getProcessos() {
        return processos;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setProcessos(Set<ESAJPesquisaFoneticaProcesso> processos) {
        if (processos != null) {
            for (ESAJPesquisaFoneticaProcesso processo : processos) {
                processo.setPesquisaFonetica(this);
            }
        }
        this.processos = processos;
    }
}
