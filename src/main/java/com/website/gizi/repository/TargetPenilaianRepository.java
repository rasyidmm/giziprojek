package com.website.gizi.repository;

import com.website.gizi.model.TargetPenilaian;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TargetPenilaianRepository extends JpaRepository<TargetPenilaian,Long> {
    @Query(value = "SELECT * FROM target_penilaian a where a.rekapitulasi_id =:idr ",nativeQuery = true)
    public List<TargetPenilaian> findKegiatanByTargetPenilaian(@Param("idr")long idr);
}
