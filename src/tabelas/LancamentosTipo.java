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
import personalfinances.LancamentosOrcamento;

/**
 *
 * @author ferna
 */
@Entity
@Table(name = "lancamentos_tipo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LancamentosTipo.findAll", query = "SELECT l FROM LancamentosTipo l")
    , @NamedQuery(name = "LancamentosTipo.findById", query = "SELECT l FROM LancamentosTipo l WHERE l.id = :id")
    , @NamedQuery(name = "LancamentosTipo.findByTitle", query = "SELECT l FROM LancamentosTipo l WHERE l.title = :title")
    , @NamedQuery(name = "LancamentosTipo.findByDescription", query = "SELECT l FROM LancamentosTipo l WHERE l.description = :description")
    , @NamedQuery(name = "LancamentosTipo.findByAntecipaPgto", query = "SELECT l FROM LancamentosTipo l WHERE l.antecipaPgto = :antecipaPgto")
    , @NamedQuery(name = "LancamentosTipo.findByObrigaBem", query = "SELECT l FROM LancamentosTipo l WHERE l.obrigaBem = :obrigaBem")
    , @NamedQuery(name = "LancamentosTipo.findByCreatedAt", query = "SELECT l FROM LancamentosTipo l WHERE l.createdAt = :createdAt")
    , @NamedQuery(name = "LancamentosTipo.findByUpdatedAt", query = "SELECT l FROM LancamentosTipo l WHERE l.updatedAt = :updatedAt")})
public class LancamentosTipo implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipoLancamento")
    private List<LancamentosOrcamento> lancamentosOrcamentoList;

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
    @Basic(optional = false)
    @Column(name = "antecipa_pgto")
    private boolean antecipaPgto;
    @Basic(optional = false)
    @Column(name = "obriga_bem")
    private boolean obrigaBem;
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "type")
    private Collection<LancamentosProvisao> lancamentosProvisaoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipo")
    private Collection<Lancamentos> lancamentosCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipo")
    private Collection<LancamentosReceitas> lancamentosReceitasCollection;

    public LancamentosTipo() {
    }

    public LancamentosTipo(Integer id) {
        this.id = id;
    }

    public LancamentosTipo(Integer id, String title, boolean antecipaPgto, boolean obrigaBem) {
        this.id = id;
        this.title = title;
        this.antecipaPgto = antecipaPgto;
        this.obrigaBem = obrigaBem;
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
        if (!"".equals(description)) {
            this.description = description;
        } else {
            this.description = null;
        }
    }

    public boolean getAntecipaPgto() {
        return antecipaPgto;
    }

    public void setAntecipaPgto(boolean antecipaPgto) {
        this.antecipaPgto = antecipaPgto;
    }

    public boolean getObrigaBem() {
        return obrigaBem;
    }

    public void setObrigaBem(boolean obrigaBem) {
        this.obrigaBem = obrigaBem;
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
    public Collection<LancamentosProvisao> getLancamentosProvisaoCollection() {
        return lancamentosProvisaoCollection;
    }

    public void setLancamentosProvisaoCollection(Collection<LancamentosProvisao> lancamentosProvisaoCollection) {
        this.lancamentosProvisaoCollection = lancamentosProvisaoCollection;
    }

    @XmlTransient
    public Collection<Lancamentos> getLancamentosCollection() {
        return lancamentosCollection;
    }

    public void setLancamentosCollection(Collection<Lancamentos> lancamentosCollection) {
        this.lancamentosCollection = lancamentosCollection;
    }

    @XmlTransient
    public Collection<LancamentosReceitas> getLancamentosReceitasCollection() {
        return lancamentosReceitasCollection;
    }

    public void setLancamentosReceitasCollection(Collection<LancamentosReceitas> lancamentosReceitasCollection) {
        this.lancamentosReceitasCollection = lancamentosReceitasCollection;
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
        if (!(object instanceof LancamentosTipo)) {
            return false;
        }
        LancamentosTipo other = (LancamentosTipo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tabelas.LancamentosTipo[ id=" + id + " ]";
    }

    @XmlTransient
    public List<LancamentosOrcamento> getLancamentosOrcamentoList() {
        return lancamentosOrcamentoList;
    }

    public void setLancamentosOrcamentoList(List<LancamentosOrcamento> lancamentosOrcamentoList) {
        this.lancamentosOrcamentoList = lancamentosOrcamentoList;
    }

}
