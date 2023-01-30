package com.st.challenge.commons.utils;

import com.st.challenge.commons.entities.PatientEntity;
import com.st.challenge.patients.models.PatientResponse;
import org.springframework.beans.BeanUtils;

public class Utils {

    public static PatientResponse patientEntToPatientResponse (PatientEntity patientEntity) {
        PatientResponse patientResponse = new PatientResponse();
        BeanUtils.copyProperties(patientEntity, patientResponse);
        return patientResponse;
    }
}
