/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hospitaladmissionsystem;

/**
 *
 * @author bshon
 */
public class Patient {
    //Private attributes
    private String patientId;
    private String firstName;
    private String lastName;
    private int age;
    private String gender;
    private String medCondition;
    private PatientCategory category;
    
    //constructor to initialize a patient object
    public Patient(String patientId, String firstName, String lastName, int age, String gender, String medCondition, PatientCategory category){
        this.patientId = patientId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.gender = gender;
        this.medCondition = medCondition;
        this.category = category;
    }
    
    // getters and setters
    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMedCondition() {
        return medCondition;
    }

    public void setMedCondition(String medCondition) {
        this.medCondition = medCondition;
    }

    public PatientCategory getCategory() {
        return category;
    }

    public void setCategory(PatientCategory category) {
        this.category = category;
    }
    
    public void displayDetails(){
        System.out.println("ID: "+ patientId+ " | Name: " +firstName+ " " +lastName+ " | Category: " +category+ " | Condition: "+medCondition);
    }
    
}
