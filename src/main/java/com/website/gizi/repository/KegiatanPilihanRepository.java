package com.website.gizi.repository;


import com.website.gizi.model.KegiatanPilihan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KegiatanPilihanRepository extends JpaRepository<KegiatanPilihan,Long> {
}
