package com.website.gizi.repository;

import com.website.gizi.model.AktorPilihan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AktorPilihanRepository extends JpaRepository<AktorPilihan,Long> {

}
