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
@Table(name = "lancamentos_cartao_credito")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LancamentosCartaoCredito.findAll", query = "SELECT l FROM LancamentosCartaoCredito l")
    , @NamedQuery(name = "LancamentosCartaoCredito.findById", query = "SELECT l FROM LancamentosCartaoCredito l WHERE l.id = :id")
    , @NamedQuery(name = "LancamentosCartaoCredito.findByIdParcela", query = "SELECT l FROM LancamentosCartaoCredito l WHERE l.idParcela = :idParcela")
    , @NamedQuery(name = "LancamentosCartaoCredito.findByData", query = "SELECT l FROM LancamentosCartaoCredito l WHERE l.data = :data")
    , @NamedQuery(name = "LancamentosCartaoCredito.findByValor", query = "SELECT l FROM LancamentosCartaoCredito l WHERE l.valor = :valor")
    , @NamedQuery(name = "LancamentosCartaoCredito.findByHistorico", query = "SELECT l FROM LancamentosCartaoCredito l WHERE l.historico = :historico")
    , @NamedQuery(name = "LancamentosCartaoCredito.findByDocumento", query = "SELECT l FROM LancamentosCartaoCredito l WHERE l.documento = :documento")
    , @NamedQuery(name = "LancamentosCartaoCredito.findByCreatedAt", query = "SELECT l FROM LancamentosCartaoCredito l WHERE l.createdAt = :createdAt")
    , @NamedQuery(name = "LancamentosCartaoCredito.findByUpdatedAt", query = "SELECT l FROM LancamentosCartaoCredito l WHERE l.updatedAt = :updatedAt")})
public class LancamentosCartaoCredito implements Serializable {

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
    @Column(name = "valor")
    private double valor;
    @Basic(optional = false)
    @Column(name = "historico")
    private String historico;
    @Column(name = "documento")
    private String documento;
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    @JoinColumn(name = "id_fatura", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private CartaoCreditoFaturas idFatura;
    @JoinColumn(name = "id_provisao", referencedColumnName = "id")
    @ManyToOne
    private LancamentosProvisaoVencimentos idProvisao;
    @JoinColumn(name = "id_pessoa", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Pessoas idPessoa;

    public LancamentosCartaoCredito() {
    }

    public LancamentosCartaoCredito(Integer id) {
        this.id = id;
    }

    public LancamentosCartaoCredito(Integer id, Date data, double valor, String historico) {
        this.id = id;
        this.data = data;
        this.valor = valor;
        this.historico = historico;
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

    public CartaoCreditoFaturas getIdFatura() {
        return idFatura;
    }

    public void setIdFatura(CartaoCreditoFaturas idFatura) {
        this.idFatura = idFatura;
    }

    public LancamentosProvisaoVencimentos getIdProvisao() {
        return idProvisao;
    }

    public void setIdProvisao(LancamentosProvisaoVencimentos idProvisao) {
        this.idProvisao = idProvisao;
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
        if (!(object instanceof LancamentosCartaoCredito)) {
            return false;
        }
        LancamentosCartaoCredito other = (LancamentosCartaoCredito) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tabelas.LancamentosCartaoCredito[ id=" + id + " ]";
    }
    
}
