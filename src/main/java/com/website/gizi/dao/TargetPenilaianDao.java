package com.website.gizi.dao;

import com.website.gizi.model.TargetPenilaian;

import java.util.List;

public interface TargetPenilaianDao {
    public List<TargetPenilaian> getAllTargetPenilaian();
    public TargetPenilaian getTargetPenilaianById(long id);
    public void SaveOrUpdateTargetPenilaian(TargetPenilaian a);
    public void deleteTargetPenilaianById(long id);
    public void deleteTargetPenilaian(TargetPenilaian a);
}
