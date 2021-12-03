package com.misiontic.clinica_ms.models;

import org.springframework.data.annotation.Id;

public class Patient {
    @Id
    private Integer id;
    private String name;
    private String telephone;
    private Integer age;
    private String city;
    private String gender;
    private String marital_status;

    public Patient(Integer id, String name, String telephone, Integer age, String city, String gender, String marital_status) {
        this.id = id;
        this.name = name;
        this.telephone = telephone;
        this.age = age;
        this.city = city;
        this.gender = gender;
        this.marital_status = marital_status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMarital_status() {
        return marital_status;
    }

    public void setMarital_status(String marital_status) {
        this.marital_status = marital_status;
    }
}
