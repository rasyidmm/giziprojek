package com.website.gizi.dao;

import com.website.gizi.model.Rekapitulasi;

import java.util.List;

public interface RekapitulasiDao {
    public List<Rekapitulasi> getAllRekapitulasi();

    public Rekapitulasi getRekapitulasiById(long id);

    public void SaveOrUpdateRekapitulasi(Rekapitulasi a);

    public void deleteRekapitulasiById(long id);

    public void deleteRekapitulasi(Rekapitulasi a);
}
