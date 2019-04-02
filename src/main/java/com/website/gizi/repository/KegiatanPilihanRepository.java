package com.website.gizi.repository;


import com.website.gizi.model.Kegiatan;
import com.website.gizi.model.KegiatanPilihan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KegiatanPilihanRepository extends JpaRepository<KegiatanPilihan,Long> {
//    @Query(value = "select * from kegiatan a join kegiatan_pilihan_kegiatan b on a.id = b.kegiatan_id join kegiatan_pilihan c on b.kegiatan_pilihans_id = c.id join waktu_kegiatan d on d.id = c.waktu_kegiatan_id where c.waktu_kegiatan_id =: idwaktuKegiatan and c.nama_keg_rek =:nama_keg_rek",nativeQuery = true)
//    List<Kegiatan>findKegiatanByNamaKegRekAndWaktuKegiatan(@Param("idwaktuKegiatan") long idwaktuKegiatan,@Param("nama_keg_rek")String nama_keg_rek);
}
