/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personalfinances;

import java.io.Serializable;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import tabelas.LancamentosTipo;
import tabelas.Pessoas;

/**
 *
 * @author ferna
 */
@Entity
@Table(name = "lancamentos_orcamento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LancamentosOrcamento.findAll", query = "SELECT l FROM LancamentosOrcamento l")
    , @NamedQuery(name = "LancamentosOrcamento.findById", query = "SELECT l FROM LancamentosOrcamento l WHERE l.id = :id")
    , @NamedQuery(name = "LancamentosOrcamento.findByDescricao", query = "SELECT l FROM LancamentosOrcamento l WHERE l.descricao = :descricao")
    , @NamedQuery(name = "LancamentosOrcamento.findByDtInicio", query = "SELECT l FROM LancamentosOrcamento l WHERE l.dtInicio = :dtInicio")
    , @NamedQuery(name = "LancamentosOrcamento.findByDtFim", query = "SELECT l FROM LancamentosOrcamento l WHERE l.dtFim = :dtFim")
    , @NamedQuery(name = "LancamentosOrcamento.findByValor", query = "SELECT l FROM LancamentosOrcamento l WHERE l.valor = :valor")
    , @NamedQuery(name = "LancamentosOrcamento.findByFluxo", query = "SELECT l FROM LancamentosOrcamento l WHERE l.fluxo = :fluxo")
    , @NamedQuery(name = "LancamentosOrcamento.findByRepeatAt", query = "SELECT l FROM LancamentosOrcamento l WHERE l.repeatAt = :repeatAt")
    , @NamedQuery(name = "LancamentosOrcamento.findByDuplicAt", query = "SELECT l FROM LancamentosOrcamento l WHERE l.duplicAt = :duplicAt")
    , @NamedQuery(name = "LancamentosOrcamento.findByCreatedAt", query = "SELECT l FROM LancamentosOrcamento l WHERE l.createdAt = :createdAt")
    , @NamedQuery(name = "LancamentosOrcamento.findByUpdatedAt", query = "SELECT l FROM LancamentosOrcamento l WHERE l.updatedAt = :updatedAt")})
public class LancamentosOrcamento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "descricao")
    private String descricao;
    @Basic(optional = false)
    @Column(name = "dt_inicio")
    @Temporal(TemporalType.DATE)
    private Date dtInicio;
    @Column(name = "dt_fim")
    @Temporal(TemporalType.DATE)
    private Date dtFim;
    @Basic(optional = false)
    @Column(name = "valor")
    private double valor;
    @Basic(optional = false)
    @Column(name = "fluxo")
    private boolean fluxo;
    @Basic(optional = false)
    @Column(name = "repeat_at")
    private String repeatAt;
    @Column(name = "duplic_at")
    private String duplicAt;
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    @JoinColumn(name = "id_tipo_lancamento", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private LancamentosTipo idTipoLancamento;
    @JoinColumn(name = "id_pessoa", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Pessoas idPessoa;

    public LancamentosOrcamento() {
    }

    public LancamentosOrcamento(Integer id) {
        this.id = id;
    }

    public LancamentosOrcamento(Integer id, Date dtInicio, double valor, boolean fluxo, String repeatAt) {
        this.id = id;
        this.dtInicio = dtInicio;
        this.valor = valor;
        this.fluxo = fluxo;
        this.repeatAt = repeatAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getDtInicio() {
        return dtInicio;
    }

    public void setDtInicio(Date dtInicio) {
        this.dtInicio = dtInicio;
    }

    public Date getDtFim() {
        return dtFim;
    }

    public void setDtFim(Date dtFim) {
        this.dtFim = dtFim;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public boolean getFluxo() {
        return fluxo;
    }

    public void setFluxo(boolean fluxo) {
        this.fluxo = fluxo;
    }

    public String getRepeatAt() {
        return repeatAt;
    }

    public void setRepeatAt(String repeatAt) {
        this.repeatAt = repeatAt;
    }

    public String getDuplicAt() {
        return duplicAt;
    }

    public void setDuplicAt(String duplicAt) {
        this.duplicAt = duplicAt;
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

    public LancamentosTipo getIdTipoLancamento() {
        return idTipoLancamento;
    }

    public void setIdTipoLancamento(LancamentosTipo idTipoLancamento) {
        this.idTipoLancamento = idTipoLancamento;
    }

    public Pessoas getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(Pessoas idPessoa) {
        this.idPessoa = idPessoa;
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
        if (!(object instanceof LancamentosOrcamento)) {
            return false;
        }
        LancamentosOrcamento other = (LancamentosOrcamento) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "personalfinances.LancamentosOrcamento[ id=" + id + " ]";
    }
    
}
