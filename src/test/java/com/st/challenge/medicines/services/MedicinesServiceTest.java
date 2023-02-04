package com.st.challenge.medicines.services;

import com.st.challenge.commons.entities.MedicineEntity;
import com.st.challenge.commons.enums.Gender;
import com.st.challenge.medicines.repository.MedicinesRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class MedicinesServiceTest {

    @Mock
    private MedicinesRepository medicinesRepository;

    @InjectMocks
    private MedicinesService medicinesService;

    private MedicineEntity expectedMedicine;

    @BeforeEach
    public void setUp() {
        expectedMedicine = new MedicineEntity();
        expectedMedicine.setMedicineId(1);
        expectedMedicine.setMaxAgeConsumption(70);
        expectedMedicine.setMinAgeConsumption(18);
        expectedMedicine.setGenderConsumption(Gender.M);
        expectedMedicine.setName("Sildenafil");
    }

    @Test
    public void getMedicineById_Success() {
        when(medicinesRepository.findById(1)).thenReturn(java.util.Optional.of(expectedMedicine));

        MedicineEntity actualMedicine = medicinesService.getMedicineById(1);

        Assertions.assertEquals(expectedMedicine, actualMedicine);
    }

    @Test
    public void testListMedicines() {
        List<MedicineEntity> medicineList;
        medicineList = Arrays.asList(expectedMedicine, expectedMedicine, expectedMedicine);
        when(medicinesRepository.findAll()).thenReturn(medicineList);
        List<MedicineEntity> result = medicinesService.listMedicines();
        Assertions.assertEquals(medicineList, result);
    }

}
