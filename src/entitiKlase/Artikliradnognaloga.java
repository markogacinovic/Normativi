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
@Table(name = "artikliradnognaloga")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Artikliradnognaloga.findAll", query = "SELECT a FROM Artikliradnognaloga a"),
    @NamedQuery(name = "Artikliradnognaloga.findByIdartikla", query = "SELECT a FROM Artikliradnognaloga a WHERE a.artikliradnognalogaPK.idartikla = :idartikla"),
    @NamedQuery(name = "Artikliradnognaloga.findByIdradnognaloga", query = "SELECT a FROM Artikliradnognaloga a WHERE a.artikliradnognalogaPK.idradnognaloga = :idradnognaloga"),
    @NamedQuery(name = "Artikliradnognaloga.findByKolicina", query = "SELECT a FROM Artikliradnognaloga a WHERE a.kolicina = :kolicina")})
public class Artikliradnognaloga implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ArtikliradnognalogaPK artikliradnognalogaPK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "kolicina")
    private BigDecimal kolicina;

    public Artikliradnognaloga() {
    }

    public Artikliradnognaloga(ArtikliradnognalogaPK artikliradnognalogaPK) {
        this.artikliradnognalogaPK = artikliradnognalogaPK;
    }

    public Artikliradnognaloga(ArtikliradnognalogaPK artikliradnognalogaPK, BigDecimal kolicina) {
        this.artikliradnognalogaPK = artikliradnognalogaPK;
        this.kolicina = kolicina;
    }

    public Artikliradnognaloga(int idartikla, int idradnognaloga) {
        this.artikliradnognalogaPK = new ArtikliradnognalogaPK(idartikla, idradnognaloga);
    }

    public ArtikliradnognalogaPK getArtikliradnognalogaPK() {
        return artikliradnognalogaPK;
    }

    public void setArtikliradnognalogaPK(ArtikliradnognalogaPK artikliradnognalogaPK) {
        this.artikliradnognalogaPK = artikliradnognalogaPK;
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
        hash += (artikliradnognalogaPK != null ? artikliradnognalogaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Artikliradnognaloga)) {
            return false;
        }
        Artikliradnognaloga other = (Artikliradnognaloga) object;
        if ((this.artikliradnognalogaPK == null && other.artikliradnognalogaPK != null) || (this.artikliradnognalogaPK != null && !this.artikliradnognalogaPK.equals(other.artikliradnognalogaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entitiKlase.Artikliradnognaloga[ artikliradnognalogaPK=" + artikliradnognalogaPK + " ]";
    }
    
}
