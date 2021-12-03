package com.misiontic.clinica_ms.repositories;

import com.misiontic.clinica_ms.models.History;
import com.misiontic.clinica_ms.models.Patient;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PatientRepository extends MongoRepository <Patient, Integer> {
}
