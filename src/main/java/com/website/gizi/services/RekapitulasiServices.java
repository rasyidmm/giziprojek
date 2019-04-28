package com.website.gizi.services;

import com.website.gizi.dao.RekapitulasiDao;
import com.website.gizi.model.Rekapitulasi;
import com.website.gizi.repository.RekapitulasiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
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
    public List<Rekapitulasi>findRekapitulasiByAktorAndWaktuKegiatanThisMonth(String waktu,long id){
        return rekapitulasiRepository.findRekapitulasiByAktorAndWaktuKegiatanThisMonth(waktu,id);
    }
    public List<Rekapitulasi>findRekapitulasiByAktorAndWaktuKegiatanLastMonth(String waktu,long id){
        return rekapitulasiRepository.findRekapitulasiByAktorAndWaktuKegiatanLastMonth(waktu,id);
    }
    public Rekapitulasi findByIdAndStatus(long id){
        return rekapitulasiRepository.findByIdAndStatus(id);
    }
    public List<Rekapitulasi> findByStatusPembuatan(){
        return rekapitulasiRepository.findByStatusPembuatan();
    };
    public List<Rekapitulasi> findByStatusMenunggu(){
        return rekapitulasiRepository.findByStatusMenunggu();
    };
    public List<Rekapitulasi> findByStatusSelesai(){
        return rekapitulasiRepository.findByStatusSelesai();
    };
    public List<Rekapitulasi> findByStatusProse(){
        return rekapitulasiRepository.findByStatusProse();
    };
    public List<Rekapitulasi> findByStatusMenunggAndDateSameNow( String waktu){
        return rekapitulasiRepository.findByStatusMenunggAndDateSameNow(waktu);
    }
    public List<Rekapitulasi> findByStatusProsesAndDateKurangNow(String waktu){
        return rekapitulasiRepository.findByStatusProsesAndDateKurangNow(waktu);
    }
}
