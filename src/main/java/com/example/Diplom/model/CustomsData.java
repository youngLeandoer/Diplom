package com.example.Diplom.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class CustomsData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fieldName;
    private String fieldValue;

    private String customsField1;
    private String customsField2;


    // геттеры и сеттеры

    public String getCustomsField1() {
        return customsField1;
    }

    public void setCustomsField1(String customsField1) {
        this.customsField1 = customsField1;
    }

    public String getCustomsField2() {
        return customsField2;
    }

    public void setCustomsField2(String customsField2) {
        this.customsField2 = customsField2;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getFieldValue() {
        return fieldValue;
    }

    public void setFieldValue(String fieldValue) {
        this.fieldValue = fieldValue;
    }
}
