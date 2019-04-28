package com.website.gizi.repository;

import com.website.gizi.model.Penilaian;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PenilaianRepository extends JpaRepository<Penilaian, Long> {
}
