package com.website.gizi.services;

import com.website.gizi.dao.WaktuKegiatanDao;
import com.website.gizi.model.WaktuKegiatan;
import com.website.gizi.repository.WaktuKegiatanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class WaktuKegiatanServices implements WaktuKegiatanDao {
    @Autowired
    WaktuKegiatanRepository waktuKegiatanRepository;

    @Override
    public List<WaktuKegiatan> getAllWaktuKegiatan() {
        List<WaktuKegiatan> wkl =  new ArrayList<>();
        waktuKegiatanRepository.findAll().forEach(wkl::add);
        return wkl;
        }

    @Override
    public WaktuKegiatan getWaktuKegiatanById(long id) {
        WaktuKegiatan wk = waktuKegiatanRepository.findById(id).get();
        return wk;
    }

    @Override
    public void SaveOrUpdateWaktuKegiatan(WaktuKegiatan a) {
        waktuKegiatanRepository.save(a);
    }

    @Override
    public void deleteWaktuKegiatanById(long id) {
        waktuKegiatanRepository.deleteById(id);
    }

    @Override
    public void deleteWaktuKegiatan(WaktuKegiatan a) {
        waktuKegiatanRepository.delete(a);
    }
}
