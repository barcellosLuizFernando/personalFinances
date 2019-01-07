/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tabelas;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ferna
 */
@Entity
@Table(name = "lancamentos_provisao_vencimentos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LancamentosProvisaoVencimentos.findAll", query = "SELECT l FROM LancamentosProvisaoVencimentos l")
    , @NamedQuery(name = "LancamentosProvisaoVencimentos.findById", query = "SELECT l FROM LancamentosProvisaoVencimentos l WHERE l.lancamentosProvisaoVencimentosPK.id = :id")
    , @NamedQuery(name = "LancamentosProvisaoVencimentos.findByIdProvisao", query = "SELECT l FROM LancamentosProvisaoVencimentos l WHERE l.lancamentosProvisaoVencimentosPK.idProvisao = :idProvisao")
    , @NamedQuery(name = "LancamentosProvisaoVencimentos.findByDate", query = "SELECT l FROM LancamentosProvisaoVencimentos l WHERE l.date = :date")
    , @NamedQuery(name = "LancamentosProvisaoVencimentos.findByValue", query = "SELECT l FROM LancamentosProvisaoVencimentos l WHERE l.value = :value")})
public class LancamentosProvisaoVencimentos implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected LancamentosProvisaoVencimentosPK lancamentosProvisaoVencimentosPK;
    @Basic(optional = false)
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Basic(optional = false)
    @Column(name = "value")
    private double value;
    @OneToMany(mappedBy = "idProvisao")
    private Collection<LancamentosCartaoCredito> lancamentosCartaoCreditoCollection;
    @JoinColumn(name = "id_provisao", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private LancamentosProvisao lancamentosProvisao;
    @OneToMany(mappedBy = "idProvisao")
    private Collection<Lancamentos> lancamentosCollection;

    public LancamentosProvisaoVencimentos() {
    }

    public LancamentosProvisaoVencimentos(LancamentosProvisaoVencimentosPK lancamentosProvisaoVencimentosPK) {
        this.lancamentosProvisaoVencimentosPK = lancamentosProvisaoVencimentosPK;
    }

    public LancamentosProvisaoVencimentos(LancamentosProvisaoVencimentosPK lancamentosProvisaoVencimentosPK, Date date, double value) {
        this.lancamentosProvisaoVencimentosPK = lancamentosProvisaoVencimentosPK;
        this.date = date;
        this.value = value;
    }

    public LancamentosProvisaoVencimentos(int id, int idProvisao) {
        this.lancamentosProvisaoVencimentosPK = new LancamentosProvisaoVencimentosPK(id, idProvisao);
    }

    public LancamentosProvisaoVencimentosPK getLancamentosProvisaoVencimentosPK() {
        return lancamentosProvisaoVencimentosPK;
    }

    public void setLancamentosProvisaoVencimentosPK(LancamentosProvisaoVencimentosPK lancamentosProvisaoVencimentosPK) {
        this.lancamentosProvisaoVencimentosPK = lancamentosProvisaoVencimentosPK;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    @XmlTransient
    public Collection<LancamentosCartaoCredito> getLancamentosCartaoCreditoCollection() {
        return lancamentosCartaoCreditoCollection;
    }

    public void setLancamentosCartaoCreditoCollection(Collection<LancamentosCartaoCredito> lancamentosCartaoCreditoCollection) {
        this.lancamentosCartaoCreditoCollection = lancamentosCartaoCreditoCollection;
    }

    public LancamentosProvisao getLancamentosProvisao() {
        return lancamentosProvisao;
    }

    public void setLancamentosProvisao(LancamentosProvisao lancamentosProvisao) {
        this.lancamentosProvisao = lancamentosProvisao;
    }

    @XmlTransient
    public Collection<Lancamentos> getLancamentosCollection() {
        return lancamentosCollection;
    }

    public void setLancamentosCollection(Collection<Lancamentos> lancamentosCollection) {
        this.lancamentosCollection = lancamentosCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (lancamentosProvisaoVencimentosPK != null ? lancamentosProvisaoVencimentosPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LancamentosProvisaoVencimentos)) {
            return false;
        }
        LancamentosProvisaoVencimentos other = (LancamentosProvisaoVencimentos) object;
        if ((this.lancamentosProvisaoVencimentosPK == null && other.lancamentosProvisaoVencimentosPK != null) || (this.lancamentosProvisaoVencimentosPK != null && !this.lancamentosProvisaoVencimentosPK.equals(other.lancamentosProvisaoVencimentosPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tabelas.LancamentosProvisaoVencimentos[ lancamentosProvisaoVencimentosPK=" + lancamentosProvisaoVencimentosPK + " ]";
    }
    
}
