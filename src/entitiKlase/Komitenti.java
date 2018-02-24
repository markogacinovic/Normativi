/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entitiKlase;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Marko
 */
@Entity
@Table(name = "komitenti")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Komitenti.findAll", query = "SELECT k FROM Komitenti k"),
    @NamedQuery(name = "Komitenti.findById", query = "SELECT k FROM Komitenti k WHERE k.id = :id"),
    @NamedQuery(name = "Komitenti.findByNaziv", query = "SELECT k FROM Komitenti k WHERE k.naziv = :naziv"),
    @NamedQuery(name = "Komitenti.findByAdresa", query = "SELECT k FROM Komitenti k WHERE k.adresa = :adresa")})
public class Komitenti implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "naziv")
    private String naziv;
    @Column(name = "adresa")
    private String adresa;

    public Komitenti() {
    }

    public Komitenti(Integer id) {
        this.id = id;
    }

    public Komitenti(Integer id, String naziv) {
        this.id = id;
        this.naziv = naziv;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
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
        if (!(object instanceof Komitenti)) {
            return false;
        }
        Komitenti other = (Komitenti) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entitiKlase.Komitenti[ id=" + id + " ]";
    }
    
}
