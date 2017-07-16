package br.com.rafagonc.tjdata.models;

import br.com.rafagonc.tjdata.utils.ESAJUtils;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;

/**
 * Created by rafagonc on 15/06/17.
 */
@Entity
public class ESAJMovimentacao {

    private Long id;
    private String texto;
    private String acao;
    private String data;
    private transient ESAJProcesso processo;
    private List<ESAJDocumento> documentos;

    public ESAJMovimentacao(Element tr) {
        Elements linkElements = tr.getElementsByTag("a");
        HashSet<ESAJDocumento> docs = new HashSet<ESAJDocumento>();
        for (Element el : linkElements) {
            if (el.ownText().length() > 0) {
                docs.add(new ESAJDocumento(el.ownText(),el.attr("href")));
            }
        }
        this.texto = ESAJUtils.getTextoWithIndex(tr, 2);
        this.data = ESAJUtils.getTextoWithIndex(tr, 0);
        this.acao = ESAJUtils.getTextoWithIndex(tr, 1);
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

    public ESAJMovimentacao(String texto, String acao, String data, List<ESAJDocumento> documentos) {
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

    @Column(nullable = true, columnDefinition = "TEXT")
    public String getAcao() {
        return acao;
    }

    @Column(nullable = true, columnDefinition = "TEXT")
    public String getData() {
        return data;
    }

    @OneToMany(targetEntity = ESAJDocumento.class, cascade = CascadeType.REMOVE)
    @JoinColumn(name="documento_id")
    public List<ESAJDocumento> getDocumentos() {
        return documentos;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "processo_id")
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

    public void setDocumentos(List<ESAJDocumento> documentos) {
        this.documentos = documentos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ESAJMovimentacao that = (ESAJMovimentacao) o;

        if (texto != null ? !texto.equals(that.texto) : that.texto != null) return false;
        if (acao != null ? !acao.equals(that.acao) : that.acao != null) return false;
        return data != null ? data.equals(that.data) : that.data == null;

    }

    @Override
    public int hashCode() {
        int result = texto != null ? texto.hashCode() : 0;
        result = 31 * result + (acao != null ? acao.hashCode() : 0);
        result = 31 * result + (data != null ? data.hashCode() : 0);
        return result;
    }
}
