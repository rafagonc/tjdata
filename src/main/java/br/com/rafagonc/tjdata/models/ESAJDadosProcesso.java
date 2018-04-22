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

    private Long id;
    private transient ESAJProcesso processo;
    private String numero;
    private String classe;
    private String assunto;
    private String distribuicao;
    private String controle;
    private String juiz;
    private String relator;
    private String valor;
    private String area;
    private String origem;
    private String numerosDeOrigem;
    private String volumeApenso;
    private String incidente;
    private String processoPrincipal;

    public ESAJDadosProcesso(Element table) {
        this.numero = ESAJUtils.getTextoFromDado("Processo:", table);
        if (this.numero == null) {
            this.numero = ESAJUtils.getTextoFromDado("Incidente:", table).replaceAll("\\w","").replaceAll("(|)", "").replace(" ", "");
        }
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

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    @OneToOne
    public ESAJProcesso getProcesso() {
        return processo;
    }

    @Column(nullable = true, columnDefinition = "TEXT")
    public String getProcessoPrincipal() {
        return processoPrincipal;
    }

    @Column(nullable = true, columnDefinition = "TEXT")
    public String getIncidente() {
        return incidente;
    }

    @Column(nullable = true, columnDefinition = "TEXT")
    public String getNumero() {
        return numero;
    }

    @Column(nullable = true, columnDefinition = "TEXT")
    public String getClasse() {
        return classe;
    }

    @Column(nullable = true, columnDefinition = "TEXT")
    public String getAssunto() {
        return assunto;
    }

    @Column(nullable = true, columnDefinition = "TEXT")
    public String getDistribuicao() {
        return distribuicao;
    }

    @Column(nullable = true, columnDefinition = "TEXT")
    public String getControle() {
        return controle;
    }

    @Column(nullable = true, columnDefinition = "TEXT")
    public String getJuiz() {
        return juiz;
    }

    @Column(nullable = true, columnDefinition = "TEXT")
    public String getValor() {
        return valor;
    }

    public ESAJGrau grau() {
        String processoLimpo = ESAJUtils.normalize(this.numero.replaceAll("\\s", "")).replace("Julgado", "");
        return processoLimpo.substring(processoLimpo.length() - 4).equals("0000") ? ESAJGrau.Segundo : ESAJGrau.Primeiro;
    }

    @Column(nullable = true, columnDefinition = "TEXT")
    public String getRelator() {
        return relator;
    }

    @Column(nullable = true, columnDefinition = "TEXT")
    public String getArea() {
        return area;
    }

    @Column(nullable = true, columnDefinition = "TEXT")
    public String getOrigem() {
        return origem;
    }

    @Column(nullable = true, columnDefinition = "TEXT")
    public String getNumerosDeOrigem() {
        return numerosDeOrigem;
    }

    @Column(nullable = true, columnDefinition = "TEXT")
    public String getVolumeApenso() {
        return volumeApenso;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setProcesso(ESAJProcesso processo) {
        this.processo = processo;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public void setDistribuicao(String distribuicao) {
        this.distribuicao = distribuicao;
    }

    public void setControle(String controle) {
        this.controle = controle;
    }

    public void setJuiz(String juiz) {
        this.juiz = juiz;
    }

    public void setRelator(String relator) {
        this.relator = relator;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public void setNumerosDeOrigem(String numerosDeOrigem) {
        this.numerosDeOrigem = numerosDeOrigem;
    }

    public void setVolumeApenso(String volumeApenso) {
        this.volumeApenso = volumeApenso;
    }

    public void setIncidente(String incidente) {
        this.incidente = incidente;
    }

    public void setProcessoPrincipal(String processoPrincipal) {
        this.processoPrincipal = processoPrincipal;
    }


}
