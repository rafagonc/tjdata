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
    private Integer numeroForo;
    private Integer numeroGrau;
    private String estado;
    private Boolean processando;
    private Boolean encontrado;
    private Set<ESAJPesquisaFoneticaProcesso> processos;
    private String erro;

    public ESAJPesquisaFonetica(String nome, ESAJGrau grau) {
        this.numeroGrau = grau.getValue();
        this.nome = nome;
        this.numeroForo = -1;
        this.processos = new HashSet<ESAJPesquisaFoneticaProcesso>();
    }

    public ESAJPesquisaFonetica(String nome, Integer numeroForo, ESAJGrau grau) {
        this.nome = nome;
        this.numeroGrau = grau.getValue();
        this.processando = true;
        this.numeroForo = numeroForo;
    }

    public ESAJPesquisaFonetica() {
        this.numeroGrau = 1;
        this.numeroForo = -1;
        this.processando = true;
        this.processos = new HashSet<ESAJPesquisaFoneticaProcesso>();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    @Column(nullable = false)
    public String getNome() {
        return nome;
    }

    @Column(nullable = false)
    public String getEstado() {
        return estado;
    }

    @Column(nullable = false)
    public Boolean getProcessando() {
        return processando;
    }

    @OneToMany(mappedBy = "pesquisaFonetica", cascade = CascadeType.REMOVE)
    public Set<ESAJPesquisaFoneticaProcesso> getProcessos() {
        return processos;
    }

    @Column(nullable = false)
    public Integer getNumeroGrau() {
        return numeroGrau;
    }

    @Column(nullable = true)
    public Boolean getEncontrado() {
        return encontrado;
    }

    public void setEncontrado(Boolean encontrado) {
        this.encontrado = encontrado;
    }

    @Column(nullable = true)
    public String getErro() {
        return erro;
    }

    public void setErro(String erro) {
        this.erro = erro;
    }

    @Column(nullable = false)
    public Integer getNumeroForo() {
        return numeroForo;
    }

    public ESAJGrau grau() {
        return ESAJGrau.grauForValue(this.numeroGrau);
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setProcessando(Boolean processando) {
        this.processando = processando;
    }

    public void setProcessos(Set<ESAJPesquisaFoneticaProcesso> processos) {
        if (processos != null) {
            for (ESAJPesquisaFoneticaProcesso processo : processos) {
                processo.setPesquisaFonetica(this);
            }
        }
        this.processos = processos;
    }

    public void setNumeroForo(Integer numeroForo) {
        this.numeroForo = numeroForo;
    }

    public void setNumeroGrau(Integer numeroGrau) {
        this.numeroGrau = numeroGrau;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ESAJPesquisaFonetica that = (ESAJPesquisaFonetica) o;

        if (nome != null ? !nome.equals(that.nome) : that.nome != null) return false;
        if (numeroForo != null ? !numeroForo.equals(that.numeroForo) : that.numeroForo != null) return false;
        if (numeroGrau != null ? !numeroGrau.equals(that.numeroGrau) : that.numeroGrau != null) return false;
        return processos != null ? processos.equals(that.processos) : that.processos == null;

    }

    @Override
    public int hashCode() {
        int result = nome != null ? nome.hashCode() : 0;
        result = 31 * result + (numeroForo != null ? numeroForo.hashCode() : 0);
        result = 31 * result + (numeroGrau != null ? numeroGrau.hashCode() : 0);
        result = 31 * result + (processos != null ? processos.hashCode() : 0);
        return result;
    }
}
