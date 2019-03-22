package com.website.gizi.dao;

import com.website.gizi.model.AktorPilihan;

import java.util.List;

public interface AktorPilihanDao {
    public List<AktorPilihan> getAllAktorPilihan();
    public AktorPilihan getAktorPilihanById(long id);
    public void SaveOrUpdateAktorPilihan(AktorPilihan a);
    public void deleteAktorPilihanById(long id);
    public void deleteAktorPilihan(AktorPilihan a);
}
