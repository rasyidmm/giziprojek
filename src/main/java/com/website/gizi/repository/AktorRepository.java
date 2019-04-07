package com.website.gizi.repository;

import com.website.gizi.model.Aktor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AktorRepository extends JpaRepository<Aktor, Long> {
    @Query(value = "SELECT * FROM aktor a LEFT JOIN rekapitulasi b ON a.id = b.aktor_id  WHERE b.waktu_kegiatan_id =:id is null ",nativeQuery = true)
    public List<Aktor> findAktorByWaktu(@Param("id")long id);

}
