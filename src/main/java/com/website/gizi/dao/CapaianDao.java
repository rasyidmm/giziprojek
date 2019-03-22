package com.website.gizi.dao;

import com.website.gizi.model.Capaian;

import java.util.List;

public interface CapaianDao {
    public List<Capaian> getAllCapaian();
    public Capaian getCapaianById(long id);
    public void SaveOrUpdateCapaian(Capaian a);
    public void deleteCapaianById(long id);
    public void deleteCapaian(Capaian a);
}
