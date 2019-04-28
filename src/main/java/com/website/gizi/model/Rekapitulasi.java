package com.website.gizi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.List;
import java.util.Set;
import javax.persistence.*;

/**
 * @author rasyid
 */
@Entity
public class Rekapitulasi extends Additional implements Serializable {
    @JsonIgnore
    @OneToMany(mappedBy = "rekapitulasi")
    private List<Penilaian> penilaians;

    @JsonIgnore
    @OneToMany(mappedBy = "rekapitulasi")
    private List<KegiatanRekapitulasi> kegiatanRekapitulasis;

    @JsonIgnore
    @OneToMany(mappedBy = "rekapitulasi")
    private List<TargetPenilaian> targetPenilaians;

    private static long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String namaRekapitulasi;
    @ManyToOne
    private
    Aktor aktor;

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
        if (!(object instanceof Rekapitulasi)) {
            return false;
        }
        Rekapitulasi other = (Rekapitulasi) object;
        if ((this.getId() == null && other.getId() != null) || (this.getId() != null && !this.getId().equals(other.getId()))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.RekapitulasiController[ id=" + getId() + " ]";
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

    /**
     * @return the penilaians
     */
    public List<Penilaian> getPenilaians() {
        return penilaians;
    }

    /**
     * @param penilaians the penilaians to set
     */
    public void setPenilaians(List<Penilaian> penilaians) {
        this.penilaians = penilaians;
    }

    /**
     * @return the kegiatanPilihan
     */

    /**
     * @return the targetPenilaian
     */


    public WaktuKegiatan getWaktuKegiatan() {
        return waktuKegiatan;
    }

    public void setWaktuKegiatan(WaktuKegiatan waktuKegiatan) {
        this.waktuKegiatan = waktuKegiatan;
    }

    public String getNamaRekapitulasi() {
        return namaRekapitulasi;
    }

    public void setNamaRekapitulasi(String namaRekapitulasi) {
        this.namaRekapitulasi = namaRekapitulasi;
    }

    public Aktor getAktor() {
        return aktor;
    }

    public void setAktor(Aktor aktor) {
        this.aktor = aktor;
    }


    public List<KegiatanRekapitulasi> getKegiatanRekapitulasis() {
        return kegiatanRekapitulasis;
    }

    public void setKegiatanRekapitulasis(List<KegiatanRekapitulasi> kegiatanRekapitulasis) {
        this.kegiatanRekapitulasis = kegiatanRekapitulasis;
    }

    public List<TargetPenilaian> getTargetPenilaians() {
        return targetPenilaians;
    }

    public void setTargetPenilaians(List<TargetPenilaian> targetPenilaians) {
        this.targetPenilaians = targetPenilaians;
    }
}
