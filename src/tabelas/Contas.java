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
@Table(name = "contas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Contas.findAll", query = "SELECT c FROM Contas c")
    , @NamedQuery(name = "Contas.findById", query = "SELECT c FROM Contas c WHERE c.id = :id")
    , @NamedQuery(name = "Contas.findByAgencia", query = "SELECT c FROM Contas c WHERE c.agencia = :agencia")
    , @NamedQuery(name = "Contas.findByConta", query = "SELECT c FROM Contas c WHERE c.conta = :conta")
    , @NamedQuery(name = "Contas.findByCreatedAt", query = "SELECT c FROM Contas c WHERE c.createdAt = :createdAt")
    , @NamedQuery(name = "Contas.findByUpdatedAt", query = "SELECT c FROM Contas c WHERE c.updatedAt = :updatedAt")
    , @NamedQuery(name = "Contas.findByFinished", query = "SELECT c FROM Contas c WHERE c.finished = :finished")})
public class Contas implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idConta")
    private List<CartaoCredito> cartaoCreditoList;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "agencia")
    private String agencia;
    @Basic(optional = false)
    @Column(name = "conta")
    private String conta;
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    @Basic(optional = false)
    @Column(name = "finished")
    private boolean finished;
    @JoinColumn(name = "bank", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Bank bank;
    @JoinColumn(name = "cidade", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private CadMunic cidade;
    @JoinColumn(name = "account", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ContasTipo account;
    @JoinColumn(name = "economic_group", referencedColumnName = "id")
    @ManyToOne
    private EconomicGroup economicGroup;
    @JoinColumn(name = "pessoa", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Pessoas pessoa;

    public Contas() {
    }

    public Contas(Integer id) {
        this.id = id;
    }

    public Contas(Integer id, String agencia, String conta, boolean finished) {
        this.id = id;
        this.agencia = agencia;
        this.conta = conta;
        this.finished = finished;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public String getConta() {
        return conta;
    }

    public void setConta(String conta) {
        this.conta = conta;
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

    public boolean getFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public CadMunic getCidade() {
        return cidade;
    }

    public void setCidade(CadMunic cidade) {
        this.cidade = cidade;
    }

    public ContasTipo getAccount() {
        return account;
    }

    public void setAccount(ContasTipo account) {
        this.account = account;
    }

    public EconomicGroup getEconomicGroup() {
        return economicGroup;
    }

    public void setEconomicGroup(EconomicGroup economicGroup) {
        this.economicGroup = economicGroup;
    }

    public Pessoas getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoas pessoa) {
        this.pessoa = pessoa;
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
        if (!(object instanceof Contas)) {
            return false;
        }
        Contas other = (Contas) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tabelas.Contas[ id=" + id + " ]";
    }

    @XmlTransient
    public List<CartaoCredito> getCartaoCreditoList() {
        return cartaoCreditoList;
    }

    public void setCartaoCreditoList(List<CartaoCredito> cartaoCreditoList) {
        this.cartaoCreditoList = cartaoCreditoList;
    }
    
}
