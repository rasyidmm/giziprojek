package com.website.gizi.repository;

import com.website.gizi.model.Rekapitulasi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RekapitulasiRepository extends JpaRepository<Rekapitulasi,Long> {
    @Query(value = "select * from Rekapitulasi a where  a.aktor_id =:ida and  a.waktu_kegiatan_id =:idwk",nativeQuery = true)
    public Rekapitulasi findRekapitulasiByAktorAndWaktuKegiatan(@Param("ida")long ida,@Param("idwk")long idwk);
}
