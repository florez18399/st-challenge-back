package com.st.challenge.patients.services;

import com.st.challenge.commons.constants.MessageConstants;
import com.st.challenge.commons.enums.Gender;
import com.st.challenge.commons.exceptions.BussinessException;
import com.st.challenge.commons.utils.PatientSpecifications;
import com.st.challenge.commons.utils.Utils;
import com.st.challenge.commons.entities.PatientEntity;
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
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class PatientsService implements PatientsServiceI{

    private PatientsRepository patientsRepository;

    @Autowired
    public PatientsService(PatientsRepository patientsRepository) {
        this.patientsRepository = patientsRepository;
    }

    @Override
    public PatientResponse createPatient(CreatePatientRequest createPatientRequest) {
        PatientEntity patientEntity = new PatientEntity();
        BeanUtils.copyProperties(createPatientRequest, patientEntity);
        patientsRepository.save(patientEntity);
        return Utils.patientEntToPatientResponse(patientEntity);
    }

    @Override
    public GetPatientsListResponse getPatientsList(Integer size, Integer pageSize, String filterByName, Gender filterByGender) {
        Pageable pageable = PageRequest.of(size, pageSize);
        Page<PatientEntity> patientsPage = this.patientsRepository.findAll(PatientSpecifications.patientCustomFilter(filterByGender, filterByName), pageable);

        return GetPatientsListResponse.builder()
                .hasPrevious(patientsPage.hasPrevious())
                .hasNext(patientsPage.hasNext())
                .data(patientsPage.stream().toList()).build();
    }

    @Override
    public PatientEntity getDetailPatient(Integer patientId) {
        Optional<PatientEntity> optionalPatient = this.patientsRepository.findById(patientId);
        return optionalPatient.orElseThrow(() -> BussinessException.builder()
                .code(HttpStatus.NOT_FOUND)
                .message(MessageConstants.PATIENT_NOT_FOUND).build());
    }

    @Override
    public PatientResponse updatePatient(Integer patientId, UpdatePatientRequest updatePatientRequest) {
        Optional<PatientEntity> optionalPatient = this.patientsRepository.findById(patientId);
        PatientEntity patientEntity = optionalPatient.orElseThrow(() -> BussinessException.builder()
                .code(HttpStatus.NOT_FOUND)
                .message(MessageConstants.PATIENT_NOT_FOUND).build());
        BeanUtils.copyProperties(updatePatientRequest, patientEntity);
        patientsRepository.save(patientEntity);
        return Utils.patientEntToPatientResponse(patientEntity);
    }

    @Override
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
