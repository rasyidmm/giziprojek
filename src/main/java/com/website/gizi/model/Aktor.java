package com.website.gizi.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author rasyid
 */
@Entity
public class Aktor extends Additional implements Serializable {
    @JsonIgnore
    @OneToMany(mappedBy = "aktor")
    private List<Kegiatan>kegiatans;
    @JsonIgnore
    @OneToMany(mappedBy = "aktor")
    private List<AktorPilihan> aktorPilihans;

    private static long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String namaAwal;
    private String namaAkhir;
    private String alamat;
    private String noHp;
    @OneToOne
    private Login login;


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
        if (!(object instanceof Aktor)) {
            return false;
        }
        Aktor other = (Aktor) object;
        if ((this.getId() == null && other.getId() != null) || (this.getId() != null && !this.getId().equals(other.getId()))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.AktorController[ id=" + getId() + " ]";
    }

    /**
     * @return the serialVersionUID
     */
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    /**
     * @return the namaAwal
     */
    public String getNamaAwal() {
        return namaAwal;
    }

    /**
     * @param namaAwal the namaAwal to set
     */
    public void setNamaAwal(String namaAwal) {
        this.namaAwal = namaAwal;
    }

    /**
     * @return the namaAkhir
     */
    public String getNamaAkhir() {
        return namaAkhir;
    }

    /**
     * @param namaAkhir the namaAkhir to set
     */
    public void setNamaAkhir(String namaAkhir) {
        this.namaAkhir = namaAkhir;
    }

    /**
     * @return the alamat
     */
    public String getAlamat() {
        return alamat;
    }

    /**
     * @param alamat the alamat to set
     */
    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    /**
     * @return the noHp
     */
    public String getNoHp() {
        return noHp;
    }

    /**
     * @param noHp the noHp to set
     */
    public void setNoHp(String noHp) {
        this.noHp = noHp;
    }

    /**
     * @return the kegiatans
     */
    public List<Kegiatan> getKegiatans() {
        return kegiatans;
    }

    /**
     * @param kegiatans the kegiatans to set
     */
    public void setKegiatans(List<Kegiatan> kegiatans) {
        this.kegiatans = kegiatans;
    }


    /**
     * @return the login
     */
    public Login getLogin() {
        return login;
    }

    /**
     * @param login the login to set
     */
    public void setLogin(Login login) {
        this.login = login;
    }

    /**
     * @param aSerialVersionUID the serialVersionUID to set
     */
    public static void setSerialVersionUID(long aSerialVersionUID) {
        serialVersionUID = aSerialVersionUID;
    }

    public List<AktorPilihan> getAktorPilihans() {
        return aktorPilihans;
    }

    public void setAktorPilihans(List<AktorPilihan> aktorPilihans) {
        this.aktorPilihans = aktorPilihans;
    }
}
