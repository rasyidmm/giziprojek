package com.website.gizi.repository;

import com.website.gizi.model.Aktor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AktorRepository extends JpaRepository<Aktor, Long> {

}
