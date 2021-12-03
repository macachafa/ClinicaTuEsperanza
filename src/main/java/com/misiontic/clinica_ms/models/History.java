package com.misiontic.clinica_ms.models;

import org.springframework.data.annotation.Id;

import java.util.Date;

public class History {

    @Id
    private Integer patientDocument;
    private  Date visit;
    private String description;
    private String prescription;


    public History(Integer patientDocument, Date visit, String description, String prescription) {
        this.patientDocument = patientDocument;
        this.visit = visit;
        this.description = description;
        this.prescription = prescription;
    }

    public String getPrescription() {return prescription;}

    public void setPrescription(String prescription) {this.prescription = prescription;}

    public Integer getPatientDocument() {
        return patientDocument;
    }

    public void setPatientDocument(Integer patientDocument) {
        this.patientDocument = patientDocument;
    }

    public Date getVisit() {
        return visit;
    }

    public void setVisit(Date visit) {
        this.visit = visit;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
