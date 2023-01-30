package com.st.challenge.patients.repository;

import com.st.challenge.commons.entities.PatientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientsRepository extends JpaRepository<PatientEntity, Integer> {
}
