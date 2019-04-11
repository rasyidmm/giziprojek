package com.website.gizi.model;

import javax.persistence.*;
import java.io.Serializable;
import javax.persistence.Transient;
@Entity
public class KegiatanRekapitulasi implements Serializable {

    private static long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private
    Kegiatan kegiatan;
    @ManyToOne
    private
    Rekapitulasi rekapitulasi;

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
        if (!(object instanceof Kegiatan)) {
            return false;
        }
        Kegiatan other = (Kegiatan) object;
        if ((this.getId() == null && other.getId() != null) || (this.getId() != null && !this.getId().equals(other.getId()))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.KegiatanController[ id=" + getId() + " ]";
    }

    /**
     * @return the serialVersionUID
     */
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    /**
     * @param aSerialVersionUID the serialVersionUID to set
     */
    public static void setSerialVersionUID(long aSerialVersionUID) {
        serialVersionUID = aSerialVersionUID;
    }

    public Kegiatan getKegiatan() {
        return kegiatan;
    }

    public void setKegiatan(Kegiatan kegiatan) {
        this.kegiatan = kegiatan;
    }

    public Rekapitulasi getRekapitulasi() {
        return rekapitulasi;
    }

    public void setRekapitulasi(Rekapitulasi rekapitulasi) {
        this.rekapitulasi = rekapitulasi;
    }

    /**
     * @return the namaKegiatan
     */

}
