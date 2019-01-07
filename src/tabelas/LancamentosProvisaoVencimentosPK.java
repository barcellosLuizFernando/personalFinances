/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tabelas;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author ferna
 */
@Embeddable
public class LancamentosProvisaoVencimentosPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id")
    private int id;
    @Basic(optional = false)
    @Column(name = "id_provisao")
    private int idProvisao;

    public LancamentosProvisaoVencimentosPK() {
    }

    public LancamentosProvisaoVencimentosPK(int id, int idProvisao) {
        this.id = id;
        this.idProvisao = idProvisao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdProvisao() {
        return idProvisao;
    }

    public void setIdProvisao(int idProvisao) {
        this.idProvisao = idProvisao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) id;
        hash += (int) idProvisao;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LancamentosProvisaoVencimentosPK)) {
            return false;
        }
        LancamentosProvisaoVencimentosPK other = (LancamentosProvisaoVencimentosPK) object;
        if (this.id != other.id) {
            return false;
        }
        if (this.idProvisao != other.idProvisao) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tabelas.LancamentosProvisaoVencimentosPK[ id=" + id + ", idProvisao=" + idProvisao + " ]";
    }
    
}
