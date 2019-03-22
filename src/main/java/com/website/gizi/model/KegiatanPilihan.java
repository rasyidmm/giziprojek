package com.website.gizi.model;



import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.List;
import java.util.Set;
import javax.persistence.*;

/**
 *
 * @author rasyid
 */
@Entity
public class KegiatanPilihan extends Additional implements Serializable {
    @JsonIgnore
    @OneToOne(mappedBy = "kegiatanPilihan")
    private Rekapitulasi rekapitulasi;

    private static long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String namaKegRek;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable
    private Set<Kegiatan> kegiatan;

    @ManyToOne
    private
    WaktuKegiatan waktuKegiatan;

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
        if (!(object instanceof KegiatanPilihan)) {
            return false;
        }
        KegiatanPilihan other = (KegiatanPilihan) object;
        if ((this.getId() == null && other.getId() != null) || (this.getId() != null && !this.getId().equals(other.getId()))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.KegiatanPilihanController[ id=" + getId() + " ]";
    }

    /**
     * @return the serialVersionUID
     */
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    /**
     * @return the namaKegRek
     */
    public String getNamaKegRek() {
        return namaKegRek;
    }

    /**
     * @param namaKegRek the namaKegRek to set
     */
    public void setNamaKegRek(String namaKegRek) {
        this.namaKegRek = namaKegRek;
    }

    /**
     * @return the rekapitulasis
     */



    /**
     * @param aSerialVersionUID the serialVersionUID to set
     */
    public static void setSerialVersionUID(long aSerialVersionUID) {
        serialVersionUID = aSerialVersionUID;
    }

    public Rekapitulasi getRekapitulasi() {
        return rekapitulasi;
    }

    public void setRekapitulasi(Rekapitulasi rekapitulasi) {
        this.rekapitulasi = rekapitulasi;
    }

    public WaktuKegiatan getWaktuKegiatan() {
        return waktuKegiatan;
    }

    public void setWaktuKegiatan(WaktuKegiatan waktuKegiatan) {
        this.waktuKegiatan = waktuKegiatan;
    }
}
