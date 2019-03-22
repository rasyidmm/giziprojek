package com.website.gizi.repository;

import com.website.gizi.model.Kegiatan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KegiatanRepository extends JpaRepository<Kegiatan,Long> {
}
