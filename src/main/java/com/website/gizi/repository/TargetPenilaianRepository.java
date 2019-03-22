package com.website.gizi.repository;

import com.website.gizi.model.TargetPenilaian;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TargetPenilaianRepository extends JpaRepository<TargetPenilaian,Long> {
}
