package com.st.challenge.commons.constants;

public class MessageConstants {

    public static final String PATIENT_NOT_FOUND = "Paciente no encontrado";

    public static final String GENDER_RULE_EXCEPTION = "No es posible asignar medicamento ya que no corresponde al género del paciente";
    public static final String MAX_PRESCRIPTION_RULE_EXCEPTION = "No es posible asignar medicamento ya que se ya fue prescrito al paciente el último mes o se han prescrito 3 medicamentos el último mes";

    public static final String AGE_PRESCRIPTION_RULE_EXCEPTION = "No es posible asignar medicamento ya que no corresponde a la edad del paciente";
}
