package com.st.challenge.patients.services;

import com.st.challenge.commons.constants.MessageConstants;
import com.st.challenge.commons.exceptions.BussinessException;
import com.st.challenge.commons.utils.Utils;
import com.st.challenge.patients.entities.PatientEntity;
import com.st.challenge.patients.models.CreatePatientRequest;
import com.st.challenge.patients.models.PatientResponse;
import com.st.challenge.patients.models.GetPatientsListResponse;
import com.st.challenge.patients.models.UpdatePatientRequest;
import com.st.challenge.patients.repository.PatientsRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PatientsService {

    private PatientsRepository patientsRepository;

    @Autowired
    public PatientsService(PatientsRepository patientsRepository) {
        this.patientsRepository = patientsRepository;
    }

    public PatientResponse createPatient(CreatePatientRequest createPatientRequest) {
        PatientEntity patientEntity = new PatientEntity();
        BeanUtils.copyProperties(createPatientRequest, patientEntity);
        patientsRepository.save(patientEntity);
        return Utils.patientEntToPatientResponse(patientEntity);
    }

    public GetPatientsListResponse getPatientsList(Integer size, Integer pageSize) {
        Pageable pageable = PageRequest.of(size, pageSize);
        Page<PatientEntity> patientsPage = this.patientsRepository.findAll(pageable);
        return GetPatientsListResponse.builder()
                .hasPrevious(patientsPage.hasPrevious())
                .hasNext(patientsPage.hasNext())
                .data(patientsPage.stream().toList()).build();
    }

    public PatientResponse getDetailPatient(Integer patientId) {
        Optional<PatientEntity> optionalPatient = this.patientsRepository.findById(patientId);
        PatientEntity patientEntity = optionalPatient.orElseThrow(() -> BussinessException.builder()
                .code(HttpStatus.NOT_FOUND)
                .message(MessageConstants.PATIENT_NOT_FOUND).build());
        return Utils.patientEntToPatientResponse(patientEntity);
    }

    public PatientResponse updatePatient(Integer patientId, UpdatePatientRequest updatePatientRequest) {
        Optional<PatientEntity> optionalPatient = this.patientsRepository.findById(patientId);
        PatientEntity patientEntity = optionalPatient.orElseThrow(() -> BussinessException.builder()
                .code(HttpStatus.NOT_FOUND)
                .message(MessageConstants.PATIENT_NOT_FOUND).build());
        BeanUtils.copyProperties(updatePatientRequest, patientEntity);
        patientsRepository.save(patientEntity);
        return Utils.patientEntToPatientResponse(patientEntity);
    }

    public void deletePatient(Integer patientId) {
        try {
            patientsRepository.deleteById(patientId);
        } catch (EmptyResultDataAccessException ex) {
            throw BussinessException.builder()
                    .code(HttpStatus.NOT_FOUND)
                    .message(MessageConstants.PATIENT_NOT_FOUND).build();
        }
    }
}
