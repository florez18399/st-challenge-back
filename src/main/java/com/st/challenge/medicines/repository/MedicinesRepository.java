package com.st.challenge.medicines.repository;

import com.st.challenge.commons.entities.MedicineEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicinesRepository extends JpaRepository<MedicineEntity, Integer> {
}
