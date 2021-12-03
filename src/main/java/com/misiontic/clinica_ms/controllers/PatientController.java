package com.misiontic.clinica_ms.controllers;

import com.misiontic.clinica_ms.exceptions.PatientNotFoundException;
import com.misiontic.clinica_ms.models.Patient;
import com.misiontic.clinica_ms.repositories.PatientRepository;
import org.springframework.web.bind.annotation.*;

@RestController
public class PatientController {
    private final PatientRepository patientRepository;

    public PatientController(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @GetMapping("/patient/{id}")
     Patient getPatient(@PathVariable Integer document){
        return patientRepository.findById(document)
                .orElseThrow(() -> new PatientNotFoundException("No se encontró paciente con el ID: " + document));
    }

    @PostMapping("/patient")
    Patient newPatient(@RequestBody Patient patient){
        return patientRepository.save(patient);
    }

    @PutMapping("/patient/{id}")
    Patient updatePatient(@PathVariable Integer document, @RequestBody Patient patient){
        Patient patientDB = patientRepository
                .findById(document)
                .orElseThrow(() -> new PatientNotFoundException("No se puede actualizar paciente con el ID: " + document));

        patientDB.setId(patient.getId());
        patientDB.setName(patient.getName());
        patientDB.setTelephone(patient.getTelephone());
        patientDB.setAge(patient.getAge());
        patientDB.setCity(patient.getCity());
        patientDB.setGender(patient.getGender());
        patientDB.setMarital_status(patient.getMarital_status());

        return patientRepository.save(patientDB);
    }

    @DeleteMapping("/patient/{id}")
    void deletePatient(@PathVariable Integer document){
        Patient patient = patientRepository
                .findById(document)
                .orElseThrow(() -> new PatientNotFoundException("No se puede eliminar paciente con el ID: " + document));
        patientRepository.delete(patient);
    }
}
