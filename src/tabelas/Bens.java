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
@Table(name = "bens")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bens.findAll", query = "SELECT b FROM Bens b")
    , @NamedQuery(name = "Bens.findById", query = "SELECT b FROM Bens b WHERE b.id = :id")
    , @NamedQuery(name = "Bens.findByNome", query = "SELECT b FROM Bens b WHERE b.nome = :nome")
    , @NamedQuery(name = "Bens.findByDescricao", query = "SELECT b FROM Bens b WHERE b.descricao = :descricao")
    , @NamedQuery(name = "Bens.findByMatricula", query = "SELECT b FROM Bens b WHERE b.matricula = :matricula")
    , @NamedQuery(name = "Bens.findByEndereco", query = "SELECT b FROM Bens b WHERE b.endereco = :endereco")
    , @NamedQuery(name = "Bens.findByCep", query = "SELECT b FROM Bens b WHERE b.cep = :cep")
    , @NamedQuery(name = "Bens.findByChassi", query = "SELECT b FROM Bens b WHERE b.chassi = :chassi")
    , @NamedQuery(name = "Bens.findByConsumo", query = "SELECT b FROM Bens b WHERE b.consumo = :consumo")
    , @NamedQuery(name = "Bens.findByDtAquisicao", query = "SELECT b FROM Bens b WHERE b.dtAquisicao = :dtAquisicao")
    , @NamedQuery(name = "Bens.findByVlrAquisicao", query = "SELECT b FROM Bens b WHERE b.vlrAquisicao = :vlrAquisicao")
    , @NamedQuery(name = "Bens.findByDtAlienacao", query = "SELECT b FROM Bens b WHERE b.dtAlienacao = :dtAlienacao")
    , @NamedQuery(name = "Bens.findByVlrAlienacao", query = "SELECT b FROM Bens b WHERE b.vlrAlienacao = :vlrAlienacao")
    , @NamedQuery(name = "Bens.findByCreatedAt", query = "SELECT b FROM Bens b WHERE b.createdAt = :createdAt")
    , @NamedQuery(name = "Bens.findByUpdatedAt", query = "SELECT b FROM Bens b WHERE b.updatedAt = :updatedAt")})
public class Bens implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "nome")
    private String nome;
    @Basic(optional = false)
    @Column(name = "descricao")
    private String descricao;
    @Column(name = "matricula")
    private String matricula;
    @Column(name = "endereco")
    private String endereco;
    @Column(name = "cep")
    private String cep;
    @Column(name = "chassi")
    private String chassi;
    @Column(name = "consumo")
    private Integer consumo;
    @Basic(optional = false)
    @Column(name = "dt_aquisicao")
    @Temporal(TemporalType.DATE)
    private Date dtAquisicao;
    @Basic(optional = false)
    @Column(name = "vlr_aquisicao")
    private double vlrAquisicao;
    @Column(name = "dt_alienacao")
    @Temporal(TemporalType.DATE)
    private Date dtAlienacao;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "vlr_alienacao")
    private Double vlrAlienacao;
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    @JoinColumn(name = "tipo", referencedColumnName = "id")
    @ManyToOne
    private BensTipo tipo;
    @JoinColumn(name = "municipio", referencedColumnName = "id")
    @ManyToOne
    private CadMunic municipio;
    @JoinColumn(name = "id_pessoa", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Pessoas idPessoa;
    @JoinColumn(name = "id_pessoa_alienacao", referencedColumnName = "id")
    @ManyToOne
    private Pessoas idPessoaAlienacao;
    @OneToMany(mappedBy = "idBem")
    private Collection<Lancamentos> lancamentosCollection;

    public Bens() {
    }

    public Bens(Integer id) {
        this.id = id;
    }

    public Bens(Integer id, String nome, String descricao, Date dtAquisicao, double vlrAquisicao) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.dtAquisicao = dtAquisicao;
        this.vlrAquisicao = vlrAquisicao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getChassi() {
        return chassi;
    }

    public void setChassi(String chassi) {
        this.chassi = chassi;
    }

    public Integer getConsumo() {
        return consumo;
    }

    public void setConsumo(Integer consumo) {
        this.consumo = consumo;
    }

    public Date getDtAquisicao() {
        return dtAquisicao;
    }

    public void setDtAquisicao(Date dtAquisicao) {
        this.dtAquisicao = dtAquisicao;
    }

    public double getVlrAquisicao() {
        return vlrAquisicao;
    }

    public void setVlrAquisicao(double vlrAquisicao) {
        this.vlrAquisicao = vlrAquisicao;
    }

    public Date getDtAlienacao() {
        return dtAlienacao;
    }

    public void setDtAlienacao(Date dtAlienacao) {
        this.dtAlienacao = dtAlienacao;
    }

    public Double getVlrAlienacao() {
        return vlrAlienacao;
    }

    public void setVlrAlienacao(Double vlrAlienacao) {
        this.vlrAlienacao = vlrAlienacao;
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

    public BensTipo getTipo() {
        return tipo;
    }

    public void setTipo(BensTipo tipo) {
        this.tipo = tipo;
    }

    public CadMunic getMunicipio() {
        return municipio;
    }

    public void setMunicipio(CadMunic municipio) {
        this.municipio = municipio;
    }

    public Pessoas getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(Pessoas idPessoa) {
        this.idPessoa = idPessoa;
    }

    public Pessoas getIdPessoaAlienacao() {
        return idPessoaAlienacao;
    }

    public void setIdPessoaAlienacao(Pessoas idPessoaAlienacao) {
        this.idPessoaAlienacao = idPessoaAlienacao;
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
        if (!(object instanceof Bens)) {
            return false;
        }
        Bens other = (Bens) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tabelas.Bens[ id=" + id + " ]";
    }
    
}
