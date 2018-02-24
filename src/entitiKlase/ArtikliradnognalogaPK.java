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
public class ArtikliradnognalogaPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "idartikla")
    private int idartikla;
    @Basic(optional = false)
    @Column(name = "idradnognaloga")
    private int idradnognaloga;

    public ArtikliradnognalogaPK() {
    }

    public ArtikliradnognalogaPK(int idartikla, int idradnognaloga) {
        this.idartikla = idartikla;
        this.idradnognaloga = idradnognaloga;
    }

    public int getIdartikla() {
        return idartikla;
    }

    public void setIdartikla(int idartikla) {
        this.idartikla = idartikla;
    }

    public int getIdradnognaloga() {
        return idradnognaloga;
    }

    public void setIdradnognaloga(int idradnognaloga) {
        this.idradnognaloga = idradnognaloga;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idartikla;
        hash += (int) idradnognaloga;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ArtikliradnognalogaPK)) {
            return false;
        }
        ArtikliradnognalogaPK other = (ArtikliradnognalogaPK) object;
        if (this.idartikla != other.idartikla) {
            return false;
        }
        if (this.idradnognaloga != other.idradnognaloga) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entitiKlase.ArtikliradnognalogaPK[ idartikla=" + idartikla + ", idradnognaloga=" + idradnognaloga + " ]";
    }
    
}
