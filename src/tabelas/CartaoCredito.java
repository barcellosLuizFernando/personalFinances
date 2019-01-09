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
@Table(name = "cartao_credito")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CartaoCredito.findAll", query = "SELECT c FROM CartaoCredito c")
    , @NamedQuery(name = "CartaoCredito.findById", query = "SELECT c FROM CartaoCredito c WHERE c.id = :id")
    , @NamedQuery(name = "CartaoCredito.findByNumero", query = "SELECT c FROM CartaoCredito c WHERE c.numero = :numero")
    , @NamedQuery(name = "CartaoCredito.findByDtVencimento", query = "SELECT c FROM CartaoCredito c WHERE c.dtVencimento = :dtVencimento")
    , @NamedQuery(name = "CartaoCredito.findByLimite", query = "SELECT c FROM CartaoCredito c WHERE c.limite = :limite")
    , @NamedQuery(name = "CartaoCredito.findByTipo", query = "SELECT c FROM CartaoCredito c WHERE c.tipo = :tipo")
    , @NamedQuery(name = "CartaoCredito.findByCreatedAt", query = "SELECT c FROM CartaoCredito c WHERE c.createdAt = :createdAt")
    , @NamedQuery(name = "CartaoCredito.findByUpdatedAt", query = "SELECT c FROM CartaoCredito c WHERE c.updatedAt = :updatedAt")})
public class CartaoCredito implements Serializable {

    @Basic(optional = false)
    @Column(name = "cancelado")
    private boolean cancelado;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "numero")
    private String numero;
    @Basic(optional = false)
    @Column(name = "dt_vencimento")
    @Temporal(TemporalType.DATE)
    private Date dtVencimento;
    @Basic(optional = false)
    @Column(name = "limite")
    private double limite;
    @Basic(optional = false)
    @Column(name = "tipo")
    private int tipo;
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    @JoinColumn(name = "id_bandeira", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private CartaoCreditoBandeiras idBandeira;
    @JoinColumn(name = "id_conta", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Contas idConta;
    @JoinColumn(name = "id_pessoa", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Pessoas idPessoa;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCartao")
    private Collection<CartaoCreditoFaturas> cartaoCreditoFaturasCollection;
    @OneToMany(mappedBy = "idCartaoCredito")
    private Collection<Lancamentos> lancamentosCollection;

    public CartaoCredito() {
    }

    public CartaoCredito(Integer id) {
        this.id = id;
    }

    public CartaoCredito(Integer id, String numero, Date dtVencimento, double limite, int tipo) {
        this.id = id;
        this.numero = numero;
        this.dtVencimento = dtVencimento;
        this.limite = limite;
        this.tipo = tipo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Date getDtVencimento() {
        return dtVencimento;
    }

    public void setDtVencimento(Date dtVencimento) {
        this.dtVencimento = dtVencimento;
    }

    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
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

    public CartaoCreditoBandeiras getIdBandeira() {
        return idBandeira;
    }

    public void setIdBandeira(CartaoCreditoBandeiras idBandeira) {
        this.idBandeira = idBandeira;
    }

    public Contas getIdConta() {
        return idConta;
    }

    public void setIdConta(Contas idConta) {
        this.idConta = idConta;
    }

    public Pessoas getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(Pessoas idPessoa) {
        this.idPessoa = idPessoa;
    }

    @XmlTransient
    public Collection<CartaoCreditoFaturas> getCartaoCreditoFaturasCollection() {
        return cartaoCreditoFaturasCollection;
    }

    public void setCartaoCreditoFaturasCollection(Collection<CartaoCreditoFaturas> cartaoCreditoFaturasCollection) {
        this.cartaoCreditoFaturasCollection = cartaoCreditoFaturasCollection;
    }

    @XmlTransient
    public Collection<Lancamentos> getLancamentosCollection() {
        return lancamentosCollection;
    }

    public void setLancamentosCollection(Collection<Lancamentos> lancamentosCollection) {
        this.lancamentosCollection = lancamentosCollection;
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
        if (!(object instanceof CartaoCredito)) {
            return false;
        }
        CartaoCredito other = (CartaoCredito) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tabelas.CartaoCredito[ id=" + id + " ]";
    }

    public boolean getCancelado() {
        return cancelado;
    }

    public void setCancelado(boolean cancelado) {
        this.cancelado = cancelado;
    }
    
}
