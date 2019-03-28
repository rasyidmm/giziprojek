package com.website.gizi.dao;

import com.website.gizi.model.Aktor;
import com.website.gizi.model.Login;

import java.util.List;

public interface AktorDao {
    public List<Aktor> getAllAktor();
    public Aktor getAktorById(long id);
    public void SaveOrUpdateAktor(Aktor a, Login l);
    public void UpdateAktorMandiri(Aktor a);
    public void deleteAktorById(long id);
    public void deleteAktor(Aktor a);
}
