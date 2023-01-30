package com.st.challenge.medicines.controller;

import com.st.challenge.commons.entities.MedicineEntity;
import com.st.challenge.medicines.services.MedicinesServiceI;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/medicines")
public class MedicinesController {

    MedicinesServiceI medicinesServiceI;

    public MedicinesController(MedicinesServiceI medicinesServiceI) {
        this.medicinesServiceI = medicinesServiceI;
    }

    @GetMapping
    public List<MedicineEntity> listMedicines() {
        return this.medicinesServiceI.listMedicines();
    }

}
