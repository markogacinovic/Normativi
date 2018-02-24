/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entitiKlase;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Marko
 */
@Entity
@Table(name = "normativizaartikal")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Normativizaartikal.findAll", query = "SELECT n FROM Normativizaartikal n"),
    @NamedQuery(name = "Normativizaartikal.findByIdnormativa", query = "SELECT n FROM Normativizaartikal n WHERE n.normativizaartikalPK.idnormativa = :idnormativa"),
    @NamedQuery(name = "Normativizaartikal.findByIdartikla", query = "SELECT n FROM Normativizaartikal n WHERE n.normativizaartikalPK.idartikla = :idartikla"),
    @NamedQuery(name = "Normativizaartikal.findByKolicina", query = "SELECT n FROM Normativizaartikal n WHERE n.kolicina = :kolicina")})
public class Normativizaartikal implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected NormativizaartikalPK normativizaartikalPK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "kolicina")
    private BigDecimal kolicina;

    public Normativizaartikal() {
    }

    public Normativizaartikal(NormativizaartikalPK normativizaartikalPK) {
        this.normativizaartikalPK = normativizaartikalPK;
    }

    public Normativizaartikal(NormativizaartikalPK normativizaartikalPK, BigDecimal kolicina) {
        this.normativizaartikalPK = normativizaartikalPK;
        this.kolicina = kolicina;
    }

    public Normativizaartikal(int idnormativa, int idartikla) {
        this.normativizaartikalPK = new NormativizaartikalPK(idnormativa, idartikla);
    }

    public NormativizaartikalPK getNormativizaartikalPK() {
        return normativizaartikalPK;
    }

    public void setNormativizaartikalPK(NormativizaartikalPK normativizaartikalPK) {
        this.normativizaartikalPK = normativizaartikalPK;
    }

    public BigDecimal getKolicina() {
        return kolicina;
    }

    public void setKolicina(BigDecimal kolicina) {
        this.kolicina = kolicina;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (normativizaartikalPK != null ? normativizaartikalPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Normativizaartikal)) {
            return false;
        }
        Normativizaartikal other = (Normativizaartikal) object;
        if ((this.normativizaartikalPK == null && other.normativizaartikalPK != null) || (this.normativizaartikalPK != null && !this.normativizaartikalPK.equals(other.normativizaartikalPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entitiKlase.Normativizaartikal[ normativizaartikalPK=" + normativizaartikalPK + " ]";
    }
    
}
