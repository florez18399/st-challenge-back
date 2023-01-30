package com.st.challenge.commons.entities;

import com.st.challenge.commons.enums.Gender;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "PATIENTS")
@Data
public class PatientEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PATIENTS_SEQ")
    @SequenceGenerator(name = "PATIENTS_SEQ", sequenceName = "PATIENTS_SEQ", allocationSize = 1)
    @Column(name = "patient_id")
    private Integer patientId;

    @Column(name = "patient_first_name")
    private String firstName;

    @Column(name = "patient_last_name")
    private String lastName;

    @Column(name = "patient_birth_date")
    @Temporal(TemporalType.DATE)
    private Date birthDate;

    @Column(name = "patient_gender")
    @Enumerated(EnumType.STRING)
    private Gender gender;
}
