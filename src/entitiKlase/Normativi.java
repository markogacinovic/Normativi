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
@Table(name = "normativi")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Normativi.findAll", query = "SELECT n FROM Normativi n"),
    @NamedQuery(name = "Normativi.findById", query = "SELECT n FROM Normativi n WHERE n.id = :id"),
    @NamedQuery(name = "Normativi.findBySifra", query = "SELECT n FROM Normativi n WHERE n.sifra = :sifra"),
    @NamedQuery(name = "Normativi.findByIdGrupe", query = "SELECT n FROM Normativi n WHERE n.idGrupe = :idGrupe"),
    @NamedQuery(name = "Normativi.findByNaziv", query = "SELECT n FROM Normativi n WHERE n.naziv = :naziv"),
    @NamedQuery(name = "Normativi.findByIdJediniceMere", query = "SELECT n FROM Normativi n WHERE n.idJediniceMere = :idJediniceMere"),
    @NamedQuery(name = "Normativi.findByCena", query = "SELECT n FROM Normativi n WHERE n.cena = :cena")})
public class Normativi implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "sifra")
    private String sifra;
    @Basic(optional = false)
    @Column(name = "idGrupe")
    private int idGrupe;
    @Basic(optional = false)
    @Column(name = "naziv")
    private String naziv;
    @Basic(optional = false)
    @Column(name = "idJediniceMere")
    private int idJediniceMere;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "cena")
    private BigDecimal cena;

    public Normativi() {
    }

    public Normativi(Integer id) {
        this.id = id;
    }

    public Normativi(Integer id, String sifra, int idGrupe, String naziv, int idJediniceMere) {
        this.id = id;
        this.sifra = sifra;
        this.idGrupe = idGrupe;
        this.naziv = naziv;
        this.idJediniceMere = idJediniceMere;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSifra() {
        return sifra;
    }

    public void setSifra(String sifra) {
        this.sifra = sifra;
    }

    public int getIdGrupe() {
        return idGrupe;
    }

    public void setIdGrupe(int idGrupe) {
        this.idGrupe = idGrupe;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public int getIdJediniceMere() {
        return idJediniceMere;
    }

    public void setIdJediniceMere(int idJediniceMere) {
        this.idJediniceMere = idJediniceMere;
    }

    public BigDecimal getCena() {
        return cena;
    }

    public void setCena(BigDecimal cena) {
        this.cena = cena;
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
        if (!(object instanceof Normativi)) {
            return false;
        }
        Normativi other = (Normativi) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entitiKlase.Normativi[ id=" + id + " ]";
    }
    
}
