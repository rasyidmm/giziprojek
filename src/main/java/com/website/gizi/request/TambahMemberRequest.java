package com.website.gizi.request;

public class TambahMemberRequest {
    private String namaAwal;
    private String namaAkhir;
    private String alamat;
    private String noHp;
    private String passwordAktor;
    private String usernameAktor;
    private Long loginId;
    private Long roleId;

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

    public String getPasswordAktor() {
        return passwordAktor;
    }

    public void setPasswordAktor(String passwordAktor) {
        this.passwordAktor = passwordAktor;
    }

    public String getUsernameAktor() {
        return usernameAktor;
    }

    public void setUsernameAktor(String usernameAktor) {
        this.usernameAktor = usernameAktor;
    }

    public Long getLoginId() {
        return loginId;
    }

    public void setLoginId(Long loginId) {
        this.loginId = loginId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }
}
