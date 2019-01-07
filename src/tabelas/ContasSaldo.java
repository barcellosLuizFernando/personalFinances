/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tabelas;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ferna
 */
@Entity
@Table(name = "contas_saldo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ContasSaldo.findAll", query = "SELECT c FROM ContasSaldo c")
    , @NamedQuery(name = "ContasSaldo.findById", query = "SELECT c FROM ContasSaldo c WHERE c.id = :id")
    , @NamedQuery(name = "ContasSaldo.findByDate", query = "SELECT c FROM ContasSaldo c WHERE c.date = :date")
    , @NamedQuery(name = "ContasSaldo.findByValue", query = "SELECT c FROM ContasSaldo c WHERE c.value = :value")
    , @NamedQuery(name = "ContasSaldo.findByCreatedAt", query = "SELECT c FROM ContasSaldo c WHERE c.createdAt = :createdAt")
    , @NamedQuery(name = "ContasSaldo.findByUpdatedAt", query = "SELECT c FROM ContasSaldo c WHERE c.updatedAt = :updatedAt")})
public class ContasSaldo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Basic(optional = false)
    @Column(name = "value")
    private double value;
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    @JoinColumn(name = "id", referencedColumnName = "id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Contas contas;
    @JoinColumn(name = "type", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ContasTipo type;

    public ContasSaldo() {
    }

    public ContasSaldo(Integer id) {
        this.id = id;
    }

    public ContasSaldo(Integer id, Date date, double value) {
        this.id = id;
        this.date = date;
        this.value = value;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Contas getContas() {
        return contas;
    }

    public void setContas(Contas contas) {
        this.contas = contas;
    }

    public ContasTipo getType() {
        return type;
    }

    public void setType(ContasTipo type) {
        this.type = type;
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
        if (!(object instanceof ContasSaldo)) {
            return false;
        }
        ContasSaldo other = (ContasSaldo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tabelas.ContasSaldo[ id=" + id + " ]";
    }
    
}
