package com.website.gizi.repository;

import com.website.gizi.model.Capaian;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CapaianRepository extends JpaRepository<Capaian,Long> {
}
