package com.website.gizi.dao;

import com.website.gizi.model.Kegiatan;

import java.util.List;

public interface KegiatanDao {
    public List<Kegiatan> getAllKegiatan();
    public Kegiatan getKegiatanById(long id);
    public void SaveOrUpdateKegiatan(Kegiatan a);
    public void deleteKegiatanById(long id);
    public void deleteKegiatan(Kegiatan a);
}
