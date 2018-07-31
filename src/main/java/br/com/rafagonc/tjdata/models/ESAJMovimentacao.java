package br.com.rafagonc.tjdata.models;

import br.com.rafagonc.tjdata.utils.ESAJUtils;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by rafagonc on 15/06/17.
 */
@Entity
public class ESAJMovimentacao implements Comparable {

    private Long id;
    private String texto;
    private String acao;
    private String data;
    private transient ESAJProcesso processo;
    private Set<ESAJDocumento> documentos;
    private Integer ord;


    public ESAJMovimentacao(Element tr, String endpoint, String completeURL) {
        Elements linkElements = tr.getElementsByTag("a");
        HashSet<ESAJDocumento> docs = new HashSet<ESAJDocumento>();
        for (Element el : linkElements) {
            if (el.ownText().length() > 0) {
                ESAJDocumento doc = new ESAJDocumento(el.ownText(),endpoint + el.attr("href"), el.attr("href").contains("Senha"));
                doc.setButtonId(el.id());
                docs.add(doc);
            }
        }
        String texto = ESAJUtils.getTextoWithIndexAndNotNormalize(tr, 2);
        String[] components = texto.split("<br>");
        if (components.length == 1) {
            this.texto = ESAJUtils.normalize(components[0]);
        } else {
            this.texto = ESAJUtils.normalize(components[0]);
            this.acao = ESAJUtils.normalize(components[1]);
        }
        this.data = ESAJUtils.getTextoWithIndex(tr, 0);
        this.documentos = docs;
    }

    public ESAJMovimentacao(String texto, String data) {
        this.texto = texto;
        this.data = data;
    }

    public ESAJMovimentacao(String texto, String acao, String data) {
        this.texto = texto;
        this.acao = acao;
        this.data = data;
    }

    public ESAJMovimentacao(String texto, String acao, String data, Set<ESAJDocumento> documentos) {
        this.texto = texto;
        this.acao = acao;
        this.data = data;
        this.documentos = documentos;
    }


    public ESAJMovimentacao() {
    }

    @Id
    @GeneratedValue( strategy= GenerationType.AUTO )
    public Long getId() {
        return id;
    }

    @Column(nullable = true, columnDefinition = "TEXT")
    public String getTexto() {
        return texto;
    }

    @Column(nullable = true)
    public Integer getord() {
        return ord;
    }

    public void setord(Integer ord) {
        this.ord = ord;
    }

    @Column(nullable = true, columnDefinition = "TEXT")
    public String getAcao() {
        return acao;
    }

    @Column(nullable = true, columnDefinition = "TEXT")
    public String getData() {
        return data;
    }

    @OneToMany(mappedBy = "movimentacao", cascade = CascadeType.ALL)
    public Set<ESAJDocumento> getDocumentos() {
        return documentos;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    public ESAJProcesso getProcesso() {
        return processo;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public void setAcao(String acao) {
        this.acao = acao;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setProcesso(ESAJProcesso processo) {
        this.processo = processo;
    }

    public void setDocumentos(Set<ESAJDocumento> documentos) {
        this.documentos = documentos;
    }

    @Override
    public int compareTo(Object o) {
        ESAJMovimentacao movimentacao = (ESAJMovimentacao)o;
        try {
            Date movDate = ESAJUtils.BR_parseDDMMYYYYDateString(movimentacao.data);
            Date thisDate = ESAJUtils.BR_parseDDMMYYYYDateString(this.data);
            return thisDate.compareTo(movDate);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

}
