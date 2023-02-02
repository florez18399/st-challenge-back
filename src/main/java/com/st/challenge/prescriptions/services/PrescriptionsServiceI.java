package com.st.challenge.prescriptions.services;

import com.st.challenge.commons.entities.PrescriptionEntity;

import java.util.List;

public interface PrescriptionsServiceI {

     void createPrescription(Integer patientId, Integer medicineId);

     List<PrescriptionEntity> getPatientPrescription(Integer patientId);

     Integer countPatientPrescriptionsInLastMonth(Integer patientId, Integer countMonths);
}
