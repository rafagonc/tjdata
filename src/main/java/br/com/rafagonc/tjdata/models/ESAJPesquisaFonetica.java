package br.com.rafagonc.tjdata.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by rafagonc on 13/08/17.
 */
@Entity
public class ESAJPesquisaFonetica {

    private Long id;
    private String nome;
    private Integer numeroGrau;
    private Set<ESAJPesquisaFoneticaProcesso> processos;

    public ESAJPesquisaFonetica(String nome, ESAJGrau grau) {
        if (grau.equals(ESAJGrau.Primeiro)) {
            this.numeroGrau = 1;
        } else if (grau.equals(ESAJGrau.Segundo)) {
            this.numeroGrau = 2;
        }
        this.nome = nome;
        this.processos = new HashSet<ESAJPesquisaFoneticaProcesso>();
    }

    public ESAJPesquisaFonetica() {
        this.numeroGrau = 1;
        this.processos = new HashSet<ESAJPesquisaFoneticaProcesso>();
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

    @Column(nullable = false)
    public Integer getNumeroGrau() {
        return numeroGrau;
    }

    public ESAJGrau grau() {
        if (numeroGrau == 1) {
            return ESAJGrau.Primeiro;
        } else {
            return ESAJGrau.Segundo;
        }
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
