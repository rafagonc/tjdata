package br.com.rafagonc.tjdata.models;

import br.com.rafagonc.tjdata.utils.ESAJUtils;
import org.jsoup.nodes.Element;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by rafagonc on 15/06/17.
 */
@Entity
public class ESAJPeticaoDiversa implements Comparable {

    private Long id;
    private String data;
    private String tipo;
    private Integer ord;

    private transient ESAJProcesso processo;

    public ESAJPeticaoDiversa(Element tr) {
        this.data = ESAJUtils.normalize(tr.child(0).toString());
        this.tipo = ESAJUtils.normalize(tr.child(1).toString());
    }

    public ESAJPeticaoDiversa(String data, String tipo) {
        this.data = data;
        this.tipo = tipo;
    }

    public ESAJPeticaoDiversa() {
    }

    @Id
    @GeneratedValue( strategy= GenerationType.AUTO )
    public Long getId() {
        return id;
    }

    @Column(nullable = true)
    public Integer getord() {
        return ord;
    }

    @Column(nullable = true, columnDefinition = "TEXT")
    public String getData() {
        return data;
    }

    @Column(nullable = true, columnDefinition = "TEXT")
    public String getTipo() {
        return tipo;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    public ESAJProcesso getProcesso() {
        return processo;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setord(Integer ord) {
        this.ord = ord;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setProcesso(ESAJProcesso processo) {
        this.processo = processo;
    }

    @Override
    public int compareTo(Object o) {
        ESAJPeticaoDiversa peticaoDiversa = (ESAJPeticaoDiversa)o;
        try {
            Date movDate = ESAJUtils.BR_parseDDMMYYYYDateString(peticaoDiversa.data);
            Date thisDate = ESAJUtils.BR_parseDDMMYYYYDateString(this.data);
            return thisDate.compareTo(movDate);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

}
