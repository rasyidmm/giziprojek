package com.website.gizi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author rasyid
 */
@Entity
public class Rekapitulasi extends Additional implements Serializable {
    @JsonIgnore
    @OneToMany(mappedBy = "rekapitulasi")
    private List<Penilaian>penilaians;
    @JsonIgnore
    @OneToOne(mappedBy = "rekapitulasi")
    private TargetPenilaian targetPenilaian;
    @JsonIgnore
    private static long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private KegiatanPilihan kegiatanPilihan;
    @OneToOne
    private
    AktorPilihan aktorPilihan;
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
    public KegiatanPilihan getKegiatanPilihan() {
        return kegiatanPilihan;
    }

    /**
     * @param kegiatanPilihan the kegiatanPilihan to set
     */
    public void setKegiatanPilihan(KegiatanPilihan kegiatanPilihan) {
        this.kegiatanPilihan = kegiatanPilihan;
    }

    /**
     * @return the targetPenilaian
     */
    public TargetPenilaian getTargetPenilaian() {
        return targetPenilaian;
    }

    /**
     * @param targetPenilaian the targetPenilaian to set
     */
    public void setTargetPenilaian(TargetPenilaian targetPenilaian) {
        this.targetPenilaian = targetPenilaian;
    }

    public AktorPilihan getAktorPilihan() {
        return aktorPilihan;
    }

    public void setAktorPilihan(AktorPilihan aktorPilihan) {
        this.aktorPilihan = aktorPilihan;
    }
}
