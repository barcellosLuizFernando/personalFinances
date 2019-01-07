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
@Table(name = "lancamentos_receitas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LancamentosReceitas.findAll", query = "SELECT l FROM LancamentosReceitas l")
    , @NamedQuery(name = "LancamentosReceitas.findById", query = "SELECT l FROM LancamentosReceitas l WHERE l.id = :id")
    , @NamedQuery(name = "LancamentosReceitas.findByDtVencimento", query = "SELECT l FROM LancamentosReceitas l WHERE l.dtVencimento = :dtVencimento")
    , @NamedQuery(name = "LancamentosReceitas.findByValorBruto", query = "SELECT l FROM LancamentosReceitas l WHERE l.valorBruto = :valorBruto")
    , @NamedQuery(name = "LancamentosReceitas.findByInss", query = "SELECT l FROM LancamentosReceitas l WHERE l.inss = :inss")
    , @NamedQuery(name = "LancamentosReceitas.findByIrrf", query = "SELECT l FROM LancamentosReceitas l WHERE l.irrf = :irrf")
    , @NamedQuery(name = "LancamentosReceitas.findByOutrosDescontos", query = "SELECT l FROM LancamentosReceitas l WHERE l.outrosDescontos = :outrosDescontos")
    , @NamedQuery(name = "LancamentosReceitas.findByDescricao", query = "SELECT l FROM LancamentosReceitas l WHERE l.descricao = :descricao")
    , @NamedQuery(name = "LancamentosReceitas.findByLote", query = "SELECT l FROM LancamentosReceitas l WHERE l.lote = :lote")
    , @NamedQuery(name = "LancamentosReceitas.findByContratado", query = "SELECT l FROM LancamentosReceitas l WHERE l.contratado = :contratado")
    , @NamedQuery(name = "LancamentosReceitas.findByCreatedAt", query = "SELECT l FROM LancamentosReceitas l WHERE l.createdAt = :createdAt")
    , @NamedQuery(name = "LancamentosReceitas.findByUpdatedAt", query = "SELECT l FROM LancamentosReceitas l WHERE l.updatedAt = :updatedAt")})
public class LancamentosReceitas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "dt_vencimento")
    @Temporal(TemporalType.DATE)
    private Date dtVencimento;
    @Basic(optional = false)
    @Column(name = "valor_bruto")
    private double valorBruto;
    @Basic(optional = false)
    @Column(name = "inss")
    private double inss;
    @Basic(optional = false)
    @Column(name = "irrf")
    private double irrf;
    @Basic(optional = false)
    @Column(name = "outros_descontos")
    private double outrosDescontos;
    @Basic(optional = false)
    @Column(name = "descricao")
    private String descricao;
    @Column(name = "lote")
    private Integer lote;
    @Basic(optional = false)
    @Column(name = "contratado")
    private boolean contratado;
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    @OneToMany(mappedBy = "idReceita")
    private Collection<Lancamentos> lancamentosCollection;
    @JoinColumn(name = "id_tipo", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private LancamentosTipo idTipo;
    @JoinColumn(name = "id_pessoa", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Pessoas idPessoa;
    @JoinColumn(name = "id_cliente", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Pessoas idCliente;

    public LancamentosReceitas() {
    }

    public LancamentosReceitas(Integer id) {
        this.id = id;
    }

    public LancamentosReceitas(Integer id, Date dtVencimento, double valorBruto, double inss, double irrf, double outrosDescontos, String descricao, boolean contratado) {
        this.id = id;
        this.dtVencimento = dtVencimento;
        this.valorBruto = valorBruto;
        this.inss = inss;
        this.irrf = irrf;
        this.outrosDescontos = outrosDescontos;
        this.descricao = descricao;
        this.contratado = contratado;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDtVencimento() {
        return dtVencimento;
    }

    public void setDtVencimento(Date dtVencimento) {
        this.dtVencimento = dtVencimento;
    }

    public double getValorBruto() {
        return valorBruto;
    }

    public void setValorBruto(double valorBruto) {
        this.valorBruto = valorBruto;
    }

    public double getInss() {
        return inss;
    }

    public void setInss(double inss) {
        this.inss = inss;
    }

    public double getIrrf() {
        return irrf;
    }

    public void setIrrf(double irrf) {
        this.irrf = irrf;
    }

    public double getOutrosDescontos() {
        return outrosDescontos;
    }

    public void setOutrosDescontos(double outrosDescontos) {
        this.outrosDescontos = outrosDescontos;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getLote() {
        return lote;
    }

    public void setLote(Integer lote) {
        this.lote = lote;
    }

    public boolean getContratado() {
        return contratado;
    }

    public void setContratado(boolean contratado) {
        this.contratado = contratado;
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
    public Collection<Lancamentos> getLancamentosCollection() {
        return lancamentosCollection;
    }

    public void setLancamentosCollection(Collection<Lancamentos> lancamentosCollection) {
        this.lancamentosCollection = lancamentosCollection;
    }

    public LancamentosTipo getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(LancamentosTipo idTipo) {
        this.idTipo = idTipo;
    }

    public Pessoas getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(Pessoas idPessoa) {
        this.idPessoa = idPessoa;
    }

    public Pessoas getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Pessoas idCliente) {
        this.idCliente = idCliente;
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
        if (!(object instanceof LancamentosReceitas)) {
            return false;
        }
        LancamentosReceitas other = (LancamentosReceitas) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tabelas.LancamentosReceitas[ id=" + id + " ]";
    }
    
}
