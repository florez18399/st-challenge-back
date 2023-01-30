package com.st.challenge.medicines.services;

import com.st.challenge.commons.entities.MedicineEntity;
import com.st.challenge.medicines.repository.MedicinesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicinesService implements MedicinesServiceI {

    private MedicinesRepository medicinesRepository;

    @Autowired
    public MedicinesService(MedicinesRepository medicinesRepository) {
        this.medicinesRepository = medicinesRepository;
    }


    @Override
    public List<MedicineEntity> listMedicines() {
        return this.medicinesRepository.findAll();
    }
}
