package br.com.rafagonc.tjdata.models;

import javax.persistence.*;

/**
 * Created by rafagonc on 01/07/17.
 */
@Entity
public class ESAJDocumento {

    private Long id;
    private String nome;
    private String link;
    private transient ESAJMovimentacao movimentacao;

    public ESAJDocumento(String nome, String link) {
        this.nome = nome;
        this.link = link;
    }

    public ESAJDocumento() {
    }

    @Id
    @GeneratedValue( strategy= GenerationType.AUTO )
    public Long getId() {
        return id;
    }

    @Column(nullable = true, columnDefinition = "TEXT")
    public String getNome() {
        return nome;
    }

    @Column(nullable = true, columnDefinition = "TEXT")
    public String getLink() {
        return link;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "movimentacao_id")
    public ESAJMovimentacao getMovimentacao() {
        return movimentacao;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public void setMovimentacao(ESAJMovimentacao movimentacao) {
        this.movimentacao = movimentacao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ESAJDocumento that = (ESAJDocumento) o;

        return link != null ? link.equals(that.link) : that.link == null;

    }

    @Override
    public int hashCode() {
        return link.hashCode();
    }

}
