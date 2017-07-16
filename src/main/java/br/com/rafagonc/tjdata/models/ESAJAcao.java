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

    @Id
    @GeneratedValue( strategy= GenerationType.AUTO )
    private Long id;

    @Column(nullable = true, columnDefinition = "TEXT")
    private String recebido;

    @Column(nullable = true, columnDefinition = "TEXT")
    private String classe;

    @Column(nullable = true, columnDefinition = "TEXT")
    private String link;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "processo_id")
    private ESAJProcesso processo;

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

    public Long getId() {
        return id;
    }

    public String getRecebido() {
        return recebido;
    }

    public String getClasse() {
        return classe;
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
