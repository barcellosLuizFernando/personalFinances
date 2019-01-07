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
@Table(name = "pessoas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pessoas.findAll", query = "SELECT p FROM Pessoas p")
    , @NamedQuery(name = "Pessoas.findById", query = "SELECT p FROM Pessoas p WHERE p.id = :id")
    , @NamedQuery(name = "Pessoas.findByNome", query = "SELECT p FROM Pessoas p WHERE p.nome = :nome")
    , @NamedQuery(name = "Pessoas.findByCpf", query = "SELECT p FROM Pessoas p WHERE p.cpf = :cpf")
    , @NamedQuery(name = "Pessoas.findByIdentidade", query = "SELECT p FROM Pessoas p WHERE p.identidade = :identidade")
    , @NamedQuery(name = "Pessoas.findByOrgaoEmissor", query = "SELECT p FROM Pessoas p WHERE p.orgaoEmissor = :orgaoEmissor")
    , @NamedQuery(name = "Pessoas.findByDataEmissao", query = "SELECT p FROM Pessoas p WHERE p.dataEmissao = :dataEmissao")
    , @NamedQuery(name = "Pessoas.findByEndereco", query = "SELECT p FROM Pessoas p WHERE p.endereco = :endereco")
    , @NamedQuery(name = "Pessoas.findByBairro", query = "SELECT p FROM Pessoas p WHERE p.bairro = :bairro")
    , @NamedQuery(name = "Pessoas.findByComplemento", query = "SELECT p FROM Pessoas p WHERE p.complemento = :complemento")
    , @NamedQuery(name = "Pessoas.findByCep", query = "SELECT p FROM Pessoas p WHERE p.cep = :cep")
    , @NamedQuery(name = "Pessoas.findByCreatedAt", query = "SELECT p FROM Pessoas p WHERE p.createdAt = :createdAt")
    , @NamedQuery(name = "Pessoas.findByUpdatedAt", query = "SELECT p FROM Pessoas p WHERE p.updatedAt = :updatedAt")})
public class Pessoas implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPessoa")
    private Collection<CartaoCredito> cartaoCreditoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPessoa")
    private Collection<Bens> bensCollection;
    @OneToMany(mappedBy = "idPessoaAlienacao")
    private Collection<Bens> bensCollection1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPessoa")
    private Collection<LancamentosCartaoCredito> lancamentosCartaoCreditoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPessoa")
    private Collection<Lancamentos> lancamentosCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTerceiro")
    private Collection<Lancamentos> lancamentosCollection1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPessoa")
    private Collection<LancamentosReceitas> lancamentosReceitasCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCliente")
    private Collection<LancamentosReceitas> lancamentosReceitasCollection1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pessoa")
    private Collection<Contas> contasCollection;

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
    @Column(name = "cpf")
    private String cpf;
    @Column(name = "identidade")
    private String identidade;
    @Column(name = "orgao_emissor")
    private String orgaoEmissor;
    @Column(name = "data_emissao")
    @Temporal(TemporalType.DATE)
    private Date dataEmissao;
    @Basic(optional = false)
    @Column(name = "endereco")
    private String endereco;
    @Column(name = "bairro")
    private String bairro;
    @Column(name = "complemento")
    private String complemento;
    @Column(name = "cep")
    private String cep;
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    @JoinColumn(name = "cidade", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private CadMunic cidade;

    public Pessoas() {
    }

    public Pessoas(Integer id) {
        this.id = id;
    }

    public Pessoas(Integer id, String nome, String cpf, String endereco) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
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
        if (!nome.equals("")) {
            this.nome = nome;
        } else {
            this.nome = null;
        }
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getIdentidade() {
        return identidade;
    }

    public void setIdentidade(String identidade) {

        if (!"".equals(identidade)) {
            this.identidade = identidade;
        } else {
            this.identidade = null;
        }
    }

    public String getOrgaoEmissor() {
        return orgaoEmissor;
    }

    public void setOrgaoEmissor(String orgaoEmissor) {
        if (!"".equals(orgaoEmissor)) {
            this.orgaoEmissor = orgaoEmissor;
        } else {
            this.orgaoEmissor = null;
        }
    }

    public Date getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(Date dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        if (!"".equals(endereco)) {
            this.endereco = endereco;
        } else {
            this.endereco = null;
        }
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        if (!"".equals(bairro)) {
            this.bairro = bairro;
        } else {
            this.bairro = null;
        }
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        if (!"".equals(complemento)) {
            this.complemento = complemento;
        } else {
            this.complemento = null;
        }
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        if (!"".equals(cep)) {
            this.cep = cep;
        } else {
            this.cep = null;
        }
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public CadMunic getCidade() {
        return cidade;
    }

    public void setCidade(CadMunic cidade) {
        this.cidade = cidade;
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
        if (!(object instanceof Pessoas)) {
            return false;
        }
        Pessoas other = (Pessoas) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tabelas.Pessoas[ id=" + id + " ]";
    }

    @XmlTransient
    public Collection<CartaoCredito> getCartaoCreditoCollection() {
        return cartaoCreditoCollection;
    }

    public void setCartaoCreditoCollection(Collection<CartaoCredito> cartaoCreditoCollection) {
        this.cartaoCreditoCollection = cartaoCreditoCollection;
    }

    @XmlTransient
    public Collection<Bens> getBensCollection() {
        return bensCollection;
    }

    public void setBensCollection(Collection<Bens> bensCollection) {
        this.bensCollection = bensCollection;
    }

    @XmlTransient
    public Collection<Bens> getBensCollection1() {
        return bensCollection1;
    }

    public void setBensCollection1(Collection<Bens> bensCollection1) {
        this.bensCollection1 = bensCollection1;
    }

    @XmlTransient
    public Collection<LancamentosCartaoCredito> getLancamentosCartaoCreditoCollection() {
        return lancamentosCartaoCreditoCollection;
    }

    public void setLancamentosCartaoCreditoCollection(Collection<LancamentosCartaoCredito> lancamentosCartaoCreditoCollection) {
        this.lancamentosCartaoCreditoCollection = lancamentosCartaoCreditoCollection;
    }

    @XmlTransient
    public Collection<Lancamentos> getLancamentosCollection() {
        return lancamentosCollection;
    }

    public void setLancamentosCollection(Collection<Lancamentos> lancamentosCollection) {
        this.lancamentosCollection = lancamentosCollection;
    }

    @XmlTransient
    public Collection<Lancamentos> getLancamentosCollection1() {
        return lancamentosCollection1;
    }

    public void setLancamentosCollection1(Collection<Lancamentos> lancamentosCollection1) {
        this.lancamentosCollection1 = lancamentosCollection1;
    }

    @XmlTransient
    public Collection<LancamentosReceitas> getLancamentosReceitasCollection() {
        return lancamentosReceitasCollection;
    }

    public void setLancamentosReceitasCollection(Collection<LancamentosReceitas> lancamentosReceitasCollection) {
        this.lancamentosReceitasCollection = lancamentosReceitasCollection;
    }

    @XmlTransient
    public Collection<LancamentosReceitas> getLancamentosReceitasCollection1() {
        return lancamentosReceitasCollection1;
    }

    public void setLancamentosReceitasCollection1(Collection<LancamentosReceitas> lancamentosReceitasCollection1) {
        this.lancamentosReceitasCollection1 = lancamentosReceitasCollection1;
    }

    @XmlTransient
    public Collection<Contas> getContasCollection() {
        return contasCollection;
    }

    public void setContasCollection(Collection<Contas> contasCollection) {
        this.contasCollection = contasCollection;
    }

}
