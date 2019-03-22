package com.website.gizi.model;


import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author rasyid
 */
@Entity
public class TargetPenilaian extends Additional implements Serializable {

    private static long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long skorTarget;
    private Long volTarget;
    private Long nilaiTarget;
    @OneToOne
    private Kegiatan kegiatan;
    @OneToOne
    private Rekapitulasi rekapitulasi;

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
        if (!(object instanceof TargetPenilaian)) {
            return false;
        }
        TargetPenilaian other = (TargetPenilaian) object;
        if ((this.getId() == null && other.getId() != null) || (this.getId() != null && !this.getId().equals(other.getId()))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.TargetPenilaianController[ id=" + getId() + " ]";
    }

    /**
     * @return the serialVersionUID
     */
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    /**
     * @return the skorTarget
     */
    public Long getSkorTarget() {
        return skorTarget;
    }

    /**
     * @param skorTarget the skorTarget to set
     */
    public void setSkorTarget(Long skorTarget) {
        this.skorTarget = skorTarget;
    }

    /**
     * @return the volTarget
     */
    public Long getVolTarget() {
        return volTarget;
    }

    /**
     * @param volTarget the volTarget to set
     */
    public void setVolTarget(Long volTarget) {
        this.volTarget = volTarget;
    }

    /**
     * @return the nilaiTarget
     */
    public Long getNilaiTarget() {
        return nilaiTarget;
    }

    /**
     * @param nilaiTarget the nilaiTarget to set
     */
    public void setNilaiTarget(Long nilaiTarget) {
        this.nilaiTarget = nilaiTarget;
    }

    /**
     * @param aSerialVersionUID the serialVersionUID to set
     */
    public static void setSerialVersionUID(long aSerialVersionUID) {
        serialVersionUID = aSerialVersionUID;
    }

    /**
     * @return the kegiatan
     */
    public Kegiatan getKegiatan() {
        return kegiatan;
    }

    /**
     * @param kegiatan the kegiatan to set
     */
    public void setKegiatan(Kegiatan kegiatan) {
        this.kegiatan = kegiatan;
    }

    /**
     * @return the rekapitulasi
     */
    public Rekapitulasi getRekapitulasi() {
        return rekapitulasi;
    }

    /**
     * @param rekapitulasi the rekapitulasi to set
     */
    public void setRekapitulasi(Rekapitulasi rekapitulasi) {
        this.rekapitulasi = rekapitulasi;
    }

}
