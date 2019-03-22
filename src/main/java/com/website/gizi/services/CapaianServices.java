package com.website.gizi.services;

import com.website.gizi.dao.CapaianDao;
import com.website.gizi.model.Capaian;
import com.website.gizi.repository.CapaianRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CapaianServices implements CapaianDao {
    @Autowired
    CapaianRepository capaianRepository;
    @Override
    public List<Capaian> getAllCapaian() {
        List<Capaian> cl = new ArrayList<>();
        capaianRepository.findAll().forEach(cl::add);
        return cl;

    }

    @Override
    public Capaian getCapaianById(long id) {
        Capaian c = capaianRepository.findById(id).get();
        return c;
    }

    @Override
    public void SaveOrUpdateCapaian(Capaian a) {
        capaianRepository.save(a);
    }

    @Override
    public void deleteCapaianById(long id) {
        capaianRepository.deleteById(id);
    }

    @Override
    public void deleteCapaian(Capaian a) {
        capaianRepository.delete(a);
    }
}
