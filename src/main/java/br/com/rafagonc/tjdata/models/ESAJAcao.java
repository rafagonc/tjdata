package br.com.rafagonc.tjdata.models;

import br.com.rafagonc.tjdata.utils.ESAJUtils;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by rafagonc on 01/07/17.
 */
@Entity
public class ESAJAcao implements Comparable {

    private Long id;
    private String recebido;
    private String classe;
    @Transient
    private Integer ord;
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

    public void setord(Integer ord) {
        this.ord = ord;
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

    public Integer getOrd() {
        return ord;
    }

    public void setOrd(Integer ord) {
        this.ord = ord;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    public ESAJProcesso getProcesso() {
        return processo;
    }

    @Override
    public int compareTo(Object o) {
        ESAJAcao acao = (ESAJAcao)o;
        try {
            Date movDate = ESAJUtils.BR_parseDDMMYYYYDateString(acao.recebido);
            Date thisDate = ESAJUtils.BR_parseDDMMYYYYDateString(this.recebido);
            return thisDate.compareTo(movDate);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}
