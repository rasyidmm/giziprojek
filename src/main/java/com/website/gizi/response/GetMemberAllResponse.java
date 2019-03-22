package com.website.gizi.response;

public class GetMemberAllResponse {
    String namaAwal;
    String namaAkhir;
    String alamat;

    public String getNamaAwal() {
        return namaAwal;
    }

    public void setNamaAwal(String namaAwal) {
        this.namaAwal = namaAwal;
    }

    public String getNamaAkhir() {
        return namaAkhir;
    }

    public void setNamaAkhir(String namaAkhir) {
        this.namaAkhir = namaAkhir;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getNoHp() {
        return noHp;
    }

    public void setNoHp(String noHp) {
        this.noHp = noHp;
    }

    String noHp;
}
