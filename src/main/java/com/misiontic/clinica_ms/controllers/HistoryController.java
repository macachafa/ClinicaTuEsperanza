package com.misiontic.clinica_ms.controllers;

import com.misiontic.clinica_ms.exceptions.PatientHistoryNotFoundException;
import com.misiontic.clinica_ms.exceptions.PatientNotFoundException;
import com.misiontic.clinica_ms.models.History;
import com.misiontic.clinica_ms.models.Patient;
import com.misiontic.clinica_ms.repositories.HistoryRepository;
import com.misiontic.clinica_ms.repositories.PatientRepository;
import org.springframework.web.bind.annotation.*;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@RestController
public class HistoryController {
    private final HistoryRepository historyRepository;
    private final PatientRepository patientRepository;

    public HistoryController(PatientRepository patientRepository, HistoryRepository historyRepository, PatientRepository patientRepository1) {
        this.historyRepository = historyRepository;
        this.patientRepository = patientRepository1;
    }

    @GetMapping("/history/{patientDocument}")
    History getPatientHistory(@PathVariable Integer patientDocument) {
        return historyRepository.findById(patientDocument)
                .orElseThrow(() -> new PatientHistoryNotFoundException("No se encontro una cuenta con el username: " + patientDocument));
    }

    @PostMapping("/history")
    History newPatientHistory(@RequestBody History patientHistory){
        return historyRepository.save(patientHistory);
    }

    @PutMapping("/history/{patientDocument}")
    History updatePatientHistory(@PathVariable Integer patientDocument, @RequestBody History patientHistoryId){
        History patientHistoryDB = historyRepository
                .findById(patientDocument)
                .orElseThrow(() -> new PatientHistoryNotFoundException("No se puede actualizar historia clinica del paciente con el ID: " + patientDocument));

        patientHistoryDB.setPatientDocument(patientHistoryId.getPatientDocument());
        patientHistoryDB.setVisit(patientHistoryId.getVisit());
        patientHistoryDB.setDescription(patientHistoryId.getDescription());

        return historyRepository.save(patientHistoryDB);
    }

    @DeleteMapping("/history/{patientDocument}")
    void deletePatientHistory(@PathVariable Integer patientDocument){
        History patientHistory = historyRepository
                .findById(patientDocument)
                .orElseThrow(() -> new PatientHistoryNotFoundException("No se puede eliminar historia del paciente con el ID: " + patientDocument));
        historyRepository.delete(patientHistory);
    }

}
