package br.com.rafagonc.tjdata.models;

import br.com.rafagonc.tjdata.utils.ESAJUtils;
import org.jsoup.nodes.Element;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by rafagonc on 15/06/17.
 */
@Entity
@Table(name = "partesProcesso")
public class ESAJPartesProcesso implements Serializable {

    private Long id;
    private String titulo;
    private String advogados;
    private ESAJProcesso processo;

    public ESAJPartesProcesso(Element tr) {
        this.advogados = ESAJUtils.getTextoWithIndex(tr,1);
        this.titulo = ESAJUtils.getTextoWithIndex(tr,0);
    }

    public ESAJPartesProcesso(String advogados, String titulo) {
        this.advogados = advogados;
        this.titulo = titulo;
    }

    public ESAJPartesProcesso() {
    }

    @Id
    @GeneratedValue( strategy= GenerationType.AUTO )
    public Long getId() {
        return id;
    }

    @Column(nullable = true, columnDefinition = "TEXT")
    public String getTitulo() {
        return titulo;
    }

    @Column(nullable = true, columnDefinition = "TEXT")
    public String getAdvogados() {
        return advogados;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "processo_id")
    public ESAJProcesso getProcesso() {
        return processo;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAdvogados(String advogados) {
        this.advogados = advogados;
    }

    public void setProcesso(ESAJProcesso processo) {
        this.processo = processo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ESAJPartesProcesso that = (ESAJPartesProcesso) o;

        if (titulo != null ? !titulo.equals(that.titulo) : that.titulo != null) return false;
        if (advogados != null ? !advogados.equals(that.advogados) : that.advogados != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = titulo != null ? titulo.hashCode() : 0;
        result = 31 * result + (advogados != null ? advogados.hashCode() : 0);
        return result;
    }
}
