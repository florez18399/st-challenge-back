package com.st.challenge.patients.controller;

import com.st.challenge.commons.enums.Gender;
import com.st.challenge.commons.utils.Utils;
import com.st.challenge.patients.models.CreatePatientRequest;
import com.st.challenge.patients.models.PatientResponse;
import com.st.challenge.patients.models.GetPatientsListResponse;
import com.st.challenge.patients.models.UpdatePatientRequest;
import com.st.challenge.patients.services.PatientsServiceI;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/patients")
@Validated
public class PatientsController {

    PatientsServiceI patientsService;

    @Autowired
    public PatientsController(PatientsServiceI patientsService) {
        this.patientsService = patientsService;
    }

    @GetMapping
    public GetPatientsListResponse listPatients(@RequestParam(defaultValue = "1") @Min(0) Integer page,
                                                 @RequestParam(defaultValue = "10") @Min(1) Integer pageSize,
                                                 @RequestParam(required = false) String filterByName,
                                                @RequestParam(required = false) Gender filterByGender
                                                ) {
        return patientsService.getPatientsList(page, pageSize, filterByName, filterByGender);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public PatientResponse createPatient(@Valid @RequestBody CreatePatientRequest createPatientRequest) {
        return patientsService.createPatient(createPatientRequest);
    }

    @GetMapping("/{patientId}")
    public PatientResponse getDetailPatient(@PathVariable @Min(0) Integer patientId) {
        return Utils.patientEntToPatientResponse(patientsService.getDetailPatient(patientId));
    }

    @PatchMapping(value = "/{patientId}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public PatientResponse updatePatients(@PathVariable @Min(0) Integer patientId,
                                          @Valid @RequestBody UpdatePatientRequest updatePatientRequest) {
        return patientsService.updatePatient(patientId, updatePatientRequest);
    }

    @DeleteMapping(value = "/{patientId}")
    public ResponseEntity<?> deletePatient(@PathVariable @Min(0) Integer patientId) {
        patientsService.deletePatient(patientId);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }

}

