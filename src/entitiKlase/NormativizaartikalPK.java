/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entitiKlase;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Marko
 */
@Embeddable
public class NormativizaartikalPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "idnormativa")
    private int idnormativa;
    @Basic(optional = false)
    @Column(name = "idartikla")
    private int idartikla;

    public NormativizaartikalPK() {
    }

    public NormativizaartikalPK(int idnormativa, int idartikla) {
        this.idnormativa = idnormativa;
        this.idartikla = idartikla;
    }

    public int getIdnormativa() {
        return idnormativa;
    }

    public void setIdnormativa(int idnormativa) {
        this.idnormativa = idnormativa;
    }

    public int getIdartikla() {
        return idartikla;
    }

    public void setIdartikla(int idartikla) {
        this.idartikla = idartikla;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idnormativa;
        hash += (int) idartikla;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NormativizaartikalPK)) {
            return false;
        }
        NormativizaartikalPK other = (NormativizaartikalPK) object;
        if (this.idnormativa != other.idnormativa) {
            return false;
        }
        if (this.idartikla != other.idartikla) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entitiKlase.NormativizaartikalPK[ idnormativa=" + idnormativa + ", idartikla=" + idartikla + " ]";
    }
    
}
