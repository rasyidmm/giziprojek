package com.website.gizi.repository;

import com.website.gizi.model.KegiatanRekapitulasi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KegiatanRekapitulasiRepository extends JpaRepository<KegiatanRekapitulasi,Long> {
    @Query(value = "select * from kegiatan_rekapitulasi a where a.rekapitulasi_id =:id and a.status='Proses'",nativeQuery = true)
    public List<KegiatanRekapitulasi> findAllByRekapitulasi(@Param("id")long id);
}
