package com.st.challenge.prescriptions.controller;

import com.st.challenge.commons.entities.PrescriptionEntity;
import com.st.challenge.prescriptions.models.GetCountPatientPrescriptionsResponse;
import com.st.challenge.prescriptions.services.PrescriptionsServiceI;
import jakarta.validation.constraints.Min;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/prescriptions")
@Validated
public class PrescriptionsController {

    PrescriptionsServiceI prescriptionsServiceI;

    public PrescriptionsController(PrescriptionsServiceI prescriptionsServiceI) {
        this.prescriptionsServiceI = prescriptionsServiceI;
    }

    @PostMapping
    public ResponseEntity<?> prescribeMedicineToPatient(
            @RequestParam @Min(0) Integer medicineId,
            @RequestParam @Min(0) Integer patientId
    ) {
        this.prescriptionsServiceI.createPrescription(patientId, medicineId);
        return new ResponseEntity<HttpStatus>(HttpStatus.CREATED);
    }

    @GetMapping("/{patientId}")
    public ResponseEntity<List<PrescriptionEntity>> getPatientPrescriptions(@PathVariable Integer patientId) {
        return new ResponseEntity<>(this.prescriptionsServiceI.getPatientPrescription(patientId), HttpStatus.OK);
    }


    @GetMapping("/count/{patientId}")
    public ResponseEntity<GetCountPatientPrescriptionsResponse> countPatientPrescriptionsInLastCountMonth(@PathVariable Integer patientId,
                                                                                                          @RequestParam(required = false, defaultValue = "1") Integer countMonths) {
        return new ResponseEntity<>(GetCountPatientPrescriptionsResponse.builder()
                .count(this.prescriptionsServiceI.countPatientPrescriptionsInLastMonth(patientId, countMonths))
                .build(), HttpStatus.OK);
    }

}
