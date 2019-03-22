package com.website.gizi.dao;

import com.website.gizi.model.KegiatanPilihan;

import java.util.List;

public interface KegiatanPilihanDao {
    public List<KegiatanPilihan> getAllKegiatanPilihan();
    public KegiatanPilihan getKegiatanPilihanById(long id);
    public void SaveOrUpdateKegiatanPilihan(KegiatanPilihan a);
    public void deleteKegiatanPilihanById(long id);
    public void deleteKegiatanPilihan(KegiatanPilihan a);
}
