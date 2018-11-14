package br.com.rafagonc.tjdata.models;

import br.com.rafagonc.tjdata.utils.ESAJUtils;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.select.Elements;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by rafagonc on 15/06/17.
 */
@Entity
public class ESAJPartesProcesso implements Serializable {

    private Long id;
    private String titulo;
    private String nome;
    private Integer ord;
    private String tituloAdvogados;
    private String advogados;
    private transient ESAJProcesso processo;


    public ESAJPartesProcesso(Element tr) {
        Element values = tr.child(1);
        this.nome = ESAJUtils.normalize(values.textNodes().get(0).text());
        Elements exibindos = values.getElementsByClass("mensagemExibindo");
        StringBuilder advs = new StringBuilder();
        for (Element e : exibindos) {
            Node node = e.nextSibling();
            advs.append(ESAJUtils.normalize(node.toString().replace("&nbsp;", "")));
        }
        this.advogados = ESAJUtils.normalize(advs.toString());
        this.tituloAdvogados = "Advogados:";
        this.titulo = ESAJUtils.getTextoWithIndex(tr,0);
    }

    public ESAJPartesProcesso(String advogados, String titulo) {
        this.advogados = advogados;
        this.titulo = titulo;
    }

    public ESAJPartesProcesso() {
    }

    public Integer getOrd() {
        return ord;
    }

    public void setOrd(Integer ord) {
        this.ord = ord;
    }

    @Id
    @GeneratedValue( strategy= GenerationType.AUTO )
    public Long getId() {
        return id;
    }

    @Column(nullable = true, columnDefinition = "TEXT")
    public String getTituloAdvogados() {
        return tituloAdvogados;
    }

    public void setTituloAdvogados(String tituloAdvogados) {
        this.tituloAdvogados = tituloAdvogados;
    }

    @Column(nullable = true, columnDefinition = "TEXT")
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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


}
