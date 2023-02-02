package com.st.challenge.medicines.services;

import com.st.challenge.commons.constants.MessageConstants;
import com.st.challenge.commons.entities.MedicineEntity;
import com.st.challenge.commons.exceptions.BussinessException;
import com.st.challenge.medicines.repository.MedicinesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    @Override
    public MedicineEntity getMedicineById(Integer id) {
        return this.medicinesRepository.findById(id).orElseThrow(() -> BussinessException.builder()
                .code(HttpStatus.NOT_FOUND)
                .message(MessageConstants.PATIENT_NOT_FOUND).build());
    }
}
