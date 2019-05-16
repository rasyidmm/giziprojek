package com.website.gizi.repository;

import com.website.gizi.model.Penilaian;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PenilaianRepository extends JpaRepository<Penilaian, Long> {
    @Query(value = "select * from penilaian b where b.rekapitulasi_id =:id",nativeQuery = true)
    public List<Penilaian>findAllByRekapitulasiId(@Param("id")long id);
    @Query(value = "select * from penilaian b where b.kegiatan_id =id",nativeQuery = true)
    public List<Penilaian>findAllByKegiatanId(@Param("id")long id);


}
