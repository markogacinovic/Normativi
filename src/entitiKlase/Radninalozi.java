/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entitiKlase;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Marko
 */
@Entity
@Table(name = "radninalozi")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Radninalozi.findAll", query = "SELECT r FROM Radninalozi r"),
    @NamedQuery(name = "Radninalozi.findById", query = "SELECT r FROM Radninalozi r WHERE r.id = :id"),
    @NamedQuery(name = "Radninalozi.findByIdKomitenta", query = "SELECT r FROM Radninalozi r WHERE r.idKomitenta = :idKomitenta"),
    @NamedQuery(name = "Radninalozi.findByBroj", query = "SELECT r FROM Radninalozi r WHERE r.broj = :broj"),
    @NamedQuery(name = "Radninalozi.findByRokIsporuke", query = "SELECT r FROM Radninalozi r WHERE r.rokIsporuke = :rokIsporuke"),
    @NamedQuery(name = "Radninalozi.findByDatum", query = "SELECT r FROM Radninalozi r WHERE r.datum = :datum"),
    @NamedQuery(name = "Radninalozi.findBySortiment", query = "SELECT r FROM Radninalozi r WHERE r.sortiment = :sortiment")})
public class Radninalozi implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "idKomitenta")
    private int idKomitenta;
    @Basic(optional = false)
    @Column(name = "broj")
    private String broj;
    @Column(name = "rokIsporuke")
    @Temporal(TemporalType.DATE)
    private Date rokIsporuke;
    @Column(name = "datum")
    @Temporal(TemporalType.DATE)
    private Date datum;
    @Column(name = "sortiment")
    private String sortiment;

    public Radninalozi() {
    }

    public Radninalozi(Integer id) {
        this.id = id;
    }

    public Radninalozi(Integer id, int idKomitenta, String broj) {
        this.id = id;
        this.idKomitenta = idKomitenta;
        this.broj = broj;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getIdKomitenta() {
        return idKomitenta;
    }

    public void setIdKomitenta(int idKomitenta) {
        this.idKomitenta = idKomitenta;
    }

    public String getBroj() {
        return broj;
    }

    public void setBroj(String broj) {
        this.broj = broj;
    }

    public Date getRokIsporuke() {
        return rokIsporuke;
    }

    public void setRokIsporuke(Date rokIsporuke) {
        this.rokIsporuke = rokIsporuke;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public String getSortiment() {
        return sortiment;
    }

    public void setSortiment(String sortiment) {
        this.sortiment = sortiment;
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
        if (!(object instanceof Radninalozi)) {
            return false;
        }
        Radninalozi other = (Radninalozi) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entitiKlase.Radninalozi[ id=" + id + " ]";
    }
    
}
