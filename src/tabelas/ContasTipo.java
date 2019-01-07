/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tabelas;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.List;
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
@Table(name = "contas_tipo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ContasTipo.findAll", query = "SELECT c FROM ContasTipo c")
    , @NamedQuery(name = "ContasTipo.findById", query = "SELECT c FROM ContasTipo c WHERE c.id = :id")
    , @NamedQuery(name = "ContasTipo.findByTitle", query = "SELECT c FROM ContasTipo c WHERE c.title = :title")
    , @NamedQuery(name = "ContasTipo.findByDescription", query = "SELECT c FROM ContasTipo c WHERE c.description = :description")
    , @NamedQuery(name = "ContasTipo.findByCreatedAt", query = "SELECT c FROM ContasTipo c WHERE c.createdAt = :createdAt")
    , @NamedQuery(name = "ContasTipo.findByUpdatedAt", query = "SELECT c FROM ContasTipo c WHERE c.updatedAt = :updatedAt")})
public class ContasTipo implements Serializable {

    @Basic(optional = false)
    @Column(name = "investment")
    private boolean investment;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "account")
    private List<Contas> contasList;

    @Basic(optional = false)
    @Column(name = "investiment")
    private boolean investiment;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "title")
    private String title;
    @Column(name = "description")
    private String description;
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "type")
    private Collection<ContasSaldo> contasSaldoCollection;

    public ContasTipo() {
    }

    public ContasTipo(Integer id) {
        this.id = id;
    }

    public ContasTipo(Integer id, String title) {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
    public Collection<ContasSaldo> getContasSaldoCollection() {
        return contasSaldoCollection;
    }

    public void setContasSaldoCollection(Collection<ContasSaldo> contasSaldoCollection) {
        this.contasSaldoCollection = contasSaldoCollection;
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
        if (!(object instanceof ContasTipo)) {
            return false;
        }
        ContasTipo other = (ContasTipo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tabelas.ContasTipo[ id=" + id + " ]";
    }

    public boolean getInvestiment() {
        return investiment;
    }

    public void setInvestiment(boolean investiment) {
        this.investiment = investiment;
    }

    public boolean getInvestment() {
        return investment;
    }

    public void setInvestment(boolean investment) {
        this.investment = investment;
    }

    @XmlTransient
    public List<Contas> getContasList() {
        return contasList;
    }

    public void setContasList(List<Contas> contasList) {
        this.contasList = contasList;
    }
    
}
