package br.com.rafagonc.tjdata.models;

import javax.persistence.*;

/**
 * Created by rafagonc on 01/07/17.
 */
@Entity
public class ESAJDocumento {

    @Id
    @GeneratedValue( strategy= GenerationType.AUTO )
    private Long id;

    @Column(nullable = true, columnDefinition = "TEXT")
    private String nome;

    @Column(nullable = true, columnDefinition = "TEXT")
    private String link;

    @ManyToOne
    private ESAJMovimentacao movimentacao;

    public ESAJDocumento(String nome, String link) {
        this.nome = nome;
        this.link = link;
    }

    public ESAJDocumento() {
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getLink() {
        return link;
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
