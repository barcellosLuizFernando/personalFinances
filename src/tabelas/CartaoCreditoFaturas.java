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
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "cartao_credito_faturas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CartaoCreditoFaturas.findAll", query = "SELECT c FROM CartaoCreditoFaturas c")
    , @NamedQuery(name = "CartaoCreditoFaturas.findById", query = "SELECT c FROM CartaoCreditoFaturas c WHERE c.id = :id")
    , @NamedQuery(name = "CartaoCreditoFaturas.findByCompetencia", query = "SELECT c FROM CartaoCreditoFaturas c WHERE c.competencia = :competencia")
    , @NamedQuery(name = "CartaoCreditoFaturas.findByCreatedAt", query = "SELECT c FROM CartaoCreditoFaturas c WHERE c.createdAt = :createdAt")})
public class CartaoCreditoFaturas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "competencia")
    @Temporal(TemporalType.DATE)
    private Date competencia;
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idFatura")
    private Collection<LancamentosCartaoCredito> lancamentosCartaoCreditoCollection;
    @JoinColumn(name = "id_cartao", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private CartaoCredito idCartao;

    public CartaoCreditoFaturas() {
    }

    public CartaoCreditoFaturas(Integer id) {
        this.id = id;
    }

    public CartaoCreditoFaturas(Integer id, Date competencia) {
        this.id = id;
        this.competencia = competencia;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCompetencia() {
        return competencia;
    }

    public void setCompetencia(Date competencia) {
        this.competencia = competencia;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    @XmlTransient
    public Collection<LancamentosCartaoCredito> getLancamentosCartaoCreditoCollection() {
        return lancamentosCartaoCreditoCollection;
    }

    public void setLancamentosCartaoCreditoCollection(Collection<LancamentosCartaoCredito> lancamentosCartaoCreditoCollection) {
        this.lancamentosCartaoCreditoCollection = lancamentosCartaoCreditoCollection;
    }

    public CartaoCredito getIdCartao() {
        return idCartao;
    }

    public void setIdCartao(CartaoCredito idCartao) {
        this.idCartao = idCartao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CartaoCreditoFaturas)) {
            return false;
        }
        CartaoCreditoFaturas other = (CartaoCreditoFaturas) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tabelas.CartaoCreditoFaturas[ id=" + id + " ]";
    }
    
}
