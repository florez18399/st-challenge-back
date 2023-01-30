package com.st.challenge.commons.entities;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.google.gson.annotations.SerializedName;
import com.st.challenge.commons.enums.Gender;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "MEDICINES")
@Data
public class MedicineEntity {

    @Id
    @Column(name = "medicine_id")
    @SerializedName("id")
    private Integer medicineId;

    @Column(name = "medicine_name")
    @SerializedName("name")
    private String name;

    @Column(name = "min_age_consumption")
    @SerializedName("min_age")
    private Integer minAgeConsumption;

    @Column(name = "max_age_consumption")
    @SerializedName("max_age")
    private Integer maxAgeConsumption;

    @Column(name = "gender_consumption")
    @Enumerated(EnumType.STRING)
    @SerializedName("single_gender")
    private Gender genderConsumption;
}
