package br.com.rafagonc.tjdata.models;

import br.com.rafagonc.tjdata.utils.ESAJUtils;
import org.jsoup.nodes.Element;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by rafagonc on 15/06/17.
 */
@Entity
public class ESAJDadosProcesso implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private ESAJProcesso processo;

    @Column(nullable = true, columnDefinition = "TEXT")
    private String numero;

    @Column(nullable = true, columnDefinition = "TEXT")
    private String classe;

    @Column(nullable = true, columnDefinition = "TEXT")
    private String assunto;

    @Column(nullable = true, columnDefinition = "TEXT")
    private String distribuicao;

    @Column(nullable = true, columnDefinition = "TEXT")
    private String controle;

    @Column(nullable = true, columnDefinition = "TEXT")
    private String juiz;

    @Column(nullable = true, columnDefinition = "TEXT")
    private String relator;

    @Column(nullable = true, columnDefinition = "TEXT")
    private String valor;

    @Column(nullable = true, columnDefinition = "TEXT")
    private String area;

    @Column(nullable = true, columnDefinition = "TEXT")
    private String origem;

    @Column(nullable = true, columnDefinition = "TEXT")
    private String numerosDeOrigem;

    @Column(nullable = true, columnDefinition = "TEXT")
    private String volumeApenso;

    @Column(nullable = true, columnDefinition = "TEXT")
    private String incidente;

    @Column(nullable = true, columnDefinition = "TEXT")
    private String processoPrincipal;

    public ESAJDadosProcesso(Element table) {
        this.numero = ESAJUtils.getTextoFromDado("Processo:", table);
        this.classe = ESAJUtils.getTextoFromDado("Classe:", table);
        this.area = ESAJUtils.getTextoFromDado("Área", table);
        this.assunto = ESAJUtils.getTextoFromDado("Assunto:", table);
        this.origem = ESAJUtils.getTextoFromDado("Origem:", table);
        this.numerosDeOrigem = ESAJUtils.getTextoFromDado("Números de origem:", table);
        this.juiz = ESAJUtils.getTextoFromDado("Juiz:", table);
        this.relator = ESAJUtils.getTextoFromDado("Relator:", table);
        this.volumeApenso = ESAJUtils.getTextoFromDado("Volume / Apenso:", table);
        this.distribuicao = ESAJUtils.getTextoFromDado("Distribuição:", table);
        this.controle = ESAJUtils.getTextoFromDado("Controle:", table);
        this.valor = ESAJUtils.getTextoFromDado("Valor da ação:", table);
        this.incidente = ESAJUtils.getTextoFromDado("Incidente:", table);
        this.processoPrincipal = ESAJUtils.getTextoFromDado("Processo principal:", table);
    }

    public ESAJDadosProcesso() {
    }

    public Long getId() {
        return id;
    }

    public ESAJProcesso getProcesso() {
        return processo;
    }

    public String getProcessoPrincipal() {
        return processoPrincipal;
    }

    public String getIncidente() {
        return incidente;
    }

    public String getNumero() {
        return numero;
    }

    public String getClasse() {
        return classe;
    }

    public String getAssunto() {
        return assunto;
    }

    public String getDistribuicao() {
        return distribuicao;
    }

    public String getControle() {
        return controle;
    }

    public String getJuiz() {
        return juiz;
    }

    public String getValor() {
        return valor;
    }

    public ESAJGrau getGrau() {
        String processoLimpo = ESAJUtils.normalize(this.numero.replaceAll("\\s", "")).replace("Julgado", "");
        return processoLimpo.substring(processoLimpo.length() - 4).equals("0000") ? ESAJGrau.Segundo : ESAJGrau.Primeiro;
    }

    public String getRelator() {
        return relator;
    }

    public String getArea() {
        return area;
    }

    public String getOrigem() {
        return origem;
    }

    public String getNumerosDeOrigem() {
        return numerosDeOrigem;
    }

    public String getVolumeApenso() {
        return volumeApenso;
    }


}
