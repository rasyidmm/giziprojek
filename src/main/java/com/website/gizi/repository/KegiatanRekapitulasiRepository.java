package com.website.gizi.repository;

import com.website.gizi.model.KegiatanRekapitulasi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KegiatanRekapitulasiRepository extends JpaRepository<KegiatanRekapitulasi,Long> {
}
