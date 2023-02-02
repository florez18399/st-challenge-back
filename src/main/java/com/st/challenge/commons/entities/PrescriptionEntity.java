package com.st.challenge.commons.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "PRESCRIPTIONS")
@Data
public class PrescriptionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PRESCRIPTIONS_SEQ")
    @SequenceGenerator(name = "PRESCRIPTIONS_SEQ", sequenceName = "PRESCRIPTIONS_SEQ", allocationSize = 1)
    @Column(name = "prescription_id")
    private Integer prescriptionId;

    @ManyToOne(optional = false)
    @JoinColumn(name = "patient_id")
    private PatientEntity patient;

    @ManyToOne(optional = false)
    @JoinColumn(name = "medicine_id")
    private MedicineEntity medicine;

    @Column(name = "prescription_date")
    @Temporal(TemporalType.DATE)
    private Date prescriptionDate;
}
