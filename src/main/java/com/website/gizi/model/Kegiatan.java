package com.website.gizi.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.List;
import java.util.Set;
import javax.persistence.*;
import javax.persistence.Transient;

/**
 *
 * @author rasyid
 */
@Entity
public class Kegiatan extends Additional implements Serializable {

    @JsonIgnore
    @OneToMany(mappedBy = "kegiatan")
    private Set<Penilaian> penilaians;
    @JsonIgnore
    @OneToMany(mappedBy = "kegiatan")
    private
    List<TargetPenilaian> targetPenilaian;
    @JsonIgnore
    @OneToMany(mappedBy = "kegiatan")
    private List<KegiatanRekapitulasi> kegiatanRekapitulasis;
    private static long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String namaKegiatan;
    private String tanggalKegiatan;
    @ManyToOne
    private Aktor aktor;

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

    /**
     * @return the namaKegiatan
     */
    public String getNamaKegiatan() {
        return namaKegiatan;
    }

    /**
     * @param namaKegiatan the namaKegiatan to set
     */
    public void setNamaKegiatan(String namaKegiatan) {
        this.namaKegiatan = namaKegiatan;
    }

    /**
     * @return the kegiatanPilihans
     */



    /**
     * @return the aktor
     */
    public Aktor getAktor() {
        return aktor;
    }

    /**
     * @param aktor the aktor to set
     */
    public void setAktor(Aktor aktor) {
        this.aktor = aktor;
    }

    public String getTanggalKegiatan() {
        return tanggalKegiatan;
    }

    public void setTanggalKegiatan(String tanggalKegiatan) {
        this.tanggalKegiatan = tanggalKegiatan;
    }



    public Set<Penilaian> getPenilaians() {
        return penilaians;
    }

    public void setPenilaians(Set<Penilaian> penilaians) {
        this.penilaians = penilaians;
    }

    public List<KegiatanRekapitulasi> getKegiatanRekapitulasis() {
        return kegiatanRekapitulasis;
    }

    public void setKegiatanRekapitulasis(List<KegiatanRekapitulasi> kegiatanRekapitulasis) {
        this.kegiatanRekapitulasis = kegiatanRekapitulasis;
    }

    public List<TargetPenilaian> getTargetPenilaian() {
        return targetPenilaian;
    }

    public void setTargetPenilaian(List<TargetPenilaian> targetPenilaian) {
        this.targetPenilaian = targetPenilaian;
    }
}
