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
@Table(name = "cartao_credito_bandeiras")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CartaoCreditoBandeiras.findAll", query = "SELECT c FROM CartaoCreditoBandeiras c")
    , @NamedQuery(name = "CartaoCreditoBandeiras.findById", query = "SELECT c FROM CartaoCreditoBandeiras c WHERE c.id = :id")
    , @NamedQuery(name = "CartaoCreditoBandeiras.findByTitle", query = "SELECT c FROM CartaoCreditoBandeiras c WHERE c.title = :title")
    , @NamedQuery(name = "CartaoCreditoBandeiras.findByCreatedAt", query = "SELECT c FROM CartaoCreditoBandeiras c WHERE c.createdAt = :createdAt")
    , @NamedQuery(name = "CartaoCreditoBandeiras.findByUpdatedAt", query = "SELECT c FROM CartaoCreditoBandeiras c WHERE c.updatedAt = :updatedAt")})
public class CartaoCreditoBandeiras implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "title")
    private String title;
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idBandeira")
    private Collection<CartaoCredito> cartaoCreditoCollection;

    public CartaoCreditoBandeiras() {
    }

    public CartaoCreditoBandeiras(Integer id) {
        this.id = id;
    }

    public CartaoCreditoBandeiras(Integer id, String title) {
        this.id = id;
        this.title = title;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    @XmlTransient
    public Collection<CartaoCredito> getCartaoCreditoCollection() {
        return cartaoCreditoCollection;
    }

    public void setCartaoCreditoCollection(Collection<CartaoCredito> cartaoCreditoCollection) {
        this.cartaoCreditoCollection = cartaoCreditoCollection;
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
        if (!(object instanceof CartaoCreditoBandeiras)) {
            return false;
        }
        CartaoCreditoBandeiras other = (CartaoCreditoBandeiras) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tabelas.CartaoCreditoBandeiras[ id=" + id + " ]";
    }
    
}
