package com.st.challenge.patients.models;

import com.st.challenge.commons.entities.PatientEntity;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class GetPatientsListResponse {

    private Boolean hasNext;

    private Boolean hasPrevious;

    private List<PatientEntity> data;

}
