package com.website.gizi.repository;

import com.website.gizi.model.WaktuKegiatan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WaktuKegiatanRepository extends JpaRepository<WaktuKegiatan,Long> {
    @Query(value = "select a.waktuRekapitulasi from WaktuKegiatan a where a.waktuRekapitulasi =:waktu ")
   List<WaktuKegiatan> findWaktuKegiatanByWakturekapitulasi(@Param("waktu")String waktu);
}
