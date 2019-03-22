package com.website.gizi.dao;

import com.website.gizi.model.WaktuKegiatan;

import java.util.List;

public interface WaktuKegiatanDao {
    public List<WaktuKegiatan> getAllWaktuKegiatan();
    public WaktuKegiatan getWaktuKegiatanById(long id);
    public void SaveOrUpdateWaktuKegiatan(WaktuKegiatan a);
    public void deleteWaktuKegiatanById(long id);
    public void deleteWaktuKegiatan(WaktuKegiatan a);
}
