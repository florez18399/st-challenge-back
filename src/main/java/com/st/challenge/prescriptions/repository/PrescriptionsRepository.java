package com.st.challenge.prescriptions.repository;

import com.st.challenge.commons.entities.PrescriptionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PrescriptionsRepository extends JpaRepository<PrescriptionEntity, Integer> {

    @Query("SELECT pe FROM PrescriptionEntity pe WHERE pe.patient.patientId = ?1")
    List<PrescriptionEntity> getByPatientId(Integer patient_id);

    /**
     * Consulta para validar la cantidad de prescripciones realizadas a un paciente en los ultimos n meses
     * @param patientId
     * @param patientId
     * @return Cantidad de prescripciones a un paciente en los últimos n meses
     */
    @Query(value = "SELECT COUNT(p.PRESCRIPTION_ID) FROM PRESCRIPTIONS p\n" +
            "WHERE p.PRESCRIPTION_DATE BETWEEN DATEADD(MONTH, :countMonths, CURRENT_TIMESTAMP()) AND CURRENT_TIMESTAMP()\n" +
            "AND p.PATIENT_ID = :patientId", nativeQuery = true)
    Integer countPrescriptionsLastMonth(@Param("patientId") Integer patientId, @Param("countMonths") Integer countMonths);

    /**
     * Consulta para validar la cantidad de veces que se ha prescrito un medicamento a un paciente en el último mes
     * @param patientId
     * @return Cantidad de prescripciones realizadas a un paciente y de un medicamento específico teniendo en cuenta el último mes
     */
    @Query(value = "SELECT COUNT(p.PRESCRIPTION_ID) FROM PRESCRIPTIONS p\n" +
            "WHERE p.PRESCRIPTION_DATE BETWEEN DATEADD(MONTH, -1, CURRENT_TIMESTAMP()) AND CURRENT_TIMESTAMP()\n" +
            "AND p.PATIENT_ID = :patientId \n" +
            "AND p.MEDICINE_ID = :medicineId ;", nativeQuery = true)
    Integer countMedicinePrescribedInMonth(@Param("patientId") Integer patientId, @Param("medicineId") Integer medicineId);
}
