package com.st.challenge.prescriptions.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GetCountPatientPrescriptionsResponse {
    private Integer count;
}
