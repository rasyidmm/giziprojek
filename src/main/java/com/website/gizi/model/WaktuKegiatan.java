package com.website.gizi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

/**
 * @author rasyid
 */
@Entity
public class WaktuKegiatan extends Additional implements Serializable {

    @JsonIgnore
    @OneToMany(mappedBy = "waktuKegiatan")
    private List<Rekapitulasi> rekapitulasis;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private
    String waktuRekapitulasi;

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
        if (!(object instanceof WaktuKegiatan)) {
            return false;
        }
        WaktuKegiatan other = (WaktuKegiatan) object;
        if ((this.getId() == null && other.getId() != null) || (this.getId() != null && !this.getId().equals(other.getId()))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.WaktuKegiatan[ id=" + getId() + " ]";
    }


    public List<Rekapitulasi> getRekapitulasis() {
        return rekapitulasis;
    }

    public void setRekapitulasis(List<Rekapitulasi> rekapitulasis) {
        this.rekapitulasis = rekapitulasis;
    }

    public String getWaktuRekapitulasi() {
        return waktuRekapitulasi;
    }

    public void setWaktuRekapitulasi(String waktuRekapitulasi) {
        this.waktuRekapitulasi = waktuRekapitulasi;
    }
}
