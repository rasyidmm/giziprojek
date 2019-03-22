package com.website.gizi.services;

import com.website.gizi.dao.KegiatanPilihanDao;
import com.website.gizi.model.KegiatanPilihan;
import com.website.gizi.repository.KegiatanPilihanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class KegiatanPilihanServices implements KegiatanPilihanDao {
    @Autowired
    KegiatanPilihanRepository kegiatanPilihanRepository;
    @Override
    public List<KegiatanPilihan> getAllKegiatanPilihan() {
        List<KegiatanPilihan> kpl  = new ArrayList<>();
        kegiatanPilihanRepository.findAll().forEach(kpl::add);
        return kpl;
    }

    @Override
    public KegiatanPilihan getKegiatanPilihanById(long id) {
        KegiatanPilihan kp = kegiatanPilihanRepository.findById(id).get();
        return kp;
    }

    @Override
    public void SaveOrUpdateKegiatanPilihan(KegiatanPilihan a) {
        kegiatanPilihanRepository.save(a);
    }

    @Override
    public void deleteKegiatanPilihanById(long id) {
        kegiatanPilihanRepository.deleteById(id);
    }

    @Override
    public void deleteKegiatanPilihan(KegiatanPilihan a) {
        kegiatanPilihanRepository.delete(a);
    }
}
