package com.st.challenge.patients.services;

import com.st.challenge.commons.entities.PatientEntity;
import com.st.challenge.commons.enums.Gender;
import com.st.challenge.patients.models.CreatePatientRequest;
import com.st.challenge.patients.models.GetPatientsListResponse;
import com.st.challenge.patients.models.PatientResponse;
import com.st.challenge.patients.models.UpdatePatientRequest;

public interface PatientsServiceI {

    PatientResponse createPatient(CreatePatientRequest createPatientRequest);

    GetPatientsListResponse getPatientsList(Integer size, Integer pageSize, String filterByName, Gender filterByGender);

    PatientEntity getDetailPatient(Integer patientId);

    PatientResponse updatePatient(Integer patientId, UpdatePatientRequest updatePatientRequest);

    void deletePatient(Integer patientId);

}
