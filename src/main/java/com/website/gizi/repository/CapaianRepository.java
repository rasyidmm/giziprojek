package com.website.gizi.repository;

import com.website.gizi.model.Capaian;
import org.hibernate.sql.Select;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CapaianRepository extends JpaRepository<Capaian, Long> {
    @Query(value = "select * from capaian a where a.rekapitulasi_id=:id",nativeQuery = true)
    public List<Capaian> findByRekapitulasiId(@Param("id")long id);
    @Query(value = "select * from capaian a where a.kegiatan_id =:id",nativeQuery = true)
    public List<Capaian> findByKegiatanId(@Param("id")long id);
}

