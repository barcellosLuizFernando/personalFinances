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
@Table(name = "bens_tipo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BensTipo.findAll", query = "SELECT b FROM BensTipo b")
    , @NamedQuery(name = "BensTipo.findById", query = "SELECT b FROM BensTipo b WHERE b.id = :id")
    , @NamedQuery(name = "BensTipo.findByTitle", query = "SELECT b FROM BensTipo b WHERE b.title = :title")
    , @NamedQuery(name = "BensTipo.findByDescription", query = "SELECT b FROM BensTipo b WHERE b.description = :description")
    , @NamedQuery(name = "BensTipo.findByVeiculo", query = "SELECT b FROM BensTipo b WHERE b.veiculo = :veiculo")
    , @NamedQuery(name = "BensTipo.findByImovel", query = "SELECT b FROM BensTipo b WHERE b.imovel = :imovel")
    , @NamedQuery(name = "BensTipo.findByEletronico", query = "SELECT b FROM BensTipo b WHERE b.eletronico = :eletronico")
    , @NamedQuery(name = "BensTipo.findByCreatedAt", query = "SELECT b FROM BensTipo b WHERE b.createdAt = :createdAt")
    , @NamedQuery(name = "BensTipo.findByUpdatedAt", query = "SELECT b FROM BensTipo b WHERE b.updatedAt = :updatedAt")})
public class BensTipo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "title")
    private String title;
    @Basic(optional = false)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @Column(name = "veiculo")
    private boolean veiculo;
    @Basic(optional = false)
    @Column(name = "imovel")
    private boolean imovel;
    @Basic(optional = false)
    @Column(name = "eletronico")
    private boolean eletronico;
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    @OneToMany(mappedBy = "tipo")
    private Collection<Bens> bensCollection;

    public BensTipo() {
    }

    public BensTipo(Integer id) {
        this.id = id;
    }

    public BensTipo(Integer id, String title, String description, boolean veiculo, boolean imovel, boolean eletronico) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.veiculo = veiculo;
        this.imovel = imovel;
        this.eletronico = eletronico;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(boolean veiculo) {
        this.veiculo = veiculo;
    }

    public boolean getImovel() {
        return imovel;
    }

    public void setImovel(boolean imovel) {
        this.imovel = imovel;
    }

    public boolean getEletronico() {
        return eletronico;
    }

    public void setEletronico(boolean eletronico) {
        this.eletronico = eletronico;
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
    public Collection<Bens> getBensCollection() {
        return bensCollection;
    }

    public void setBensCollection(Collection<Bens> bensCollection) {
        this.bensCollection = bensCollection;
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
        if (!(object instanceof BensTipo)) {
            return false;
        }
        BensTipo other = (BensTipo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tabelas.BensTipo[ id=" + id + " ]";
    }
    
}
