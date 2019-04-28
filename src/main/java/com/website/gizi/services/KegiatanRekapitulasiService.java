package com.website.gizi.services;

import com.website.gizi.dao.KegiatanRekapitulasiDao;
import com.website.gizi.model.KegiatanRekapitulasi;
import com.website.gizi.repository.KegiatanRekapitulasiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class KegiatanRekapitulasiService implements KegiatanRekapitulasiDao {
    @Autowired
    KegiatanRekapitulasiRepository kegiatanRekapitulasiRepository;

    @Override
    public List<KegiatanRekapitulasi> getAllKegiatanRekapitulasi() {
        List<KegiatanRekapitulasi> krl = new ArrayList<>();
        kegiatanRekapitulasiRepository.findAll().forEach(krl::add);
        return krl;
    }

    @Override
    public KegiatanRekapitulasi getKegiatanRekapitulasiById(long id) {
        KegiatanRekapitulasi kr = kegiatanRekapitulasiRepository.findById(id).get();
        return kr;
    }

    @Override
    public void SaveOrUpdateKegiatanRekapitulasi(KegiatanRekapitulasi a) {
        kegiatanRekapitulasiRepository.save(a);
    }

    @Override
    public void deleteKegiatanRekapitulasiById(long id) {
        kegiatanRekapitulasiRepository.deleteById(id);
    }

    @Override
    public void deleteKegiatanRekapitulasi(KegiatanRekapitulasi a) {
        kegiatanRekapitulasiRepository.delete(a);
    }

    public List<KegiatanRekapitulasi> findAllByRekapitulasi(long id) {
        return kegiatanRekapitulasiRepository.findAllByRekapitulasi(id);
    }
}
