package com.st.challenge.patients.services;

import com.st.challenge.commons.entities.PatientEntity;
import com.st.challenge.commons.enums.Gender;
import com.st.challenge.commons.exceptions.BussinessException;
import com.st.challenge.patients.models.CreatePatientRequest;
import com.st.challenge.patients.models.PatientResponse;
import com.st.challenge.patients.repository.PatientsRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import static org.mockito.Mockito.*;

import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;


@SpringBootTest
public class PatientServiceTest {

    @Mock
    private PatientsRepository patientsRepository;

    @InjectMocks
    @Spy
    private PatientsService patientsService;

    @BeforeEach()
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreatePatientSuccess() {
        CreatePatientRequest createPatientRequest = new CreatePatientRequest();
        createPatientRequest.setFirstName("Andres Felipe");
        createPatientRequest.setGender(Gender.M);
        PatientEntity patientEntity = new PatientEntity();
        patientEntity.setLastName("Florez Caro");
        patientEntity.setGender(Gender.M);
        when(patientsRepository.save(any(PatientEntity.class))).thenReturn(patientEntity);
        PatientResponse patientResponse = patientsService.createPatient(createPatientRequest);
        Assertions.assertEquals(patientResponse.getFirstName(), "Andres Felipe");
        Assertions.assertEquals(patientResponse.getGender(), Gender.M);
    }


    @Test
    public void testDeletePatientSuccess() {
        doNothing().when(patientsRepository).deleteById(anyInt());
        patientsService.deletePatient(1);
        verify(patientsRepository).deleteById(1);
    }

    @Test
    public void getDetailPatient_shouldReturnPatientDetails_whenCalledWithValidId() {
        PatientEntity patientEntity = new PatientEntity();
        Optional<PatientEntity> optionalPatient = Optional.of(patientEntity);

        when(patientsRepository.findById(anyInt())).thenReturn(optionalPatient);

        PatientEntity result = patientsService.getDetailPatient(1);

        Assertions.assertEquals(patientEntity, result);
    }

    @Test
    public void getDetailPatient_shouldThrowBussinessException_whenCalledWithInvalidId() {
        when(patientsRepository.findById(anyInt())).thenReturn(Optional.empty());

       Assertions.assertThrows(BussinessException.class, () -> patientsService.getDetailPatient(1));
    }

}
