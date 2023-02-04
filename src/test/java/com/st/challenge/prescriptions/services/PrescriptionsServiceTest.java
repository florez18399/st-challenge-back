package com.st.challenge.prescriptions.services;

import com.st.challenge.commons.entities.MedicineEntity;
import com.st.challenge.commons.entities.PatientEntity;
import com.st.challenge.commons.entities.PrescriptionEntity;
import com.st.challenge.commons.enums.Gender;
import com.st.challenge.medicines.services.MedicinesService;
import com.st.challenge.patients.repository.PatientsRepository;
import com.st.challenge.patients.services.PatientsService;
import com.st.challenge.prescriptions.repository.PrescriptionsRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import static org.mockito.Mockito.*;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

@SpringBootTest
public class PrescriptionsServiceTest {

    @Mock
    private MedicinesService medicinesService;

    @Mock
    private PrescriptionsRepository prescriptionsRepository;

    @Mock
    private PatientsService patientsService;

    @InjectMocks
    private PrescriptionsService prescriptionsService;

    @BeforeEach()
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void createPrescription_validData_prescriptionCreated() {
        Integer patientId = 1;
        Integer medicineId = 2;

        MedicineEntity medicine = new MedicineEntity();
        medicine.setMedicineId(medicineId);

        Calendar cal = new GregorianCalendar();
        cal.setTime(new Date());
        cal.add(Calendar.YEAR, -30);

        PatientEntity patient = new PatientEntity();
        patient.setPatientId(patientId);
        patient.setBirthDate(cal.getTime());
        patient.setGender(Gender.M);

        when(medicinesService.getMedicineById(medicineId)).thenReturn(medicine);
        when(patientsService.getDetailPatient(patientId)).thenReturn(patient);
        when(prescriptionsRepository.countPrescriptionsLastMonth(patientId, -1)).thenReturn(2);
        when(prescriptionsRepository.countMedicinePrescribedInMonth(patientId, medicineId)).thenReturn(0);

        // Act
        PrescriptionEntity prescription = prescriptionsService.createPrescription(patientId, medicineId);

        // Assert
        verify(medicinesService, times(1)).getMedicineById(medicineId);
        verify(patientsService, times(1)).getDetailPatient(patientId);
        verify(prescriptionsRepository, times(1)).save(prescription);
        Assertions.assertNotNull(prescription);
    }
}
