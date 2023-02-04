package com.st.challenge.prescriptions.services;

import com.st.challenge.commons.constants.MessageConstants;
import com.st.challenge.commons.entities.MedicineEntity;
import com.st.challenge.commons.entities.PatientEntity;
import com.st.challenge.commons.entities.PrescriptionEntity;
import com.st.challenge.commons.exceptions.BussinessException;
import com.st.challenge.medicines.services.MedicinesService;
import com.st.challenge.patients.services.PatientsService;
import com.st.challenge.prescriptions.repository.PrescriptionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PrescriptionsService implements PrescriptionsServiceI {

    private PrescriptionsRepository prescriptionsRepository;

    private PatientsService patientsService;

    private MedicinesService medicinesService;

    @Autowired
    public PrescriptionsService(PrescriptionsRepository prescriptionsRepository,
                                PatientsService patientsService,
                                MedicinesService medicinesService) {
        this.prescriptionsRepository = prescriptionsRepository;
        this.patientsService = patientsService;
        this.medicinesService = medicinesService;
    }

    @Override
    public PrescriptionEntity createPrescription(Integer patientId, Integer medicineId) {
        MedicineEntity medicine = medicinesService.getMedicineById(medicineId);
        PatientEntity patient = patientsService.getDetailPatient(patientId);
        Integer patientAge = patient.calculateAge();

        if (countPatientPrescriptionsInLastMonth(patientId, -1) >= 3
                || prescriptionsRepository.countMedicinePrescribedInMonth(patientId, medicineId) >= 1) {
            throw BussinessException.builder()
                    .code(HttpStatus.BAD_REQUEST)
                    .message(MessageConstants.MAX_PRESCRIPTION_RULE_EXCEPTION).build();
        }

        if (medicine.getGenderConsumption() != null && medicine.getGenderConsumption() != patient.getGender()) {
            throw BussinessException.builder()
                    .code(HttpStatus.BAD_REQUEST)
                    .message(MessageConstants.GENDER_RULE_EXCEPTION).build();
        }

        if (medicine.getMaxAgeConsumption() != null && medicine.getMaxAgeConsumption() < patientAge ||
                medicine.getMinAgeConsumption() != null && medicine.getMinAgeConsumption() > patientAge
        ) {
            throw BussinessException.builder()
                    .code(HttpStatus.BAD_REQUEST)
                    .message(MessageConstants.AGE_PRESCRIPTION_RULE_EXCEPTION).build();
        }

        PrescriptionEntity prescriptionEntity = new PrescriptionEntity();
        prescriptionEntity.setMedicine(medicine);
        prescriptionEntity.setPatient(patient);
        prescriptionEntity.setPrescriptionDate(new Date());

        prescriptionsRepository.save(prescriptionEntity);

        return prescriptionEntity;
    }


    @Override
    public List<PrescriptionEntity> getPatientPrescription(Integer patientId) {
        return this.prescriptionsRepository.getByPatientId(patientId);
    }

    @Override
    public Integer countPatientPrescriptionsInLastMonth(Integer patientId, Integer countMonths) {
        return prescriptionsRepository.countPrescriptionsLastMonth(patientId, countMonths*-1);
    }
}
