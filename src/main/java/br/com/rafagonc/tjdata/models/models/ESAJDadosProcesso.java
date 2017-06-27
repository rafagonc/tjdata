package br.com.rafagonc.tjdata.models.models;

import br.com.rafagonc.tjdata.models.models.utils.ESAJUtils;
import org.jsoup.nodes.Element;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by rafagonc on 15/06/17.
 */
@Entity
public class ESAJDadosProcesso implements Serializable {

    @Id
    @GeneratedValue( strategy= GenerationType.AUTO )
    private Long id;

    @Column(nullable = true)
    private String processo;

    @Column(nullable = true)
    private String classe;

    @Column(nullable = true)
    private String assunto;

    @Column(nullable = true)
    private String distribuicao;
    private String controle;

    @Column(nullable = true)
    private String juiz;

    @Column(nullable = true)
    private String relator;

    @Column(nullable = true)
    private String valor;

    @Column(nullable = true)
    private String area;

    @Column(nullable = true)
    private String origem;

    @Column(nullable = true)
    private String numerosDeOrigem;

    @Column(nullable = true)
    private String volumeApenso;

    public ESAJDadosProcesso(Element table) {
        this.processo = ESAJUtils.getTextoFromDado("Processo:",table);
        this.classe = ESAJUtils.getTextoFromDado("Classe:",table);
        this.area = ESAJUtils.getTextoFromDado("Área",table);
        this.assunto = ESAJUtils.getTextoFromDado("Assunto:",table);
        this.origem = ESAJUtils.getTextoFromDado("Origem:",table);
        this.numerosDeOrigem = ESAJUtils.getTextoFromDado("Números de origem:",table);
        this.juiz = ESAJUtils.getTextoFromDado("Juiz:",table);
        this.relator = ESAJUtils.getTextoFromDado("Relator:",table);
        this.volumeApenso = ESAJUtils.getTextoFromDado("Volume / Apenso:",table);
        this.distribuicao = ESAJUtils.getTextoFromDado("Distribuição:",table);
        this.controle = ESAJUtils.getTextoFromDado("Controle:",table);
        this.valor = ESAJUtils.getTextoFromDado("Valor da ação:",table);
    }

    public ESAJDadosProcesso() {
    }

    public String getProcesso() {
        return processo;
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
        String processoLimpo = ESAJUtils.normalize(this.processo.replaceAll("\\s","")).replace("Julgado","");
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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ESAJDadosProcesso that = (ESAJDadosProcesso) o;

        if (processo != null ? !processo.equals(that.processo) : that.processo != null) return false;
        if (classe != null ? !classe.equals(that.classe) : that.classe != null) return false;
        if (assunto != null ? !assunto.equals(that.assunto) : that.assunto != null) return false;
        if (distribuicao != null ? !distribuicao.equals(that.distribuicao) : that.distribuicao != null) return false;
        if (controle != null ? !controle.equals(that.controle) : that.controle != null) return false;
        if (juiz != null ? !juiz.equals(that.juiz) : that.juiz != null) return false;
        if (relator != null ? !relator.equals(that.relator) : that.relator != null) return false;
        if (valor != null ? !valor.equals(that.valor) : that.valor != null) return false;
        if (area != null ? !area.equals(that.area) : that.area != null) return false;
        if (origem != null ? !origem.equals(that.origem) : that.origem != null) return false;
        if (numerosDeOrigem != null ? !numerosDeOrigem.equals(that.numerosDeOrigem) : that.numerosDeOrigem != null)
            return false;
        return volumeApenso != null ? volumeApenso.equals(that.volumeApenso) : that.volumeApenso == null;

    }

    @Override
    public int hashCode() {
        int result = processo != null ? processo.hashCode() : 0;
        result = 31 * result + (classe != null ? classe.hashCode() : 0);
        result = 31 * result + (assunto != null ? assunto.hashCode() : 0);
        result = 31 * result + (distribuicao != null ? distribuicao.hashCode() : 0);
        result = 31 * result + (controle != null ? controle.hashCode() : 0);
        result = 31 * result + (juiz != null ? juiz.hashCode() : 0);
        result = 31 * result + (relator != null ? relator.hashCode() : 0);
        result = 31 * result + (valor != null ? valor.hashCode() : 0);
        result = 31 * result + (area != null ? area.hashCode() : 0);
        result = 31 * result + (origem != null ? origem.hashCode() : 0);
        result = 31 * result + (numerosDeOrigem != null ? numerosDeOrigem.hashCode() : 0);
        result = 31 * result + (volumeApenso != null ? volumeApenso.hashCode() : 0);
        return result;
    }
}
