package com.accenture.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.accenture.demo.model.Acreditacion;

@Repository
public interface AcreditacionRepository extends JpaRepository<Acreditacion, Long> {
}
