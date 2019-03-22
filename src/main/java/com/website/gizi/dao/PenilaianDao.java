package com.website.gizi.dao;

import com.website.gizi.model.Penilaian;

import java.util.List;

public interface PenilaianDao {
    public List<Penilaian> getAllPenilaian();
    public Penilaian getPenilaianById(long id);
    public void SaveOrUpdatePenilaian(Penilaian a);
    public void deletePenilaianById(long id);
    public void deletePenilaian(Penilaian a);
}
