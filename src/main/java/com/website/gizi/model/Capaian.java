package com.website.gizi.model;


import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 * @author rasyid
 */
@Entity
public class Capaian extends Additional implements Serializable {

    private static long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long volCapaian;
    private Long nilaiCapaian;
    private Long persentCapaian;

    private String bulanCapaian;
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
        if (!(object instanceof Capaian)) {
            return false;
        }
        Capaian other = (Capaian) object;
        if ((this.getId() == null && other.getId() != null) || (this.getId() != null && !this.getId().equals(other.getId()))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.CapaianController[ id=" + getId() + " ]";
    }

    /**
     * @return the serialVersionUID
     */
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    /**
     * @return the volCapaian
     */
    public Long getVolCapaian() {
        return volCapaian;
    }

    /**
     * @param volCapaian the volCapaian to set
     */
    public void setVolCapaian(Long volCapaian) {
        this.volCapaian = volCapaian;
    }

    /**
     * @return the nilaiCapaian
     */
    public Long getNilaiCapaian() {
        return nilaiCapaian;
    }

    /**
     * @param nilaiCapaian the nilaiCapaian to set
     */
    public void setNilaiCapaian(Long nilaiCapaian) {
        this.nilaiCapaian = nilaiCapaian;
    }

    /**
     * @return the persentCapaian
     */
    public Long getPersentCapaian() {
        return persentCapaian;
    }

    /**
     * @param persentCapaian the persentCapaian to set
     */
    public void setPersentCapaian(Long persentCapaian) {
        this.persentCapaian = persentCapaian;
    }

    /**
     * @return the bulanCapaian
     */

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

    public String getBulanCapaian(String waktuRekapitulasi) {
        return bulanCapaian;
    }

    public void setBulanCapaian(String bulanCapaian) {
        this.bulanCapaian = bulanCapaian;
    }
}
