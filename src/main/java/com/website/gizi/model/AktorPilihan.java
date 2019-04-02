package com.website.gizi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author rasyid
 */
@Entity
public class AktorPilihan implements Serializable {
    @JsonIgnore
    @OneToOne(mappedBy = "aktorPilihan")
    private
    Rekapitulasi rekapitulasi;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    private
    Aktor aktor;


    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (getId() != null ? getId().hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AktorPilihan)) {
            return false;
        }
        AktorPilihan other = (AktorPilihan) object;
        if ((this.getId() == null && other.getId() != null) || (this.getId() != null && !this.getId().equals(other.getId()))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.AktorPilihan[ id=" + getId() + " ]";
    }

    public Rekapitulasi getRekapitulasi() {
        return rekapitulasi;
    }

    public void setRekapitulasi(Rekapitulasi rekapitulasi) {
        this.rekapitulasi = rekapitulasi;
    }

    public Aktor getAktor() {
        return aktor;
    }

    public void setAktor(Aktor aktor) {
        this.aktor = aktor;
    }


}
