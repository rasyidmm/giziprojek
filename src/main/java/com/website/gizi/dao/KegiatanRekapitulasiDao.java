package com.website.gizi.dao;

import com.website.gizi.model.KegiatanRekapitulasi;

import java.util.List;

public interface KegiatanRekapitulasiDao {
    public List<KegiatanRekapitulasi> getAllKegiatanRekapitulasi();
    public KegiatanRekapitulasi getKegiatanRekapitulasiById(long id);
    public void SaveOrUpdateKegiatanRekapitulasi(KegiatanRekapitulasi a);
    public void deleteKegiatanRekapitulasiById(long id);
    public void deleteKegiatanRekapitulasi(KegiatanRekapitulasi a);

}
