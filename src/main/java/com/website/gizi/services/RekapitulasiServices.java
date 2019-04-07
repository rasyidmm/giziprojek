package com.website.gizi.services;

import com.website.gizi.dao.RekapitulasiDao;
import com.website.gizi.model.Rekapitulasi;
import com.website.gizi.repository.RekapitulasiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RekapitulasiServices implements RekapitulasiDao {
    @Autowired
    RekapitulasiRepository rekapitulasiRepository;

    @Override
    public List<Rekapitulasi> getAllRekapitulasi() {
        List<Rekapitulasi> rl =  new ArrayList<>();
        rekapitulasiRepository.findAll().forEach(rl::add);
        return rl;
    }

    @Override
    public Rekapitulasi getRekapitulasiById(long id) {
        Rekapitulasi r = rekapitulasiRepository.findById(id).get();
        return r;
    }

    @Override
    public void SaveOrUpdateRekapitulasi(Rekapitulasi a) {
        rekapitulasiRepository.save(a);
    }

    @Override
    public void deleteRekapitulasiById(long id) {
        rekapitulasiRepository.deleteById(id);
    }

    @Override
    public void deleteRekapitulasi(Rekapitulasi a) {
        rekapitulasiRepository.delete(a);
    }

    public Rekapitulasi findRekapitulasiByAktorAndWaktuKegiatan(long ida,long idwk){
        return rekapitulasiRepository.findRekapitulasiByAktorAndWaktuKegiatan(ida,idwk);
    }
}
