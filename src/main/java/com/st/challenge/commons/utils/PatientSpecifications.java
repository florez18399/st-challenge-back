package com.st.challenge.commons.utils;

import com.st.challenge.commons.entities.PatientEntity;
import com.st.challenge.commons.enums.Gender;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class PatientSpecifications {

    public static Specification<PatientEntity> patientCustomFilter(Gender gender, String name) {
        return new Specification<PatientEntity>() {
            @Override
            public Predicate toPredicate(Root<PatientEntity> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                List<Predicate> predicates = new ArrayList<>();
                if (gender != null) {
                    Predicate predicateGender = cb.equal(root.get("gender"), gender);
                    predicates.add(predicateGender);
                }
                if (name != null) {
                    String lowername = name.toLowerCase().trim();
                    Predicate predicateName = cb.like(cb.lower(root.get("firstName")), "%"+ lowername +"%");
                    Predicate predicateLastName = cb.like(cb.lower(root.get("lastName")), "%"+ lowername +"%");
                    predicates.add(cb.or(predicateName, predicateLastName));
                }
                return cb.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        };
    }
}