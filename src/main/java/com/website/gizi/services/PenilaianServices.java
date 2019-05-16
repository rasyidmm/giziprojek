package com.website.gizi.services;

import com.website.gizi.dao.PenilaianDao;
import com.website.gizi.model.Penilaian;
import com.website.gizi.repository.PenilaianRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PenilaianServices implements PenilaianDao {
    @Autowired
    PenilaianRepository penilaianRepository;

    @Override
    public List<Penilaian> getAllPenilaian() {
        List<Penilaian> pl = new ArrayList<>();
        penilaianRepository.findAll().forEach(pl::add);
        return pl;
    }

    @Override
    public Penilaian getPenilaianById(long id) {
        Penilaian p = penilaianRepository.findById(id).get();
        return p;
    }

    @Override
    public void SaveOrUpdatePenilaian(Penilaian a) {
        penilaianRepository.save(a);
    }

    @Override
    public void deletePenilaianById(long id) {
        penilaianRepository.deleteById(id);
    }

    @Override
    public void deletePenilaian(Penilaian a) {
        penilaianRepository.delete(a);
    }

    public List<Penilaian>findAllByRekapitulasiId(long id){
        return penilaianRepository.findAllByRekapitulasiId(id);
    }
    public List<Penilaian>findAllByKegiatanId(long id){
        return penilaianRepository.findAllByKegiatanId(id);
    }
}
