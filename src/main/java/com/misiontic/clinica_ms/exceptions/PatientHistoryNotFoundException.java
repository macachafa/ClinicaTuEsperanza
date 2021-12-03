package com.misiontic.clinica_ms.exceptions;

public class PatientHistoryNotFoundException extends RuntimeException{
    public PatientHistoryNotFoundException(String message) {
        super(message);
    }
}
