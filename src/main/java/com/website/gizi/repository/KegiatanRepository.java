package com.website.gizi.repository;

import com.website.gizi.model.Kegiatan;
import org.hibernate.validator.constraints.URL;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KegiatanRepository extends JpaRepository<Kegiatan,Long> {
    @Query(value = "select * from kegiatan a left join kegiatan_rekapitulasi b on a.id = b.kegiatan_id where b.rekapitulasi_id =:id ",nativeQuery = true)
    public List<Kegiatan> findKegiatanByRekapitulasiID(@Param("id")long id);
    @Query(value = "select * from kegiatan a left join kegiatan_rekapitulasi b on a.id = b.kegiatan_id where b.rekapitulasi_id =:id is null ",nativeQuery = true)
    public List<Kegiatan> findKegiatanNONByRekapitulasiID(@Param("id")long id);
}
