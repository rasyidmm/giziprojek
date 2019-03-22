package com.website.gizi.repository;

import com.website.gizi.model.WaktuKegiatan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WaktuKegiatanRepository extends JpaRepository<WaktuKegiatan,Long> {
}
