package com.website.gizi.services;

import com.website.gizi.dao.TargetPenilaianDao;
import com.website.gizi.model.TargetPenilaian;
import com.website.gizi.repository.TargetPenilaianRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TargetPenilaianServices implements TargetPenilaianDao {
    @Autowired
    TargetPenilaianRepository targetPenilaianRepository;

    @Override
    public List<TargetPenilaian> getAllTargetPenilaian() {
        List<TargetPenilaian>tpl =  new ArrayList<>();
        targetPenilaianRepository.findAll().forEach(tpl::add);
        return tpl;
    }

    @Override
    public TargetPenilaian getTargetPenilaianById(long id) {
        TargetPenilaian tp = targetPenilaianRepository.findById(id).get();
        return tp;
    }

    @Override
    public void SaveOrUpdateTargetPenilaian(TargetPenilaian a) {
        targetPenilaianRepository.save(a);
    }

    @Override
    public void deleteTargetPenilaianById(long id) {
        targetPenilaianRepository.deleteById(id);
    }

    @Override
    public void deleteTargetPenilaian(TargetPenilaian a) {
        targetPenilaianRepository.save(a);
    }
}
