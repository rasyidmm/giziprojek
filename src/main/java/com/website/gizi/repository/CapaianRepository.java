package com.website.gizi.repository;

import com.website.gizi.model.Capaian;
import org.hibernate.sql.Select;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CapaianRepository extends JpaRepository<Capaian, Long> {
    @Query(value = "select * from capaian a where a.rekapitulasi_id=:id",nativeQuery = true)
    public Capaian findByRekapitulasiId(@Param("id")long id);
}

