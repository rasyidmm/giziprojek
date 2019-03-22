package com.website.gizi.dao;

import com.website.gizi.model.Aktor;

import java.util.List;

public interface AktorDao {
    public List<Aktor> getAllAktor();
    public Aktor getAktorById(long id);
    public Aktor SaveOrUpdateAktor(Aktor a);
    public void deleteAktorById(long id);
    public void deleteAktor(Aktor a);
}
