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

/**
 *
 * @author ferna
 */
@Entity
@Table(name = "lancamentos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Lancamentos.findAll", query = "SELECT l FROM Lancamentos l")
    , @NamedQuery(name = "Lancamentos.findById", query = "SELECT l FROM Lancamentos l WHERE l.id = :id")
    , @NamedQuery(name = "Lancamentos.findByIdParcela", query = "SELECT l FROM Lancamentos l WHERE l.idParcela = :idParcela")
    , @NamedQuery(name = "Lancamentos.findByData", query = "SELECT l FROM Lancamentos l WHERE l.data = :data")
    , @NamedQuery(name = "Lancamentos.findByFluxo", query = "SELECT l FROM Lancamentos l WHERE l.fluxo = :fluxo")
    , @NamedQuery(name = "Lancamentos.findByValor", query = "SELECT l FROM Lancamentos l WHERE l.valor = :valor")
    , @NamedQuery(name = "Lancamentos.findByHistorico", query = "SELECT l FROM Lancamentos l WHERE l.historico = :historico")
    , @NamedQuery(name = "Lancamentos.findByDocumento", query = "SELECT l FROM Lancamentos l WHERE l.documento = :documento")
    , @NamedQuery(name = "Lancamentos.findByCreatedAt", query = "SELECT l FROM Lancamentos l WHERE l.createdAt = :createdAt")
    , @NamedQuery(name = "Lancamentos.findByUpdatedAt", query = "SELECT l FROM Lancamentos l WHERE l.updatedAt = :updatedAt")})
public class Lancamentos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "id_parcela")
    private Integer idParcela;
    @Basic(optional = false)
    @Column(name = "data")
    @Temporal(TemporalType.DATE)
    private Date data;
    @Basic(optional = false)
    @Column(name = "fluxo")
    private boolean fluxo;
    @Basic(optional = false)
    @Column(name = "valor")
    private double valor;
    @Basic(optional = false)
    @Column(name = "historico")
    private String historico;
    @Basic(optional = false)
    @Column(name = "documento")
    private String documento;
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    @JoinColumn(name = "id_bem", referencedColumnName = "id")
    @ManyToOne
    private Bens idBem;
    @JoinColumn(name = "id_cartao_credito", referencedColumnName = "id")
    @ManyToOne
    private CartaoCredito idCartaoCredito;
    @JoinColumn(name = "id_conta", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Contas idConta;
    @JoinColumn(name = "id_provisao", referencedColumnName = "id")
    @ManyToOne
    private LancamentosProvisaoVencimentos idProvisao;
    @JoinColumn(name = "id_receita", referencedColumnName = "id")
    @ManyToOne
    private LancamentosReceitas idReceita;
    @JoinColumn(name = "id_tipo", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private LancamentosTipo idTipo;
    @JoinColumn(name = "id_pessoa", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Pessoas idPessoa;
    @JoinColumn(name = "id_terceiro", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Pessoas idTerceiro;

    public Lancamentos() {
    }

    public Lancamentos(Integer id) {
        this.id = id;
    }

    public Lancamentos(Integer id, Date data, boolean fluxo, double valor, String historico, String documento) {
        this.id = id;
        this.data = data;
        this.fluxo = fluxo;
        this.valor = valor;
        this.historico = historico;
        this.documento = documento;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdParcela() {
        return idParcela;
    }

    public void setIdParcela(Integer idParcela) {
        this.idParcela = idParcela;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public boolean getFluxo() {
        return fluxo;
    }

    public void setFluxo(boolean fluxo) {
        this.fluxo = fluxo;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getHistorico() {
        return historico;
    }

    public void setHistorico(String historico) {
        this.historico = historico;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
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

    public Bens getIdBem() {
        return idBem;
    }

    public void setIdBem(Bens idBem) {
        this.idBem = idBem;
    }

    public CartaoCredito getIdCartaoCredito() {
        return idCartaoCredito;
    }

    public void setIdCartaoCredito(CartaoCredito idCartaoCredito) {
        this.idCartaoCredito = idCartaoCredito;
    }

    public Contas getIdConta() {
        return idConta;
    }

    public void setIdConta(Contas idConta) {
        this.idConta = idConta;
    }

    public LancamentosProvisaoVencimentos getIdProvisao() {
        return idProvisao;
    }

    public void setIdProvisao(LancamentosProvisaoVencimentos idProvisao) {
        this.idProvisao = idProvisao;
    }

    public LancamentosReceitas getIdReceita() {
        return idReceita;
    }

    public void setIdReceita(LancamentosReceitas idReceita) {
        this.idReceita = idReceita;
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

    public Pessoas getIdTerceiro() {
        return idTerceiro;
    }

    public void setIdTerceiro(Pessoas idTerceiro) {
        this.idTerceiro = idTerceiro;
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
        if (!(object instanceof Lancamentos)) {
            return false;
        }
        Lancamentos other = (Lancamentos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tabelas.Lancamentos[ id=" + id + " ]";
    }
    
}
