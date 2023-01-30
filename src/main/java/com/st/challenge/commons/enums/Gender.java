package com.st.challenge.commons.enums;

import lombok.Getter;
import lombok.Setter;

@Getter
public enum Gender {
    M("MASCULINO"), F("FEMENINO");
    private String text;

    private Gender(String text) {
        this.text = text;
    }
}
