package com.st.challenge.patients.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.st.challenge.commons.enums.Gender;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.Date;

@Data
public class UpdatePatientRequest {
    @NotBlank
    @Size(max=50)
    private String firstName;

    @NotBlank
    @Size(max=50)
    private String lastName;

    @NotNull
    @JsonFormat(pattern = "yyyy-mm-dd")
    private Date birthDate;

    @NotNull
    private Gender gender;
}
