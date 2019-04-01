package com.website.gizi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author rasyid
 */
@Entity
public class WaktuKegiatan implements Serializable {
    @JsonIgnore
    @OneToMany(mappedBy = "waktuKegiatan")
    private
    List<AktorPilihan> aktorPilihans;
    @JsonIgnore
    @OneToMany(mappedBy = "waktuKegiatan")
    private
    List<KegiatanPilihan> kegiatanPilihans;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Temporal(javax.persistence.TemporalType.DATE)
    private
    Date waktuRekapitulasi;

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

    public List<AktorPilihan> getAktorPilihans() {
        return aktorPilihans;
    }

    public void setAktorPilihans(List<AktorPilihan> aktorPilihans) {
        this.aktorPilihans = aktorPilihans;
    }

    public List<KegiatanPilihan> getKegiatanPilihans() {
        return kegiatanPilihans;
    }

    public void setKegiatanPilihans(List<KegiatanPilihan> kegiatanPilihans) {
        this.kegiatanPilihans = kegiatanPilihans;
    }

    public Date getWaktuRekapitulasi() {
        return waktuRekapitulasi;
    }

    public void setWaktuRekapitulasi(String waktuRekapitulasi) {
        this.waktuRekapitulasi = waktuRekapitulasi;
    }
}
