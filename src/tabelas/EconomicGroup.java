/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tabelas;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
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
@Table(name = "economic_group")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EconomicGroup.findAll", query = "SELECT e FROM EconomicGroup e")
    , @NamedQuery(name = "EconomicGroup.findById", query = "SELECT e FROM EconomicGroup e WHERE e.id = :id")
    , @NamedQuery(name = "EconomicGroup.findByTitle", query = "SELECT e FROM EconomicGroup e WHERE e.title = :title")
    , @NamedQuery(name = "EconomicGroup.findByDescricao", query = "SELECT e FROM EconomicGroup e WHERE e.descricao = :descricao")
    , @NamedQuery(name = "EconomicGroup.findByCreatedAt", query = "SELECT e FROM EconomicGroup e WHERE e.createdAt = :createdAt")
    , @NamedQuery(name = "EconomicGroup.findByUpdatedAt", query = "SELECT e FROM EconomicGroup e WHERE e.updatedAt = :updatedAt")})
public class EconomicGroup implements Serializable {

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
    @OneToMany(mappedBy = "economicGroup")
    private List<Contas> contasList;

    public EconomicGroup() {
    }

    public EconomicGroup(Integer id) {
        this.id = id;
    }

    public EconomicGroup(Integer id, String title) {
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

    @XmlTransient
    public List<Contas> getContasList() {
        return contasList;
    }

    public void setContasList(List<Contas> contasList) {
        this.contasList = contasList;
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
        if (!(object instanceof EconomicGroup)) {
            return false;
        }
        EconomicGroup other = (EconomicGroup) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tabelas.EconomicGroup[ id=" + id + " ]";
    }

}
