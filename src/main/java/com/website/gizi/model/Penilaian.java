package com.website.gizi.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 *
 * @author rasyid
 */
@Entity
public class Penilaian extends Additional implements Serializable {
    @JsonIgnore
    @OneToOne(mappedBy = "penilaian")
    private Capaian capaian;

    private static long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date tglKegiatan;
    private Long skorKegiatan;
    private Long volKegiatan;
    private Long nilaiKegiatan;
    @ManyToOne
    private Kegiatan kegiatan;
    @ManyToOne
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
        if (!(object instanceof Penilaian)) {
            return false;
        }
        Penilaian other = (Penilaian) object;
        if ((this.getId() == null && other.getId() != null) || (this.getId() != null && !this.getId().equals(other.getId()))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.PenilaianController[ id=" + getId() + " ]";
    }

    /**
     * @return the serialVersionUID
     */
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    /**
     * @return the tglKegiatan
     */
    public Date getTglKegiatan() {
        return tglKegiatan;
    }

    /**
     * @param tglKegiatan the tglKegiatan to set
     */
    public void setTglKegiatan(Date tglKegiatan) {
        this.tglKegiatan = tglKegiatan;
    }

    /**
     * @return the skorKegiatan
     */
    public Long getSkorKegiatan() {
        return skorKegiatan;
    }

    /**
     * @param skorKegiatan the skorKegiatan to set
     */
    public void setSkorKegiatan(Long skorKegiatan) {
        this.skorKegiatan = skorKegiatan;
    }

    /**
     * @return the volKegiatan
     */
    public Long getVolKegiatan() {
        return volKegiatan;
    }

    /**
     * @param volKegiatan the volKegiatan to set
     */
    public void setVolKegiatan(Long volKegiatan) {
        this.volKegiatan = volKegiatan;
    }

    /**
     * @return the nilaiKegiatan
     */
    public Long getNilaiKegiatan() {
        return nilaiKegiatan;
    }

    /**
     * @param nilaiKegiatan the nilaiKegiatan to set
     */
    public void setNilaiKegiatan(Long nilaiKegiatan) {
        this.nilaiKegiatan = nilaiKegiatan;
    }

    /**
     * @return the capaian
     */
    public Capaian getCapaian() {
        return capaian;
    }

    /**
     * @param capaian the capaian to set
     */
    public void setCapaian(Capaian capaian) {
        this.capaian = capaian;
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
