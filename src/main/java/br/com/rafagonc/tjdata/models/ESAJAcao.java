package br.com.rafagonc.tjdata.models;

import br.com.rafagonc.tjdata.utils.ESAJUtils;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javax.persistence.*;

/**
 * Created by rafagonc on 01/07/17.
 */
@Entity
public class ESAJAcao {

    private Long id;
    private String recebido;
    private String classe;
    private String link;
    private transient ESAJProcesso processo;

    public ESAJAcao(Element tr) {
        Elements linkElements = tr.getElementsByTag("a");
        for (Element el : linkElements) {
            if (el.ownText().length() > 0) {
                this.classe = el.ownText();
                this.link = el.attr("href");
            }
        }
        this.recebido = ESAJUtils.normalize(tr.child(0).toString());
    }

    public ESAJAcao(String recebido, String classe) {
        this.recebido = recebido;
        this.classe = classe;
    }

    public ESAJAcao(String recebido, String classe, String link) {
        this.recebido = recebido;
        this.classe = classe;
        this.link = link;
    }

    public ESAJAcao() {
    }

    @Id
    @GeneratedValue( strategy= GenerationType.AUTO )
    public Long getId() {
        return id;
    }

    @Column(nullable = true, columnDefinition = "TEXT")
    public String getRecebido() {
        return recebido;
    }

    @Column(nullable = true, columnDefinition = "TEXT")
    public String getClasse() {
        return classe;
    }

    @Column(nullable = true, columnDefinition = "TEXT")
    public String getLink() {
        return link;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setRecebido(String recebido) {
        this.recebido = recebido;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public void setProcesso(ESAJProcesso processo) {
        this.processo = processo;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "processo_id")
    public ESAJProcesso getProcesso() {
        return processo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ESAJAcao esajAcao = (ESAJAcao) o;

        if (recebido != null ? !recebido.equals(esajAcao.recebido) : esajAcao.recebido != null) return false;
        return classe != null ? classe.equals(esajAcao.classe) : esajAcao.classe == null;

    }

    @Override
    public int hashCode() {
        int result = recebido != null ? recebido.hashCode() : 0;
        result = 31 * result + (classe != null ? classe.hashCode() : 0);
        return result;
    }
}
