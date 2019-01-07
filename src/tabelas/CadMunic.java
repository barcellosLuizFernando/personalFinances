/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tabelas;

import java.io.Serializable;
import java.util.Collection;
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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ferna
 */
@Entity
@Table(name = "cad_munic")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CadMunic.findAll", query = "SELECT c FROM CadMunic c")
    , @NamedQuery(name = "CadMunic.findById", query = "SELECT c FROM CadMunic c WHERE c.id = :id")
    , @NamedQuery(name = "CadMunic.findByUf", query = "SELECT c FROM CadMunic c WHERE c.uf = :uf")
    , @NamedQuery(name = "CadMunic.findByCodIbge", query = "SELECT c FROM CadMunic c WHERE c.codIbge = :codIbge")
    , @NamedQuery(name = "CadMunic.findByNome", query = "SELECT c FROM CadMunic c WHERE c.nome = :nome")})
public class CadMunic implements Serializable {

    @OneToMany(mappedBy = "municipio")
    private Collection<Bens> bensCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cidade")
    private Collection<Contas> contasCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "uf")
    private String uf;
    @Basic(optional = false)
    @Column(name = "cod_ibge")
    private int codIbge;
    @Column(name = "nome")
    private String nome;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cidade")
    private Collection<Pessoas> pessoasCollection;

    public CadMunic() {
    }

    public CadMunic(Integer id) {
        this.id = id;
    }

    public CadMunic(Integer id, String uf, int codIbge) {
        this.id = id;
        this.uf = uf;
        this.codIbge = codIbge;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public int getCodIbge() {
        return codIbge;
    }

    public void setCodIbge(int codIbge) {
        this.codIbge = codIbge;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @XmlTransient
    public Collection<Pessoas> getPessoasCollection() {
        return pessoasCollection;
    }

    public void setPessoasCollection(Collection<Pessoas> pessoasCollection) {
        this.pessoasCollection = pessoasCollection;
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
        if (!(object instanceof CadMunic)) {
            return false;
        }
        CadMunic other = (CadMunic) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tabelas.CadMunic[ id=" + id + " ]";
    }

    @XmlTransient
    public Collection<Bens> getBensCollection() {
        return bensCollection;
    }

    public void setBensCollection(Collection<Bens> bensCollection) {
        this.bensCollection = bensCollection;
    }

    @XmlTransient
    public Collection<Contas> getContasCollection() {
        return contasCollection;
    }

    public void setContasCollection(Collection<Contas> contasCollection) {
        this.contasCollection = contasCollection;
    }
    
}
