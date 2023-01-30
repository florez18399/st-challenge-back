package com.st.challenge.medicines.config;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.st.challenge.commons.entities.MedicineEntity;
import com.st.challenge.medicines.repository.MedicinesRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


@Configuration
public class LoadMedicinesConfiguration {

    private MedicinesRepository medicineRepository;

    public LoadMedicinesConfiguration(MedicinesRepository medicineRepository) {
        this.medicineRepository = medicineRepository;
    }

    @PostConstruct
    public void loadMedicines() throws IOException, URISyntaxException {
        ClassLoader loader = ClassLoader.getSystemClassLoader();
        String json = Files.lines(Paths.get(Objects.requireNonNull(loader.getResource("static/medicamentos.json")).toURI())).parallel()
                .collect(Collectors.joining()).toString();
        Gson gson = new Gson();
        List<MedicineEntity> medicines = gson.fromJson(json, new TypeToken<List<MedicineEntity>>(){}.getType());

        medicines.forEach((MedicineEntity m) -> System.err.println(m.toString()));

        medicineRepository.saveAll(medicines);
    }
}
