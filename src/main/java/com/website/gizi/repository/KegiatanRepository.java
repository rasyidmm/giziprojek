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
public interface KegiatanRepository extends JpaRepository<Kegiatan,Long> {
    @Query(value = "SELECT * from kegiatan a left join kegiatan_rekapitulasi b on a.id = b.kegiatan_id where b.rekapitulasi_id =:id ",nativeQuery = true)
    public List<Kegiatan> findKegiatanByRekapitulasiID(@Param("id")long id);
    @Query(value = "SELECT * from kegiatan a full join kegiatan_rekapitulasi b on a.id = b.kegiatan_id where a.tanggal_kegiatan =:waktu and b.rekapitulasi_id !=:id order by a.id desc",nativeQuery = true)
    public List<Kegiatan> findKegiatanNONByRekapitulasiID(@Param("id")long id,@Param("waktu")String waktu);
    @Query(value = "SELECT * FROM kegiatan a LEFT JOIN target_penilaian b on a.id = b.kegiatan_id WHERE b.rekapitulasi_id =:idr ISNULL",nativeQuery = true)
    public List<Kegiatan>findKegiatanNONByTargetPenilaian(@Param("idr")long idr);

}
