package com.st.challenge.patients.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.st.challenge.commons.enums.Gender;
import lombok.Data;

import java.util.Date;

@Data
public class PatientResponse {

    private Integer patientId;

    private String firstName;

    private String lastName;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date birthDate;

    private Gender gender;
}
