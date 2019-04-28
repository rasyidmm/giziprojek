package com.website.gizi.repository;

import com.website.gizi.model.Kegiatan;
import com.website.gizi.model.TargetPenilaian;
import org.hibernate.validator.constraints.URL;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KegiatanRepository extends JpaRepository<Kegiatan, Long> {
    @Query(value = "SELECT * from kegiatan a left join kegiatan_rekapitulasi b on a.id = b.kegiatan_id where b.rekapitulasi_id =:id AND a.status = 'Active'", nativeQuery = true)
    public List<Kegiatan> findKegiatanByRekapitulasiID(@Param("id") long id);

    @Query(value = "SELECT * from kegiatan a left join kegiatan_rekapitulasi b on a.id = b.kegiatan_id where a.aktor_id =:ida AND a.tanggal_kegiatan =:waktu and b.rekapitulasi_id is null AND  a.status = 'Active'", nativeQuery = true)
    public List<Kegiatan> findKegiatanNONByRekapitulasiID(@Param("waktu") String waktu, @Param("ida") long ida);

    @Query(value = "SELECT * FROM kegiatan a LEFT JOIN target_penilaian b on a.id = b.kegiatan_id WHERE b.rekapitulasi_id !=:idr and b.nilai_target = null or b.skor_target = null or b.vol_target = null AND  a.status = 'Active'", nativeQuery = true)
    public List<Kegiatan> findKegiatanNONByTargetPenilaian(@Param("idr") long idr);

    @Query(value = "select * from kegiatan d where d.status = 'Active'", nativeQuery = true)
    public List<Kegiatan> findKegiatanByStatusActive();

    @Query(value = "select * from kegiatan d where d.status = 'Deleted'", nativeQuery = true)
    public List<Kegiatan> findKegiatanByStatusDeleted();
}
