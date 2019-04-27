package com.website.gizi.repository;

import com.website.gizi.model.Rekapitulasi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RekapitulasiRepository extends JpaRepository<Rekapitulasi,Long> {
    @Query(value = "select * from Rekapitulasi a where  a.aktor_id =:ida and  a.waktu_kegiatan_id =:idwk",nativeQuery = true)
    public Rekapitulasi findRekapitulasiByAktorAndWaktuKegiatan(@Param("ida")long ida,@Param("idwk")long idwk);
    @Query(value = "select * from rekapitulasi a join waktu_kegiatan b on a.waktu_kegiatan_id = b.id where b.waktu_rekapitulasi =:waktu and a.aktor_id =:id",nativeQuery = true)
    public List<Rekapitulasi>findRekapitulasiByAktorAndWaktuKegiatanThisMonth(@Param("waktu")String waktu,@Param("id")long id);
    @Query(value = "select * from rekapitulasi a join waktu_kegiatan b on a.waktu_kegiatan_id = b.id where b.waktu_rekapitulasi <:waktu and a.aktor_id =:id",nativeQuery = true)
    public List<Rekapitulasi>findRekapitulasiByAktorAndWaktuKegiatanLastMonth(@Param("waktu")String waktu,@Param("id")long id);
}
