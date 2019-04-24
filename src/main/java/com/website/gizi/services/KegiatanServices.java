package com.website.gizi.services;

import com.website.gizi.dao.KegiatanDao;
import com.website.gizi.model.Kegiatan;
import com.website.gizi.repository.KegiatanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class KegiatanServices implements KegiatanDao {
    @Autowired
    KegiatanRepository kegiatanRepository;
    @Override
    public List<Kegiatan> getAllKegiatan() {
        List<Kegiatan> kl = new ArrayList<>();
        kegiatanRepository.findAll().forEach(kl::add);
        return kl;
    }

    @Override
    public Kegiatan getKegiatanById(long id) {
        Kegiatan k =kegiatanRepository.findById(id).get();
        return k;
    }

    @Override
    public void SaveOrUpdateKegiatan(Kegiatan a) {
        kegiatanRepository.save(a);
    }

    @Override
    public void deleteKegiatanById(long id) {
        kegiatanRepository.deleteById(id);
    }

    @Override
    public void deleteKegiatan(Kegiatan a) {
        kegiatanRepository.delete(a);
    }

    public List<Kegiatan> findKegiatanByRekapitulasiID(long id){
        return kegiatanRepository.findKegiatanByRekapitulasiID(id);
    };
    public List<Kegiatan> findKegiatanNONByRekapitulasiID(String waktu,long ida){
        return kegiatanRepository.findKegiatanNONByRekapitulasiID(waktu,ida);
    };

    public List<Kegiatan>findKegiatanNONByTargetPenilaian(long idr){
        return kegiatanRepository.findKegiatanNONByTargetPenilaian(idr);
    };
}
