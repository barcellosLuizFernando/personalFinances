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
@Table(name = "lancamentos_provisao")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LancamentosProvisao.findAll", query = "SELECT l FROM LancamentosProvisao l")
    , @NamedQuery(name = "LancamentosProvisao.findById", query = "SELECT l FROM LancamentosProvisao l WHERE l.id = :id")
    , @NamedQuery(name = "LancamentosProvisao.findByIdPessoa", query = "SELECT l FROM LancamentosProvisao l WHERE l.idPessoa = :idPessoa")
    , @NamedQuery(name = "LancamentosProvisao.findByIdFornecedor", query = "SELECT l FROM LancamentosProvisao l WHERE l.idFornecedor = :idFornecedor")
    , @NamedQuery(name = "LancamentosProvisao.findByDescricao", query = "SELECT l FROM LancamentosProvisao l WHERE l.descricao = :descricao")
    , @NamedQuery(name = "LancamentosProvisao.findByDocumento", query = "SELECT l FROM LancamentosProvisao l WHERE l.documento = :documento")
    , @NamedQuery(name = "LancamentosProvisao.findByDtVencimento", query = "SELECT l FROM LancamentosProvisao l WHERE l.dtVencimento = :dtVencimento")
    , @NamedQuery(name = "LancamentosProvisao.findByParcelas", query = "SELECT l FROM LancamentosProvisao l WHERE l.parcelas = :parcelas")
    , @NamedQuery(name = "LancamentosProvisao.findByValor", query = "SELECT l FROM LancamentosProvisao l WHERE l.valor = :valor")
    , @NamedQuery(name = "LancamentosProvisao.findByContratado", query = "SELECT l FROM LancamentosProvisao l WHERE l.contratado = :contratado")
    , @NamedQuery(name = "LancamentosProvisao.findByLote", query = "SELECT l FROM LancamentosProvisao l WHERE l.lote = :lote")
    , @NamedQuery(name = "LancamentosProvisao.findByCreatedAt", query = "SELECT l FROM LancamentosProvisao l WHERE l.createdAt = :createdAt")
    , @NamedQuery(name = "LancamentosProvisao.findByUpdatedAt", query = "SELECT l FROM LancamentosProvisao l WHERE l.updatedAt = :updatedAt")})
public class LancamentosProvisao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "id_pessoa")
    private int idPessoa;
    @Basic(optional = false)
    @Column(name = "id_fornecedor")
    private int idFornecedor;
    @Basic(optional = false)
    @Column(name = "descricao")
    private String descricao;
    @Column(name = "documento")
    private String documento;
    @Basic(optional = false)
    @Column(name = "dt_vencimento")
    @Temporal(TemporalType.DATE)
    private Date dtVencimento;
    @Basic(optional = false)
    @Column(name = "parcelas")
    private int parcelas;
    @Basic(optional = false)
    @Column(name = "valor")
    private double valor;
    @Basic(optional = false)
    @Column(name = "contratado")
    private boolean contratado;
    @Column(name = "lote")
    private Integer lote;
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    @JoinColumn(name = "type", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private LancamentosTipo type;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "lancamentosProvisao")
    private Collection<LancamentosProvisaoVencimentos> lancamentosProvisaoVencimentosCollection;

    public LancamentosProvisao() {
    }

    public LancamentosProvisao(Integer id) {
        this.id = id;
    }

    public LancamentosProvisao(Integer id, int idPessoa, int idFornecedor, String descricao, Date dtVencimento, int parcelas, double valor, boolean contratado) {
        this.id = id;
        this.idPessoa = idPessoa;
        this.idFornecedor = idFornecedor;
        this.descricao = descricao;
        this.dtVencimento = dtVencimento;
        this.parcelas = parcelas;
        this.valor = valor;
        this.contratado = contratado;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(int idPessoa) {
        this.idPessoa = idPessoa;
    }

    public int getIdFornecedor() {
        return idFornecedor;
    }

    public void setIdFornecedor(int idFornecedor) {
        this.idFornecedor = idFornecedor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public Date getDtVencimento() {
        return dtVencimento;
    }

    public void setDtVencimento(Date dtVencimento) {
        this.dtVencimento = dtVencimento;
    }

    public int getParcelas() {
        return parcelas;
    }

    public void setParcelas(int parcelas) {
        this.parcelas = parcelas;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public boolean getContratado() {
        return contratado;
    }

    public void setContratado(boolean contratado) {
        this.contratado = contratado;
    }

    public Integer getLote() {
        return lote;
    }

    public void setLote(Integer lote) {
        this.lote = lote;
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

    public LancamentosTipo getType() {
        return type;
    }

    public void setType(LancamentosTipo type) {
        this.type = type;
    }

    @XmlTransient
    public Collection<LancamentosProvisaoVencimentos> getLancamentosProvisaoVencimentosCollection() {
        return lancamentosProvisaoVencimentosCollection;
    }

    public void setLancamentosProvisaoVencimentosCollection(Collection<LancamentosProvisaoVencimentos> lancamentosProvisaoVencimentosCollection) {
        this.lancamentosProvisaoVencimentosCollection = lancamentosProvisaoVencimentosCollection;
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
        if (!(object instanceof LancamentosProvisao)) {
            return false;
        }
        LancamentosProvisao other = (LancamentosProvisao) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tabelas.LancamentosProvisao[ id=" + id + " ]";
    }
    
}
