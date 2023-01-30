package com.st.challenge.commons.enums;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;

@Getter
public enum Gender {
    @SerializedName("MALE")
    M("MASCULINO"),
    @SerializedName("FEMALE")
    F("FEMENINO");
    private String text;

    private Gender(String text) {
        this.text = text;
    }
}
