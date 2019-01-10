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
@Table(name = "lancamentos_centro_custo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LancamentosCentroCusto.findAll", query = "SELECT l FROM LancamentosCentroCusto l")})
public class LancamentosCentroCusto implements Serializable {

    @OneToMany(mappedBy = "idCc")
    private Collection<LancamentosProvisao> lancamentosProvisaoCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "title")
    private String title;
    @Column(name = "descricao")
    private String descricao;
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    public LancamentosCentroCusto() {
    }

    public LancamentosCentroCusto(Integer id) {
        this.id = id;
    }

    public LancamentosCentroCusto(Integer id, String title) {
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
        if (!"".equals(title)) {
            this.title = title;
        } else {
            this.title = null;
        }
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        if (!"".equals(descricao)) {
            this.descricao = descricao;
        } else {
            this.descricao = null;
        }
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LancamentosCentroCusto)) {
            return false;
        }
        LancamentosCentroCusto other = (LancamentosCentroCusto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tabelas.LancamentosCentroCusto[ id=" + id + " ]";
    }

    @XmlTransient
    public Collection<LancamentosProvisao> getLancamentosProvisaoCollection() {
        return lancamentosProvisaoCollection;
    }

    public void setLancamentosProvisaoCollection(Collection<LancamentosProvisao> lancamentosProvisaoCollection) {
        this.lancamentosProvisaoCollection = lancamentosProvisaoCollection;
    }

}
