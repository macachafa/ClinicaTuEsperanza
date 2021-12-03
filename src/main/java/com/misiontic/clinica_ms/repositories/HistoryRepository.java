package com.misiontic.clinica_ms.repositories;

import com.misiontic.clinica_ms.models.History;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface HistoryRepository extends MongoRepository <History, Integer> {
    List<History> findByPatientDocument (Integer patientDocument);
}
